package com.viomi.ssh.jbpm.controller;

import org.jbpm.kie.services.impl.ProcessServiceImpl;
import org.kie.spring.factorybeans.TaskServiceFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProcessController
{
    @Autowired
    ProcessServiceImpl processService;
    
    @RequestMapping(value = "/testtask", method = RequestMethod.GET)
    public String test()
    {
        System.out.println("测试");
        processService.startProcess("XXX", "ddddd");
        return "test";
    }
    
}
