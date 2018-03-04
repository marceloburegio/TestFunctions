package br.upe.poli.functions;

import br.upe.poli.Problem;

/**
 * Staircase Function
 * 
 * global minimum: 
 */
public class Staircase extends Problem {
	
	public Staircase(){
		nDimensions = 2;
		leftBounds = new double[]{0D, 0D};
		rightBounds = new double[]{2D, 2D};
	}
	
	@Override
	public double getFitness(double[] position) {
		double x = position[0];
		double y = position[1];
		return 25 - Math.floor(x) - Math.floor(y);
	}
}