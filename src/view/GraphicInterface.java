package view;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class GraphicInterface extends Frame{

	private static final long serialVersionUID = 1L;
	private Label lblImport ;
	private TextField tfImport;
	private Label lblList ;
	private List listOfAlgorithm;
	private Button btnValidate;
	private Button btnCancel;
	
	public GraphicInterface() {
		
		setTitle("Algorithme de Recherche Weka");
		setSize(500,150);
		setLayout(new GridLayout(3,2,3,3));
		lblImport = new Label("Fichier à importer : ");
		add(lblImport);
		
		tfImport = new TextField(); 
		tfImport.setEditable(true);
		add(tfImport);
		
		lblList = new Label("Liste d'Algorithmes : ");
		add(lblList);
		listOfAlgorithm = new List();
		listOfAlgorithm.add("J48");
		listOfAlgorithm.add("k-NN");
		listOfAlgorithm.add("Boosting");
		listOfAlgorithm.add("Random Forest");
		add(listOfAlgorithm);
		btnValidate = new Button("Exécuter");
		btnValidate.addActionListener(new ActionListener() {
			 public void actionPerformed (ActionEvent e) {
				  // 
				 }
			});
		add(btnValidate);
		btnCancel = new Button("Fermer");
		btnCancel.addActionListener(new ActionListener() {
			 public void actionPerformed (ActionEvent e) {
				  //dispose();
				  System.exit(0);
				 }
			});
		add(btnCancel);
		
		setVisible(true);
		
	}
	
	

}
