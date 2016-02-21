package com.crossover.onlinetestexam.controller;

import com.crossover.onlinetestexam.model.Answer;
import com.crossover.onlinetestexam.model.Candidate;
import com.crossover.onlinetestexam.model.Choice;
import com.crossover.onlinetestexam.model.Exam;
import com.crossover.onlinetestexam.model.Question;
import com.crossover.onlinetestexam.model.Test;
import com.crossover.onlinetestexam.service.CandidateService;
import com.crossover.onlinetestexam.service.ExamService;
import com.crossover.onlinetestexam.service.QuestionService;
import com.crossover.onlinetestexam.service.TestService;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Julian Gomez
 */
@Controller
public class OnlineTestExamController {

    @Autowired
    private QuestionService questionSvc;
    @Autowired
    private CandidateService candidateSvc;
    @Autowired
    private TestService testService;
    @Autowired
    private ExamService examService;

    private static final Long EXAMID = 1L; //already into the DB
    
    private List<Answer> answerList;
    
    private List<Question> questionList;
    
    private ListIterator<Question> iterator;
    
    private Exam exam;
    
    private String username;
    

    /**
     * Validate User, if does not exist throws an UserNotFoundException
     * @param model
     * @return Go to index page
     */
    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login(ModelMap model){
        model.addAttribute("candidate", new Candidate());
        answerList = new ArrayList<>();
        exam = examService.findById(EXAMID);
        model.addAttribute("examDescription", exam.getDescription());
        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submitLogin(@ModelAttribute("candidate") Candidate c, 
            BindingResult result, ModelMap model){
        if (result.hasErrors()) {
            return "login";
        }
        username = c.getUsername();
        String passwd = c.getPassword();
        try{
            validateUser(username, passwd);
        } catch(RuntimeException e){
            FieldError userError = new FieldError("candidate","username", 
                    "User authentication error");
            result.addError(userError);
            return "login";
        }
        questionList = questionSvc.getQuestionsByExam(EXAMID);
        iterator = questionList.listIterator();
        iterator.next();
        model.addAttribute("questionList", questionList);
        model.addAttribute("candidate", username);
        model.addAttribute("question", new Question());
        return "questions";

    }
    
    @RequestMapping(value = "/viewQuestions", method = RequestMethod.GET)
    public String viewAllQuestions(ModelMap model){
        model.addAttribute("questionList", questionList);
        model.addAttribute("question", new Question());
        return "questions";
    }

    @RequestMapping(value= "/viewQuestion", method = RequestMethod.GET)
    public String selectQuestion(@ModelAttribute("question") Question q, 
            ModelMap model) {
        q = questionSvc.getById(q.getId());
        model.addAttribute("questionSelected", q);
        model.addAttribute("choice", new Choice());
        return "viewQuestion";
    }

    @RequestMapping(value = "/nextQuestion", method = RequestMethod.GET)
    public String nextQuestion(@ModelAttribute("choice") Choice choice, 
            ModelMap model){
        Answer answer = new Answer();
        answer.setChoiceid(choice);
        answerList.add(answer);
        //Get next question
        Question q;
        if(iterator.hasNext()){
            q = iterator.next();
        } else{
            return "lastquestion";
        }
        model.addAttribute("questionSelected", q);
        model.addAttribute("choice", new Choice());
        return "viewQuestion";
    }   
    
    @RequestMapping(value = "/submitExam", method = RequestMethod.POST)
    public String submitExam(ModelMap model) {
        Test test = new Test();
        test.setAnswerList(answerList);
        Candidate candidate = candidateSvc.getByUsername(username);
        test.setCandidateid(candidate);
        test.setExamid(new Exam(EXAMID));
        test.setGrade(calculateGrade());
        testService.saveTest(test);
        model.addAttribute("grade", test.getGrade());
        return "grade";
    }
    
    private void validateUser(String username, String password){
        if(!candidateSvc.validateCandidate(username, password)){
            throw new UserNotFoundException(username);
        }
    }

    private Double calculateGrade() {
        return Math.floor(Math.random()*(0-(10+1))+(10+1));
    }
    
    class UserNotFoundException extends RuntimeException {

        public UserNotFoundException(String userName) {
            super("could not find user '" + userName);
        }
    }
}
