package com.controller;

import com.entities.CommonResult;
import com.service.MessageProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/stream/provider")
public class RabbitmqProviderController {

    @Autowired
    private MessageProviderService messageProviderService;

    @RequestMapping("/send")
    @ResponseBody
    public CommonResult<Map> send(){
        Map map = new HashMap();
        String message = messageProviderService.send();
        map.put("message",message);
        return new CommonResult<Map>("0000","",map);
    }
}
