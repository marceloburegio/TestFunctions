package br.upe.poli.functions;

import br.upe.poli.Problem;

/**
 * 10rd Function
 * 
 * Ackley's Path function 10
 * f10(x)=-a·exp(-b·sqrt(1/n·sum(x(i)^2)))-exp(1/n·sum(cos(c·x(i))))+a+exp(1)
 * a=20; b=0.2; c=2·pi; i=1:n; -32.768<=x(i)<=32.768.
 * 
 * global minimum: f(x)=0; x(i)=0, i=1:n.
 */
public class Ackley extends Problem {
	
	public Ackley(){
		nDimensions = 2;
		leftBounds = new double[]{-32.768D, -32.768D};
		rightBounds = new double[]{32.768D, 32.768D};
	}
	
	@Override
	public double getFitness(double[] position) {
		double a = 20D, b = 0.2D, c = 2D * Math.PI;
		
		double sum1 = 0D;
		double sum2 = 0D;
		for (int i = 1; i <= nDimensions; i++) {
			double xi = position[(i - 1)];
			sum1 += (xi * xi);
			sum2 += Math.cos(c * xi);
		}
		return (-a * Math.exp(-b * Math.sqrt(sum1 / nDimensions))) - Math.exp(sum2 / nDimensions) + a + Math.E;
	}
}