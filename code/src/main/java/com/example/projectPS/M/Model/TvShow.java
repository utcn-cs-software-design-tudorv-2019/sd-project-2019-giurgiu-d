package com.example.projectPS.M.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "TvShow")
public class TvShow {

    /* `idTvShow` INT NOT NULL AUTO_INCREMENT,
  `tvName` VARCHAR(45) NOT NULL,
  `tvDescription` VARCHAR(45) NULL,
  `tvRating` INT NOT NULL,
  `tvGenre` VARCHAR(45) NULL,
  `tvDirector` VARCHAR(45) NULL,
  `tvDateCreation` DATETIME NULL,
  `tvReview` VARCHAR(45) NULL,
  `tvCertification` VARCHAR(45) NULL,
    */


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idTvShow", nullable = false)
    private int idTvShow;
    @Column(name = "tvRating", nullable = false)
    private int tvRating;
    @Column(name = "tvDateCreation")
    private Date tvDateCreation;
    @Column(name = "tvName")
    private String tvName;
    @Column(name = "tvDescription")
    private String tvDescription;
    @Column(name = "tvGenre")
    private String tvGenre;
    @Column(name = "tvDirector")
    private String tvDirector;
    @Column(name = "tvReview")
    private String tvReview;
    @Column(name = "tvCertification")
    private String tvCertification;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "TvShow_has_Season",
            joinColumns = { @JoinColumn(name = "TvShow_idTvShow") },
            inverseJoinColumns = { @JoinColumn(name = "Season_idSeason") })
    private Set<Season> seasons;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "tvShows")
    private Set<User>users;


    public TvShow(int tvRating, String tvName, String tvGenre) {
        this.tvRating = tvRating;
        this.tvName = tvName;
        this.tvGenre = tvGenre;
    }
    public TvShow(){}

    public TvShow(int tvRating, Date tvDateCreation, String tvName, String tvDescription, String tvGenre, String tvDirector, String tvReview, String tvCertification, Set<Season> seasons) {
        this.tvRating = tvRating;
        this.tvDateCreation = tvDateCreation;
        this.tvName = tvName;
        this.tvDescription = tvDescription;
        this.tvGenre = tvGenre;
        this.tvDirector = tvDirector;
        this.tvReview = tvReview;
        this.tvCertification = tvCertification;
        this.seasons = seasons;
    }

    public TvShow(int idTvShow, int tvRating, Date tvDateCreation, String tvName, String tvDescription, String tvGenre, String tvDirector, String tvReview, String tvCertification, Set<Season> seasons) {
        this.idTvShow = idTvShow;
        this.tvRating = tvRating;
        this.tvDateCreation = tvDateCreation;
        this.tvName = tvName;
        this.tvDescription = tvDescription;
        this.tvGenre = tvGenre;
        this.tvDirector = tvDirector;
        this.tvReview = tvReview;
        this.tvCertification = tvCertification;
        this.seasons = seasons;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public int getIdTvShow() {
        return idTvShow;
    }

    public void setIdTvShow(int idTvShow) {
        this.idTvShow = idTvShow;
    }

    public int getTvRating() {
        return tvRating;
    }

    public void setTvRating(int tvRating) {
        this.tvRating = tvRating;
    }

    public Date getTvDateCreation() {
        return tvDateCreation;
    }

    public void setTvDateCreation(Date tvDateCreation) {
        this.tvDateCreation = tvDateCreation;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public String getTvDescription() {
        return tvDescription;
    }

    public void setTvDescription(String tvDescription) {
        this.tvDescription = tvDescription;
    }

    public String getTvGenre() {
        return tvGenre;
    }

    public void setTvGenre(String tvGenre) {
        this.tvGenre = tvGenre;
    }

    public String getTvDirector() {
        return tvDirector;
    }

    public void setTvDirector(String tvDirector) {
        this.tvDirector = tvDirector;
    }

    public String getTvReview() {
        return tvReview;
    }

    public void setTvReview(String tvReview) {
        this.tvReview = tvReview;
    }

    public String getTvCertification() {
        return tvCertification;
    }

    public void setTvCertification(String tvCertification) {
        this.tvCertification = tvCertification;
    }

    public Set<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(Set<Season> seasons) {
        this.seasons = seasons;
    }

    @Override
    public String toString() {
        return "TvShow{" +
                "idTvShow=" + idTvShow +
                ", tvRating=" + tvRating +
                ", tvDateCreation=" + tvDateCreation +
                ", tvName='" + tvName + '\'' +
                ", tvDescription='" + tvDescription + '\'' +
                ", tvGenre='" + tvGenre + '\'' +
                ", tvDirector='" + tvDirector + '\'' +
                ", tvReview='" + tvReview + '\'' +
                ", tvCertification='" + tvCertification + '\'' +
                '}';
    }
}
