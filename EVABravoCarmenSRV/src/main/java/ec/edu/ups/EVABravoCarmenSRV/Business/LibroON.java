package ec.edu.ups.EVABravoCarmenSRV.Business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.EVABravoCarmenSRV.DAO.LibroDAO;
import ec.edu.ups.EVABravoCarmenSRV.Model.Libro;


@Stateless
public class LibroON implements LibroONLOCAL, LibroRemote{
	@Inject
	private LibroDAO libroDao;
		
		public void insertar(Libro p) throws Exception {
			libroDao.insert(p);
			
		}
		public void guardarLibro(Libro p) throws Exception {
			if(libroDao.read(p.getCodigo())==null)
				libroDao.insert(p);
			else
				libroDao.update(p);
		}
		
		public List<Libro>getLibros(){
			return libroDao.getList();
		}
}
