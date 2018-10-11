import edu.ConnColl.SoftwareEngineering.MyFileReader;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;



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
    ArrayList <RaterPerson> raterList = new ArrayList<RaterPerson>();
    MyFileReader fr = new MyFileReader(filename);
    CSVParser parser = fr.accessCSVParser();
    for (CSVRecord record: parser){

       String raterPersonID = record.get("RaterPersonID");
       String movieID = record.get("MovieID");
       Double movieRating = Double.parseDouble(record.get("MovieRating"));
       if (Integer.parseInt(raterPersonID) > raterList.size()){
         RaterPerson newRater = new RaterPerson(raterPersonID);
         newRater.addRating(movieID, movieRating);
         raterList.add(newRater);
       }
       else{
        int index = Integer.parseInt(raterPersonID);
        RaterPerson person = raterList.get(index-1);
        person.addRating(movieID, movieRating);

       }// String timeOfRating = record.get("TimeOfRating");
      // RaterPerson newRater =  new RaterPerson(raterPersonID);
      //raterList.add(newRater);
    }
    return raterList;
 }
 public String findAndDisplayRaterPersons(ArrayList<RaterPerson> raterList, String id, String movieID){
   String output = "Number of rating for id " + id;
   int index = Integer.parseInt(id);
   RaterPerson rater = raterList.get(index - 1);
   output = output + " "+  String.valueOf(rater.findNumberOfRatings());

   ArrayList<RaterPerson> highestRaters = new ArrayList();
   int maxMoviesRated =0;

   for (RaterPerson raters: raterList){
     if (raters.findNumberOfRatings()>= maxMoviesRated){
       highestRaters.add(raters);
       maxMoviesRated = raters.findNumberOfRatings();

     }
   }
   int index1 = highestRaters.size() - 1;
   output = output + "\nHighest raters";
   while (highestRaters.get(index1).findNumberOfRatings() == maxMoviesRated){
     RaterPerson highestRater = highestRaters.get(index1);
     output = output + highestRater.getRaterPersonID() + " ";
     index1--;
   }
   int count = 0;

   for (RaterPerson rater2: raterList){
     if (rater2.hasRatingValue(movieID))
       count++;
    }
    output = output + "\nThe number of rater for movie id " + movieID + " " + count;
    output = output + "\nNumber of movies rated by person with id " + id + " " + rater.findNumberOfRatings();

  return output;

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
   Map<String, Integer>  director_dict = new HashMap<String, Integer> ();
   int maxValue = 0;
   for (MovieInformation movie : movieList){
     if (director_dict.containsKey(movie.getMovieDirector())){
       int value =  director_dict.get(movie.getMovieDirector()) + 1;
       if (value > maxValue)
          maxValue = value;
       director_dict.put(movie.getMovieDirector(), value);
     }
     else{
       maxValue = 1; 
       director_dict.put(movie.getMovieDirector(), 1);
    }
  }
    System.out.println("size " + director_dict.size() + " " + maxValue);
    //Set<String> directors = new HashSet<String>();
    String directors = "";
    for (Object entry : director_dict.keySet()){
      if (director_dict.get(entry).equals(maxValue))
        //directors.add(entry.getKey());
        directors = directors + ", " + entry;
    }
    System.out.println(directors);
   return movies;
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
  public void testRaters(){
    String str = "Datafiles/Movie-Ratings-for-Testing.csv";
    ArrayList<RaterPerson> newRaters = loadRaterPersonData(str);
    String raterInfo = findAndDisplayRaterPersons(newRaters, "1", "68646");
    System.out.println(raterInfo);
    System.out.println("array size " + newRaters.size());

  }
  public static void main(String[] args){
    TestMovieRatings testMovies =  new TestMovieRatings();
    testMovies.testLoadMovies();
    testMovies.testLoadRater();
    testMovies.testFind();
    testMovies.testRaters();

  }
}
