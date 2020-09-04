package Flag.Config;

import Flag.LoginHandInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//@Configuration
public class MyConfig2 extends WebMvcConfigurationSupport {
//变换路径
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/user").setViewName("first");
//        registry.addViewController("/first.html").setViewName("first");

    }
//注册拦截器
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        LoginHandInterceptor is =new LoginHandInterceptor();
//        registry.addInterceptor(is).addPathPatterns("/*").excludePathPatterns("/OAuth","/login");
//
//    }


////排除对静态资源的拦截
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/*")
//                .addResourceLocations("classpath:/static/");
//    }
}
