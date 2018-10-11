import edu.ConnColl.SoftwareEngineering.MyFileReader;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.util.ArrayList;

public class TestMovieRatings{
  public ArrayList<MovieInformation> loadMovieData(String filename){
    ArrayList <MovieInformation> movieData = new ArrayList<MovieInformation>();
    System.out.println("this works");
    MyFileReader fr = new MyFileReader(filename);
    CSVParser parser = fr.accessCSVParser();
    System.out.println("this works");
    for (CSVRecord record : parser){
      String id = record.get("IMDB");
      String title = record.get("MovieTitle");
      String year = record.get("MovieYear");
      String genre = record.get("MovieGenre");
      String length = record.get("MovieLength");
      String director = record.get("MovieDirector");
      MovieInformation movie = new MovieInformation(id, title, year, genre, length, director);
      movieData.add(movie);
    }
    return movieData;
  }
  public ArrayList<RaterPerson> loadRaterPersonData(String filename){
    ArrayList <RaterPerson> raterPerson = new ArrayList<RaterPerson>();
    MyFileReader fr = new MyFileReader(filename);
    CSVParser parser = fr.accessCSVParser();
    for (CSVRecord record: parser){
      String raterPersonID = record.get("RaterPersonID");
      String movieID = record.get("MovieID");
      String movieRating = record.get("MovieRating");
      String timeOfRating = record.get("TimeOfRating");
      RaterPerson newRater =  new RaterPerson(raterPersonID);
      raterPerson.add(newRater);
    }
    return raterPerson;
 }
 public String findAndDisplayMovies(ArrayList<MovieInformation> movieList){
   String movies = "Movies more than 135 min: ";
   for (MovieInformation movie : movieList){
     int movieLength = movie.getMovieLength();
     //System.out.println(movieLength);
     if (movieLength > 135){
       movies = movies + movie.getMovieTitle() + ", ";
     }
   }
   movies = movies+ "\nDrama movies: ";
   for (MovieInformation movie : movieList){
     String movieGenre = movie.getMovieGenre();
     //System.out.println(movieLength);
     if (movieGenre.toLowerCase().contains("drama")){
       movies = movies+ movie.getMovieTitle() + ", ";
     }
   }
   return movies;
}
  public static findAndDisplayRaterPersons(personID){
      public final X x; 
  public final Y y; 
  public Tuple(X x, Y y) { 
    this.x = x; 
    this.y = y; 
      personID.findNumberOfRatings();
  }
      
  public void testLoadMovies(){
    String str = "Datafiles/Rated-Movies-for-Testing.csv";
    //System.out.println("this works");
    ArrayList<MovieInformation> myMovies = loadMovieData(str);
    System.out.println(myMovies);
  }
  public void testLoadRater(){
    String str = "Datafiles/Movie-Ratings-for-Testing.csv";
    ArrayList<RaterPerson> newRaters = loadRaterPersonData(str);
    System.out.println(newRaters);

    }
  public void testFind(){
    String str = "Datafiles/Rated-Movies-for-Testing.csv";
    ArrayList<MovieInformation> movies = loadMovieData(str);
    String movieLengths = findAndDisplayMovies(movies);
    System.out.println(movieLengths);

  }
  public static void main(String[] args){
    TestMovieRatings testMovies =  new TestMovieRatings();
    testMovies.testLoadMovies();
    testMovies.testLoadRater();
    testMovies.testFind();

  }
}
