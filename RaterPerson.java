/**
 * This class captures and encapsulate information about the
 * person rating movies and all of that person's ratings
 * based on the CSV data file that has movie ratings information.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;

public class RaterPerson {
    // private data (instance) fields
    private String raterPersonID;
    // a person can rate more than one movie.
    // We need to store all of those ratings in a data structure like an array list
    private ArrayList<MovieRatingInfo> raterPersonRatings;

    /**
     * 1-argument constructor for objects of class RaterPerson
     */
    public RaterPerson(String personID) {
        raterPersonID = personID;
        raterPersonRatings = new ArrayList<MovieRatingInfo>();
    }

    // getter method for raterPersonID
    public String getRaterPersonID() {
        return raterPersonID;
    }

    // finds and returns the number of rating values for this person
    public int findNumberOfRatings() {
        return raterPersonRatings.size();
    }

    // adds a rating for a movie to the list of this person's movie ratings
    public void addRating(String movie, double ratingValue) {
        raterPersonRatings.add(new MovieRatingInfo(movie,ratingValue));
    }

    // checks to see if a movie rating value exists for this person
    // this method iterates over all of this person's rating values
    // to see if a rating exists for the movie passed to the method
    public boolean hasRatingValue(String movie) {
        for(int i = 0; i < raterPersonRatings.size(); i++){
            if (raterPersonRatings.get(i).getRatedMovie().equals(movie)){
                return true;
            }
        }
        return false;
    }

    // checks to see if a rating has been done by this person
    // for the movie passed to the method and if so, returns the rating value
    // this method iterates over all of this person's rating values
    public double getRatingValues(String movie) {
        for(int i = 0; i < raterPersonRatings.size(); i++){
            if (raterPersonRatings.get(i).getRatedMovie().equals(movie)){
                return raterPersonRatings.get(i).getRatingValue();
            }
        }
        return -1;
    }

    // finds and returns all of this person's rating values in an array list
    // this method iterates over all of this person's rating values
    public ArrayList<String> getMoviesRated() {
        ArrayList<String> movieList = new ArrayList<String>();
        for(int i = 0; i < raterPersonRatings.size(); i++){
            movieList.add(raterPersonRatings.get(i).getRatedMovie());
        }
        return movieList;
    }
    public String toString(){
      String raterInfo = raterPersonID;
      return raterPersonID;
    }
}
