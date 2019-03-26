package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GraphicInterfaceResult extends JFrame{

	private static final long serialVersionUID = -5677204364423194016L;
	
	private JButton buttonClose;
	private JTextField tfview;

	public GraphicInterfaceResult(){
		setTitle("Algorithme de Recherche Weka");
		setSize(500,500);
		setLayout(new GridLayout(2,1,3,3));
		
		tfview = new JTextField(); 
		tfview.setSize(400, 400);
		tfview.setEditable(false);
		tfview.setText("Test bidon");
		add(tfview);
		
		buttonClose = new JButton("Fermer");
		buttonClose.addActionListener(new ActionListener() {
			 public void actionPerformed (ActionEvent e) {
				  //dispose();
				  System.exit(0);
				 }
			});
		add(buttonClose);
		
		setVisible(true);
	}
}
