package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import model.Usuario;

public class demo06 {


	 public static void main(String[] args) {
		  EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		  EntityManager em = fabrica.createEntityManager();
		
		  TypedQuery<Usuario> query = em.createQuery("Select u from Usuario u",Usuario.class);
		  java.util.List<Usuario> lstUsuarios =query.getResultList();
		  System.out.println("Cantidad de usuarios: "+lstUsuarios.size());
		  if(lstUsuarios.size() == 0) {
			  
			  System.out.println("listado vacio");
			  
		  }else {
			  System.out.println("Listado de usuarios");
			  for(Usuario u:lstUsuarios){
				  System.out.println(">>>>"+u);
			  }
		  }
		  
		  
		
		  java.util.List<Usuario> lstUsuarios2 =em.createQuery("Select u from Usuario u",Usuario.class).getResultList();
		  System.out.println("Cantidad de usuarios: "+lstUsuarios2.size());
		  if(lstUsuarios2.size() == 0) {
			  
			  System.out.println("listado vacio");
			  
		  }else {
			  System.out.println("Listado de usuarios");
			  for(Usuario u:lstUsuarios2){
				  System.out.println(">>>>"+u);
			  }
		  }
		  
		  String sql="Select u from Usuario u where u.tipo = :xtipo";
		  TypedQuery<Usuario> query3 = em.createQuery(sql,Usuario.class);
		  query3.setParameter("xtipo", 1); 
		  java.util.List<Usuario> lstUsuarios3 =query3.getResultList();
		  System.out.println("Cantidad de usuarios: "+lstUsuarios3.size());
		  if(lstUsuarios3.size() == 0) {
			  
			  System.out.println("listado vacio");
			  
		  }else {
			  System.out.println("Listado de usuarios");
			  for(Usuario u:lstUsuarios3){
				  System.out.println(">>>>"+ u);
			  }
		  }
		  
		  em.close();
		 
	}
	
	
}
