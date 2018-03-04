package br.upe.poli.functions;

import br.upe.poli.Problem;

/**
 * Peaks' Function
 * 
 * global minimum: 
 */
public class Peaks extends Problem {
	
	public Peaks(){
		nDimensions = 2;
		leftBounds = new double[]{0D, 0D};
		rightBounds = new double[]{3D, 3D};
	}
	
	@Override
	public double getFitness(double[] position) {
		double x = position[0];
		double y = position[1];
		return 	3*Math.pow((1-x), 2)*Math.exp(-(x*x+Math.pow((y+1), 2)))
				- 10*((x/5) -Math.pow(x, 3)- Math.pow(y, 5))*Math.exp(-(x*x + y*y))
				- (1/3)*Math.exp(-(Math.pow(x+1, 2) + y*y));
	}
}