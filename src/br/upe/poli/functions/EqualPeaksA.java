package br.upe.poli.functions;

import br.upe.poli.Problem;

/**
 * EqualPeaksA function
 * 
 * 
 * global minimum: 
 */
public class EqualPeaksA extends Problem {
	
	public EqualPeaksA(){
		nDimensions = 2;
		leftBounds = new double[]{0D, 0D};
		rightBounds = new double[]{4D, 4D};
	}
	
	@Override
	public double getFitness(double[] position) {
		double sum = 0D;
		for (int i = 1; i <= nDimensions; i++) {
			double xi = position[(i - 1)];
			xi = Math.cos(xi);
			sum += (xi * xi);
		}
		return sum;
	}
}