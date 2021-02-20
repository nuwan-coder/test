package com.icbt.weddingplanner.controller;

import com.icbt.weddingplanner.appuser.AppUser;
import com.icbt.weddingplanner.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final AppUserService userService;

    @PostMapping
    public AppUser registration(@RequestBody RegistrationRequest registrationRequest){
        return userService.registration(registrationRequest);
    }

}
