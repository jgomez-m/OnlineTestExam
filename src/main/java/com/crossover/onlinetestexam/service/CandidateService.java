package com.crossover.onlinetestexam.service;

import com.crossover.onlinetestexam.model.Candidate;

/**
 *
 * @author Julian
 */
public interface CandidateService {
    
    public Candidate getById(Long id);
    
    public void saveCandidate(Candidate candidate);
    
    public boolean validateCandidate(String username, String password);

    public Candidate getByUsername(String username);
    
}
