package com.crossover.onlinetestexam.model.dao;

import com.crossover.onlinetestexam.model.Choice;
import com.crossover.onlinetestexam.model.Exam;
import com.crossover.onlinetestexam.model.Question;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Julian
 */
public class QuestionDaoImplTest extends EntityDaoImplTest{

    @Autowired
    QuestionDao dao;
    
    private static final Long EXAMID = 1L;
    
    @Test
    public void findById(){
        assertNotNull(dao.findById(1L));
        assertNull(dao.findById(3L));
    }
    
    @Test
    public void saveQuestion(){
        assertEquals(dao.findQuestionsByExam(EXAMID).size(), 2);
        dao.saveQuestion(getSampleQuestion());
        assertEquals(dao.findQuestionsByExam(1L).size(), 3);
    }
    
    @Test
    public void saveQuestionWithChoices(){
        Question q = getSampleQuestion();
        List<Choice> choiceList = new ArrayList<>();
        choiceList.add(new Choice(10L, "Choice", q, null));
        q.setChoiceList(choiceList);
        dao.saveQuestion(q);
        assertNotNull(dao.findById(3L));
        assertNotNull(dao.findById(3L).getChoiceList());
        assertEquals(dao.findById(3L).getChoiceList().size(), 1);
    }
    
    @Test
    public void findQuestionsByExam(){
        assertNotNull(dao.findQuestionsByExam(EXAMID));
        assertEquals(dao.findQuestionsByExam(EXAMID).size(), 2);
    }
    
    @Test
    public void getChoicesByQuestion(){
        assertNotNull(dao.getChoicesByQuestion(1L));
        assertNotNull(dao.getChoicesByQuestion(2L));
        assertEquals(dao.getChoicesByQuestion(1L).size(), 3);
        assertEquals(dao.getChoicesByQuestion(2L).size(), 2);
    }
    
    private Question getSampleQuestion(){
        Question q = new Question();
        q.setId(3L);
        q.setDescription("Description 3");
        q.setExamid(new Exam(1L));
        return q;
    }
}
