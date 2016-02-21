package com.crossover.onlinetestexam.model.dao;

import com.crossover.onlinetestexam.model.Candidate;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Julian
 */
@Repository("candidateDao")
public class CandidateDaoImpl extends AbstractDao<Long, Candidate> 
        implements CandidateDao{

    @Override
    public Candidate findById(Long id) {
        return getByKey(id);
    }

    @Override
    public void saveCandidate(Candidate candidate) {
        persist(candidate);
    }

    @Override
    public List<Candidate> findAllCandidates() {
        Criteria criteria = createEntityCriteria();
        return (List<Candidate>) criteria.list();
    }

    @Override
    public void deleteCandidate(Long id) {
        Query query = getSession().createQuery("delete Candidate where"
                + " id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }

    @Override
    public Candidate getByUsername(String username) {
         Criteria criteria = createEntityCriteria();
         criteria.add(Restrictions.eq("username", username));
         return (Candidate) criteria.uniqueResult();
    }
    
}
