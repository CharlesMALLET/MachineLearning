package view;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GraphicInterfaceResult extends Frame{

	private static final long serialVersionUID = -5677204364423194016L;
	
	private JButton buttonFermer;

	public GraphicInterfaceResult(){
		setTitle("Algorithme de Recherche Weka");
		setSize(500,150);
		setLayout(new GridLayout(3,2,3,3));
		
		setVisible(true);
	}
}
