package br.upe.poli.functions;

import br.upe.poli.Problem;

/**
 * 4rd Function
 * 
 * Moved axis parallel hyper-ellipsoid function
 * f1c(x)=sum(5*i·x(i)^2), i=1:n, -5.12<=x(i)<=5.12.
 * 
 * global minimum: f(x)=0; x(i)= 5*i, i=1:n.
 */
public class MovedAxisParallelHyperEllipsoid extends Problem {
	
	public MovedAxisParallelHyperEllipsoid(){
		nDimensions = 2;
		leftBounds = new double[]{-5.12D, -5.12D};
		rightBounds = new double[]{5.12D, 5.12D};
	}
	
	@Override
	public double getFitness(double[] position) {
		double sum = 0D;
		for (int i = 1; i <= nDimensions; i++) {
			double xi = position[(i - 1)];
			sum += (5 * i) * (xi * xi);
		}
		return sum;
	}
}