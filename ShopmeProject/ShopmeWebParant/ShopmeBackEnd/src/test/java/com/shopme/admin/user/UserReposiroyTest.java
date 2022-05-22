package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.booleanThat;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class UserReposiroyTest {

	@Autowired
	UserRepository userRepo;
	@Autowired
	TestEntityManager enityManger;
	@InjectMocks
	UserRestController userrest;
	
	@Test
	public void TestcreateUse() {
		
		Role role=enityManger.find(Role.class, 
				3);
		User user= new User("Neeraj","sgssdshgdvq","sdsdhghvq","sqsddghgv");
	
		user.addRole(role);
		User saveduser =userRepo.save(user);
		
		assertThat(saveduser.getId()).isGreaterThan(0);
//	System.out.println(userRepo.findAll());
	}
	@Test
	public void TestcreateTwoUse() {
		
		Role role=enityManger.find(Role.class, 
				1);
		Role role2=enityManger.find(Role.class, 
				4);
	
		User user= new User("Gulshan","sgssdshgdvq","sdsdhghvq","sqsddghgv");
	
		user.addRole(role);
		user.addRole(role2);
		
		User saveduser =userRepo.save(user);
		
		assertThat(saveduser.getId()).isGreaterThan(0);
//	System.out.println(userRepo.findAll());
	}
	
	
	
	@Test
	public void TestgetUser() {
		Iterable<User> listUser= userRepo.findAll();
		listUser.forEach(user ->System.out.print(user));

	}
	@Test
	public void TestgetscsUser() {
userrest.isEmailUnique("uwuhwff@gmail.com");
	}
//		
	
	@Test
	public void getUserbyEmail() {
		User user=userRepo.getUserBYEmail("neerajbashani69sdff@gmail.com");
	assertThat(user).isNotNull();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
