package com.proje.eTicaretSitesi.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proje.eTicaretSitesi.entities.Category;

public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
