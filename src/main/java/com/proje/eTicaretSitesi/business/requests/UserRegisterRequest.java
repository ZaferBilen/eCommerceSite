package com.proje.eTicaretSitesi.business.requests;

import com.proje.eTicaretSitesi.entities.User.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {
	
	private String name;
    private String surname;
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;
	
    @Pattern(regexp ="^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,18}$",
            message = "Password must contain at least one letter, one number, and be between 6 and 18 characters") 
    private String password;
	
    private String passwordControl;
   
    private UserRole role;
}
