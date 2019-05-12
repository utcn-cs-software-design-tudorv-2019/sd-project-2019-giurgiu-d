package com.example.projectPS.M.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "User")
public class User {

    /*
    *
CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(45) NULL,
  `dateCreation` DATETIME NULL,
  `userBan` TINYINT(1) NULL,
   `passsword` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUser`))
ENGINE = InnoDB;*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUser", nullable = false)
    private int idUser;
    @Column(name = "password", nullable = false)
    private int password;
    @Column(name="userName")
    private String userName;
    @Column(name="dateCreation")
    private Date dateCreation;
    @Column(name="userBan")
    private int userBan;
     //User_has_Movies
     @ManyToMany(fetch = FetchType.LAZY,
             cascade = {
                     CascadeType.PERSIST,
                     CascadeType.MERGE
             })
     @JoinTable(name = "User_has_Movies",
             joinColumns = { @JoinColumn(name = "User_idUser") },
             inverseJoinColumns = { @JoinColumn(name = "Movies_idMovie") })
     private Set<Movies> movies;

     /////User_has_TvShow
     @ManyToMany(fetch = FetchType.LAZY,
             cascade = {
                     CascadeType.PERSIST,
                     CascadeType.MERGE
             })
     @JoinTable(name = "User_has_TvShow",
             joinColumns = { @JoinColumn(name = "User_idUser") },
             inverseJoinColumns = { @JoinColumn(name = "TvShow_idTvShow") })
     private Set<TvShow> tvShows;

    public User(int idUser, int password, String userName, Date dateCreation, int userBan, Set<Movies> movies, Set<TvShow> tvShows) {
        this.idUser = idUser;
        this.password = password;
        this.userName = userName;
        this.dateCreation = dateCreation;
        this.userBan = userBan;
        this.movies = movies;
        this.tvShows = tvShows;
    }

    public User(int password, String userName, Date dateCreation, int userBan, Set<Movies> movies, Set<TvShow> tvShows) {
        this.password = password;
        this.userName = userName;
        this.dateCreation = dateCreation;
        this.userBan = userBan;
        this.movies = movies;
        this.tvShows = tvShows;
    }

    public User(int password, String userName) {
        this.password = password;
        this.userName = userName;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public int getUserBan() {
        return userBan;
    }

    public void setUserBan(int userBan) {
        this.userBan = userBan;
    }

    public Set<Movies> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movies> movies) {
        this.movies = movies;
    }

    public Set<TvShow> getTvShows() {
        return tvShows;
    }

    public void setTvShows(Set<TvShow> tvShows) {
        this.tvShows = tvShows;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", password=" + password +
                ", userName='" + userName + '\'' +
                ", dateCreation=" + dateCreation +
                ", userBan=" + userBan +
                '}';
    }
}
