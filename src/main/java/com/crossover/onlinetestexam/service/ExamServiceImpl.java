package com.crossover.onlinetestexam.service;

import com.crossover.onlinetestexam.model.dao.ExamDao;
import com.crossover.onlinetestexam.model.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Julian
 */
@Service("examService")
@Transactional
public class ExamServiceImpl implements ExamService{

    @Autowired
    private ExamDao dao;
    
    @Override
    public Exam findById(Long id) {
        return dao.findById(id);
    }
    
}
