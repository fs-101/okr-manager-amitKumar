package com.xebia.okr.okrmanageramitkumar.domain;


import javax.persistence.*;

@Entity
@Table(name = "key_results")
public class KeyResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name ="percentage_finished")
    private double percentageFinished;

    @Column(name = "confidence_score")
    private int confidenceScore;

    @Column(name = "key_result_status")
    private KeyResultsStatus keyResultsStatus;

    @ManyToOne
    @JoinColumn
    private Objective objective;

    public KeyResult() {
    }

    public KeyResult(String title, double percentageFinished, int confidenceScore, KeyResultsStatus keyResultsStatus, Objective objective) {
        this.title = title;
        this.percentageFinished = percentageFinished;
        this.confidenceScore = confidenceScore;
        this.keyResultsStatus = keyResultsStatus;
        this.objective = objective;
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

    public double getPercentageFinished() {
        return percentageFinished;
    }

    public void setPercentageFinished(double percentageFinished) {
        this.percentageFinished = percentageFinished;
    }

    public int getConfidenceScore() {
        return confidenceScore;
    }

    public void setConfidenceScore(int confidenceScore) {
        this.confidenceScore = confidenceScore;
    }

    public KeyResultsStatus getKeyResultsStatus() {
        return keyResultsStatus;
    }

    public void setKeyResultsStatus(KeyResultsStatus keyResultsStatus) {
        this.keyResultsStatus = keyResultsStatus;
    }
}
