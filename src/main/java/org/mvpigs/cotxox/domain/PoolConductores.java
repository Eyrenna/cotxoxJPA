package org.mvpigs.cotxox.domain;

import java.util.ArrayList;
import java.util.Random;

public class PoolConductores {
	
	private ArrayList<Conductor> poolConductores = new ArrayList<>();

	/**
	 * Constructores: necesitamos el constructor por defecto para trabajar con Spring JPA
	 */

	public PoolConductores() {};
	
	public PoolConductores(ArrayList<Conductor> poolConductores){
		this.poolConductores = poolConductores;
	}

	/** 
	 * Getters y setter
	 */
	
	public ArrayList<Conductor> getPoolConductores(){
		return this.poolConductores;
	}
	
	/**
	 * Lógica de la clase
	 */

	public Conductor asignarConductor(){
		Conductor conductor = new Conductor();
		Random aleatorio = new Random();
		boolean asignado = false;
		while(!asignado){
			int index = aleatorio.nextInt(getPoolConductores().size());
			conductor = getPoolConductores().get(index);
			if(!conductor.isOcupado()){
				conductor.setOcupado(true);
				asignado = true;
			}
		}
		return conductor;
	}
	
}
