package com.java.shiro;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zl
 * @create 2019-08-15 15:55
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    //keymap默认配置ctrl+o,重写方法addViewControllers
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //访问guarantee路径进guarantee.html,然后页面加载ajax请求访问guarantees
        registry.addViewController("/guarantee").setViewName("/guarantee/guarantee");
    }
}
