package com.icbt.weddingplanner.controller;

import com.icbt.weddingplanner.appuser.AppUser;
import com.icbt.weddingplanner.appuser.AppUserService;
import com.icbt.weddingplanner.serviceuser.ServiceUser;
import com.icbt.weddingplanner.serviceuser.ServiceUserService;
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
    private final ServiceUserService serviceUserService;

    @PostMapping
    public AppUser registration(@RequestBody RegistrationRequest registrationRequest){
        return userService.registration(registrationRequest);
    }

    @PostMapping("/service")
    public ServiceUser registration(@RequestBody ServiceRequest serviceRequest){
        return serviceUserService.saveServiceUser(serviceRequest);
    }

}
