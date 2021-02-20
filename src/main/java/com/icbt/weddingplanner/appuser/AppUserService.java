package com.icbt.weddingplanner.appuser;

import com.icbt.weddingplanner.controller.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<AppUser> user = appUserRepository.findByUsername(username);

        if(user.isPresent()){
            return user.map(AppUser::new).get();
        }else{
            throw new UsernameNotFoundException("User not found with username "+ username);
        }

    }

    public AppUser registration(RegistrationRequest registrationRequest){

        return appUserRepository.save(new AppUser(
                registrationRequest.getFirstName(),
                registrationRequest.getLastName(),
                registrationRequest.getUsername(),
                registrationRequest.getEmail(),
                registrationRequest.getNic(),
                registrationRequest.getContactNo(),
                registrationRequest.getPassword(),
                AppUserRole.USER
        ));
    }

    public List<AppUser> getUser() {

        return appUserRepository.findAll();

    }
}
