package com.shopme.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	RoleRepository roleRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	public List<User> getData(){
	List<User> list=(List<User>) repo.findAll(org.springframework.data.domain.Sort.by("id"));
	return list;
	}
	
	public void saveData(User user){
		encodePassword(user);
	repo.save(user);
		
		}

	
	
	private void encodePassword(User user) {
		
		String En=passwordEncoder.encode(user.getPassword());
		user.setPassword(En);
	}
	public List<Role> getRole(){
	List<Role> list1=(List<Role>) roleRepo.findAll();
	return list1;
	}
	
	public boolean emailUnique(String email) {
		
		User usernyemail=repo.getUserBYEmail(email);
return	usernyemail == null;
			
	}
	public void deleteUserbyid(Integer id) {
		
		Long countbyid=repo.countById(id);
		
		if(countbyid == null || countbyid==0) {
			throw new NotFoundException("User notr found");
		}
		
		repo.deleteById(id);
	}
	
	
	
	
	public User getUser(Integer id) {
		
	User user=repo.findById(id).get();
	
return user;	
	}
	
	
	
	
}
