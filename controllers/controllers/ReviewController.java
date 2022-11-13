package controllers;

import entities.Review;

import java.util.ArrayList;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class ReviewController implements Serializable{
    private static ArrayList<Review> reviewList;
    private static ReviewController controllerInstance = null;
    private static final String filepath = "reviews.ser";

    @SuppressWarnings("unchecked")
    public static ReviewController getController() {
        if (controllerInstance == null) {
            controllerInstance = new ReviewController();
        }
        
        if (reviewList==null){
            System.out.println("No reviewList found; creating new file.");
            reviewList = new ArrayList<Review>();
            saveData(reviewList);
        }
        reviewList = (ArrayList<Review>)loadData();
        return controllerInstance;
    }

    public void createReview(String movieName, int rating, String comments, String reviewer){ // TODO review does not increase in size at all.
        Review review = new Review(movieName, rating, comments, reviewer);
        reviewList.add(review);
    }

    public void listReviews(String movieName)
    {
        if(reviewList.size()==0) {
            System.out.println("There is currently no reviews for this movie yet");
            
            return;
        }
    
        for (int i = 0; i < reviewList.size(); i++){
            if (reviewList.get(i).getMovieName() == movieName)
            {
                System.out.println(reviewList.get(i).getRating());
                System.out.printf("By: %s\n", reviewList.get(i).getReviewer());
                System.out.println(reviewList.get(i).getReview());
                System.out.println();
            }
        }
    }

    public static void saveData(ArrayList<Review> bookingObj){  
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        
            objectOut.writeObject(bookingObj);
            objectOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object loadData(){
        try{
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();
            objectIn.close();
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }        
    }


}