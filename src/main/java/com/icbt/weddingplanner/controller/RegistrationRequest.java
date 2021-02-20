package com.icbt.weddingplanner.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String nic;
    private String contactNo;
    private String password;
}
