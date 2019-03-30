package view;

import java.awt.Dimension;
import java.util.Map;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Chart extends JFrame {
	ChartPanel chartPanel = new ChartPanel(null);
	
	public Chart(Map<Integer, Double> results) {
		this.setTitle("Visualisation Graphiques");
		this.setLocation(100, 100);
		this.setSize(new Dimension(700, 450));
		
		// Génération du graphe
		XYSeriesCollection dataSet = new XYSeriesCollection();
		XYSeries taux = new XYSeries("Taux d'erreur");
		dataSet.addSeries(taux);
		
		for (Map.Entry<Integer, Double> entry : results.entrySet()) {
			taux.add(entry.getKey(), entry.getValue());
		}
		
		JFreeChart chart = ChartFactory.createXYLineChart("Performances", "MinNumObj", "Taux err", dataSet);
		
		XYPlot plot = (XYPlot) chart.getPlot();
		XYSplineRenderer renderer = new XYSplineRenderer();
		renderer.setBaseShapesVisible(false);
		plot.setRenderer(renderer);
		
		chartPanel.setChart(chart);
		
		this.add(chartPanel);
		this.setVisible(true);
	}
}
