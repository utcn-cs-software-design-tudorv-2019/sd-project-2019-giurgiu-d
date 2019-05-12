package com.example.projectPS.M.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "Episodes")
public class Episodes {
/* `idEpisodes` INT NOT NULL AUTO_INCREMENT,
  `episodeName` VARCHAR(45) NULL,
  `episodeRating` INT NOT NULL,
  `episodeDescription` VARCHAR(45) NULL,
  `episodeDate` DATETIME NULL,
  `episodeReview` VARCHAR(29) NULL,
  `Season_idSeason` INT NOT NULL,*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEpisodes", nullable = false)
    private int idEpisodes;

    @Column(name="episodeRating", nullable = false)
    private int episodeRating;

    @Column(name="episodeName")
    private String episodeName;

    @Column(name="episodeDescription")
    private String episodeDescription;

    @Column(name="episodeReview")
    private String episodeReview;

    @ManyToOne
    @JoinColumn(name="Season_idSeason")
    Season Season_idSeason;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "Episodes_has_Actors",
            joinColumns = { @JoinColumn(name = "Episodes_idEpisodes") },
            inverseJoinColumns = { @JoinColumn(name = "Actors_idActors") })
    private Set<Actors> actorsEpisodic;

    public Episodes(int episodeRating, String episodeName) {
        this.episodeRating = episodeRating;
        this.episodeName = episodeName;
    }
    public Episodes(){}
    public Episodes(int episodeRating, String episodeName, String episodeDescription, String episodeReview, Season season_idSeason, Set<Actors> actorsEpisodic) {
        this.episodeRating = episodeRating;
        this.episodeName = episodeName;
        this.episodeDescription = episodeDescription;
        this.episodeReview = episodeReview;
        Season_idSeason = season_idSeason;
        this.actorsEpisodic = actorsEpisodic;
    }

    public Episodes(int idEpisodes, int episodeRating, String episodeName, String episodeDescription, String episodeReview, Season season_idSeason, Set<Actors> actorsEpisodic) {
        this.idEpisodes = idEpisodes;
        this.episodeRating = episodeRating;
        this.episodeName = episodeName;
        this.episodeDescription = episodeDescription;
        this.episodeReview = episodeReview;
        Season_idSeason = season_idSeason;
        this.actorsEpisodic = actorsEpisodic;
    }

    public int getIdEpisodes() {
        return idEpisodes;
    }

    public void setIdEpisodes(int idEpisodes) {
        this.idEpisodes = idEpisodes;
    }

    public int getEpisodeRating() {
        return episodeRating;
    }

    public void setEpisodeRating(int episodeRating) {
        this.episodeRating = episodeRating;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public String getEpisodeDescription() {
        return episodeDescription;
    }

    public void setEpisodeDescription(String episodeDescription) {
        this.episodeDescription = episodeDescription;
    }

    public String getEpisodeReview() {
        return episodeReview;
    }

    public void setEpisodeReview(String episodeReview) {
        this.episodeReview = episodeReview;
    }

    public Season getSeason_idSeason() {
        return Season_idSeason;
    }

    public void setSeason_idSeason(Season season_idSeason) {
        Season_idSeason = season_idSeason;
    }

    public Set<Actors> getActorsEpisodic() {
        return actorsEpisodic;
    }

    public void setActorsEpisodic(Set<Actors> actorsEpisodic) {
        this.actorsEpisodic = actorsEpisodic;
    }

    @Override
    public String toString() {
        return "Episodes{" +
                "idEpisodes=" + idEpisodes +
                ", episodeRating=" + episodeRating +
                ", episodeName='" + episodeName + '\'' +
                ", episodeDescription='" + episodeDescription + '\'' +
                ", episodeReview='" + episodeReview + '\'' +
                ", Season_idSeason=" + Season_idSeason +
                ", actorsEpisodic=" + actorsEpisodic +
                '}';
    }
}

