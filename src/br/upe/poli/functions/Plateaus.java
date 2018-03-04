package br.upe.poli.functions;

import br.upe.poli.Problem;

/**
 * Plateaus' Function
 * 
 * global minimum: 
 */
public class Plateaus extends Problem {
	
	public Plateaus(){
		nDimensions = 2;
		leftBounds = new double[]{-2D*Math.PI, -2D*Math.PI};
		rightBounds = new double[]{2D*Math.PI, 2D*Math.PI};
	}
	
	@Override
	public double getFitness(double[] position) {
		double x = position[0];
		double y = position[1];
		return Math.signum(Math.cos(x) + Math.cos(y));
	}
}