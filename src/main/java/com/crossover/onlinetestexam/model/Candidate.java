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
public class Candidate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Long id;
    @Basic(optional = false)
    private String name;
    @Basic(optional = false)
    private String username;
    @Basic(optional = false)
    private String password;
    @OneToMany(mappedBy = "candidateid")
    private List<Test> testList;

    public Candidate() {
    }

    public Candidate(Long id) {
        this.id = id;
    }

    public Candidate(Long id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Test> getTestList() {
        return testList;
    }

    public void setTestList(List<Test> testList) {
        this.testList = testList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Candidate)) {
            return false;
        }
        Candidate other = (Candidate) object;
        return this.id.equals(other.id);
    }

    @Override
    public String toString() {
        return "com.crossover.onlinetestexam.ent.Candidate[ id=" + id + " ]";
    }
    
}
