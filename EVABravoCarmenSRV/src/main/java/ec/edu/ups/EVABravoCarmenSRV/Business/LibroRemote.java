package ec.edu.ups.EVABravoCarmenSRV.Business;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.EVABravoCarmenSRV.Model.Libro;

@Remote
public interface LibroRemote {
		
		
		public void insertar(Libro lib)  throws Exception;
		public List<Libro>getLibros();

		public void guardarLibro(Libro p) throws Exception;
}
