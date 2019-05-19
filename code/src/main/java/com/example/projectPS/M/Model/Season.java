package com.example.projectPS.M.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "Season")
public class Season {
    /* `idSeason` INT NOT NULL AUTO_INCREMENT,
  `seasonName` VARCHAR(45) NULL,
  `seasonNoEpisode` INT NULL,
  `seasonRating` INT NULL,*/


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idSeason", nullable = false)
    private int idSeason;

    @Column(name="seasonName")
    private String seasonName;

    @Column(name="seasonNoEpisode")
    private int seasonNoEpisode;

    @Column(name="seasonRating")
    private int seasonRating;

    @OneToMany(mappedBy = "Season_idSeason", cascade = CascadeType.ALL,fetch= FetchType.LAZY)
    private Set<Episodes> episodesList;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            },
            mappedBy = "seasons")
    private Set<TvShow> TvShow;

    public Season(String seasonName, int seasonNoEpisode, int seasonRating, Set<Episodes> episodesList) {
        this.seasonName = seasonName;
        this.seasonNoEpisode = seasonNoEpisode;
        this.seasonRating = seasonRating;
        this.episodesList = episodesList;
    }

    public Season(String seasonName, int seasonNoEpisode, int seasonRating) {
        this.seasonName = seasonName;
        this.seasonNoEpisode = seasonNoEpisode;
        this.seasonRating = seasonRating;
        }
    public Season(){}

    public Season(String seasonName, int seasonRating) {
        this.seasonName = seasonName;
        this.seasonRating = seasonRating;
    }

    public int getIdSeason() {
        return idSeason;
    }

    public void setIdSeason(int idSeason) {
        this.idSeason = idSeason;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public int getSeasonNoEpisode() {
        return seasonNoEpisode;
    }

    public void setSeasonNoEpisode(int seasonNoEpisode) {
        this.seasonNoEpisode = seasonNoEpisode;
    }

    public int getSeasonRating() {
        return seasonRating;
    }

    public void setSeasonRating(int seasonRating) {
        this.seasonRating = seasonRating;
    }

    public Set<Episodes> getEpisodesList() {
        return episodesList;
    }

    public void setEpisodesList(Set<Episodes> episodesList) {
        this.episodesList = episodesList;
    }

    public Season(int idSeason, String seasonName, int seasonNoEpisode, int seasonRating, Set<Episodes> episodesList) {
        this.idSeason = idSeason;
        this.seasonName = seasonName;
        this.seasonNoEpisode = seasonNoEpisode;
        this.seasonRating = seasonRating;
        this.episodesList = episodesList;
    }
}
