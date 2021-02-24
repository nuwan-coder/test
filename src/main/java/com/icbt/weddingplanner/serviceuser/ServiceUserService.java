package com.icbt.weddingplanner.serviceuser;

import com.icbt.weddingplanner.appuser.AppUserRole;
import com.icbt.weddingplanner.controller.ServiceRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceUserService {

    private final ServiceUserRepository serviceUserRepository;

    public ServiceUser saveServiceUser(ServiceRequest serviceRequest){
        return serviceUserRepository.save(new ServiceUser(
                serviceRequest.getHotelName(),
                serviceRequest.getAddress(),
                serviceRequest.getContactNo(),
                serviceRequest.getEmail(),
                serviceRequest.getPricePerPlate(),
                serviceRequest.getPassword(),
                AppUserRole.SERVICE_USER
        ));
    }

    public List<ServiceUser> getUsers(){
        return serviceUserRepository.findAll();
    }

}
