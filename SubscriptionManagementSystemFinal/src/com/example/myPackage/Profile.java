package com.example.myPackage;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;



// write function for username
//initializing a username if the profile is made for the first time

public class Profile {

    // array of subscriptions
    // wallet balance
    public int walletBalance;
    public ArrayList<Subscription> subscriptionsList;

    // to check if the customer is a basic pro or ultra user;
    public String customerTier;
    public String username;
    public String password;

    // initialize it as false in constructor
    boolean firstTimePassword;


    public Profile(String username){
        this.username=username;
        this.firstTimePassword=true;
        this.subscriptionsList= new ArrayList<Subscription>();

    }



    public void setWalletBalance(int balance) {

        this.walletBalance = balance;

    }

    public void setCustomerTier(){
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter Tier :");
        String tier=scanner.nextLine();
        this.customerTier=tier;





    }

    public void setPassword(String password) {
        Scanner scanner = new Scanner(System.in);
        if (firstTimePassword) {

            this.password = password;
        } else {
            String prev_password = this.password;

            System.out.println("Enter previous password");
            String enter_prev_password = scanner.nextLine();
            if (enter_prev_password.equals(prev_password)) {
                this.password = password;
            } else {
                System.out.println("Enter right password to authenticate change of password!");
            }

        }
    }

    // basic 5 //pro 8 // ultra unlimited
    public void addSubscription(Subscription subscription) {

        if (customerTier.equals("basic")) {
            if (subscriptionsList.size() < 5) {
                subscriptionsList.add(subscription);

            } else {
                System.out.println("You have exhausted features of your membership. Please get pro or ultra membership to" +
                        "add more subscriptions! ");
            }

        } else if (customerTier.equals("pro")) {
            if (subscriptionsList.size() < 8) {
                subscriptionsList.add(subscription);

            } else {
                System.out.println("You have exhausted features of your membership. Please get ultra membership to" +
                        "add more subscriptions! ");
            }

        } else {
            subscriptionsList.add(subscription);

        }
    }

    // to check if enough balance is there to process withdrawal
    public boolean balanceIsThere(int amount) {
        if (this.walletBalance > amount) {
            return true;
        }
        return false;
    }

    public void displayFeatures(Spotify s){

    }



    public void addBalance(int amount) {
        this.walletBalance = this.walletBalance + amount;

    }

    public static void displayOptions() {
        System.out.println("1.Show subscriptions");
        System.out.println("2.Renew subscriptions");
        System.out.println("3.Cancel subscriptions");
        System.out.println("4.Add subscription");
        System.out.println("5.Show Features");


    }

    public void displaySubscription(Subscription s) {

        if (!s.categoryExists) {


            System.out.println("Subscription Name " + s.getName() + " Subscription start " + s.getStartDate().get(s.getStartDate().DATE) +" "+
                    s.getStartDate().get(s.getStartDate().MONTH)+" "+s.getStartDate().get(s.getStartDate().YEAR)+" "+
                    "Subscription End: " +s.getEndDate().get(s.getEndDate().DATE) +" "+
                    s.getEndDate().get(s.getEndDate().MONTH)+" "+s.getEndDate().get(s.getEndDate().YEAR) );
        } else {
            // get category works only if category exists flag is passed let;see see if it
            // works

            System.out.println("Subscription Name " + s.getName() + " Subscription start " + s.getStartDate().get(s.getStartDate().DATE) +" "+
                    s.getStartDate().get(s.getStartDate().MONTH)+" "+s.getStartDate().get(s.getStartDate().YEAR)+" "+
                    "Subscription End: " +s.getEndDate().get(s.getEndDate().DATE) +" "+
                    s.getEndDate().get(s.getEndDate().MONTH)+" "+s.getEndDate().get(s.getEndDate().YEAR) );

        }

    }
    public void displaySubscription(Netflix s) {


        // get subscription category somehow
        System.out.println("Subscription Name " + s.getName() + "Subscription start " + s.getStartDate().get(s.getStartDate().DATE) +" "+
                s.getStartDate().get(s.getStartDate().MONTH)+" "+s.getStartDate().get(s.getStartDate().YEAR)+" "+
                "Subscription End: " +s.getEndDate().get(s.getEndDate().DATE) +" "+
                s.getEndDate().get(s.getEndDate().MONTH)+" "+s.getEndDate().get(s.getEndDate().YEAR) + " Subscription Category :"+s.category );

    }

    public static boolean calendarProofed(Subscription s, Calendar toDate) {

        if (toDate.compareTo(s.getEndDate()) < 0 && toDate.compareTo(s.getStartDate()) > 0) {
            return true;

        }
        return false;
    }

    public void showSubscriptions(Calendar toDate) {

        for (int i = 0; i < subscriptionsList.size(); i++) {
            if (calendarProofed(subscriptionsList.get(i), toDate)) {

                displaySubscription(subscriptionsList.get(i));
            }

        }

    }

    public boolean passwordVerification() {
        // to give authorization
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password");
        String pass = scanner.nextLine();
        if (pass.equals(this.password)) {
            return true;

        } else {
            return false;
        }

    }

    public Calendar addMonths(Calendar prevCalendar, int month) {
        Calendar newCalendar = Calendar.getInstance();
        newCalendar.set(prevCalendar.get(Calendar.YEAR), (prevCalendar.get(Calendar.MONTH) + month) % 12 +1,
                prevCalendar.get(Calendar.DATE));
        return newCalendar;

    }

    public void renewSubscription(Subscription s) {

        if (passwordVerification()) {
            Scanner scanner = new Scanner(System.in);

            String renewVar="month";
            // do renewal for year also and write an year adding function
            int howManyMonths;
            System.out.println("Enter how many months?");
            howManyMonths = scanner.nextInt();
            if (balanceIsThere(howManyMonths * s.costPerMonth)) {



                s.endDate.add(Calendar.MONTH,howManyMonths);




                displaySubscription(s);

            } else {
                System.out.println("Not enough balance to add subscription");

            }

        } else {
            System.out.println("You have entered invalid password! Please try again");

        }

    }

}
