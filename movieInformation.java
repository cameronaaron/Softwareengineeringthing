public class movieInformation{
  private String movieID;
  private String movieTitle;
  private int movieYear;
  private String movieGenre;
  private String movieDirector;
  private String movieCountry;
  private String posterurl;
  private int movielength;

  public movieInformation(String id, String title, String year, String genre){
    movieID = id;
    movieTitle = title;
    movieYear = Integer.parseInt(year);
    movieGenre = genre;
  }
  public movieInformation(String id, String title, String year, String genre,
                          String director, String country, String url, String length){
    movieID = id;
    movieTitle = title;
    movieYear = Integer.parseInt(year);
    movieGenre = genre;
    movieDirector = director;
    movieCountry = country;
    posterurl = url;
    movielength = Integer.parseInt(length);

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
  public String getPosterurl(){
    return posterurl;
  }
  public int getMovieLength(){
    return movielength;
  }
  public String toString(){
    String info = "";
    info = "info" + movieID + " " + movieTitle;
    return info;

  }
}
