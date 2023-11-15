package com.proje.eTicaretSitesi.business.requests;

import com.proje.eTicaretSitesi.entities.User.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    
    @NotBlank(message = "Password cannot be blank")
	@Size(min = 6, max = 18, message = "Password must be between 6 and 18 characters")
	@Pattern(
	        regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
	        message = "Password must contain at least one letter, one number, and one special character"
	    )
    private String password;
    private UserRole role;
}
