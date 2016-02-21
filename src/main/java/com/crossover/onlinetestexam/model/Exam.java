package com.crossover.onlinetestexam.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Julian Gomez
 */
@Entity
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Long id;
    
    private String description;
    /*@OneToMany(mappedBy = "examid")
    private List<Test> testList;*/
    @OneToMany(mappedBy = "examid")
    private List<Question> questionList;

    public Exam() {
    }

    public Exam(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public List<Test> getTestList() {
        return testList;
    }

    public void setTestList(List<Test> testList) {
        this.testList = testList;
    }*/

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Exam)) {
            return false;
        }
        Exam other = (Exam) object;
        return this.id.equals(other.id);
    }

    @Override
    public String toString() {
        return "com.crossover.onlinetestexam.ent.Exam[ id=" + id + " ]";
    }
    
}
