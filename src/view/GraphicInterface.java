package view;

import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;

public class GraphicInterface extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Label lblImport ;
	private TextField tfImport;
	private List listOfAlgorithm;
	private Button btnValidate;
	private Button btnCancel;
	//private FlowLayout flwLayout;
	
	public GraphicInterface() {
		//Container cter = new Container();
		
		setTitle("Algorithme de Recherche Weka");
		setSize(500,150);
		//flwLayout = new FlowLayout();
		setLayout(new GridLayout(2,3,3,3));
		lblImport = new Label("Fichier à importer : ");
		add(lblImport);
		
		tfImport = new TextField(); // à modifier
		tfImport.setEditable(true);
		add(tfImport);
		
		listOfAlgorithm = new List();
		add(listOfAlgorithm);
		btnValidate = new Button("Exécuter");
		add(btnValidate);
		btnCancel = new Button("Fermer");
		add(btnCancel);
		
		setVisible(true);
		
	}

}
