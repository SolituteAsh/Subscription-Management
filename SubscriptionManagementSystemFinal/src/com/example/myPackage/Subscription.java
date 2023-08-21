package com.example.myPackage;




import java.util.Calendar;
import java.util.Date;

public class Subscription {

    int durationInMonths;
    //user name
    String name;
    int costPerYear;
    int costPerMonth;
    boolean monthlyRenewalOrNot;
    Calendar startDate;
    Calendar endDate;

    // if the subscription is a standalone one or are there further subcategories

    boolean categoryExists;

//assume that every subscription has a yearly renewal


    public Subscription(int durationInMonths, String name, int costPerYear, int costPerMonth, boolean monthlyRenewalOrNot, Calendar startDate, Calendar endDate, boolean categoryExists) {
        this.durationInMonths = durationInMonths;
        this.name = name;
        this.costPerYear = costPerYear;
        this.costPerMonth = costPerMonth;
        this.monthlyRenewalOrNot = monthlyRenewalOrNot;
        this.startDate = startDate;
        this.endDate = endDate;
        this.categoryExists = categoryExists;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(int durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCostPerYear() {
        return costPerYear;
    }

    public void setCostPerYear(int costPerYear) {
        this.costPerYear = costPerYear;
    }

    public int getCostPerMonth() {
        return costPerMonth;
    }

    public void setCostPerMonth(int costPerMonth) {
        this.costPerMonth = costPerMonth;
    }

    public boolean isMonthlyRenewalOrNot() {
        return monthlyRenewalOrNot;
    }

    public void setMonthlyRenewalOrNot(boolean monthlyRenewalOrNot) {
        this.monthlyRenewalOrNot = monthlyRenewalOrNot;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }
    // remove this after testing
    public void printYes(){
        System.out.println("Print HIIII");
    }
    public void displayPlans(){
        System.out.println("Hi");
    }





}
