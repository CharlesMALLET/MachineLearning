package importExport;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class ExportIntoCSV {
	
	private String nameFile;
	
	public ExportIntoCSV(String nameFile) throws FileNotFoundException, UnsupportedEncodingException {
		this.nameFile = nameFile;
		PrintWriter writer = new PrintWriter(this.nameFile, "UTF-8");
		//writer.println("The first line");
		//writer.println("The second line");
		writer.close();	}

}
