/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.onlinetestexam.service;

import com.crossover.onlinetestexam.model.Candidate;
import com.crossover.onlinetestexam.model.dao.CandidateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Julian
 */
@Service("candidateService")
@Transactional
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    CandidateDao dao;
    
    @Override
    public Candidate getById(Long id) {
        return dao.findById(id);
    }

    @Override
    public void saveCandidate(Candidate candidate) {
        dao.saveCandidate(candidate);
    }

    @Override
    public boolean validateCandidate(String username, String password) {
        Candidate c = dao.getByUsername(username);
        return (c != null  && c.getPassword().equals(password));
    }

    @Override
    public Candidate getByUsername(String username) {
        return dao.getByUsername(username);
    }
    
}
