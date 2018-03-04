package br.upe.poli.functions;

import br.upe.poli.Problem;

/**
 * 12rd Michalewicz's function 12
 * 
 * Michalewicz's function 12
 * f12(x)=-sum(sin(x(i))·(sin(i·x(i)^2/pi))^(2·m)), i=1:n, m=10
 * 0<=x(i)<=pi.
 * 
 * global minimum:  f(x)=-4.687 (n=5); x(i)=???, i=1:n.
 * 					f(x)=-9.66 (n=10); x(i)=???, i=1:n.
 */
public class Michalewicz extends Problem {
	
	public Michalewicz(){
		nDimensions = 2;
		leftBounds = new double[]{0D, 0D};
		rightBounds = new double[]{Math.PI, Math.PI};
	}
	
	@Override
	public double getFitness(double[] position) {
		int m = 5;
		double sum = 0D;
		for (int i = 1; i <= nDimensions; i++) {
			double xi = position[(i - 1)];
			double pow = 1D;
			double xiPow = Math.sin(i * (xi * xi) / Math.PI);
			for (int j = 1; j <= (2 * m); j++) {
				pow *= xiPow;
			}
			sum += Math.sin(xi) * pow;
		}
		return -sum;
	}
}