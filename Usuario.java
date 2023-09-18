package ar.edu.info.unlp.ejercicioDemo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String domicilio;
	private String nombre;
	private List<Consumo> consumos;
	private List<Factura> facturas;
	
	
	public Usuario(String nombre, String domicilio) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		consumos = new ArrayList<>();
		facturas = new ArrayList<>();
	}

	public void agregarMedicion(Consumo medicion) {
		consumos.add(medicion);
	}
	
	public double ultimoConsumoActiva() {
		double result = 0;
		if(!consumos.isEmpty()) result = consumos.get(consumos.size()).getConsumoEnergiaActiva();
		return result;
	}
	
	
	public Factura facturarEnBaseA(double precioKWh) {
		Factura nueva = null;
		
		if (!consumos.isEmpty()) {
			
			Consumo ultimo = consumos.get(consumos.size());
			
			double monto = ultimo.costoEnBaseA(precioKWh);
			double descuento = 0;
			if(ultimo.factorDePotencia() > 0.8) descuento = monto * 0.1;
			
			nueva = new Factura(this, ultimo.getFecha(), monto, descuento);
			
			facturas.add(nueva);
		}
		
		return nueva;
	}
	
	public List<Factura> facturas(){
		return facturas;
	}
	
	public List<Consumo> consumos(){
		return consumos;
	}
	
}
