package br.upe.poli.functions;

import br.upe.poli.Problem;

/**
 * 16rd Function
 * 
 * Six-hump camel back function
 * fSixh(x1,x2)=(4-2.1·x1^2+x1^4/3)·x1^2+x1·x2+(-4+4·x2^2)·x2^2
   -3<=x1<=3, -2<=x2<=2.
 * 
 * global minimum: f(x1,x2)=-1.0316; (x1,x2)=(-0.0898,0.7126), (0.0898,-0.7126).
 */
public class SixHumpCamelBack extends Problem {
	
	public SixHumpCamelBack(){
		nDimensions = 2;
		leftBounds = new double[]{-3D, -2D};
		rightBounds = new double[]{3D, 2D};
	}
	
	@Override
	public double getFitness(double[] position) {
		double x = position[0];
		double y = position[1];
		return ((4D - (2.1*x*x) + ((x*x*x*x)/3D)) * (x*x)) + (x*y) + ((-4 + (4*x*x)) * (x*x));
	}
}