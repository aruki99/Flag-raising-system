package Flag;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class Request {
    String id = "25f57dd99d5c0739";
    String secret = "f81ad272ab02b01b528c42102ddfad76";
    String userName;

    @GetMapping("/login")
    public String login() {
        return "redirect:https://openapi.yiban.cn/oauth/authorize?client_id=" + id + "&redirect_uri=http://localhost:5000/OAuth";

    }


    @GetMapping("/OAuth")
    public void OAuth(@RequestParam String code,
                      HttpServletResponse response, HttpSession session) throws IOException {
        long a = System.currentTimeMillis();
        String access_token = getAccess(code);

        if (access_token != null) {

            System.out.println(getInfs(access_token, "yb_realname"));
            System.out.println(getInfs(access_token, "yb_userid"));


            session.setAttribute("access_token", access_token);
            session.setAttribute("yb_realname", getInfs(access_token, "yb_realname"));
            session.setAttribute("yb_userid", getInfs(access_token, "yb_userid"));

            response.sendRedirect("/index");
            long b = System.currentTimeMillis();
            System.out.println(b - a);
        } else {

            response.sendRedirect("/login");

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
        multiValueMap.add("redirect_uri", "http://localhost:5000/OAuth");

        //将请求头部和参数合成一个请求
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(multiValueMap, headers);

        //执行HTTP请求，将返回的结构使用String 类格式化（可设置为对应返回值格式的类）
        final ResponseEntity<String> responseEntity = restTemplate.postForEntity(token_url, request, String.class);

        //取得返回json的某个值，添加依赖 fastjson
        JSONObject pa = JSONObject.parseObject(responseEntity.getBody());

        return pa.getString("access_token");


    }


    //获取个人信息，取姓名，id

    public String getInfs(String access_token, String need) {

        String token_url = "https://openapi.yiban.cn/user/verify_me";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.getForEntity(token_url + "?access_token=" + access_token, String.class);

        JSONObject pa = JSONObject.parseObject(response.getBody());
        JSONObject ps = (JSONObject) pa.get("info");

//      return ps.getString("yb_realname")+ps.getString("yb_userid") ;

//        map.put("yb_realname",ps.getString("yb_realname"));
//        map.put("yb_userid",ps.getString("yb_userid"));
        return ps.getString(need);

    }


    @RequestMapping("/index")
    public String Index(Model model) {
        model.addAttribute("userName");
        this.userName = null;
        return "first";
    }

    @RequestMapping("/rise")
    public String rise() {
        return "shengqi";
    }

    @RequestMapping("/out")
    public String out() {

        return "end";

    }


//Vue跨域用端口
//    @CrossOrigin
//    @ResponseBody
//    @PostMapping("api/logins")
////    public String login(@RequestBody User user) {
////
////        return "code";
////
////    }
//    public String login(@RequestBody User user) {
//        return this.code;
//    }


}



