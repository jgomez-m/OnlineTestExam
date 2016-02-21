package com.crossover.onlinetestexam.service;

import com.crossover.onlinetestexam.model.Choice;
import com.crossover.onlinetestexam.model.Question;
import com.crossover.onlinetestexam.model.dao.QuestionDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Julian Gomez
 */
@Service("questionService")
@Transactional
public class QuestionServiceImpl implements QuestionService {
    
    @Autowired
    private QuestionDao dao;

    @Override
    public List<Question> getQuestionsByExam(Long examId) {
        return dao.findQuestionsByExam(examId);
    }

    @Override
    public Question getById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Choice> getChoices(Question question) {
        return dao.getChoicesByQuestion(question.getId());
    }

    @Override
    public void saveQuestion(Question question) {
        dao.saveQuestion(question);
    }   
}
