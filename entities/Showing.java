package entities;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Showing implements Serializable {
    private Movie showingMovie;
    private LocalDateTime showingTime;
    private ArrayList<Seat> seating;
    private Cinema cinema;


    // Constructor 
    public Showing(Cinema cinema, LocalDateTime showTime, Movie movie){
        this.showingMovie = movie;
        this.showingTime = showTime;
        this.seating = cinema.getSeatingPlan();
        this.cinema = cinema;
        cinema.addShowing(this);
    }


    // Accessors
    public Movie getMovie(){
        return this.showingMovie;
    }
    
    public Cinema getCinema(){
        return this.cinema;
    }

    public LocalDateTime getShowtime(){
        return showingTime;
    }

    public ArrayList<Seat> getSeating(){
        return this.seating;
    }

    //Mutators
    public void setMovie(Movie movie){
        this.showingMovie = movie;
    }    

    public void setShowingTime( LocalDateTime showTime){
        this.showingTime = showTime;
    }

    /* public void setSeating(Seat seat){  
        int index = this.seating.indexOf(seat);
        this.seating.get(index).setOccupancy(true);
    } */
}