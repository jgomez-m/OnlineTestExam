package com.crossover.onlinetestexam.service;

import com.crossover.onlinetestexam.model.Choice;
import com.crossover.onlinetestexam.model.Exam;
import com.crossover.onlinetestexam.model.Question;
import com.crossover.onlinetestexam.model.dao.QuestionDao;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Julian Gomez
 */
@RunWith(MockitoJUnitRunner.class)
public class QuestionServiceImplTest {
    
    @InjectMocks
    QuestionServiceImpl service;
    
    @Mock
    QuestionDao dao;
    
    @Spy
    private static List<Question> questionList = new ArrayList<>();
    private static final Long EXAMID = 1L;
    
    @BeforeClass
    public static void setUp(){
        questionList = getQuestions(); 
    }
    
    
    private static List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(10L,"Q1-Test", new Exam(EXAMID)));
        questions.add(new Question(11L,"Q2-Test", new Exam(EXAMID)));
        questions.add(new Question(11L,"Q3-Test", new Exam(EXAMID)));
        return questions;
    }
    
    @Test
    public void getQuestionsByExam(){
        when(dao.findQuestionsByExam(EXAMID)).thenReturn(questionList);
        assertNotNull(service.getQuestionsByExam(EXAMID));
        assertEquals(service.getQuestionsByExam(EXAMID), questionList);
        assertTrue("Question List size is equal to 0", questionList.size() > 0);
    }
    
    @Test
    public void getById() {
        Long id1 = 10L; 
        Long id2 = 11L;
        String quest1 = "Q1-Test"; 
        String quest2 = "Q2-Test";
        Question q1 = questionList.get(0);
        Question q2 = questionList.get(1);
        when(dao.findById(id1)).thenReturn(q1);
        when(dao.findById(id2)).thenReturn(q2);
        
        Question q = service.getById(id1);
        assertEquals(q, questionList.get(0));
        assertEquals(q.getDescription(), quest1);
        assertNotNull(q.getExamid());
        
        q = service.getById(id2);
        assertEquals(q, questionList.get(1));
        assertEquals(q.getDescription(), quest2);
        assertNotNull(q.getExamid());
    }
    
    @Test
    public void getChoices() {
        List<Choice> choices = new ArrayList<>();
        Long id = 1L;
        String desc = "This is the text of the choice";
        choices.add(new Choice(id, desc, questionList.get(0), null));
        when(dao.getChoicesByQuestion(10L)).thenReturn(choices);
        
        Question q = questionList.get(0);
        assertEquals(service.getChoices(q), choices);
        assertEquals(service.getChoices(q).size(), 1);
        Choice choice = service.getChoices(q).get(0);
        assertEquals(choice.getDescription(), desc);
        assertEquals(choice.getId(), id);
        assertNull(choice.getAnswerList());

    }

    @Test
    public void saveQuestion() {
        //Stub
        Question question = questionList.get(0);
        doNothing().when(dao).saveQuestion(any(Question.class));
        //Testing
        service.saveQuestion(question);
        verify(dao, atLeastOnce()).saveQuestion(any(Question.class));
    }
    
}
