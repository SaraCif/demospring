package com.spring.demospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.demospring.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	
	
	List<UserEntity> findAll ();
	
	/*
	@Query("SELECT c FROM USER c WHERE (:name is null or c.name = :name) and (:surname is null"
			  + " or c.surname = :surname)")
			List<UserEntity> findByNameOrSurname(@Param("name") String name, @Param("surname") String surname);
	*/
	
}
