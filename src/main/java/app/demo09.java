package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.Usuario;

public class demo09 {

	
	
	
	public static void main(String[] args) {
		  EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		  EntityManager em = fabrica.createEntityManager();
		  //Usuario u = em.find(Usuario.class, 11);
		  String sql="{call usp_validaAcceso (?,?)}";
		  //TypedQuery<Usuario> query3 = em.createQuery(sql,Usuario.class);//
		  Query query3 = em.createNativeQuery(sql,Usuario.class);
		  query3.setParameter(1, "U002@gmail.com"); 
		  query3.setParameter(2, "10002");
		  Usuario u=null;
		try {
			u = (Usuario) query3.getSingleResult();
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
