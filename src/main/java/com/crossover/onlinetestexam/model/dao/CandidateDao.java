
package com.crossover.onlinetestexam.model.dao;

import com.crossover.onlinetestexam.model.Candidate;
import java.util.List;

/**
 *
 * @author Julian Gomez
 */
public interface CandidateDao {
    public Candidate findById(Long id);
    
    public void saveCandidate(Candidate candidate);
    
    public List<Candidate> findAllCandidates();
    
    public void deleteCandidate(Long id);
    
    public Candidate getByUsername(String username);
}
