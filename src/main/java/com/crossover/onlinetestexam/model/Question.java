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
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Julian Gomez
 */
@Entity
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Long id;
    @Lob
    private String description;
    @OneToMany(mappedBy = "questionid")
    private List<Choice> choiceList;
    @JoinColumn(name = "examid", referencedColumnName = "id")
    @ManyToOne
    private Exam examid;

    public Question() {
    }

    public Question(Long id, String description, Exam examid) {
        this.id = id;
        this.description = description;
        this.examid = examid;
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

    public List<Choice> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<Choice> choiceList) {
        this.choiceList = choiceList;
    }

    public Exam getExamid() {
        return examid;
    }

    public void setExamid(Exam examid) {
        this.examid = examid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        return this.id.equals(other.id);
    }

    @Override
    public String toString() {
        return "com.crossover.onlinetestexam.ent.Question[ id=" + id + " ]";
    }
    
}
