package br.upe.poli.functions;

import br.upe.poli.Problem;

/**
 * 15rd Function
 * 
 * Goldstein-Price's function
 * fGold(x1,x2)=[1+(x1+x2+1)^2·(19-14·x1+3·x1^2-14·x2+6·x1·x2+3·x2^2)]·
              [30+(2·x1-3·x2)^2·(18-32·x1+12·x1^2+48·x2-36·x1·x2+27·x2^2)]
   -2<=x(i)<=2, i=1:2.
 * 
 * global minimum: f(x1,x2)=3; (x1,x2)=(0,-1).
 */
public class GoldsteinPrice extends Problem {
	
	public GoldsteinPrice(){
		nDimensions = 2;
		leftBounds = new double[]{-2D, -2D};
		rightBounds = new double[]{2D, 2D};
	}
	
	@Override
	public double getFitness(double[] position) {
		double x = position[0];
		double y = position[1];
		return	(1 + (((x+y+1)*(x+y+1)) * (19 - (14*x) + (3*x*x) - (14*y) + (6*x*y) + (3*y*y)))) *
				(30 + ((((2*x)-(3*y))*((2*x)-(3*y))) * (18 - (32*x) + (12*x*x) + (48*y) - (36*x*y) + (27*y*y))));
	}
}