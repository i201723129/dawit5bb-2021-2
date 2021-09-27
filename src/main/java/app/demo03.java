package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class demo03 {

	
	 public static void main(String[] args) {
		  EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		  EntityManager em = fabrica.createEntityManager();
		  Usuario u = new Usuario();
		  u.setCodigo(11);
		 
		  
		  try {
			
		  em.getTransaction().begin();
		  em.remove(u);
		  em.getTransaction().commit();
		  System.out.println("Eliminado :) ");
		  } catch (Exception e) {
				System.out.println("Error: "+e.getClass().getTypeName());
			}
		  em.close();
		 
	}
	
	
}
