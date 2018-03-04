package br.upe.poli;

public abstract class Problem {
	protected double[] leftBounds;
	
	protected double[] rightBounds;
	
	protected int nDimensions;
	
	public abstract double getFitness(double[] location);

	public void evaluateConstraints(double[] location) {
		for (int i = 0; i < nDimensions; i++){
			if (location[i] < leftBounds[i]){
				location[i] = leftBounds[i];
			}
			if (location[i] > rightBounds[i]){
				location[i] = rightBounds[i];
			}
		}
	}

	/**
	 * M�todo acessor para obter o valor de leftBounds
	 *
	 * @return O valor de leftBounds
	 */
	public double[] getLeftBounds() {
		return leftBounds;
	}

	/**
	 * M�todo acessor para modificar o valor de leftBounds
	 *
	 * @param leftBounds O novo valor de leftBounds
	 */
	public void setLeftBounds(double[] leftBounds) {
		this.leftBounds = leftBounds;
	}

	/**
	 * M�todo acessor para obter o valor de rightBounds
	 *
	 * @return O valor de rightBounds
	 */
	public double[] getRightBounds() {
		return rightBounds;
	}

	/**
	 * M�todo acessor para modificar o valor de rightBounds
	 *
	 * @param rightBounds O novo valor de rightBounds
	 */
	public void setRightBounds(double[] rightBounds) {
		this.rightBounds = rightBounds;
	}

	/**
	 * M�todo acessor para obter o valor de nDimensions
	 *
	 * @return O valor de nDimensions
	 */
	public int getNDimensions() {
		return nDimensions;
	}

	/**
	 * M�todo acessor para modificar o valor de nDimensions
	 *
	 * @param dimensions O novo valor de nDimensions
	 */
	public void setNDimensions(int dimensions) {
		nDimensions = dimensions;
	}
}
