package br.upe.poli.functions;

import br.upe.poli.Problem;

/**
 * 8rd Function
 * 
 * Griewangk's function 8
 * f8(x)=sum(x(i)^2/4000)-prod(cos(x(i)/sqrt(i)))+1, i=1:n -600<=x(i)<= 600.
 * 
 * global minimum: f(x)=0; x(i)=0, i=1:n.
 */
public class Griewangk extends Problem {
	
	public Griewangk(){
		nDimensions = 2;
		leftBounds = new double[]{-600D, -600D};
		rightBounds = new double[]{600D, 600D};
	}
	
	@Override
	public double getFitness(double[] position) {
		double sum = 0D;
		double prod = 1D;
		for (int i = 1; i <= nDimensions; i++) {
			double xi = position[(i - 1)];
			sum += (xi * xi) / 4000;
			prod *= Math.cos(xi / Math.sqrt(i));
		}
		return sum - prod + 1;
	}
}