package br.upe.poli.functions;

import br.upe.poli.Problem;

/**
 * Himmelblau's Function
 * 
 * global minimum: 
 */
public class Himmelblau extends Problem {
	
	public Himmelblau(){
		nDimensions = 2;
		leftBounds = new double[]{0D, 0D};
		rightBounds = new double[]{6D, 6D};
	}
	
	@Override
	public double getFitness(double[] position) {
		double x = position[0];
		double y = position[1];
		return 200 - Math.pow((x*x + y - 11), 2) - Math.pow((x + y*y - 7), 2);
	}
}