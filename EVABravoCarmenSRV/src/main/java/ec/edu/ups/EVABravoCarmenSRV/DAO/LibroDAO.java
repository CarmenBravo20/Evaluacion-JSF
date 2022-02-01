package ec.edu.ups.EVABravoCarmenSRV.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.EVABravoCarmenSRV.Model.Libro;




@Stateless
public class LibroDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void insert(Libro lib) {
		em.persist(lib);		
	}
	
	public void update(Libro lib) {
		em.merge(lib);
	}
	
	public Libro read(int codigo) {
		Libro lib = em.find(Libro.class, codigo);
		return lib;
	}
	public List<Libro>getList(){
		List<Libro> listado=new ArrayList<Libro>();
	
		String jpql="SELECT lib FROM Libro lib"; 
		
		Query query =em.createQuery(jpql,Libro.class);
		listado=query.getResultList();
	return listado;
	}
}
