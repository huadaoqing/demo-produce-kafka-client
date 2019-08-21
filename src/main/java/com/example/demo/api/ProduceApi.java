package com.example.demo.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

/**
 * 
 * @author 华道青
 *
 */
@Api(value = "kafka相关接口", description = "kafka相关接口")
@RequestMapping(value = "kafka/producer")
public interface ProduceApi {
    /**
     * 成功编码
     */
    int SUCCESS_CODE = 200;
    int ERROR_CODE = 500;
	@RequestMapping(value = "/sendKafka", produces = { "application/json" }, method = RequestMethod.POST)
    @ApiOperation(value = "发送消息", notes = "发送消息", response = Result.class,
    tags = {"kafka"})
    @ApiResponses(value = {@ApiResponse(code = SUCCESS_CODE, message = "返回", response = Result.class),
    @ApiResponse(code = ERROR_CODE, message = "Unexpected error",
            response = Result.class)}) 
	Result sendKafka(@RequestBody String a);

}
