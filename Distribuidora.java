package ar.edu.info.unlp.ejercicioDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Distribuidora {
	private double precioKWh;
	private List<Usuario> usuarios;
	
	public Distribuidora(double precio) {
		precioKWh = precio;
		usuarios = new ArrayList<Usuario>();
	}
	
	//deberia comprobar que no exista un usuario con mismo nombre y domicilio? ( overriding equals de usuario)
	public void agregarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public List<Factura> facturar(){
		List<Factura> mensual = new ArrayList<Factura>();;
		if (!usuarios.isEmpty()) {
			usuarios.forEach(usuario -> {
				Factura nueva = usuario.facturarEnBaseA(precioKWh);
				if ( nueva != null) mensual.add(nueva);
			});
			
		}
		return mensual;
	}
	
	public double consumoTotalActica() {
		double result = -1;
		if (!usuarios.isEmpty()) result = usuarios.stream().mapToDouble(usuario -> usuario.ultimoConsumoActiva()).sum();
		return result;
	}
	
	
	public void precioKWh(double precio) {
		precioKWh = precio;
	}
	
}
