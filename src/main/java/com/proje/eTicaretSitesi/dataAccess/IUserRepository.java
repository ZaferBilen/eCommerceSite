package com.proje.eTicaretSitesi.dataAccess;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proje.eTicaretSitesi.entities.User;

public interface IUserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
}
