package com.crossover.onlinetestexam.model.dao;

import com.crossover.onlinetestexam.model.Test;
import java.util.List;

/**
 *
 * @author Julian Gomez
 */

public interface TestDao {
    
    public void saveTest(Test test);
    
    public List<Test> getTestsByCandidate(Long candidateId);
    
    public List<Test>getAllTests();
    
}
