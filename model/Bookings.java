/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gberry23
 */
@Entity
@Table(name = "bookings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookings.findAll", query = "SELECT b FROM Bookings b"),
    @NamedQuery(name = "Bookings.findByBookings", query = "SELECT b FROM Bookings b WHERE b.bookings = :bookings"),
    @NamedQuery(name = "Bookings.findByFirstName", query = "SELECT b FROM Bookings b WHERE b.firstName = :firstName"),
    @NamedQuery(name = "Bookings.findByLastName", query = "SELECT b FROM Bookings b WHERE b.lastName = :lastName"),
    @NamedQuery(name = "Bookings.findByAddress", query = "SELECT b FROM Bookings b WHERE b.address = :address"),
    @NamedQuery(name = "Bookings.findByEmail", query = "SELECT b FROM Bookings b WHERE b.email = :email"),
    @NamedQuery(name = "Bookings.findByEnterDate", query = "SELECT b FROM Bookings b WHERE b.enterDate = :enterDate"),
    @NamedQuery(name = "Bookings.findByLeaveDate", query = "SELECT b FROM Bookings b WHERE b.leaveDate = :leaveDate")})
public class Bookings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "bookings")
    private Integer bookings;
    @Size(max = 45)
    @Column(name = "firstName")
    private String firstName;
    @Size(max = 45)
    @Column(name = "lastName")
    private String lastName;
    @Size(max = 45)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Column(name = "enterDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enterDate;
    @Column(name = "leaveDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date leaveDate;
    @JoinColumn(name = "campID", referencedColumnName = "campID")
    @ManyToOne(optional = false)
    private Camps campID;

    public Bookings() {
    }

    public Bookings(Integer bookings) {
        this.bookings = bookings;
    }

    public Integer getBookings() {
        return bookings;
    }

    public void setBookings(Integer bookings) {
        this.bookings = bookings;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public Camps getCampID() {
        return campID;
    }

    public void setCampID(Camps campID) {
        this.campID = campID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookings != null ? bookings.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookings)) {
            return false;
        }
        Bookings other = (Bookings) object;
        if ((this.bookings == null && other.bookings != null) || (this.bookings != null && !this.bookings.equals(other.bookings))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Bookings[ bookings=" + bookings + " ]";
    }
    
}
