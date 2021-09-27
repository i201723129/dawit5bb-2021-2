package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class demo01 {
     
	  public static void main(String[] args) {
		  EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		  EntityManager em = fabrica.createEntityManager();
		  Usuario u = new Usuario();
		  u.setCodigo(10);
		  u.setNombre("Jose");
		  u.setApellido("Suejiro");
		  u.setUsuario("Jose99@homtail.com");
		  u.setClave("123");
		  u.setFnacim("2021/04/12");
		  u.setTipo(1);
		  u.setEstado(1);
		  
		  try {
			
		  em.getTransaction().begin();
		  em.persist(u);
		  em.getTransaction().commit();
		  System.out.println("registro echo :) ");
		  } catch (Exception e) {
				System.out.println("Error: "+e.getClass().getTypeName());
			}
		  em.close();
		 
	}
}
