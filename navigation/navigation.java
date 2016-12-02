package navigation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import model.Bookings;
import model.Camps;
import model.Users;
import model.UsersFacade;
import model.CampsFacade;
import model.BookingsFacade;
/**
 *
 * @author gberry23
 */
@SessionScoped
@ManagedBean(name = "navigation", eager = true)
public class navigation implements Serializable{

    @EJB
    private UsersFacade users;
    @EJB
    private CampsFacade camps;
    
    @EJB
    private BookingsFacade bookings;
    
    private String currentPage = "index.xhtml";
    private int campID;

    public int getCampID() {
        return campID;
    }

    public void setCampID(int campID) {
        this.campID = campID;
    }
    private List<Users> listOfUsers;
    private List<Camps> listOfCamps;
    private List<Bookings> listOfBookings;

    public List<Camps> getListOfCamps() {
        return listOfCamps;
    }

    public void setListOfCamps(List<Camps> listOfCamps) {
        this.listOfCamps = listOfCamps;
    }
    
    
    public String gotoCamps(){
        listOfCamps = camps.findAll();
        currentPage = "Camps.xhtml";
        return "Camps.xhtml";
    }
    
    public String gotoBookings(){
        listOfBookings = bookings.findAll();
        currentPage = "bookings.xhtml";
        return "bookings.xhtml";
    }
    
    public String gotoHomePage(){
        currentPage = "index.xhtml";
        return "index.xhtml";
    }
    /**
     * Creates a new instance of navigaton
     */
    public navigation() {
    }
 
    
    public List getUserList(){
        return listOfUsers;
    }
    
    String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
    
}
