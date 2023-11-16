package com.proje.eTicaretSitesi.business.rules;

import org.springframework.stereotype.Service;

import com.proje.eTicaretSitesi.core.utilities.exceptions.BusinessException;
import com.proje.eTicaretSitesi.dataAccess.IUserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserBusinessRules {
	
	private IUserRepository userRepository;
	
	public void checkIfUserEmailExists(String email) {
		if(this.userRepository.existsByEmail(email)) {
			throw new BusinessException("This email is registered");
		}
	}
	
	public void checkIfPasswordsMatch(String password, String passwordControl) {
	    if(!password.equals(passwordControl)) {
	        throw new BusinessException("Passwords do not match");
	    }
	}

}
