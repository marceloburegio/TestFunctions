package br.upe.poli.functions;

import br.upe.poli.Problem;

/**
 * Circles' function
 * 
 * 
 * global minimum: 
 */
public class Circles extends Problem {
	
	public Circles(){
		nDimensions = 2;
		leftBounds = new double[]{-10D, -10D};
		rightBounds = new double[]{10D, 10D};
	}
	
	@Override
	public double getFitness(double[] position) {
		double x = position[0];
		double y = position[1];
		
		return Math.pow((x*x + y*y), 0.25)*(Math.pow(Math.sin(50D*Math.pow((x*x + y*y), 0.1)), 2D) + 1D);
	}
}