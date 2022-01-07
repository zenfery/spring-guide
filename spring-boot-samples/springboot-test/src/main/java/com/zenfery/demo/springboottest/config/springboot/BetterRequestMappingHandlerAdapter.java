package com.zenfery.demo.springboottest.config.springboot;

import org.springframework.web.method.annotation.InitBinderDataBinderFactory;
import org.springframework.web.method.support.InvocableHandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.List;

public class BetterRequestMappingHandlerAdapter extends RequestMappingHandlerAdapter {

    @Override
    protected InitBinderDataBinderFactory createDataBinderFactory(List<InvocableHandlerMethod> binderMethods) throws Exception {
        return new BetterServletRequestDataBinderFactory(binderMethods, getWebBindingInitializer());
    }
}
