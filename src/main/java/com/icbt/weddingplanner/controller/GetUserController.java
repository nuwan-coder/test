package com.icbt.weddingplanner.controller;

import com.icbt.weddingplanner.appuser.AppUser;
import com.icbt.weddingplanner.appuser.AppUserService;
import com.icbt.weddingplanner.serviceuser.ServiceUser;
import com.icbt.weddingplanner.serviceuser.ServiceUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
@AllArgsConstructor
public class GetUserController {

    private final ServiceUserService serviceUserService;
    private final AppUserService appUserService;

    @GetMapping
    public List<ServiceUser> getUser(){
        return serviceUserService.getUsers();
    }

    @PostMapping
    public List<ServiceUser> selectSuitableUsers(@RequestBody SelectServiceRequest selectServiceRequest){
        return serviceUserService.getSuitableService(selectServiceRequest);
    }

}
