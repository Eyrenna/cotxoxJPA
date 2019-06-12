package org.mvpigs.cotxox.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_carreras")
public class Carrera {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="c_id")
    private Long id;
	
	@Column(name="c_tarjeta_credito")
	private String tarjetaCredito = null;
	
	@Column(name="c_origen")
	private String origen = null;
	
	@Column(name="c_destino")
	private String destino = null;
	
	@Column(name="c_distancia")
	private double distancia = 0d;
	
	@Column(name="c_tiempo_esperado")
	private int tiempoEsperado = 0;
	
	@Column(name="c_tiempo_carrera")
	private int tiempoCarrera = 0;
	
	@Column(name="c_coste_total")
	private double costeTotal = 0;
	
	@Column(name="c_propina")
	private int propina = 0;
	
	@ManyToOne
	@JoinColumn(name="c_conductor")
	private Conductor conductor = null;
	
	/**
	 * Constructores: necesitamos el constructor por defecto 
	 * para trabajar con Spring JPA
	 */

	public Carrera() {}
	
	public Carrera(String tarjetaCredito){
		this.tarjetaCredito = tarjetaCredito;
	}
	
	/** 
	 * Getters y setters
	 */

	public Long getId() {
		return this.id;
	}

	public String getTarjetaCredito(){
		return this.tarjetaCredito;
	}
	
	public void setOrigen(String origen){
		this.origen = origen;
	}
	
	public String getOrigen(){
		return this.origen;
	}
	
	public void setDestino(String destino){
		this.destino = destino;
	}
	
	public String getDestino(){
		return this.destino;
	}
	
	public void setDistancia(double distancia){
		this.distancia = distancia;
	}
	
	public double getDistancia(){
		return this.distancia;
	}
	
	public double getCosteEsperado(){
		return Tarifa.getCosteTotalEsperado(this);
	}

	public int getTiempoEsperado() {
		return tiempoEsperado;
	}

	public void setTiempoEsperado(int tiempoEsperado) {
		this.tiempoEsperado = tiempoEsperado;
	}
	
	public int getTiempoCarrera() {
		return tiempoCarrera;
	}

	public void setTiempoCarrera(int tiempoCarrera) {
		this.tiempoCarrera = tiempoCarrera;
	}
	
	public void setConductor(Conductor conductor){
		this.conductor = conductor;
	}
	
	public Conductor getConductor(){
		return this.conductor;
	}

	/**
	 * Lógica de la clase
	 */
	
	
	public void asignarConductor(PoolConductores conductores){
		setConductor(conductores.asignarConductor());
	}
	
	public void realizarPago(double pago){
		this.costeTotal = pago;
	}
	
	public double getCosteTotal(){
		return this.costeTotal;
	}

	public void setCosteTotal(double pago){
		this.costeTotal = pago;
	}
	
	public void recibirPropina(int propina){
		this.propina = propina;
	}
	
	public int getPropina(){
		return this.propina;
	}
	
	public void liberarConductor(){
		getConductor().setOcupado(false);
	}
}
