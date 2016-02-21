package com.crossover.onlinetestexam.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Julian Gomez
 */
@Entity
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    
    private Double grade;
    @JoinColumn(name = "examid", referencedColumnName = "id")
    @ManyToOne
    private Exam examid;
    @JoinColumn(name = "candidateid", referencedColumnName = "id")
    @ManyToOne
    private Candidate candidateid;
    @OneToMany(mappedBy = "testid")
    @Cascade(CascadeType.PERSIST)
    private List<Answer> answerList;
            
    public Test() {
    }

    public Test(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Exam getExamid() {
        return examid;
    }

    public void setExamid(Exam examid) {
        this.examid = examid;
    }

    public Candidate getCandidateid() {
        return candidateid;
    }

    public void setCandidateid(Candidate candidateid) {
        this.candidateid = candidateid;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        return this.id.equals(other.id);
    }

    @Override
    public String toString() {
        return "com.crossover.onlinetestexam.ent.Test[ id=" + id + " ]";
    }
    
}
