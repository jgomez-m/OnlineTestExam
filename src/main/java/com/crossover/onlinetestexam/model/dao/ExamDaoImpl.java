
package com.crossover.onlinetestexam.model.dao;

import com.crossover.onlinetestexam.model.Exam;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Julian
 */
@Repository("examDao")
public class ExamDaoImpl extends AbstractDao<Long, Exam> implements ExamDao {

    
    @Override
    public Exam findById(Long id) {
        return getByKey(id);
    }
    
}
