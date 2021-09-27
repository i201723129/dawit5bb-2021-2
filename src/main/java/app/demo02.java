package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class demo02 {

	
	 public static void main(String[] args) {
		  EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		  EntityManager em = fabrica.createEntityManager();
		  Usuario u = new Usuario();
		  u.setCodigo(11);
		  u.setNombre("Jose");
		  u.setApellido("Aguirre");
		  u.setUsuario("Jose100@homtail.com");
		  u.setClave("clave :v");
		  u.setFnacim("2010/01/20");
		  u.setTipo(1);
		  u.setEstado(1);
		  
		  try {
			
		  em.getTransaction().begin();
		  em.merge(u);
		  em.getTransaction().commit();
		  System.out.println("Actualizado :) ");
		  } catch (Exception e) {
				System.out.println("Error: "+e.getClass().getTypeName());
			}
		  em.close();
		 
	}
	
	
	
	
}
