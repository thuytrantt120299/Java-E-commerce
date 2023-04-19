package com.shopme.admin;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.shopme.admin.user.UserService;
import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;

@SpringBootTest
public class ShopmeTest {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateNewUserWithOneRole() {
		Role roleAdmin = entityManager.find(Role.class, 1);
		User userNamHM = new User("thuy@gmail.com", "thuy123", "Nam", "Ha Minh");
		userNamHM.addRole(roleAdmin);
		
		User savedUser = userService.save(userNamHM);
		
		System.out.println(savedUser.toString());
	}
	

}
