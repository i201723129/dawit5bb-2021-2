package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class demo05 {

	
	
	public static void main(String[] args) {
		  EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		  EntityManager em = fabrica.createEntityManager();
		  Usuario u = em.find(Usuario.class, 11);
		  if(u == null) {
			  System.out.println("Usuario no existe");
		  }else {
			  System.out.println("Usuario encontrado: "+u.getNombre());
			  System.out.println(u);
		  }
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
