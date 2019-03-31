package com.hmily.springboot.controller;


import com.hmily.springboot.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see
 * @since 2017.09.16
 */
@RestController
public class PersonRestController {

    private final Person person;

    public PersonRestController(Person person) {
        this.person = person;
    }

    @GetMapping("/person")
    public Person person() {
        return person;
    }

}
