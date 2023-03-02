package com.example.controller;

import com.example.anno.MyAnnotation4Swagger;
import com.example.entity.MyEntity;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author lxk
 * @Api - 描述当前类型生成帮助文档的注解信息
 *      - tags  标签，给当前类型定义别名，可以有多个。定义几个，就在UI中显示几个控制器访问菜单。
 *      - produces 指定返回的类型，默认是application/json
 */
@RestController
@RequestMapping("/swagger")
@Api(tags = {"MyController","Swagger测试"})

public class MyController {

    @RequestMapping("/testEntity")
    public MyEntity testEntity(){
        return new MyEntity();
    }

    /**
     * @ApiImplicitParam - 描述文档
     *    - name - 需要描述的参数名
     *    - required - 是否必须
     *    - dataType - 数据类型
     *    - paramType - 参数类型
     *    - defaultValue - 默认值
     *    - example - 示例值
     *    - allowEmptyValue - 是否允许空值
     *    - allowMultiple - 是否允许多个
     * @param m
     * @param n
     * @return
     */
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "m", value = "测试姓名", required = false, dataType = "string",paramType = "String"),
            @ApiImplicitParam(name = "n", value = "测试年龄", required = true, dataType = "int",paramType = "Integer")
    })
    public String test(String m, String n) {
        return "test";
    }

    /**
     * @ApiOperation - 注解
     *    - value - 描述信息
     *    - httpMethod - 请求方式
     *    - produces - 返回的类型
     *    - notes - 说明
     * @return
     */
    @PostMapping("/post")
    @ApiOperation(value = "post方法", notes = "请求的处理方法")
    public String PostHello(){
        return "success";
    }

    /**
     * @ApiOperation - 注解
     * @ApiParam - 注解
     *   - value - 描述信息
     *   - required - 是否必填
     *   - example - 示例值
     *   - name - 名称
     *   - paramType - 参数类型
     *   - dataType - 数据类型
     *   - paramType - 参数类型
     * @param UserName
     * @param UserAge
     * @return
     * @ApiIgnore - 忽略当前注解描述的方法或类型，不生成当前api帮助文档。
     */
    @GetMapping("/get")
    public String GetHello(
            @ApiParam(name = "用户名", value = "新增的用户名")
            String UserName,
            @ApiParam(name = "年龄", value = "新增的年龄")
            String UserAge) {
        return "hello";
    }
    @RequestMapping("/req")
    @MyAnnotation4Swagger
    public String ReqHello(){
        return "success";
    }
}
