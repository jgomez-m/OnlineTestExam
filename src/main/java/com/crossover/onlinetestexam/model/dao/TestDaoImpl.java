package com.crossover.onlinetestexam.model.dao;

import com.crossover.onlinetestexam.model.Test;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;



/**
 *
 * @author Julian
 */
@Repository("testDao")
public class TestDaoImpl extends AbstractDao<Long, Test> 
    implements TestDao{

    @Override
    public void saveTest(Test test) {
        persist(test);
    }

    @Override
    public List<Test> getTestsByCandidate(Long candidateId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("candidateid.id", candidateId));
        return (List<Test>) criteria.list();
    }

    @Override
    public List<Test> getAllTests() {
        Criteria criteria = createEntityCriteria();
        return (List<Test>) criteria.list();
    }
    
}
