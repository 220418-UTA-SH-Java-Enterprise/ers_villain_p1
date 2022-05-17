package com.revature.services;

import static org.mockito.Mockito.when;

import com.revature.models.ReimbStatus;
import com.revature.repositories.ReimbStatusDAOImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import junit.framework.TestCase;

public class ReimbStatusServiceTest extends TestCase {
  
  private ReimbStatusDAOImpl mockdao;
  private ReimbStatusServiceImpl rserv;

  @Before
  public void setUp() {
    
    mockdao = Mockito.mock(ReimbStatusDAOImpl.class);
    rserv = new ReimbStatusServiceImpl(mockdao);
    
  }

  @Test
  public void testgetReimbStatusById() {

    ReimbStatus r = new ReimbStatus(1, "processing");

    when(mockdao.findReimbStatusById(1)).thenReturn(r);
    assertEquals("processing", rserv.getReimbStatusById(1).getReimbStatusStatus());

  }

}
