/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.descuento.Dao;

import com.descuento.Modelo.Descuento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author USUARIO
 */
public class DescuentoDao {
    
    protected EntityManager em;
    private EntityManagerFactory tran = null;
    
    public DescuentoDao (){
        tran = Persistence.createEntityManagerFactory("Descuento");
    }
    
    public Descuento fyndbyId(Descuento p){
        em = getEntityManager();
        return em.find(Descuento.class, p.getCodigo());
    }

    private EntityManager getEntityManager(){
        
        return tran.createEntityManager();     
    
    }
    
    public void selectall(){
    
    //Iniciamos variable que contiene la sentencia a ejecutar
        String hql = "SELECT d from Descuento d";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        List<Descuento> lista = query.getResultList();
        for (Descuento d : lista){
        System.out.print(d + "\n");
        }
        
    }
    
    
    public void Insertar (Descuento descuento){
    
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(descuento);
            em.getTransaction().commit();
            

        }catch (Exception ex){
        
            System.out.println("Error al insertar el objeto:" + ex.getMessage());
        
        
        }finally{
        
        if(em !=null){
            em.close();
            }
        
        }
    }
    
    
    public void actualizar (Descuento descuento){
     try{
         em = getEntityManager();
         em.getTransaction().begin();
         em.merge(descuento);
         em.getTransaction().commit();
         
     
     }catch (Exception ex){
     
         System.out.println("Error al actualizar el objeto:"+ex.getMessage());
     
     
        }finally{
            if(em !=null){
                
                em.close();
            
            }
        }  
         
     }
    
    public void eliminar (Descuento descuento){
    try{
        em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(descuento));
        em.getTransaction().commit();

   
    
    }catch (Exception ex){
        System.out.println("Error al eliminar el objeto persona:"+ ex.getMessage());
    
    
        }finally{
    
        if(em !=null){
            em.close();
            
            }
        
        }
    
    }
}
