package com.example.adams.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * create by zl on 2019/6/12
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface Data {}
