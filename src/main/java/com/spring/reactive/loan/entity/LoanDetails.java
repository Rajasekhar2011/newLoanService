package com.spring.reactive.loan.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class LoanDetails {

    @Id
    private String loanId;
    private String userId;
    private String loanType;
    private Double loanAmount;
    private LocalDate loanDate;
    private Double rateOfInterest;
    private Double durationInYears;

    public LoanDetails(){

    }

    public LoanDetails(String loanId,String userId, String loanType, Double loanAmount, LocalDate loanDate, Double rateOfInterest, Double durationInYears) {
        this.loanId=loanId;
        this.userId = userId;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
        this.loanDate = loanDate;
        this.rateOfInterest = rateOfInterest;
        this.durationInYears = durationInYears;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public Double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(Double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public Double getDurationInYears() {
        return durationInYears;
    }

    public void setDurationInYears(Double durationInYears) {
        this.durationInYears = durationInYears;
    }

    @Override
    public String toString() {
        return "LoanDetails{" +
                "loanId='" + loanId + '\'' +
                ", userId='" + userId + '\'' +
                ", loanType='" + loanType + '\'' +
                ", loanAmount=" + loanAmount +
                ", loanDate=" + loanDate +
                ", rateOfInterest=" + rateOfInterest +
                ", durationInYears=" + durationInYears +
                '}';
    }
}
