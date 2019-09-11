package com.xebia.okr.okrmanageramitkumar.domain;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "objectives")
public class Objective {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name="labels")
    private String labels;

    @ManyToOne
    @JoinColumn
    private Plan plan;

    @OneToMany(mappedBy = "objective")
    private List<KeyResult> keyResults;

    public Objective() {
    }

    public Objective(String title, String labels, Plan plan) {
        this.title = title;
        this.labels = labels;
        this.plan = plan;
    }

    @Override
    public String toString() {
        return super.toString() + "\ntitle: " + title + "\nlabel: " + labels + "\nplan: " + plan;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public List<KeyResult> getKeyResults() {
        return keyResults;
    }

    public void setKeyResults(List<KeyResult> keyResults) {
        this.keyResults = keyResults;
    }
}

