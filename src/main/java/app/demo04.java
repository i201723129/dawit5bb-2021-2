package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

//consultas
public class demo04 {

	
	
	
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
			  
		  em.close();
		 
	}
}

