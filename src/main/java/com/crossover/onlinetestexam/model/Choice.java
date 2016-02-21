package com.crossover.onlinetestexam.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Julian Gomez
 */
@Entity
public class Choice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Long id;
    @Lob
    private String description;
    @JoinColumn(name = "questionid", referencedColumnName = "id")
    @ManyToOne
    private Question questionid;
    @OneToMany(mappedBy = "choiceid")
    private List<Answer> answerList;

    public Choice() {
    }

    public Choice(Long id, String description, 
            Question questionid, List<Answer> answerList) {
        this.id = id;
        this.description = description;
        this.questionid = questionid;
        this.answerList = answerList;
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

    public Question getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Question questionid) {
        this.questionid = questionid;
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
        if (!(object instanceof Choice)) {
            return false;
        }
        Choice other = (Choice) object;
        return this.id.equals(other.id);
    }

    @Override
    public String toString() {
        return "com.crossover.onlinetestexam.ent.Choice[ id=" + id + " ]";
    }
    
}
