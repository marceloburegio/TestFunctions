package br.upe.poli.functions;

import br.upe.poli.Problem;

/**
 * 3rd Function
 * 
 * Rotated hyper-ellipsoid function
 * f1b(x)=sum(sum(x(j)^2), j=1:i), i=1:n, -65.536<=x(i)<=65.536.
 * 
 * global minimum: f(x)=0; x(i)= 0, i=1:n.
 */
public class RotatedHyperEllipsoid extends Problem {
	
	public RotatedHyperEllipsoid(){
		nDimensions = 2;
		leftBounds = new double[]{-65.536D, -65.536D};
		rightBounds = new double[]{65.536D, 65.536D};
	}
	
	@Override
	public double getFitness(double[] position) {
		double sum1 = 0D;
		for (int i = 1; i <= nDimensions; i++) {
			double sum2 = 0D;
			for (int j = 1; j <= i; j++) {
				double xi = position[(j - 1)];
				sum2 += xi;
			}
			sum1 += sum2 * sum2;
		}
		return sum1;
	}
}