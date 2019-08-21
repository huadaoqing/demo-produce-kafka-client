/**
 * All rights Reserved, Designed By MiGu
 * Copyright: Copyright(C) 2016-2020
 * Company MiGu Co., Ltd.
 */
package com.example.demo.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 项目名称: Rainbow Stone for cartoon
 * 包: com.migu.rstone.dto
 * 类名称: Result.java
 * 类描述: 返回结果封装对象,包含结果编码，结果描述.
 * 创建人: guhao
 * 创建时间: 2017/8/2 17:29
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement(name = "result")
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @NotBlank(message = "返回码不能为空")
    private String resultCode;
    private String resultMessage;
}
