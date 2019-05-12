package com.example.projectPS.M.Model;

import javax.persistence.*;

@Entity
@Table(name = "Admin")
public class Admin {
    /*CREATE TABLE IF NOT EXISTS `mydb`.`Admin` (
  `idAdmin` INT NOT NULL AUTO_INCREMENT,
  `adminName` VARCHAR(45) NULL,
  `passsword` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAdmin`))
    ENGINE = InnoDB;
*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAdmin", nullable = false)
    private int idAdmin;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name="adminName")
    private String adminName;

    public Admin(String password, String adminName) {
        this.password = password;
        this.adminName = adminName;
    }
    public Admin(){}
    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "idAdmin=" + idAdmin +
                ", password=" + password +
                ", adminName='" + adminName + '\'' +
                '}';
    }
}
