package com.viomi.ssh.jbpm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viomi.ssh.jbpm.entity.Person;
import com.viomi.ssh.jbpm.repository.PersonRepository;
import com.viomi.ssh.jbpm.service.PersonService;

/**
 * Created by XRom
 * On 11/16/2017.11:58 PM
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired(required = true)
    private PersonRepository personRepository;

    @Override
    public Long savePerson() {
        Person person = new Person("test","test","test","mobile","email");
        return personRepository.save(person);
    }
}
