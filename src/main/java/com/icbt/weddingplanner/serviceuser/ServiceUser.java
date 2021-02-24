package com.icbt.weddingplanner.serviceuser;

import com.icbt.weddingplanner.appuser.AppUserRole;
import lombok.*;

import javax.persistence.*;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ServiceUser {

    @Id
    @SequenceGenerator(
            name = "serviceUser_sequence",
            sequenceName = "serviceUser_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "serviceUser_sequence"
    )
    private Long id;
    private String hotelName;
    private String address;
    private String contactNo;
    private String email;
    private String pricePerPlate;
    private String password;
    private AppUserRole appUserRole;

    public ServiceUser(
                       String hotelName,
                       String address,
                       String contactNo,
                       String email,
                       String pricePerPlate,
                       String password,
                       AppUserRole appUserRole) {
        this.hotelName = hotelName;
        this.address = address;
        this.contactNo = contactNo;
        this.email = email;
        this.pricePerPlate = pricePerPlate;
        this.password = password;
        this.appUserRole = appUserRole;
    }
}
