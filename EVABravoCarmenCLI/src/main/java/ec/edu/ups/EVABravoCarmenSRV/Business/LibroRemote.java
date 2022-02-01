package ec.edu.ups.EVABravoCarmenSRV.Business;

import java.util.List;



import ec.edu.ups.EVABravoCarmenSRV.Model.Libro;
public interface LibroRemote {
		
		
		public void insertar(Libro lib)  throws Exception;
		public List<Libro>getLibros();

		public void guardarLibro(Libro p) throws Exception;
}
