package com.zenfery.demo.springboottest.config.springboot;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.InitBinderDataBinderFactory;
import org.springframework.web.method.support.InvocableHandlerMethod;

import java.util.List;

public class BetterServletRequestDataBinderFactory extends InitBinderDataBinderFactory {
    /**
     * Create a new InitBinderDataBinderFactory instance.
     *
     * @param binderMethods {@code @InitBinder} methods
     * @param initializer   for global data binder initialization
     */
    public BetterServletRequestDataBinderFactory(List<InvocableHandlerMethod> binderMethods, WebBindingInitializer initializer) {
        super(binderMethods, initializer);
    }

    @Override
    protected WebDataBinder createBinderInstance(Object target, String objectName, NativeWebRequest webRequest) throws Exception {
        return new BetterServletRequestDataBinder(target, objectName);
    }
}
