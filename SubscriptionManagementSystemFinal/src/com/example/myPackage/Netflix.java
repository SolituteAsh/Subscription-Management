package com.example.myPackage;



import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Netflix extends Subscription {

    boolean autoRenewal;

    public String category;

    public boolean isAutoRenewal() {
        return autoRenewal;
    }

    public void setAutoRenewal(boolean autoRenewal) {
        this.autoRenewal = autoRenewal;
    }

    public String getCategory() {
        return category;
    }

    public int setCategory(String cateGory) {
        // function returns if the category has been successfully set



        // do balance check for category selection
        if(cateGory.equals("Basic")){

            this.category = cateGory;
            this.costPerMonth=199;
            return 1;
        }
        else if(cateGory.equals("Individual")){

            this.category = cateGory;
            this.costPerMonth=499;
            return 1;
        }
        else if(cateGory.equals("Premium")){

            this.category = cateGory;
            this.costPerMonth=699;
            return 1;

        }
        else{
            System.out.println("Category not found ! Please Try again");
            return 0;
        }




    }

    public Netflix(int durationInMonths, String name, int costPerYear, int costPerMonth, boolean monthlyRenewalOrNot, Calendar startDate, Calendar endDate, Boolean autoRenewal, String category) {
        super(durationInMonths,name, costPerYear, costPerMonth, monthlyRenewalOrNot, startDate, endDate,true);
        this.autoRenewal=autoRenewal;
        this.category=category;

    }
    @Override
    public  void displayPlans(){
        System.out.println("Netflix Plans:");
        System.out.println("Basic Plan Monthly Cost:199");
        System.out.println("Individual Plan Monthly Cost:499");
        System.out.println("Premium Plan Monthly Cost:699");


    }

    public void getType() {
        System.out.println("Netflix is a subscription-based streaming service.");
    }

    public void displayFeatures(){
        if(this.category.equals("Basic")){
            System.out.println("You have basic features like streaming in 720p quality in one device and access to all language content");
        }
        else if(this.category.equals("Individual")){
            System.out.println("You have features like streaming in 1080p quality in two devices and access to all language content");
        }
        else{
            System.out.println("You have features like streaming in 1440p quality in four devices and access to all language content");
        }
    }

    public String getSub(){
        return "Netflix";
    }



    public void language() {
        System.out.println("Netflix offers content in multiple languages.");
    }


    public void reward() {
        System.out.println("Netflix does not offer a reward program for its subscribers.");
    }










}
