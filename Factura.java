package ar.edu.info.unlp.ejercicioDemo;

import java.time.LocalDate;

public class Factura {

	
	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario usuario;
	
	public Factura(Usuario usuario, LocalDate fecha, double montoEnergia, double desc) {
		this.usuario = usuario;
		this.fecha = fecha;
		montoEnergiaActiva = montoEnergia;
		descuento = desc;
	}
	
	
	public double montoTotal() {
		return montoEnergiaActiva - descuento;
	}
	
	public Usuario usuario() {
		return usuario;
	}
	
	
	public LocalDate fecha() {
		return fecha;
	}
	
	public double descuento() {
		return descuento;
	}
	
}
