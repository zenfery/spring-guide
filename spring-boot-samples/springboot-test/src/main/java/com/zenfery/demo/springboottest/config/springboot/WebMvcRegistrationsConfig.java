package com.zenfery.demo.springboottest.config.springboot;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
public class WebMvcRegistrationsConfig implements WebMvcRegistrations {

    @Override
    public RequestMappingHandlerAdapter getRequestMappingHandlerAdapter() {
        return new BetterRequestMappingHandlerAdapter();
    }
}
