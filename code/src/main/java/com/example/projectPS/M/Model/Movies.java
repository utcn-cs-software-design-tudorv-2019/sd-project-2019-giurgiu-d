package com.example.projectPS.M.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Movies")
public class Movies {
/*`idMovie` INT NOT NULL AUTO_INCREMENT,
  `movieName` VARCHAR(45) NOT NULL,
  `movieDescription` VARCHAR(45) NULL,
  `movieGenre` VARCHAR(45) NOT NULL,
  `movieReviews` VARCHAR(45) NULL,
  `moviePhotos` VARCHAR(45) NULL,
  `movieDirector` VARCHAR(45) NOT NULL,
  `movieCertification` VARCHAR(45) NULL,
  `movieDateCreation` DATETIME NULL,
  `movieCountry` VARCHAR(45) NULL,
  `movieRating` INT NULL,*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idMovie", nullable = false)
    private  int idMovie;

    @Column(name="movieName", nullable=false)
    private String movieName;

    @Column(name="movieDescription")
    private String movieDescription;

    @Column(name="movieGenre")
    private String movieGenre;

    @Column(name="movieReviews")
    private String movieReviews;

    @Column(name="moviePhotos")
    private String moviePhotos;

    @Column(name="movieDirector")
    private String movieDirector;

    @Column(name="movieCertification")
    private String movieCertification;

    @Column(name="movieDateCreation")
    private Date movieDateCreation;

    @Column(name="movieRating")
    private int movieRating;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "Movies_has_Actors",
            joinColumns = { @JoinColumn(name = "Movies_idMovie") },
            inverseJoinColumns = { @JoinColumn(name = "Actors_idActors") })
    private Set<Actors> actors;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "movies")
    private Set<User>users;

    public Movies(String movieName, String movieDescription, String movieGenre, String movieDirector, String movieCertification, String movieDateCreation, String movieRating) {
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.movieGenre = movieGenre;
        this.movieDirector = movieDirector;
        this.movieCertification = movieCertification;
        this.movieDateCreation = java.sql.Date.valueOf(movieDateCreation);
        this.movieRating = Integer.valueOf(movieRating);
    }

    public Movies(String name)
    {
        this.movieName =name;
    }
    public Movies(int idMovie, String movieName, String movieDescription, String movieGenre, String movieReviews, String moviePhotos, String movieDirector, String movieCertification, Date movieDateCreation, int movieRating, Set<Actors> actors) {
        this.idMovie = idMovie;
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.movieGenre = movieGenre;
        this.movieReviews = movieReviews;
        this.moviePhotos = moviePhotos;
        this.movieDirector = movieDirector;
        this.movieCertification = movieCertification;
        this.movieDateCreation = movieDateCreation;
        this.movieRating = movieRating;
        this.actors = actors;
    }
    public Movies()
    {}
    public Movies(String movieName, String movieDescription, String movieGenre, String movieReviews, String moviePhotos, String movieDirector, String movieCertification, Date movieDateCreation, int movieRating) {
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.movieGenre = movieGenre;
        this.movieReviews = movieReviews;
        this.moviePhotos = moviePhotos;
        this.movieDirector = movieDirector;
        this.movieCertification = movieCertification;
        this.movieDateCreation = movieDateCreation;
        this.movieRating = movieRating;
    }

    public Movies(String movieName, String movieGenre, int movieRating) {
        this.movieName = movieName;
        this.movieGenre = movieGenre;
        this.movieRating = movieRating;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieReviews() {
        return movieReviews;
    }

    public void setMovieReviews(String movieReviews) {
        this.movieReviews = movieReviews;
    }

    public String getMoviePhotos() {
        return moviePhotos;
    }

    public void setMoviePhotos(String moviePhotos) {
        this.moviePhotos = moviePhotos;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public String getMovieCertification() {
        return movieCertification;
    }

    public void setMovieCertification(String movieCertification) {
        this.movieCertification = movieCertification;
    }

    public Date getMovieDateCreation() {
        return movieDateCreation;
    }

    public void setMovieDateCreation(Date movieDateCreation) {
        this.movieDateCreation = movieDateCreation;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }

    public Set<Actors> getActors() {
        return actors;
    }

    public void setActors(Set<Actors> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "idMovie=" + idMovie +
                ", movieName='" + movieName + '\'' +
                ", movieDescription='" + movieDescription + '\'' +
                ", movieGenre='" + movieGenre + '\'' +
                ", movieReviews='" + movieReviews + '\'' +
                ", moviePhotos='" + moviePhotos + '\'' +
                ", movieDirector='" + movieDirector + '\'' +
                ", movieCertification='" + movieCertification + '\'' +
                ", movieDateCreation=" + movieDateCreation +
                ", movieRating=" + movieRating +
                '}';
    }
}
