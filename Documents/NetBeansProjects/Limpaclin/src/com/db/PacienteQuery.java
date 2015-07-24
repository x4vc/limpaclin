/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db;

import com.entity.TbPaciente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 *
 * @author victorcmaf
 */
public class PacienteQuery {
    EntityManager em;
    EntityManagerFactory emf;

    public PacienteQuery() {
        emf = Persistence.createEntityManagerFactory("LimpaclinPU");
        em = emf.createEntityManager();
        
        em.getTransaction().begin();
    }
    
    public List<TbPaciente> listaPaciente() {
        return em.createNamedQuery("TbPaciente.findAll",TbPaciente.class).getResultList();  
        
        }
    
     public List<TbPaciente> listaProcurarNomePaciente(String strNomePaciente) {
        return em.createNamedQuery("TbPaciente.findByLikeNomePaciente",TbPaciente.class)
                .setParameter("nomePaciente", "%" +strNomePaciente + "%" )
                .getResultList();  
        
        }
    
    
}
