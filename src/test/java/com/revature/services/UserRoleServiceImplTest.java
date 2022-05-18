package com.revature.services;

import static org.mockito.Mockito.when;

import com.revature.models.UserRole;
import com.revature.repositories.UserRoleDAOImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.TestCase;

public class UserRoleServiceImplTest extends TestCase {

  private UserRoleDAOImpl mockdao;
  private UserRoleServiceImpl userv;

  @Before
  public void setUp() {
    mockdao = Mockito.mock(UserRoleDAOImpl.class);
    userv = new UserRoleServiceImpl(mockdao);
  }

  @Test
  public void testGetByRoleId() {
    UserRole ur = new UserRole(1, "employee");

    when(mockdao.findByRoleId(1)).thenReturn(ur);
    assertEquals("employee", ur.getRole());
  }
}
