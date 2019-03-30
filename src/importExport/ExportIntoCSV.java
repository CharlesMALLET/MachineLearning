package importExport;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

public class ExportIntoCSV {
	
	private String nameFile;
	private Vector<String> headers;
	private Vector<Vector<Object>> donnees;
	
	public ExportIntoCSV(String nameFile, Vector<String> headers, Vector<Vector<Object>> donnees) throws FileNotFoundException, UnsupportedEncodingException {
		this.nameFile = "Resultat_"+nameFile+".csv";
		this.headers=headers;
		this.donnees = donnees;
		PrintWriter writer = new PrintWriter(this.nameFile, "UTF-8");
		for(int i = 0 ; i<headers.size()-1;++i)
		{
			writer.print(headers.get(i));
			writer.print(';');
		}
		writer.println(headers.get(headers.size()-1));
		
		for(int i = 0 ; i<donnees.size();++i)
		{
			writer.println(donnees.get(i).get(0)+";"+donnees.get(i).get(1));
		}
		writer.close();	}
}
