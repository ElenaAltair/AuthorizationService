package ru.netology.authorizationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.authorizationservice.model.User;
import ru.netology.authorizationservice.repository.Authorities;
import ru.netology.authorizationservice.service.AuthorizationService;

import javax.validation.Valid;
import java.util.List;


@RestController
public class AuthorizationController {

    @Autowired
    AuthorizationService service;

    /*
    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") @Validated String user,
                                            @RequestParam("password") @Validated String password) {
        return service.getAuthorities(user, password);
    }
    */

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }

}
