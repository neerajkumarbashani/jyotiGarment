package com.shopme.admin.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopme.common.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value="SELECT u FROM User u where u.email = :email")
	public User getUserBYEmail(@Param("email") String email);
	
	public Long countById(Integer id);
	
}
