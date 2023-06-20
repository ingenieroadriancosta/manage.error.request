package com.adrian.costa.errors.manage.manage.error.request.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.costa.errors.manage.manage.error.request.responses.ServerResponse;

@RestController
@RequestMapping(value = "api/client")
public class MainController {

    @GetMapping
    public  @ResponseBody Map<String,Object> getClientInfoRequestParam(@RequestParam String documentType,
            @RequestParam String documentNumber) {
        return new ServerResponse("clientinfo", (documentType+" - " + documentNumber) ).getResponse();
    }

    
    @GetMapping("path/{documentType}/{documentNumber}")
    public @ResponseBody Map<String,Object> getClientInfoPathVariable(@PathVariable String documentType,
            @PathVariable String documentNumber) {
        int values[] = {0,10,2};
        for(int i=0;i<1000;i++){
            values[i]=i;
        }
        return new ServerResponse("clientinfo", (documentType+" - " + documentNumber)).getResponse();
    }

    @GetMapping("{documentType}/{documentNumber}")
    public @ResponseBody Map<String,Object> getClientInfoPathVariableWithOut(@PathVariable String documentType,
            @PathVariable String documentNumber) {
        return new ServerResponse("clientinfo", (documentType+" - " + documentNumber)).getResponse();
    }

}
