
package com.crossover.onlinetestexam.service;

import com.crossover.onlinetestexam.model.Answer;
import com.crossover.onlinetestexam.model.Test;
import com.crossover.onlinetestexam.model.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Julian
 */

@Service("testService")
@Transactional
public class TestServiceImpl implements TestService{

    @Autowired
    TestDao dao;
    
    @Override
    public void saveTest(Test test) {
        if(test.getAnswerList() != null){
            for(Answer elem : test.getAnswerList()){
                elem.setTestid(test);
            }
        }
        dao.saveTest(test);
    }
    
}
