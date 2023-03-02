package com.example.anno;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lxk
 * @version 1.0
 * @Target() 描述注解的作用可以定义在什么资源上
 *  - @Target(ElementType.TYPE) 表示该注解可以定义在类上
 *  - @Target(ElementType.METHOD) 表示该注解可以定义在方法上
 *  - @Target(ElementType.PARAMETER) 表示该注解可以定义在参数上
 *  - @Target(ElementType.FIELD) 表示该注解可以定义在字段上
 *  - @Target(ElementType.ANNOTATION_TYPE) 表示该注解可以定义在注解上
 *  - @Target(ElementType.CONSTRUCTOR) 表示该注解可以定义在构造器上
 *  - @Target(ElementType.LOCAL_VARIABLE) 表示该注解可以定义在局部变量
 *  - @Target(ElementType.PACKAGE) 表示该注解可以定义在包上
 *  - @Target(ElementType.TYPE_PARAMETER) 表示该注解可以定义在类型参数上
 *  - @Target(ElementType.TYPE_USE) 表示该注解可以定义在类型使用上
 * @Retention() 定义该注解的作用
 * - @Retention(RetentionPolicy.RUNTIME) 表示该注解可以定义在运行时
 * - @Retention(RetentionPolicy.CLASS) 表示该注解可以定义在类上
 * - @Retention(RetentionPolicy.RUNTIME) 表示该注解可以定义在运行时
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
public @interface MyAnnotation4Swagger {
    /**
     * 自定义注解里的属性，相当于@MyAnnotation4Swagger(value = "自定义注解里的属性")
     * @return
     */
    String value() default "";
}
