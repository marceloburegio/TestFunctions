package br.upe.poli.functions;

import br.upe.poli.Problem;

/**
 * 6rd Function
 * 
 * Rastrigin's function 6
 * f6(x)=10·n+sum(x(i)^2-10·cos(2·pi·x(i))), i=1:n; -5.12<=x(i)<=5.12.
 * 
 * global minimum: f(x)=0; x(i)=0, i=1:n.
 */
public class Rastrigin extends Problem {
	
	public Rastrigin(){
		nDimensions = 2;
		leftBounds = new double[]{-5.12D, -5.12D};
		rightBounds = new double[]{5.12D, 5.12D};
	}
	
	@Override
	public double getFitness(double[] position) {
		double sum = 0D;
		for (int i = 1; i <= nDimensions; i++) {
			double xi = position[(i - 1)];
			sum += (xi * xi) - (10D * Math.cos(2D * Math.PI * xi));
		}
		return (10 * nDimensions) + sum;
	}
}