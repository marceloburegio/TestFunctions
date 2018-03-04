package br.upe.poli.functions;

import br.upe.poli.Problem;

/**
 * 7rd Function
 * 
 * Schwefel's function 7
 * f7(x)=sum(-x(i)·sin(sqrt(abs(x(i))))), i=1:n; -500<=x(i)<=500.
 * 
 * global minimum: f(x)=-n·418.9829; x(i)=420.9687, i=1:n.
 */
public class Schwefel extends Problem {
	
	public Schwefel(){
		nDimensions = 2;
		leftBounds = new double[]{-500D, -500D};
		rightBounds = new double[]{500D, 500D};
	}
	
	@Override
	public double getFitness(double[] position) {
		double sum = 0D;
		for (int i = 1; i <= nDimensions; i++) {
			double xi = position[(i - 1)];
			sum += -xi * Math.sin(Math.sqrt(Math.abs(xi)));
		}
		return sum;
	}
}