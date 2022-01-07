package com.zenfery.demo.springboottest.config.springboot;

import java.util.Arrays;

import javax.servlet.ServletRequest;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

public class BetterServletRequestDataBinder extends ExtendedServletRequestDataBinder {

    public BetterServletRequestDataBinder(Object target) {
        super(target);
    }

    public BetterServletRequestDataBinder(Object target, String objectName) {
        super(target, objectName);
    }

    @Override
    protected void addBindValues(MutablePropertyValues mpvs, ServletRequest request) {
        // 采用 ExtendedServletRequestDataBinder 的绑定 @PathVariable 参数
        super.addBindValues(mpvs, request);

        // 添加 下划线参数（蛇形参数） 对应的 驼峰 参数
        PropertyValue[] pvs = mpvs.getPropertyValues();
        Arrays.stream(pvs).forEach(pv -> {
            // System.out.println(pv.getName() + " : " + pv.getValue());
            String propertyName = pv.getName();
            StringBuilder sb = new StringBuilder();
            boolean isContainUnderline = false; // 判断是否有下划线
            boolean preIsUnderline = false; // 前一个字符是否为下划线
            for (int i = 0; i < propertyName.length(); i++) {
                char c = propertyName.charAt(i);
                if (c == '_') {
                    isContainUnderline = true;
                    preIsUnderline = true;
                } else {
                    if (preIsUnderline) {
                        sb.append(Character.toUpperCase(c));
                    } else {
                        sb.append(c);
                    }
                    preIsUnderline = false;
                }
            }

            // 如果包含下划线，添加一个新值
            if (isContainUnderline) {
                mpvs.addPropertyValue(sb.toString(), pv.getValue());
            }
        });
    }
}
