package com.crossover.onlinetestexam.model.dao;

import com.crossover.onlinetestexam.model.Choice;
import com.crossover.onlinetestexam.model.Question;
import java.util.List;

/**
 * @author Julian Gomez
 */
public interface QuestionDao {
    public Question findById(Long id);
    
    public void saveQuestion(Question question);
    
    public List<Question> findQuestionsByExam(Long examId);
    
    public List<Choice> getChoicesByQuestion(Long id);
    
}
