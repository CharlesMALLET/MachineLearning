package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Algorithm.Boosting;
import Algorithm.AlgoJ48;
import Algorithm.RandomForest;
import Algorithm.kNN;

public class GraphicInterfaceSettings extends JFrame{

	private static final long serialVersionUID = 8828797684183958811L;
	private JLabel lblImport ;
	private JTextField tfImport;
	private JLabel lblList ;
	private JList<String> listOfAlgorithm;
	private JButton btnValidate;
	private JButton btnCancel;
	//private String [] donnees = {"J48","k-NN","Boosting","Random Forest"};
	private String [] donnees = {"J48"};
	private static Map<Integer, Double> results = new HashMap<Integer, Double>();
	
	public GraphicInterfaceSettings() {
		
		setTitle("Algorithme de Recherche Weka");
		setSize(500,150);
		setLayout(new GridLayout(3,2,3,3));
		lblImport = new JLabel("Fichier à importer : ");
		add(lblImport);
		
		tfImport = new JTextField(); 
		tfImport.setEditable(true);
		add(tfImport);
		
		lblList = new JLabel("Liste d'Algorithmes : ");
		add(lblList);
		listOfAlgorithm = new JList<String>(donnees);
		add(new JScrollPane(listOfAlgorithm));
		btnValidate = new JButton("Exécuter");
		btnValidate.addActionListener(new ActionListener() {
			 public void actionPerformed (ActionEvent e) {
				 	GraphicInterfaceSettings.onExecution(listOfAlgorithm.getSelectedValue(), tfImport.getText());
				 	dispose();
				 }
			});
		add(btnValidate);
		btnCancel = new JButton("Fermer");
		btnCancel.addActionListener(new ActionListener() {
			 public void actionPerformed (ActionEvent e) {
				  System.exit(0);
				 }
			});
		add(btnCancel);
		
		this.setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public static void onExecution(String algo, String fileName) {
		switch(algo) {
	 	case "J48":
	 		try {
				AlgoJ48 algorithmJ48 = new AlgoJ48(fileName);
				results = algorithmJ48.evaluation();
				//System.out.println(results.toString());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	 		break;
	 	/*case "Boosting":
	 		try {
				Boosting algorithmBoosting = new Boosting(filename);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	 		break;
	 	case "k-NN":
	 		try {
				kNN algorithmkNN = new kNN(filename);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	 		break;
	 	case "RandomForest":
	 		try {
				RandomForest algorithmRandomForest = new RandomForest(filename);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	 		break;*/
	 	}
	 	new GraphicInterfaceResult(results, fileName);
	}
	
	

}
