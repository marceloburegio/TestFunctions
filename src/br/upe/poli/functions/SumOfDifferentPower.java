package br.upe.poli.functions;

import br.upe.poli.Problem;

/**
 * 9rd Function
 * 
 * Sum of different power function 9
 * f9(x)=sum(abs(x(i))^(i+1)), i=1:n; -1<=x(i)<=1.
 * 
 * global minimum: f(x)=0; x(i)=0, i=1:n.
 */
public class SumOfDifferentPower extends Problem {
	
	public SumOfDifferentPower(){
		nDimensions = 2;
		leftBounds = new double[]{-1D, -1D};
		rightBounds = new double[]{1D, 1D};
	}
	
	@Override
	public double getFitness(double[] position) {
		double sum = 0D;
		for (int i = 1; i <= nDimensions; i++) {
			double xi = position[(i - 1)];
			double xiAbs = Math.abs(xi);
			double pow = 1D;
			for (int j = 1; j <= (i + 1); j++) {
				pow *= xiAbs;
			}
			sum += pow;
		}
		return sum;
	}
}