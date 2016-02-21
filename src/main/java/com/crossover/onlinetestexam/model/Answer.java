package com.crossover.onlinetestexam.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Julian Gomez
 */
@Entity
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @JoinColumn(name = "testid", referencedColumnName = "id")
    @ManyToOne
    private Test testid;
    @JoinColumn(name = "choiceid", referencedColumnName = "id")
    @ManyToOne
    private Choice choiceid;

    public Answer() {
    }

    public Answer(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Test getTestid() {
        return testid;
    }

    public void setTestid(Test testid) {
        this.testid = testid;
    }

    public Choice getChoiceid() {
        return choiceid;
    }

    public void setChoiceid(Choice choiceid) {
        this.choiceid = choiceid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Answer)) {
            return false;
        }
        Answer other = (Answer) object;
        return this.id.equals(other.id);
    }

    @Override
    public String toString() {
        return "Answer = [ id=" + id + " testid= "+ testid+ " choiceid="+ 
                choiceid+"] ";
    }
    
}
