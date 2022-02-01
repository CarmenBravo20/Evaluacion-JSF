package ec.edu.ups.EVABravoCarmenSRV.BEAN;


import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.EVABravoCarmenSRV.Business.LibroONLOCAL;
import ec.edu.ups.EVABravoCarmenSRV.Model.Libro;

@WebService
public class LibroSOAP {

	@Inject
	private LibroONLOCAL libroON;

	@WebMethod
	public String crearLibro(Libro libro) {
		try {
			libroON.guardarLibro(libro);
			return "Libro Creado Exitosamente";
		} catch (Exception e) {
			return "Error Libro no creado";
		}

	}

	@WebMethod
	public List<Libro> getLibros() {
		return libroON.getLibros();
	}

}
