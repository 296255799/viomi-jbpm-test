package com.viomi.ssh.jbpm.controller;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.viomi.ssh.jbpm.service.PersonService;

/**
 * Created by XRom
 * On 11/16/2017.11:59 PM
 */
@Controller
public class TestController {

    @Autowired(required=true)
    private PersonService personService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

    @RequestMapping(value = "/savePerson", method = RequestMethod.GET)
    @ResponseBody
    public String savePerson() {
        personService.savePerson();
        return "success!";
    }
    
    @RequestMapping(value = "/updateFlow", method = RequestMethod.GET)
    @ResponseBody
    public String updateFlow(){
//        KieHelper helper = new KieHelper();
//        helper.addResource(ResourceFactory.newClassPathResource(null));
        try
        {
            Context context = new InitialContext();
            Object test = context.lookup("java:comp/env/jdbc/jbpm");
            System.out.println(test.getClass());
        }
        catch (NamingException e)
        {
            e.printStackTrace();
        }
        return "XXX";
    }
    
    
}
