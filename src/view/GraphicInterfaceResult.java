package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import importExport.ExportIntoCSV;

public class GraphicInterfaceResult extends JFrame{

	private static final long serialVersionUID = -5677204364423194016L;
	
	private String nameFile;
	private JButton buttonClose;
	private JButton buttonChart;
	private JButton buttonCsv;
	private JTextField tfview;
	
	private JPanel resultsView = new JPanel();
	
	private static Map<Integer, Double> results = new HashMap<Integer, Double>();

	public GraphicInterfaceResult(Map<Integer, Double> results, String nameFile){
		this.nameFile = nameFile;
		this.results = results;
		Vector<String> headers = new Vector<String>();
		Vector<Vector<Object>> donnees = new Vector<>();
		
		setTitle("Algorithme de Recherche Weka");
		setSize(500,500);
		setLayout(new BorderLayout());
		
		if (results.size() != 0) {
			// Tableau de résultats
			headers.add("Minimum d'exemples par feuille");
			headers.add("Taux d'erreurs");
			
			// Tri par la clé
			Map<Integer, Double> treeMap = new TreeMap<Integer, Double>(results);
				
			for (Entry<Integer, Double> entry : treeMap.entrySet()) {
				Vector<Object> v = new Vector<>();
				v.add(entry.getKey());
				v.add(entry.getValue());
				donnees.add(v);
			}
		
			JTable table = new JTable(donnees, headers);			
			resultsView.add(new JScrollPane(table), BorderLayout.CENTER);
		} else {
			tfview = new JTextField(); 
			tfview.setSize(400, 400);
			tfview.setEditable(false);
			tfview.setText("Aucun résultat obtenu !");
			resultsView.add(tfview, BorderLayout.CENTER);
		}
		
		add(resultsView, BorderLayout.CENTER);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(3,1));
		
		buttonChart = new JButton("Afficher le graphique");
		buttonChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Afficher le graphique");
				Chart chart = new Chart(GraphicInterfaceResult.results);
			}
		});
		
		buttonCsv = new JButton("Exporter au format CSV");
		buttonCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Exporter au format CSV");
				try {
					ExportIntoCSV export = new ExportIntoCSV(getNameFile(), headers,donnees);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		buttonClose = new JButton("Fermer");
		buttonClose.addActionListener(new ActionListener() {
			 public void actionPerformed (ActionEvent e) {
				  System.exit(0);
				 }
			});
		btnPanel.add(buttonChart);
		btnPanel.add(buttonCsv);
		btnPanel.add(buttonClose);
		add(btnPanel, BorderLayout.SOUTH);
		
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
	
	String getNameFile()
	{
		return this.nameFile;
	}
	
}
