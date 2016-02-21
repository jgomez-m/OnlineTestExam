package com.crossover.onlinetestexam.service;

import com.crossover.onlinetestexam.model.Choice;
import com.crossover.onlinetestexam.model.Question;
import java.util.List;


/**
 *
 * @author Julian Gomez
 */

public interface QuestionService {
    
    public List<Question> getQuestionsByExam(Long examId);
    
    public Question getById(Long id);
    
    public List<Choice> getChoices(Question question);
    
    public void saveQuestion(Question question);
    
}
