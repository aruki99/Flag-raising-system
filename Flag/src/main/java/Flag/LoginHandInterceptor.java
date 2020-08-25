package Flag;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截器制作，
public class LoginHandInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        Object user = request.getSession().getAttribute("access_token");
        if (user == null) {
            //未登录，弹回易班授权页
            response.sendRedirect("/login");
            return false;
        } else {
            //已登录
            request.setAttribute("yb_realname", request.getSession().getAttribute("yb_realname"));
            request.setAttribute("yb_userid", request.getSession().getAttribute("yb_userid"));

            return true;

        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}

