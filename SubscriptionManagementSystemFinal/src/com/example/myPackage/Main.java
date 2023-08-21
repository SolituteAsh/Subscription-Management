package com.example.myPackage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int date,month,year;
        System.out.println("Enter current day:");
        date=scanner.nextInt();
        System.out.println("Enter current month:");
        month=scanner.nextInt();
        System.out.println("Enter current year:");
        year=scanner.nextInt();

        // what time the program is being run
        Calendar runDate=Calendar.getInstance();
        runDate.set(year,month,date);



        Profile profile1= new Profile("user1");
        Profile profile2=new Profile("user2");
        Profile profile3= new Profile("user3");
        // get input
        profile1.setCustomerTier();
        // get input for balance giving 1000 for now
        profile1.setWalletBalance(1000);

        // get input for password
        profile1.setPassword("pass123");

//        System.out.println("Enter customer tier for profile2");
//
//        profile2.setCustomerTier();
        // get input for balance giving 1000 for now
        profile2.setWalletBalance(1000);
        // get input for password
        profile2.setPassword("pass123");

//        System.out.println("Enter customer tier for profile3");
//        profile3.setCustomerTier();
        // get input for balance giving 1000 for now
        profile3.setWalletBalance(1000);
        // get input for password
        profile3.setPassword("pass123");






        ArrayList<Profile> profilesList= new ArrayList<Profile>();
        profilesList.add(profile1);
        profilesList.add(profile2);
        profilesList.add(profile3);

        Calendar startDate1 = Calendar.getInstance();
        startDate1.set(2022, 7, 7);
        Calendar endDate1 = Calendar.getInstance();
        endDate1.set(2022, 9, 7);

        Calendar startDate2 = Calendar.getInstance();
        startDate2.set(2022, 8, 15);
        Calendar endDate2 = Calendar.getInstance();
        endDate2.set(2022, 10, 15);

        Calendar startDate3 = Calendar.getInstance();
        startDate3.set(2022, 05, 30);
        Calendar endDate3 = Calendar.getInstance();
        endDate3.set(2022, 11, 30);

        // change cost per year or month as per category


        Netflix netflix1a = new Netflix(8, "Netflix1", 999, 100, true, startDate1, endDate1, false, "Basic");
        Netflix netflix2 = new Netflix(8, "Netflix2", 999, 100, true, startDate2, endDate2, false, "Basic");
        Netflix netflix3 = new Netflix(8, "Netflix3", 999, 100, true, startDate3, endDate3, false, "Basic");
        netflix1a.setCategory(netflix1a.category);
        netflix2.setCategory(netflix2.category);
        netflix3.setCategory(netflix3.category);


        Calendar startDate = Calendar.getInstance();

        startDate.set(2022, 06, 10);

        Calendar testDate = Calendar.getInstance();
        testDate.set(2022, 10, 10);






        Calendar startDateNetflix1 = Calendar.getInstance();

        startDateNetflix1.set(2022, 06, 10);
        Calendar endDateNetflix1 = Calendar.getInstance();

        endDateNetflix1.set(2022, 10, 10);

        Calendar startDateSpotify1 = Calendar.getInstance();

        startDateSpotify1.set(2022, 06, 10);
        Calendar endDateSpotify1 = Calendar.getInstance();

        endDateSpotify1.set(2022, 10, 10);


        Spotify spotify1= new Spotify(3,"Spotify1",1000,99,true,startDateSpotify1,endDateSpotify1,false,"Basic");

        Spotify spotify2= new Spotify(3,"Spotify2",1000,169,true,startDateSpotify1,endDateSpotify1,false,"Premium");
        Netflix netflix1=new Netflix(3,"Netflix4",1000,100,true,startDateNetflix1,
                endDateNetflix1,false,"Basic" );

        Song song =new Song("Shape of you"," Me and my friends at the table!");
        Song song1= new Song("Done for me","Tell me what you have done for me!");
        spotify1.playlist.add(song);
        spotify1.playlist.add(song1);




        profile1.subscriptionsList.add(netflix1);
        profile1.subscriptionsList.add(netflix1a);
        profile1.subscriptionsList.add(spotify1);
        profile1.subscriptionsList.add(netflix2);
        profile1.subscriptionsList.add(netflix3);
        profile1.subscriptionsList.add(spotify2);




        Profile.displayOptions();
        int choice;
        System.out.println("Enter Choice");
        choice =scanner.nextInt();
        Profile currentProfile = null;
        while(true) {
            // assume username is right
            if (choice == 1) {
                //show subscriptions
                System.out.println("Enter username");
                scanner.nextLine();

                String a = scanner.nextLine();
                System.out.println("Current active subscriptions :");
                for (int i = 0; i < profilesList.size(); i++) {
                    if (profilesList.get(i).username.equals(a)) {

                        currentProfile = profilesList.get(i);


                        currentProfile.showSubscriptions(runDate);
                    }
                }

            } else if (choice == 2) {
                System.out.println("Enter username");
                scanner.nextLine();

                String a = scanner.nextLine();
                //renew subscription
                System.out.println("Enter name of subscription");

                for (int i = 0; i < profilesList.size(); i++) {
                    if (profilesList.get(i).username.equals(a)) {

                        currentProfile = profilesList.get(i);

                    }
                }

                String subscriptionName = scanner.nextLine();
                for (int i = 0; i < currentProfile.subscriptionsList.size(); i++) {
                    if (currentProfile.subscriptionsList.get(i).name.equals(subscriptionName)) {
                        currentProfile.renewSubscription(currentProfile.subscriptionsList.get(i));


                    }


                }
                System.out.println("Your subscription has been renewed!!");


            } else if (choice == 3) {

                //Remove subscription
                System.out.println("Enter name of subscription");
                scanner.nextLine();
                String subscriptionName = scanner.nextLine();
                for (int i = 0; i < currentProfile.subscriptionsList.size(); i++) {
                    if (currentProfile.subscriptionsList.get(i).name.equals(subscriptionName)) {
                        currentProfile.subscriptionsList.remove(currentProfile.subscriptionsList.get(i));

                    }
                }
                System.out.println("Your subscription has been cancelled!!");
            }
            else if(choice ==4){
                //create subscription
                System.out.println("Enter username :");
                scanner.nextLine();
                String a=scanner.nextLine();
                System.out.println("Enter name of subscription you want to create?");
                String subscriptionName = scanner.nextLine();

                for (int i = 0; i < profilesList.size(); i++) {
                    if (profilesList.get(i).username.equals(a)) {

                        currentProfile = profilesList.get(i);

                    }
                }
                if(subscriptionName.equals("Netflix")){
                    int date1,month1,year1;
                    System.out.println("Enter starting day:");
                    date1=scanner.nextInt();
                    System.out.println("Enter starting month:");
                    month1=scanner.nextInt();
                    System.out.println("Enter starting year:");
                    year1=scanner.nextInt();

                    Calendar startDateN = Calendar.getInstance();


                    startDateN.set(year1,month1,date1);

                    int date2,month2,year2;
                    System.out.println("Enter ending day:");
                    date2=scanner.nextInt();
                    System.out.println("Enter ending month:");
                    month2=scanner.nextInt();
                    System.out.println("Enter ending year:");
                    year2=scanner.nextInt();


                    Calendar endDateN = Calendar.getInstance();
                    endDateN.set(year2,month2,date2);

                    Netflix newNetflix= new Netflix(4,"NetflixNew",1000,100,true,
                            startDateN,endDateN,false,"Basic");

                    currentProfile.subscriptionsList.add(newNetflix);
                    System.out.println("Netflix subscription successfully created!");

                }
                else if(subscriptionName.equals("Spotify")){
                    int date1,month1,year1;
                    System.out.println("Enter starting day:");
                    date1=scanner.nextInt();
                    System.out.println("Enter starting month:");
                    month1=scanner.nextInt();
                    System.out.println("Enter starting year:");
                    year1=scanner.nextInt();

                    Calendar startDateN = Calendar.getInstance();


                    startDateN.set(year1,month1,date1);

                    int date2,month2,year2;
                    System.out.println("Enter ending day:");
                    date2=scanner.nextInt();
                    System.out.println("Enter ending month:");
                    month2=scanner.nextInt();
                    System.out.println("Enter ending year:");
                    year2=scanner.nextInt();


                    Calendar endDateN = Calendar.getInstance();
                    endDateN.set(year2,month2,date2);
                    System.out.println("Enter category :");
                    scanner.nextLine();
                    String category=scanner.nextLine();

                    Spotify newSpotify= new Spotify(4,"SpotifyNew",1000,100,true,
                            startDateN,endDateN,false,category);

                    currentProfile.subscriptionsList.add(newSpotify);
                    System.out.println("Spotify subscription has been successfully created!");





                }







            }

            else if(choice==5){


                System.out.println("Enter username :");
                scanner.nextLine();

                String a=scanner.nextLine();


                for (int i = 0; i < profilesList.size(); i++) {
                    if (profilesList.get(i).username.equals(a)) {

                        currentProfile = profilesList.get(i);

                    }
                }
                System.out.println("Enter Subscription Name");
                String subscriptionName = scanner.nextLine();

                for (int i = 0; i < currentProfile.subscriptionsList.size(); i++) {
                    if (currentProfile.subscriptionsList.get(i).name.equals(subscriptionName)) {
                        if( currentProfile.subscriptionsList.get(i).name.startsWith("N")){
                            Netflix currentNetflix= (Netflix) currentProfile.subscriptionsList.get(i);
                            System.out.println("Displaying features of your Netflix Subscription");
                            currentNetflix.displayFeatures();



                        }
                        else{

                            Spotify currentSpotify= (Spotify) currentProfile.subscriptionsList.get(i);
                            System.out.println("You have entered into your Spotify subscription! Have fun listening to " +
                                    "music!");
                            currentSpotify.showFeatures();
                        }


                    }
                }











            }
            else{
                System.out.println("Thank you for using our subscription management system! See you again");
                break;
            }
            System.out.println("Enter choice");
            choice=scanner.nextInt();

        }














    }
}
