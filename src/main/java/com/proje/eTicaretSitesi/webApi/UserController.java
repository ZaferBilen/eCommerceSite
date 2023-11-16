package com.proje.eTicaretSitesi.webApi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proje.eTicaretSitesi.business.abstracts.IUserService;
import com.proje.eTicaretSitesi.business.requests.UserLoginRequest;
import com.proje.eTicaretSitesi.business.requests.UserRegisterRequest;
import com.proje.eTicaretSitesi.business.responses.GetUserProfileResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/user")  
@AllArgsConstructor
public class UserController {
	
		private IUserService userService;
	
		
		@PostMapping("/register")
	    @ResponseStatus(code = HttpStatus.CREATED)
	    public ResponseEntity<String> registerUser(@RequestBody UserRegisterRequest register){
			
			userService.register(register);
			return ResponseEntity.ok("User registered successfully");
		}
		
		@PostMapping("/login")
		public ResponseEntity<String> loginUser(@RequestBody UserLoginRequest loginRequest){
			userService.login(loginRequest);
			
			return ResponseEntity.ok("Login successful");
		}
	
	    @GetMapping("/profile")
	    public ResponseEntity<GetUserProfileResponse> getUserProfile() {
	        // Şu anki kullanıcının bilgilerini al
	        GetUserProfileResponse userResponse = userService.getCurrentUserProfile();
	        return ResponseEntity.ok(userResponse);
	    }
	    
	    @GetMapping("/logout")
	    public ResponseEntity<String> logout() {
	        userService.logout();
	        return ResponseEntity.ok("Logout successful");
	    }
	    

}