package com.tommy.studentmanager.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "major")
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "major_id", unique = true, nullable = false)
    private Long id;


    @Column(name = "alias")
    private String alias;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "history")
    private String history;

    @OneToMany(mappedBy="major")
    private Set<Student> students;

    public Long getId() {
        return id;
    }

    public void setId(Long  id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
