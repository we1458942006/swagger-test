package com.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author: dj
 * @create: 2020-12-13 16:15
 * @ApiModel - 描述一个实体类型，这个类型如果成为任何一个生成Api帮助文档的返回值类型时，此注解被解析
 * @ApiModelProperty
 *  - 描述参数的描述信息
 * @version: 1.0.0
 */
@ApiModel(value = "User", description = "用户实体")
public class MyEntity implements Serializable {

    @ApiModelProperty(value = "用户id",name = "主键(id)",required = true,example = "1",hidden = false)
    private String id;
    @ApiModelProperty(value = "用户姓名",name = "姓名(id)",required = true,example = "elven",hidden = false)
    private String name;

    @ApiModelProperty(value = "用户密码",name = "密码(id)",required = true,example = "root123",hidden = false)
    private String password;


    public String getId() {
        return id;
    }

    public MyEntity() {

    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyEntity myEntity = (MyEntity) o;
        return Objects.equals(id, myEntity.id) && Objects.equals(name, myEntity.name) && Objects.equals(password, myEntity.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
