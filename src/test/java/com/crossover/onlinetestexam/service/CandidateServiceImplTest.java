package com.crossover.onlinetestexam.service;

import com.crossover.onlinetestexam.model.Candidate;
import com.crossover.onlinetestexam.model.Question;
import com.crossover.onlinetestexam.model.dao.CandidateDao;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Julian
 */
@RunWith(MockitoJUnitRunner.class)
public class CandidateServiceImplTest {
    
    @InjectMocks
    CandidateServiceImpl service;
    
    @Mock
    CandidateDao dao;

    /**
     * Test of getById method, of class CandidateServiceImpl.
     */
    @Test
    public void testGetById() {
        Long id1 = 1L; 
        Long id2 = 2L;
        String cand1 = "Candidate 1"; 
        String cand2 = "Candidate 2";
        Candidate c1 = new Candidate(id1);
        c1.setName(cand1);
        Candidate c2 = new Candidate(id2);
        c2.setName(cand2);
        when(dao.findById(id1)).thenReturn(c1);
        when(dao.findById(id2)).thenReturn(c2);
        
        Candidate c = service.getById(id1);
        assertEquals(c, c1);
        assertEquals(c.getName(), cand1);
    }

    /**
     * Test of saveCandidate method, of class CandidateServiceImpl.
     */
    @Test
    public void testSaveCandidate() {
        //Stub
        Candidate candidate = getSample();
        doNothing().when(dao).saveCandidate(any(Candidate.class));
        //Testing
        service.saveCandidate(candidate);
        verify(dao, atLeastOnce()).saveCandidate(any(Candidate.class));
    }

    /**
     * Test of validateCandidate method, of class CandidateServiceImpl.
     */
    @Test
    public void testValidateCandidate() {
        String username = getSample().getUsername();
        String passwd = getSample().getPassword();
        when(dao.getByUsername(username)).thenReturn(getSample());
        assertTrue(service.validateCandidate(username, passwd));
        
        when(dao.getByUsername("jgomez")).thenReturn(null);
        assertFalse(service.validateCandidate("jgomez", "1234"));
    }
    
    private Candidate getSample(){
        Candidate c = new Candidate();
        c.setId(3L);
        c.setName("Andrea Solano");
        c.setUsername("asolano");
        c.setPassword("1234");
        return c;
    }
    
}
