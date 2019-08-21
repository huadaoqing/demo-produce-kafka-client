package com.example.demo.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.ProduceApi;
import com.example.demo.dto.Result;
@RestController
public class ProduceController implements ProduceApi{
    @Autowired
    private KafkaTemplate<String, byte[]> KafkaTemplate;
    
    private static final Logger LOG = LoggerFactory.getLogger(ProduceController.class);
	@Override
	public Result sendKafka(@RequestBody String a) {
		try {
			LOG.info("kafka send fail info");
			LOG.warn("kafka send fail warn");
			LOG.error("kafka send fail error");
		//	KafkaTemplate.send("testTopic", 0, a.getBytes("utf-8"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.error("kafka send fail");
			return new Result("9999","fail");
		}
		return new Result("0000","SUCCESS");
	}
	
	public static void main(String[] args) {
		HashMap<String,Result> map = new HashMap<String,Result>();
		Result res = new Result();
		res.setResultCode("8888");
		res.setResultMessage("成功");
		
		map.put("hua", res);
		Result r = map.get("hua");
		r.setResultCode("9999");
		System.out.println(map.toString());
	}
}