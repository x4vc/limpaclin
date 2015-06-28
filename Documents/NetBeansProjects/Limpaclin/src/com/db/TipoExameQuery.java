/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db;

import com.entity.TbTipoExame;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
/**
 *
 * @author Victor
 */
public class TipoExameQuery {
    EntityManager em;
    EntityManagerFactory emf;

    public TipoExameQuery() {
        emf = Persistence.createEntityManagerFactory("LimpaclinPU");
        em = emf.createEntityManager();
        
        em.getTransaction().begin();
    }
    
    public List<TbTipoExame> listaTipoExame() {
        return em.createNamedQuery("TbTipoExame.findAll",TbTipoExame.class).getResultList();  
        
        }
    public List<TbTipoExame> listaProcurarNomeTipoExame(String nomeTipoExame) {
        return em.createNamedQuery("TbTipoExame.findByLikeNomeTipoExame",TbTipoExame.class)
                .setParameter("nomeTipoExame", "%" + nomeTipoExame + "%" )
                .getResultList();  
        
        }
    public int SalvarTipoExame(String NomeTipoExame, BigDecimal bd, Boolean AtivoTipoExame){
        try {
            TbTipoExame novoTipoExame = new TbTipoExame();
            //Codigo para Create new record
            novoTipoExame.setNomeTipoExame(NomeTipoExame);
            novoTipoExame.setFatorTipoExame(bd);
            if (AtivoTipoExame){
                novoTipoExame.setTipoExameAtivo("S");

            } else {
                novoTipoExame.setTipoExameAtivo("N");
            }        
            em.persist(novoTipoExame);
            em.getTransaction().commit();            
            int Id = novoTipoExame.getIdTipoExame();
            em.close();
            emf.close();
            return Id;           
            
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
            em.close();
            emf.close();
            return 0;            
        }
        
    }
    
    public int UpdateTipoExame(int Id, String NomeTipoExame, BigDecimal bd, Boolean AtivoTipoExame){
        try {
            //TbTipoExame novoTipoExame = new TbTipoExame();
            TbTipoExame novoTipoExame = em.find(TbTipoExame.class, Id);
            //Codigo para Create new record
            novoTipoExame.setNomeTipoExame(NomeTipoExame);
            novoTipoExame.setFatorTipoExame(bd);
            if (AtivoTipoExame){
                novoTipoExame.setTipoExameAtivo("S");

            } else {
                novoTipoExame.setTipoExameAtivo("N");
            }        
            em.merge(novoTipoExame);
            em.getTransaction().commit();            
            em.close();
            emf.close();
            return Id;           
            
        } catch (javax.persistence.PersistenceException e) {
            e.printStackTrace();
            em.close();
            emf.close();
            return 0;            
        }
        
    }
}
