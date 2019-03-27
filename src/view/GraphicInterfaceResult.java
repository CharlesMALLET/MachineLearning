package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class GraphicInterfaceResult extends JFrame{

	private static final long serialVersionUID = -5677204364423194016L;
	
	private JButton buttonClose;
	private JButton buttonChart;
	private JButton buttonCsv;
	private JTextField tfview;
	
	private JPanel resultsView = new JPanel();
	
	private Map<Integer, Double> results = new HashMap<Integer, Double>();

	public GraphicInterfaceResult(Map<Integer, Double> results){
		this.results = results;
		
		setTitle("Algorithme de Recherche Weka");
		setSize(500,500);
		setLayout(new BorderLayout());
		//setLayout(new GridLayout(2,1,1,1));
		
		if (results.size() != 0) {
			// Tableau de résultats
			Vector<String> headers = new Vector<String>();
			headers.add("Min exemples par feuille");
			headers.add("Taux d'erreur");
			
			// Tri par la clé
			Map<Integer, Double> treeMap = new TreeMap<Integer, Double>(results);
			
			Vector<Vector<Object>> donnees = new Vector<>();
			
			for (Entry<Integer, Double> entry : treeMap.entrySet()) {
				Vector<Object> v = new Vector<>();
				v.add(entry.getKey());
				v.add(entry.getValue());
				donnees.add(v);
				//System.out.println(v.toString());
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
		
		buttonCsv = new JButton("Exporter au format CSV");
		
		buttonClose = new JButton("Fermer");
		buttonClose.addActionListener(new ActionListener() {
			 public void actionPerformed (ActionEvent e) {
				  //dispose();
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
}
