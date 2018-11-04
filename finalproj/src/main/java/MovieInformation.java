public class MovieInformation{
  private String movieID;
  private String movieTitle;
  private int movieYear;
  private String movieGenre;
  private String movieDirector;
  private String movieCountry;
  private String posterUrl;
  private int movieLength;
  private double averageRating;
  public MovieInformation(String id, String title, String year, String genre, String length, String director){
    movieID = id;
    movieTitle = title;
    movieYear = Integer.parseInt(year);
    movieGenre = genre;
    movieLength = Integer.parseInt(length);
    movieDirector = director;

  }
  public MovieInformation(String id, String title, String year, String genre,
                          String director, String country, String url, String length){
    movieID = id;
    movieTitle = title;
    movieYear = Integer.parseInt(year);
    movieGenre = genre;
    movieDirector = director;
    movieCountry = country;
    posterUrl = url;
    movieLength = Integer.parseInt(length);


  }
  public String getMovieID(){
      return movieID;
  }
  public String getMovieTitle(){
    return movieTitle;
  }
  public int getMovieYear(){
    return movieYear;
  }
  public String getMovieGenre(){
    return movieGenre;
  }
  public String getMovieDirector(){
    return movieDirector;
  }
  public String getMovieCountry(){
    return movieCountry;
  }
  public String getPosterUrl(){
    return posterUrl;
  }
  public int getMovieLength(){
    return movieLength;
  }
  public void setAverageRating(double rating){
    averageRating = rating;
  }
  public String toString(){
    String info = "";
    info =  movieLength + " " + movieTitle;
    return info;

  }
}
