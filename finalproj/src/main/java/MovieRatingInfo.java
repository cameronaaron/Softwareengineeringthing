public class MovieRatingInfo implements Comparable<MovieRatingInfo>{
  private String ratedMovie;
  private double ratingValue;
  private double averageRating;


  public MovieRatingInfo(String movie, double value){
    ratedMovie = movie;
    ratingValue = value;
  }
  public String getRatedMovie(){
    return ratedMovie;
  }
  public double getRatingValue(){
    return ratingValue;
  }
  public void setAverageRating(double average){
    averageRating = average;
  }

  public String toString(){
    return getRatedMovie() + " " + getRatingValue();
  }
  public int compareTo(MovieRatingInfo otherRating){
    if (ratingValue < otherRating.getRatingValue())
      return -1;
    else if (ratingValue > otherRating.getRatingValue())
      return 1;
    else
      return -1;
  }
}
