package com.crossover.onlinetestexam.model.dao;

import com.crossover.onlinetestexam.model.Candidate;
import com.crossover.onlinetestexam.model.Exam;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Julian
 */
public class TestDaoImplTest extends EntityDaoImplTest {

    @Autowired
    TestDao dao;

    /**
     * Test of saveTest method, of class TestDaoImpl.
     */
    @Test
    public void testSaveTest() {
        assertEquals(dao.getAllTests().size(), 3);
        dao.saveTest(getSampleTest());
        assertEquals(dao.getAllTests().size(), 4);
    }

    /**
     * Test of getTestsByCandidate method, of class TestDaoImpl.
     */
    @Test
    public void testGetTestsByCandidate() {
        assertNotNull(dao.getTestsByCandidate(1L));
        assertEquals(dao.getTestsByCandidate(1L).size(), 2);
    }

    private com.crossover.onlinetestexam.model.Test getSampleTest() {
        com.crossover.onlinetestexam.model.Test t = new com.crossover.onlinetestexam.model.Test();        
        t.setGrade(10.0);
        t.setExamid(new Exam(1L));
        t.setCandidateid(new Candidate(1L));
        return t;
    }

}
