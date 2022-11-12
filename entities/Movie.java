package entities;
import java.util.ArrayList;
import java.lang.Comparable;
import java.io.Serializable;

public class Movie implements Comparable<Movie>, Serializable{
    // TODO movie type (blockbuster/3D) should be in this class?
    private String movieName;
    private long movieMin;
    private showingStatus status; //COMING_SOON, PREVIEW, NOW_SHOWING, END_OF_SHOWING
    private String synopsis;
    private String director;
    private ArrayList<String> cast;
    private ArrayList<Review> reviews;
    private double ticketSales = 0;

    @Override public int compareTo(Movie movie){
        if (this.averageRating() < movie.averageRating()){return -1;}
        return 1;
    }

    /*
     * should we have the parameters declared in the constructor arguments, or use the setters in
     * another line?
     */

    // Constructor
    public Movie(
        String movieName, long movieMin, 
        showingStatus status, String synopsis, String director, ArrayList<String> cast) {
        this.movieName = movieName;
        this.movieMin = movieMin;
        this.status = status;
        this.synopsis = synopsis;
        this.director = director;
        this.cast = cast;
        this.reviews = new ArrayList<>();
        this.ticketSales = 0;
    }

    // methods

    public float averageRating() {
        if (getReviews().size()==0){return 0;}
        int total = 0;
        for (int i = 0; i < getReviews().size(); i++) {
            total += getReviews().get(i).getRating();
        }
        return total / getReviews().size();
    }

    public void printDetails() {
        System.out.println("------------\n");
        System.out.printf("Title: %s\n", getMovieName());
        System.out.printf("Showing Status: " + status.toString() + "\n");
        System.out.printf("Runtime: %d minutes\n", getMovieMin());
        if (getReviews().size() != 0) {
            System.out.printf("Average score: %.2f\n", averageRating());
        }
        System.out.printf("Director: %s\n", getDirector());
        System.out.println("Cast:");
        for (int i = 0; i < getCast().size(); i++) {
            System.out.printf(getCast().get(i)+ "\n");
        }
        System.out.printf("Synopsis:\n%s\n", getSynopsis());
        System.out.println("------------\n");

    }

    // getters
    public String getMovieName() {
        return movieName;
    }

    public long getMovieMin() {
        return movieMin;
    }
    public showingStatus getStatus() {
        return status;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getDirector() {
        return director;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public Double getTicketSales() {
        return ticketSales;
    }

   /*  public float getOverallRating() {
        return overallRating;
    }

    public ArrayList<Review> getPastReviews() {
        return pastReviews;
    } */

    // setters
    public void setMovieName(String name){
        this.movieName = name;
    }

    public void setLength(int length){
        this.movieMin = length;
    }

    public void setStatus(showingStatus status) {
        this.status = status;
    }

    public void setSynopsis(String synopsis){
        this.synopsis = synopsis;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public void setCast(ArrayList<String> cast){
        this.cast = cast;
    }

    /* public void addReview(Review newReview) {
        this.pastReviews.add(newReview);
    } */
}