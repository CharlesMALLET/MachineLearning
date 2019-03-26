package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class GraphicInterfaceSettings extends JFrame{

	private static final long serialVersionUID = 8828797684183958811L;
	private JLabel lblImport ;
	private JTextField tfImport;
	private JLabel lblList ;
	private JList<String> listOfAlgorithm;
	private JButton btnValidate;
	private JButton btnCancel;
	private String [] donnees = {"J-48","k-NN","Boosting","Random Forest"};
	
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
				  new GraphicInterfaceResult();
				 }
			});
		add(btnValidate);
		btnCancel = new JButton("Fermer");
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
