package com.example.myPackage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Spotify extends Subscription implements Music{

    //things to be done

    //add songs count as an member variable


    private String name;

    ArrayList<Song> playlist;
    int playTime;
    boolean autoRenewal;
    String category;
    public Spotify(int durationInMonths, String name, int costPerYear, int costPerMonth, boolean monthlyRenewalOrNot, Calendar startDate, Calendar endDate, Boolean autoRenewal, String category) {
        super(durationInMonths, name, costPerYear, costPerMonth, monthlyRenewalOrNot, startDate, endDate,true);
        this.autoRenewal=autoRenewal;
        this.category=category;
        this.playlist= new ArrayList<Song>();

    }
    public int setCategory() {
        // function returns if the category has been successfully set
        String cateGory;
        displayPlans();
        Scanner scanner=new Scanner(System.in);
        cateGory=scanner.nextLine();
        // do balance check for category selection
        if(cateGory.equals("Basic")){

            this.category = cateGory;
            return 1;
        }
        else if(cateGory.equals("Standard")){

            this.category = cateGory;
            return 1;
        }
        else if(cateGory.equals("Premium")){

            this.category = cateGory;
            return 1;

        }
        else{
            System.out.println("Category not found ! Please Try again");
            return 0;
        }
    }

    public String getSub(){
        return "Spotify";
    }

    public void addMusic(Song song) {
        int count = playlist.size();
        if (category.equals("Basic")) {
            //System.out.println("You can have a maximum of 5 songs in yur playlist!")
            playlist.add(song);
            count++;
            if (count > 5) {
                System.out.println("Basic subscription can hold only 5 songs in your playlist!");

            }
        }
        if (category.equals("Standard")) {
            //System.out.println("You can have a maximum of 5 songs in yur playlist!")
            playlist.add(song);
            count++;
            if (count > 10) {
                System.out.println("Standard subscription can hold only 10 songs in your playlist!");

            }
        }
        if (category.equals("Premium")) {
            //System.out.println("You can have a maximum of 5 songs in yur playlist!")
            playlist.add(song);
        }
    }
        public void removeMusic(Song song){
            playlist.remove(song);
        }
        public void playMusic(){

            if(category.equals("Basic")){
                for(Song song:playlist){
                    System.out.println(song.name);
                    displayAd(5000);
                }
                System.out.println("Thanks for listening to spotify");
            }
            if(category.equals("Standard")){
                for(Song song:playlist){
                    System.out.println(song.name);
                    displayAd(3000);
                }
                System.out.println("Thanks for listening to spotify");
            }
            //no ads for premium
            if(category.equals("Premium")){
                for(Song song:playlist){
                    System.out.println(song.name);

                }
            }
            System.out.println("Thanks for listening to spotify premium");




        }
        public void displayLyrics(Song song){
            if(category.equals("Premium")){
                System.out.println("Lyrics of the song:\n"+song.lyrics);
            }
            else{
                System.out.println("You need Premium subscription to view the lyrics!");
            }
        }

        public void showFeatures(){
        Scanner scanner= new Scanner(System.in);


            System.out.println("Enter choice " +
                    "1.Add song to playlist " +
                    " 2.Display Lyrics "+
                    " 3.Remove Song "+
                    " 4.Display playlist "
                    );
            System.out.println("Enter Choice");
            int choice=scanner.nextInt();

        while(true){
            if(choice==1){
                Song newSong= new Song();
                System.out.println("Enter song name");
                scanner.nextLine();
                String name=scanner.nextLine();
                System.out.println("Enter lyrics");
                String lyrics=scanner.nextLine();
                newSong.name=name;
                newSong.lyrics=lyrics;
                addMusic(newSong);


            }
            else if (choice==2){
                System.out.println("Enter the song name to display lyrics: ");
                scanner.nextLine();
                String songname=scanner.nextLine();


                for(int i=0;i<playlist.size();i++){
                    if(playlist.get(i).name.equals(songname)){
                        displayLyrics(playlist.get(i));

                    }

                }


            }
            else if(choice ==3){
                System.out.println("Enter the song name to remove from your playlist ");
                scanner.nextLine();
                String songname=scanner.nextLine();


                for(int i=0;i<playlist.size();i++){
                    if(playlist.get(i).name.equals(songname)){
                        removeMusic(playlist.get(i));

                    }

                }

            }
            else if(choice==4){
                playMusic();
            }
            else{
                break;
            }
            System.out.println("Enter choice");
            choice=scanner.nextInt();



        }
        }

public void displayPlans(){
            System.out.println("Basic subscription - Cost 49/Month Features: 5 songs in playlist ");
            System.out.println("Standard subscription Cost 69/Month can hold only 10 songs in your playlist!");
            System.out.println("Premium subscription Cost 99/month can hold  unlimited songs in your playlist  and  No ads ");
        }
// check if it does playlist
       public  void displayList(){
            for(int i=0;i<playlist.size();i++){
                System.out.println("Song name:"+playlist.get(i).name);
                System.out.println("Song lyrics "+playlist.get(i).lyrics);

            }
        }
//to check if payment has been processsed then proceed
        //also should check if category is in the three possibilities
        public int setCategory(boolean PaymentProcessed, String category){
            if(PaymentProcessed){
                if(category.equals("Basic") || category.equals("Standard") || category.equals("Premium")){
                    return 1;
                }
                else{
                    System.out.println("You have not paid for your subscription or the subscription type that has been entered is invalid please try again!");
                    return 0;
                }
            }
            return 0;
        }


        public void displayAd(int milliseconds){
            //this will pause the execution for 2000 milliseconds to simulate
            //display of adds remove it if it doesn't work
            System.out.println("Advertisement is being displayed please wait");
            try{
                Thread.sleep(milliseconds);
            }catch(InterruptedException e){
            }

        }










    }