/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gberry23
 */
@Stateless
@ManagedBean(name = "CampsFacade")
public class CampsFacade extends AbstractFacade<Camps> implements Serializable{

    @PersistenceContext(unitName = "inClassPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CampsFacade() {
        super(Camps.class);
    }   
    
    @PostConstruct
    public void init() {
        
    }
    
}
