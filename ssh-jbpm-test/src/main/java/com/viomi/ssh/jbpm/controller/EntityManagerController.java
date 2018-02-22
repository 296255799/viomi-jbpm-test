package com.viomi.ssh.jbpm.controller;

import org.jbpm.runtime.manager.impl.jpa.EntityManagerFactoryManager;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EntityManagerController
{
    
    AbstractEntityManagerFactoryBean entityManagerFactory;
    
    @RequestMapping(value = "/deploy", method = RequestMethod.GET)
    public String deploy()
    {
        return "test";
    }
}
