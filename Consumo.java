package ar.edu.info.unlp.ejercicioDemo;

import java.time.LocalDate;

public class Consumo {

		private LocalDate fecha;
		private double consumoEnergiaActiva;
		private double consumoEnergiaReactiva;
		
		
		public Consumo(LocalDate fecha, double consumoEnergiaActiva, double consumoEnergiaReactiva) {
			this.fecha = fecha;
			this.consumoEnergiaActiva = consumoEnergiaActiva;
			this.consumoEnergiaReactiva = consumoEnergiaReactiva;
		}
		
		public LocalDate getFecha() {
			return fecha;
		}
		
		public double getConsumoEnergiaActiva() {
			return consumoEnergiaActiva;
		}
		
		
		public double costoEnBaseA(double precioKWh) {
			return consumoEnergiaActiva * precioKWh;
		}
		
		public double factorDePotencia() {
			double denominador = Math.sqrt( Math.pow(consumoEnergiaActiva, 2)  +  Math.pow(consumoEnergiaReactiva, 2)  );
			return consumoEnergiaActiva / denominador;
		}
	
}
