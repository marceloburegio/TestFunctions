package br.upe.poli.functions;

import br.upe.poli.Problem;

/**
 * 5rd Function
 * 
 * Rosenbrock's valley (De Jong's function 2)
 * f2(x)=sum(100·(x(i+1)-x(i)^2)^2+(1-x(i))^2) i=1:n-1; -2.048<=x(i)<=2.048.
 * 
 * global minimum: f(x)=0; x(i)=1, i=1:n.
 */
public class Rosenbrock extends Problem {
	
	public Rosenbrock(){
		nDimensions = 2;
		leftBounds = new double[]{-2.048D, -2.048D};
		rightBounds = new double[]{2.048D, 2.048D};
	}
	
	@Override
	public double getFitness(double[] position) {
		double sum = 0D;
		for (int i = 1; i <= (nDimensions - 1); i++) {
			double xi = position[(i - 1)];
			double yi = position[i];
			sum += (100 * ((yi - (xi * xi)) * (yi - (xi * xi)))) + ((1 - xi) * (1 - xi));
		}
		return sum;
	}
}