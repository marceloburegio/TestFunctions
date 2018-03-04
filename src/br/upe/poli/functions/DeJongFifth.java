package br.upe.poli.functions;

import br.upe.poli.Problem;

/**
 * Fifth function of De Jong
 * 
 * global minimum: 
 */
public class DeJongFifth extends Problem {
	
	public DeJongFifth(){
		nDimensions = 2;
		leftBounds = new double[]{-65.536, -65.536};
		rightBounds = new double[]{65.536, 65.536};
	}
	
	@Override
	public double getFitness(double[] position) {
		double x = position[0];
		double y = position[1];
		double sum1 = 0D;
		for (int i = -2; i <= 2; i++) {
			double sum2 = 0D;
			for (int j = -2; j <= 2; j++) {
				sum2 += 1D / ((5D * (i + 2D)) + j + 3D + Math.pow(x - (16D * j), 6) + Math.pow(y - (16D * i), 6));
			}
			sum1 += sum2;
		}
		return 1D / (0.002 + sum1);
	}
}