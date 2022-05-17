package com.revature.services;

import static org.mockito.Mockito.when;

import com.revature.models.ReimbType;
import com.revature.repositories.ReimbTypeDAOImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.TestCase;

public class ReimbTypeServiceImplTest extends TestCase {

  private ReimbTypeDAOImpl mockdao;
  private ReimbTypeServiceImpl rserv;

  @Before
  public void setUp() {
    mockdao = Mockito.mock(ReimbTypeDAOImpl.class);
    rserv = new ReimbTypeServiceImpl(mockdao);
  }

  @Test
  public void testGetById() {
    ReimbType rt = new ReimbType(1, "food");

    when(mockdao.findById(1)).thenReturn(rt);
    assertEquals("food", rserv.getById(1).getrType());
  }
}
