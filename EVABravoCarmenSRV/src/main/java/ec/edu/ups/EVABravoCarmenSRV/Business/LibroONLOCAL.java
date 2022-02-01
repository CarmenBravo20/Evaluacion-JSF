package ec.edu.ups.EVABravoCarmenSRV.Business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.EVABravoCarmenSRV.Model.Libro;


@Local
public interface LibroONLOCAL {
	
	
	public void insertar(Libro lib)  throws Exception;
	public List<Libro>getLibros();

	public void guardarLibro(Libro p) throws Exception;
	 

}
