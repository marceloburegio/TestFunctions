package br.upe.poli;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import ChartDirector.Chart;
import ChartDirector.ChartViewer;
import ChartDirector.SurfaceChart;

import br.upe.poli.functions.*;

public class View3D {
	
	
	// Main code for creating charts
	public void createChart(ChartViewer viewer, int index) {
		// Define the problem
		List<Problem> listProblems = new ArrayList<Problem>();
		
		// Adding the problems to ArrayList
		listProblems.add(new Ackley());
		listProblems.add(new AxisParallelHyperEllipsoid());
		listProblems.add(new Branins());
		listProblems.add(new Plateaus());
		listProblems.add(new Circles());
		listProblems.add(new DeJongFifth());
		listProblems.add(new DeJongs());
		listProblems.add(new DropWave());
		listProblems.add(new Easom());
		listProblems.add(new EqualPeaksA());
		listProblems.add(new EqualPeaksB());
		listProblems.add(new GoldsteinPrice());
		listProblems.add(new Griewangk());
		listProblems.add(new Himmelblau());
		//listProblems.add(new Langermann());
		listProblems.add(new Michalewicz());
		listProblems.add(new MovedAxisParallelHyperEllipsoid());
		listProblems.add(new Peaks());
		listProblems.add(new Plateaus());
		listProblems.add(new Rastrigin());
		listProblems.add(new RotatedHyperEllipsoid());
		listProblems.add(new Schwefel());
		listProblems.add(new Shubert());
		listProblems.add(new SixHumpCamelBack());
		listProblems.add(new Staircase());
		listProblems.add(new SumOfDifferentPower());
		
		// Calculating the spaces between the x,y values
		int xVal = 1000;
		int yVal = 1000;
		
		for (Problem problem : listProblems) {
			// The x and y coordinates of the grid
			double[] dataX = new double[(xVal +1)];
			double[] dataY = new double[(yVal +1)];
			double delta;
			
			// Fill the x and y data arrays
			delta = problem.rightBounds[0] - problem.leftBounds[0];
			for (int i = 0; i <= xVal; i++) {
				dataX[i] = problem.leftBounds[0] + (((double) i / (double) xVal) * delta);
			}
			delta = problem.rightBounds[1] - problem.leftBounds[1];
			for (int i = 0; i <= yVal; i++) {
				dataY[i] = problem.leftBounds[1] + (((double) i / (double) yVal) * delta);
			}
			
			// The values at the grid points. In this example, we will compute the
			// values
			// using the formula z = x * sin(y) + y * sin(x).
			double[] dataZ = new double[(dataX.length) * (dataY.length)];
			for (int yIndex = 0; yIndex < dataY.length; ++yIndex) {
				double y = dataY[yIndex];
				for (int xIndex = 0; xIndex < dataX.length; ++xIndex) {
					double x = dataX[xIndex];
					dataZ[yIndex * (dataX.length) + xIndex] = problem.getFitness(new double[]{x, y});
				}
			}
			
			// Create a SurfaceChart object of size 720 x 600 pixels
			int w = 720;
			int h = 600;
			SurfaceChart c = new SurfaceChart(w, h);
			
			// Add a title to the chart using 20 points Times New Roman Italic font
			/*
			c.addTitle("Concentração nutrientes (picos = comida, vales = subst. nocivas)",
					"Times New Roman Bold", 16);
			*/
			//c.setViewAngle(50, 45);
			
			// Set the center of the plot region at (350, 280), and set width x
			// depth x
			// height to 360 x 360 x 270 pixels
			c.setPlotRegion(w/2, (h/2) - 30, w/2, w/2, h/2);
			
			// Set the data to use to plot the chart
			c.setData(dataX, dataY, dataZ);
			
			// Spline interpolate data to a 80 x 80 grid for a smooth surface
			c.setInterpolation(80, 80);
			
			//c.setDefaultFonts("Arial Bold", 15);
			
			// Add a color axis (the legend) in which the left center is anchored at
			// (645, 270). Set the length to 200 pixels and the labels on the right
			// side.
			//c.setColorAxis(645, 270, Chart.Left, 200, Chart.Right);
			
			// Set the x, y and z axis titles using 10 points Arial Bold font
			c.xAxis().setTitle("X", "Arial Bold", 10);
			c.yAxis().setTitle("Y", "Arial Bold", 10);
			//c.zAxis().setTitle("Gradiente nutritivo", "Arial Bold", 10);
			
			// Output the chart
			Image image = c.makeImage();
			//viewer.setImage(image);
						
			// Creates a BufferdImage from the Image
			BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
			Graphics2D g2 = bufferedImage.createGraphics();
			g2.drawImage(image, null, null);  
			g2.dispose();
			
			// Prints the image to a file
			try {
				ImageIO.write(bufferedImage, "PNG", new File("./", problem.getClass().getName().replaceAll("br.upe.poli.functions.", "") + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//break;
		}
	}
	
	// Allow this module to run as standalone program for easy testing
	public static void main(String[] args) {
		// Instantiate an instance of this demo module
		View3D demo = new View3D();
		
		// Create and set up the main window
		/*
		JFrame frame = new JFrame(demo.toString());
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.getContentPane().setBackground(Color.white);
		*/
		
		// Create the chart and put them in the content pane
		ChartViewer viewer = new ChartViewer();
		demo.createChart(viewer, 0);
		/*
		frame.getContentPane().add(viewer);
		
		// Display the window
		frame.pack();
		frame.setVisible(true);
		*/
	}
}