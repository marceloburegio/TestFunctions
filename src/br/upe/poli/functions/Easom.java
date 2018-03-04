package br.upe.poli.functions;

import br.upe.poli.Problem;

/**
 * 14rd Function
 * 
 * Easom's function
 * fEaso(x1,x2)=-cos(x1)·cos(x2)·exp(-((x1-pi)^2+(x2-pi)^2))
 * -100<=x(i)<=100, i=1:2.
 * 
 * global minimum: f(x1,x2)=-1; (x1,x2)=(pi,pi).
 */
public class Easom extends Problem {
	
	public Easom(){
		nDimensions = 2;
		leftBounds = new double[]{-100D, -100D};
		rightBounds = new double[]{100D, 100D};
	}
	
	@Override
	public double getFitness(double[] position) {
		double x = position[0];
		double y = position[1];
		return -Math.cos(x) * Math.cos(y) * Math.exp(-(((x - Math.PI) * (x - Math.PI)) + ((y - Math.PI) * (y - Math.PI))));
	}
}