package Flag;

import Flag.lesson01.DO.Data;
import Flag.lesson01.DO.Students;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpSession;


@Controller
public class Request {
    String id = "25f57dd99d5c0739";
    String secret = "f81ad272ab02b01b528c42102ddfad76";
    String userName;
    int Sequence = 1;

    @Autowired
    Data data;

    @GetMapping("/login")
    public String login() {
        return "redirect:https://openapi.yiban.cn/oauth/authorize?client_id=" + id + "&redirect_uri=http://47.103.202.240/OAuth";
    }

    @Autowired
    HttpSession session;

    @GetMapping("/OAuth")
    public String OAuth(@RequestParam String code) {
        String access_token = getAccess(code);

        String name = getInfs(access_token).getString("yb_realname");
        String id = getInfs(access_token).getString("yb_userid");
        if (access_token != null) {
            session.setAttribute("yb_realname", name);
            session.setAttribute("yb_userid", id);
            session.setAttribute("access_token", access_token);
            return "redirect:/index";
        } else {
            return "redirect:/login";
        }
    }


    //获取授权码 access_token
    public String getAccess(String code) {
        String token_url = "https://openapi.yiban.cn/oauth/access_token";

        RestTemplate restTemplate = new RestTemplate();

        //新建Http头，add方法可以添加参数
        HttpHeaders headers = new HttpHeaders();
        // 以表单的方式提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        //添加请求参数
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("client_id", id);
        multiValueMap.add("client_secret", secret);
        multiValueMap.add("code", code);
        multiValueMap.add("redirect_uri", "http://47.103.202.240/OAuth");

        //将请求头部和参数合成一个请求
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(multiValueMap, headers);

        //执行HTTP请求，将返回的结构使用String 类格式化（可设置为对应返回值格式的类）
        final ResponseEntity<String> responseEntity = restTemplate.postForEntity(token_url, request, String.class);

        //取得返回json的某个值，添加依赖 fastjson
        JSONObject pa = JSONObject.parseObject(responseEntity.getBody());

        return pa.getString("access_token");


    }


    //获取个人信息

    public JSONObject getInfs(String access_token) {

        String token_url = "https://openapi.yiban.cn/user/verify_me";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.getForEntity(token_url + "?access_token=" + access_token, String.class);

        JSONObject pa = JSONObject.parseObject(response.getBody());

        return (JSONObject) pa.get("info");

    }


    @GetMapping({"/", "/index"})
    public String index(Model model) {
        String name = (String) session.getAttribute("yb_realname");
        if (name == null) return "redirect:/login";
        model.addAttribute("yb_realname", name);
        return "first";
    }

    @GetMapping("/rise")
    public String rise() {
        String name = (String) session.getAttribute("yb_realname");
        if (name == null) return "redirect:/login";
        return "shengqi";
    }


    @GetMapping("/out")
    public String out(Model model) {
        String name = (String) session.getAttribute("yb_realname");
        if (name == null) return "redirect:/login";
        String yb_userid = (String) session.getAttribute("yb_userid");

        Students students = new Students(yb_userid, name, -1);

        int paiWei = data.getPaiWei(students);

        model.addAttribute("sequence", paiWei);
        model.addAttribute("yb_realname", name);
        return "end";
    }

    @GetMapping("logout")
    public String logout() {

        try {
            String access_token = (String) session.getAttribute("access_token");
            String token_url = "https://openapi.yiban.cn/oauth/revoke_token";

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
            multiValueMap.add("client_id", id);
            multiValueMap.add("access_token", access_token);

            //将请求头部和参数合成一个请求
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(multiValueMap, headers);

            //执行HTTP请求，将返回的结构使用String 类格式化（可设置为对应返回值格式的类）
            final ResponseEntity<String> responseEntity = restTemplate.postForEntity(token_url, request, String.class);

            //取得返回json的某个值，添加依赖 fastjson
            JSONObject pa = JSONObject.parseObject(responseEntity.getBody());
            if (!pa.getString("status").equals("200")) {
                System.out.println(pa.getString("info"));
                return "redirect:/";
            }
            session.removeAttribute("yb_realname");
            session.removeAttribute("yb_userid");
            session.removeAttribute("access_token");
            return "redirect:/login";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "redirect:/";
        }
    }
}

