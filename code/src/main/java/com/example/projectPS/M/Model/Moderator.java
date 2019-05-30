package com.example.projectPS.M.Model;

import javax.persistence.*;

@Entity
@Table(name = "Moderator")
public class Moderator {

    /*
    * CREATE TABLE IF NOT EXISTS `mydb`.`Moderator` (
  `idModerator` INT NOT NULL AUTO_INCREMENT,
  `moderatorName` VARCHAR(45) NOT NULL,
  `noBan` INT NULL,
   `passsword` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idModerator`))
ENGINE = InnoDB;
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idModerator", nullable = false)
    private int idModerator;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "moderatorName")
    private String moderatorName;
    @Column(name = "noBan")
    private int noBan=0;

    public Moderator(String password, String moderatorName) {
        this.password = password;
        this.moderatorName = moderatorName;
    }

    public Moderator(String password, String moderatorName, int noBan) {
        this.password = password;
        this.moderatorName = moderatorName;
        this.noBan = noBan;
    }

    public int getIdModerator() {
        return idModerator;
    }

    public void setIdModerator(int idModerator) {
        this.idModerator = idModerator;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getModeratorName() {
        return moderatorName;
    }

    public void setModeratorName(String moderatorName) {
        this.moderatorName = moderatorName;
    }

    public int getNoBan() {
        return noBan;
    }

    public void setNoBan(int noBan) {
        this.noBan = noBan;
    }

    @Override
    public String toString() {
        return "Moderator{" +
                "idModerator=" + idModerator +
                ", password=" + password +
                ", moderatorName='" + moderatorName + '\'' +
                ", noBan=" + noBan +
                '}';
    }
}
