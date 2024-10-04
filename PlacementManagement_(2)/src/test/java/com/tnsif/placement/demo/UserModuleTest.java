package com.tnsif.placement.demo;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.placement.demo.model.RahulUser;
import com.placement.demo.repository.RahulUserRepository;
import com.placement.demo.service.RahulUserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserModuleTest {

	@Mock//Mock is used to interrupt the interaction with database 
	//creating reference for User repository and service
	private RahulUserRepository repo;
	
	@InjectMocks
	private RahulUserService serv;
	
	private RahulUser user1,user2;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		
		user1 = new RahulUser(2,"ronit","student","1235",101);
		user2 = new RahulUser(3,"gagan","student","1234",102);
	}
	
	@Test
	void testListAll() {
		List<RahulUser> users = Arrays.asList(user1,user2);
		when(repo.findAll()).thenReturn(users);
		
		List<RahulUser> result = serv.listAll();
		assertEquals(2,result.size());//checking the size of users list whether it has 2 user details
		verify(repo,times(1)).findAll();
	}
	
	@Test
	void testGetUserId() {
		when(repo.findById(2)).thenReturn(Optional.of(user2));
		
		RahulUser userfound = serv.get(2);
		assertNotNull(userfound);
		assertEquals("student",userfound.getType());
		verify(repo,times(1)).findById(2);
	}
	
	@Test
	void testCreateUser() {//check user1 is available
		serv.create(user1);
		verify(repo,times(1)).save(user1);
	}
	
	@Test
	void testDeleteUser() {//checking whether user with id 2 is deleting
		serv.delete(2);
		verify(repo,times(1)).deleteById(2);
	}
	
	@Test
	//Testing assertion using setters
	void settertesting() {
		RahulUser user = new RahulUser();
		//adding details to user
		user.setId(7);
		user.setName("Dhoni");
		user.setType("Captain");
		user.setPassword(null);
		
		assertNotNull(user.getId());//checking whether user id is not null
		assertEquals("Dhoni",user.getName());
		assertFalse(user.getType().contains("D"));
		assertTrue(user.getName().contains("D"));
		assertNull(user.getPassword());
	}
	
	
}
