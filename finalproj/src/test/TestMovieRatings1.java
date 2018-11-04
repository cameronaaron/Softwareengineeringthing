import edu.ConnColl.SoftwareEngineering.MyFileReader;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.util.ArrayList;


public class TestMovieRatings1{
  private ArrayList<MovieInformation> listOfMoviesInfo;
  private ArrayList<RaterPerson>  listOfRatersPersonInfo;
  // this constructoer sets up the private fields
  public TestMovieRatings1(String movieRatingInfoFile, String TestMovieRatings){
    this();
    TestMovieRatings movieRatings = new TestMovieRatings();
    listOfMoviesInfo = movieRatings.loadMovieData(movieRatingInfoFile);
    listOfRatersPersonInfo = movieRatings.loadRaterPersonData(TestMovieRatings);
  }
  public TestMovieRatings1(){
    listOfMoviesInfo = null;
    listOfRatersPersonInfo = null;

  }
  // returns the number of movies in the list
  public int findNumberOfMovies(){
    return  listOfMoviesInfo.size();

  }

  // returns the number of rater persons in the list
  public int findNumberofRaterPersons(){
    return listOfRatersPersonInfo.size();
  }

  //
  public double findIDBasedAverage(String movieID, int minimumNumOfPersonRaters){
    int numberOfRaters = 0;
    double ratingSum = 0;
     for (RaterPerson rater : listOfRatersPersonInfo){
        if (rater.hasRatingValue(movieID)){
          ratingSum = ratingSum + rater.getRatingValues(movieID);
          numberOfRaters ++;

        }
     }
     if (numberOfRaters >= minimumNumOfPersonRaters){
        return ratingSum/numberOfRaters;

     }
     else{
       return -1;

    }
  }
  // evalutes the average ratings of all movies based the number for minimum number of raters

  public ArrayList<MovieInformation> findRatingsAverage(int n){
    double rating = 0;
    for (MovieInformation movies : listOfMoviesInfo){
       String id = movies.getMovieID();
       rating = findIDBasedAverage(id, n);
       movies.setAverageRating(rating);


    }
    return listOfMoviesInfo;
  }

 public String getMovieTitle(String movieID){
   for (MovieInformation movie : listOfMoviesInfo){
     if (movie.getMovieID().equals(movieID))
      return movie.getMovieTitle();
   }
   return "movie not found";

 }
 public String getMovieID(String movieTitle){
   for (MovieInformation movie : listOfMoviesInfo){
     if (movie.getMovieID().equals(movieTitle))
      return movie.getMovieTitle();
   }
   return "movie not found";

 }
 public static void main(String[] args){
   TestMovieRatings1 test = new TestMovieRatings1("Datafiles/Rated-Movies-for-Testing.csv", "Datafiles/Movie-Ratings-for-Testing.csv");
   System.out.println(test.findNumberOfMovies());
   System.out.println(test.findNumberofRaterPersons());
   System.out.println(test.findIDBasedAverage("68646", 2));
   System.out.println(test.getMovieTitle("68646"));

 }
}
