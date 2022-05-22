package com.shopme.admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.shopme.admin.user.UserRepository;
import com.shopme.common.entity.User;

public class ShopmeUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user=userRepo.getUserBYEmail(email);
		System.out.println("%%%%%%%"+email);
		System.out.println("%%%%%%%$$$$$$"+userRepo.getUserBYEmail(email));
		if (user != null){
		return new UserSecurityDetails(user);	
			
		}
		throw new UsernameNotFoundException("Not found : "+ email);
				
	}

}
