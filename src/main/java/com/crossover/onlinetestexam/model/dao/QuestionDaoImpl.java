package com.crossover.onlinetestexam.model.dao;

import com.crossover.onlinetestexam.model.Choice;
import com.crossover.onlinetestexam.model.Question;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Julian Gomez
 */
@Repository("questionDao")
public class QuestionDaoImpl extends AbstractDao<Long, Question> 
        implements QuestionDao{

    @Override
    public Question findById(Long id) {
        return getByKey(id);
    }

    @Override
    public void saveQuestion(Question question) {
        persist(question);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Question> findQuestionsByExam(Long examId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("examid.id", examId));
        return (List<Question>) criteria.list();
    }

    @Override
    public List<Choice> getChoicesByQuestion(Long id) {
        Question q = getByKey(id);
        return q.getChoiceList();
    }
    
}
