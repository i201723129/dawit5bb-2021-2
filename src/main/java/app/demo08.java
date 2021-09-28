package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class demo08 {

	public static void main(String[] args) {
		  EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		  EntityManager em = fabrica.createEntityManager();
		  //Usuario u = em.find(Usuario.class, 11); 
		  String sql="Select u from Usuario u where u.usuario = :xusr and u.clave= :xcla";
		  TypedQuery<Usuario> query3 = em.createQuery(sql,Usuario.class);
		  query3.setParameter("xusr", "U002@gmail.com"); 
		  query3.setParameter("xcla", "10002");
		  Usuario u=null;
		try {
			u = query3.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		  if(u == null) {
			  System.out.println("Usuario no existe");
		  }else {
			  System.out.println("Usuario encontrado: "+u.getNombre());
			  System.out.println(u);
		  }
			  
		  em.close();
		 
	}



}
