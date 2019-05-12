package com.example.projectPS.M.Model;

//import com.example.projectPS.M.Model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Actors")
public class Actors {

/*  `idActors` INT NOT NULL AUTO_INCREMENT,
  `actorName` VARCHAR(45) NOT NULL,
  `actorDescription` VARCHAR(45) NULL,
  `actorBirth` DATETIME NULL,*/


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idActors", nullable = false)
    private  int idActors;
    @Column(name="actorName",nullable = false)
    private  String actorName;
    @Column(name="actorDescription")
    private  String actorDescription;
    @Column(name="actorBirth")
    private Date actorBirth;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "actors")
    private Set<Movies> movies;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "actorsEpisodic")
    private Set<Episodes>episodes;

    public Actors(String actorName, String actorDescription) {
        this.actorName = actorName;
        this.actorDescription = actorDescription;
    }

    public Actors() {
    }

    public int getIdActors() {
        return idActors;
    }

    public void setIdActors(int idActors) {
        this.idActors = idActors;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorDescription() {
        return actorDescription;
    }

    public void setActorDescription(String actorDescription) {
        this.actorDescription = actorDescription;
    }

    public Date getActorBirth() {
        return actorBirth;
    }


    public void setActorBirth(Date actorBirth) {
        this.actorBirth = actorBirth;
    }

    public Set<Movies> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movies> movies) {
        this.movies = movies;
    }

    public Set<Episodes> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Set<Episodes> episodes) {
        this.episodes = episodes;
    }

    @Override
    public String toString() {
        return "Actors{" +
                "idActors=" + idActors +
                ", actorName='" + actorName + '\'' +
                ", actorDescription='" + actorDescription + '\'' +
                ", actorBirth=" + actorBirth +
                '}';
    }
}
