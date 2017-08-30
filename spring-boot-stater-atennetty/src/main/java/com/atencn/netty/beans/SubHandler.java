package com.atencn.netty.beans;

import com.google.protobuf.Any;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017/8/28.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Component
public @interface SubHandler {
    int order();
    Class type() default Any.class;
}
