package br.upe.poli.functions;

import br.upe.poli.Problem;

/**
 * EqualPeaksA function
 * 
 * 
 * global minimum: 
 */
public class EqualPeaksB extends Problem {
	
	public EqualPeaksB(){
		nDimensions = 2;
		leftBounds = new double[]{0D, 0D};
		rightBounds = new double[]{5D, 5D};
	}
	
	@Override
	public double getFitness(double[] position) {
		double x = position[0];
		double y = position[1];
		return (Math.cos(x) * Math.cos(x)) + (Math.sin(y) * Math.sin(y));
	}
}