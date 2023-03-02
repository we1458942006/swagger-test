package com.example.config;


import com.example.anno.MyAnnotation4Swagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import com.google.common.base.Predicates;
import springfox.documentation.builders.RequestHandlerSelectors;

/**
 * @author lxk
 */
@Configuration
public class SwaggerConfigration {
    /**
     * 创建Docket对象，并使用Spring管理
     * Docket是Swagger中的全局配置对象
     * @return
     */

    @Bean
    public Docket docket(){
       Docket docket = new Docket(DocumentationType.SWAGGER_2);

        /**
         * 设置api的基本描述信息
         * @return
         * .contact(new Contact 配置swagger文档主体内容
         * name = 配置swagger文档发布者名称
         * url = 配置swagger文档发布者的网站地址
         * email = 配置swagger文档发布者邮箱
         * title = 配置swagger文档标题
         * description = 配置swagger文档详细描述
         * version = 配置swagger文档版本号
         */
       ApiInfo apiInfo = new ApiInfoBuilder()
               .contact(new Contact("测试项目","http://www.example.com","admin@example.com"))
               .title("swagger文档测试项")
               .description("详细描述")
               .version("1.1")
               .build();

       // 给docket上下文对象添加api描述信息
       docket.apiInfo(apiInfo);

        /**
         * 添加docket方法
         * select()方法用于指定要扫描的包的注解，获取Docket中的选择器，返回ApiSelectorBuilder对象
         * RouterSelectors.basePackage("com.example.controller")设定扫描那个类的包
         * apiSelectorBuilder.paths(PathSelectors.any())设定要扫描的路径
         * Predicate.not指自定义注解取反。 false -> true, ture -> false
         * RequestHandlerSelectors.withMethodAnnotation 当方法上有注解的时候返回true
         * build() 重新构建
         * 使用/swagger/.*生成约束路径文档 /swagger/
         * pathSelectors.regex("/.*")设定约束生成API文档的路径
         * pathSelectors.or 任意一个即可通过
         */
        docket = docket
                .select()
                .paths(
                        Predicates.or(
                            PathSelectors.regex("/swagger/.*"),
                            PathSelectors.regex("/.*"),
                            PathSelectors.regex("/webjars/.*"),
                            PathSelectors.regex("/v2/api-docs"),
                            PathSelectors.regex("/swagger-resources/.*")

                        )
                )
                .apis(
                        Predicates.not(
                            RequestHandlerSelectors.withMethodAnnotation(MyAnnotation4Swagger.class)
                        )

                )
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                .build();

       return docket;
    }
}
