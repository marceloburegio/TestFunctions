package br.upe.poli.functions;

import br.upe.poli.Problem;

/**
 * 11rd Function
 * 
 * Langermann's function 11
 * f11(x)=-sum(c(i)·(exp(-1/pi·sum((x-A(i))^2))·cos(pi·sum((x-A(i))^2))))
 * i=1:m, 2<=m<=10; 0<=x(i)<=10.
 * 
 * global minimum: f(x)=-1.4 (for m=5); x(i)=???, i=1:n. 
 */
public class Langermann extends Problem {
	
	public Langermann(){
		nDimensions = 2;
		leftBounds = new double[]{0D, 10D};
		rightBounds = new double[]{0D, 10D};
	}
	
	@Override
	public double getFitness(double[] position) {
		double[][] a = new double[][]{{3, 5, 2, 1, 7}, {5, 2, 1, 4, 9}};
		double[] c = new double[]{3, 5, 2, 1, 7};
		double m = 5;
		
		double sum1 = 0D;
		for (int i = 1; i <= m; i++) {
			double sum2 = 0D;
			for (int j = 1; j <= nDimensions; j++) {
				double xj = position[(j - 1)];
				sum2 += (xj - a[(j - 1)][(i - 1)]) * (xj - a[(j - 1)][(i - 1)]);
			}
			sum1 += c[(i - 1)] * Math.exp(-1D/Math.PI * sum2) * Math.cos(Math.PI * sum2);
		}
		return sum1;
	}
}