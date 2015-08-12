/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Team12.Model;

import java.io.Serializable;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "UserGame")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserGame.findAll", query = "SELECT u FROM UserGame u"),
    @NamedQuery(name = "UserGame.findByUgID", query = "SELECT u FROM UserGame u WHERE u.ugID = :ugID"),
    @NamedQuery(name = "UserGame.findByGameID", query = "SELECT u FROM UserGame u WHERE u.gameID = :gameID"),
    @NamedQuery(name = "UserGame.findByUserID", query = "SELECT u FROM UserGame u WHERE u.userID = :userID"),
    @NamedQuery(name = "UserGame.findByUrl", query = "SELECT u FROM UserGame u WHERE u.url = :url")})
public class UserGame implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ugID")
    private Integer ugID;
    @Column(name = "gameID")
    private Integer gameID;
    @Column(name = "userID")
    private Integer userID;
    @Size(max = 500)
    @Column(name = "url")
    private String url;

    public UserGame() {
    }

    public UserGame(Integer ugID) {
        this.ugID = ugID;
    }

    public Integer getUgID() {
        return ugID;
    }

    public void setUgID(Integer ugID) {
        this.ugID = ugID;
    }

    public Integer getGameID() {
        return gameID;
    }

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ugID != null ? ugID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserGame)) {
            return false;
        }
        UserGame other = (UserGame) object;
        if ((this.ugID == null && other.ugID != null) || (this.ugID != null && !this.ugID.equals(other.ugID))) {
            return false;
        }
        return true;
    }

    public JsonObject toJson() {
        return (Json.createObjectBuilder()
                .add("gameID",gameID)
                .add("userID", userID)
                .add("url", url)
                .build());    
      }
    
    @Override
    public String toString() {
        return "com.Team12.Model.UserGame[ ugID=" + ugID + " ]";
    }
    
}
