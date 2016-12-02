/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gberry23
 */
@Entity
@Table(name = "camps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camps.findAll", query = "SELECT c FROM Camps c"),
    @NamedQuery(name = "Camps.findByCampID", query = "SELECT c FROM Camps c WHERE c.campID = :campID"),
    @NamedQuery(name = "Camps.findByCampName", query = "SELECT c FROM Camps c WHERE c.campName = :campName"),
    @NamedQuery(name = "Camps.findByMaxCampers", query = "SELECT c FROM Camps c WHERE c.maxCampers = :maxCampers"),
    @NamedQuery(name = "Camps.findByIsActive", query = "SELECT c FROM Camps c WHERE c.isActive = :isActive")})
public class Camps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "campID")
    private Integer campID;
    @Size(max = 45)
    @Column(name = "campName")
    private String campName;
    @Column(name = "maxCampers")
    private Integer maxCampers;
    @Column(name = "isActive")
    private Boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campID")
    private Collection<Bookings> bookingsCollection;

    public Camps() {
    }

    public Camps(Integer campID) {
        this.campID = campID;
    }

    public Integer getCampID() {
        return campID;
    }

    public void setCampID(Integer campID) {
        this.campID = campID;
    }

    public String getCampName() {
        return campName;
    }

    public void setCampName(String campName) {
        this.campName = campName;
    }

    public Integer getMaxCampers() {
        return maxCampers;
    }

    public void setMaxCampers(Integer maxCampers) {
        this.maxCampers = maxCampers;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public Collection<Bookings> getBookingsCollection() {
        return bookingsCollection;
    }

    public void setBookingsCollection(Collection<Bookings> bookingsCollection) {
        this.bookingsCollection = bookingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (campID != null ? campID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camps)) {
            return false;
        }
        Camps other = (Camps) object;
        if ((this.campID == null && other.campID != null) || (this.campID != null && !this.campID.equals(other.campID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Camps[ campID=" + campID + " ]";
    }
    
}
