package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.WebSocketServer;

@Controller
public class testController {
	@RequestMapping
	 public String web() {
		 return "index";
	 }
	
	
	 @RequestMapping(value="/pushWeb")
	 public @ResponseBody Map<String,Object> pushVideoListToWeb(String msg) {
		 Map<String,Object> result =new HashMap<String,Object>();
		 
		 try {
			 WebSocketServer.sendInfo("有新客户呼入,sltAccountId:"+msg);
			 result.put("operationResult", true);
		 }catch (IOException e) {
			 result.put("operationResult", true);
		 }
		 return result;
	 }
	
    
}

