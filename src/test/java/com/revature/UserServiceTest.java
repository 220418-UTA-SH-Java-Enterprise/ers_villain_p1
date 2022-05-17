package com.revature;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.repositories.UserDAOImpl;
import com.revature.services.UserServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.TestCase;

public class UserServiceTest extends TestCase {

    private UserDAOImpl mockdao;
	private UserServiceImpl userv;
	private User u1, u2;
	List<User> mockDb;
    private UserRole role1, role2; 

    @Before
    public void setUp(){
        //1. Mock the depending class.
        mockdao = Mockito.mock(UserDAOImpl.class);
        userv = new UserServiceImpl(mockdao); 

        //2. Create mock data and add it to your mockDb
        role1 = new UserRole(1, "Employee");
        role2 = new UserRole(2, "Manager"); 

        
        u1 = new User(1,"Solsphere", "password", "Mister", "Calvin", "calvineraines@gmail.com", role2); 
        u2 = new User(2, "Juliano", "password", "Julian", "Mercado", "julianmercado@gmail.com", role2);
        

        mockDb = new ArrayList<User>(); 
        mockDb.add(u1); 
        mockDb.add(u2);
        System.out.print(mockDb);
        
    }

    // @Test
    // public void testUserDAO_addNewUser() throws Exception {
    //     User u3 = new User(3, "Leviathon", "password", "Levi", "Choi", "levichoi@gmail.com", role2);

    //     mockDb.add(u3);

    //     when(mockdao.insert(u3)).thenReturn(3);

    //     assertEquals(3,mockdao.insert(u3));
    // }

    @Test
    public void testUserService_getByIdSuccess(){
        when(mockdao.findById(2)).thenReturn(u2);

        assertEquals(u2, userv.getUserById(2));
    }





}
