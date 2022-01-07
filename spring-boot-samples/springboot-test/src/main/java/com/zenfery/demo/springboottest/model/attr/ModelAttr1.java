package com.zenfery.demo.springboottest.model.attr;

import lombok.Data;

@Data
public class ModelAttr1 {

    /**
     * url 中的请求参数 或 表单参数
     */
    private String requestParam;

    /**
     * url 中的请求参数（带下划线）
     */
    private String underlineRequestParam;

    /**
     * Path 中存储的属性
     */
    private String pathVar;

    /**
     * Model 中之前存储的属性
     */
    private String preAtrr;

    /**
     * Session 中存储的属性 注：这个属性是不能自动被 @ModelAttribute 注解的对象绑定
     */
    private String sessionAttr;
}
