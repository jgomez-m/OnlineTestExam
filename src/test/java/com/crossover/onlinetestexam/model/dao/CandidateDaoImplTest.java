package com.crossover.onlinetestexam.model.dao;

import com.crossover.onlinetestexam.model.Candidate;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Julian
 */
public class CandidateDaoImplTest extends EntityDaoImplTest{
    
    @Autowired
    CandidateDao dao;

    /**
     * Test of findById method, of class CandidateDaoImpl.
     */
    @Test
    public void testFindById() {
        Long id = 1L;
        assertNotNull(dao.findById(id));
        assertEquals(dao.findById(id).getId(), id);
    }
    
    @Test
    public void testGetByUsername() {
        String username = "jgomez";
        assertNotNull(dao.getByUsername(username));
    }

    /**
     * Test of saveCandidate method, of class CandidateDaoImpl.
     */
    @Test
    public void testSaveCandidate() {
        assertEquals(dao.findAllCandidates().size(), 2);
        dao.saveCandidate(getSampleCandidate());
        assertEquals(dao.findAllCandidates().size(), 3);
    }

    /**
     * Test of findAllCandidates method, of class CandidateDaoImpl.
     */
    @Test
    public void testFindAllCandidates() {
        assertNotNull(dao.findAllCandidates());
        assertEquals(dao.findAllCandidates().size(), 2);
    }

    /**
     * Test of deleteCandidate method, of class CandidateDaoImpl.
     */
    @Test
    public void testDeleteCandidate() {
        assertEquals(dao.findAllCandidates().size(), 2);
        dao.saveCandidate(getSampleCandidate());
        assertEquals(dao.findAllCandidates().size(), 3);
        dao.deleteCandidate(getSampleCandidate().getId());
        assertEquals(dao.findAllCandidates().size(), 2);
    }
    
    private Candidate getSampleCandidate(){
        Candidate c = new Candidate();
        c.setId(3L);
        c.setName("Andrea Solano");
        c.setUsername("asolano");
        c.setPassword("1234");
        return c;
    }
    
}
