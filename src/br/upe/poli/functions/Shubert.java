package br.upe.poli.functions;

import br.upe.poli.Problem;

/**
 * Shubert's function
 *
 * -10 <= xi <= 10, i=1,2
 * 
 * global minimum: f(x) = -186.7309
 */
public class Shubert extends Problem {
	
	public Shubert(){
		nDimensions = 2;
		leftBounds = new double[]{-5.12, -5.12};
		rightBounds = new double[]{5.12, 5.12};
	}
	
	@Override
	public double getFitness(double[] position) {
		double x = position[0];
		double y = position[1];
		double sum1 = 0D;
		double sum2 = 0D;
		for (int i = 1; i <= 5; i++) {
			sum1 += i * Math.cos(((i + 1) * x) + 1);
			sum2 += i * Math.cos(((i + 1) * y) + 1);
		}
		return sum1 * sum2;
	}
}