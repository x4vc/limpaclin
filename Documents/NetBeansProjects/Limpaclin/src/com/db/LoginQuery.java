/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db;

import com.entity.TbUsername;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Victor
 */
public class LoginQuery {
    EntityManager em;
    EntityManagerFactory emf;

    public LoginQuery() {
        emf = Persistence.createEntityManagerFactory("LimpaclinPU");
        em = emf.createEntityManager();
        
        em.getTransaction().begin();
    }
    
    public List<TbUsername> listaUsername() {
        
         return em.createNamedQuery("TbUsername.findAll",TbUsername.class).getResultList();
        
        }
    
    
}
