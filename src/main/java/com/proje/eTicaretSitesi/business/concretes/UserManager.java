package com.proje.eTicaretSitesi.business.concretes;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.proje.eTicaretSitesi.business.abstracts.IUserService;
import com.proje.eTicaretSitesi.business.requests.UserLoginRequest;
import com.proje.eTicaretSitesi.business.requests.UserRegisterRequest;
import com.proje.eTicaretSitesi.business.responses.GetUserProfileResponse;
import com.proje.eTicaretSitesi.core.utilities.authentication.IAuthenticationFacade;
import com.proje.eTicaretSitesi.core.utilities.mappers.IModelMapperService;
import com.proje.eTicaretSitesi.dataAccess.IUserRepository;
import com.proje.eTicaretSitesi.entities.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserManager implements IUserService {

	private IUserRepository userRepository;
	private IModelMapperService modelMapperService;
	private IAuthenticationFacade authenticationFacade;
	
	
	@Override
	public void register(UserRegisterRequest register) {
		User user = this.modelMapperService.forRequest().map(register, User.class);
		this.userRepository.save(user);
		
	}

	@Override
	public void login(UserLoginRequest login) {
        User user = this.modelMapperService.forRequest().map(login, User.class);

        User existingUser = userRepository.findByEmail(user.getEmail()).orElse(null);

        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            System.out.println("Login successful");
        } else {
            System.out.println("Username or password is incorrect");
        }
    }
	@Override
	public GetUserProfileResponse getCurrentUserProfile() {
		Authentication authentication = authenticationFacade.getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(()-> new NotFoundException("User not found"));
        
        return modelMapperService.forResponse().map(user,GetUserProfileResponse.class);
                
    }

	@Override
	public void logout() {
		SecurityContextHolder.getContext().setAuthentication(null);
		
	}
}
