package com.revature.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.ReimbType;
import com.revature.repositories.ReimbTypeDAOImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.TestCase;

public class ReimbTypeServiceTest extends TestCase {

    private ReimbTypeDAOImpl mockdao;
	private ReimbTypeServiceImpl reimb_Type;
	private ReimbType type1, type2, type3, type4;
	List<ReimbType> mockTypeDb;
    

    @Before
    public void setUp(){
        //1. Mock the depending class.
        mockdao = Mockito.mock(ReimbTypeDAOImpl.class);
        reimb_Type = new ReimbTypeServiceImpl(mockdao); 

        //2. Create mock data and add it to your mockDb
        type1 = new ReimbType(1, "Lodging");
        type2 = new ReimbType(2, "Travel"); 
        type3 = new ReimbType(3, "Food"); 
        type4 = new ReimbType(4, "Other"); 

        mockTypeDb = new ArrayList<ReimbType>(); 
        mockTypeDb.add(type1); 
        mockTypeDb.add(type2); 
        mockTypeDb.add(type3); 
        mockTypeDb.add(type4); 
        
    }

    @Test
    public void testGetTypeById_Success(){
        when(mockdao.findById(2)).thenReturn(type2);

        assertEquals(type2, reimb_Type.getById(2));
    }

}
