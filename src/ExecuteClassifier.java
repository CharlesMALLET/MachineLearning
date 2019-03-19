import java.io.File;
import java.io.IOException;

import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
public class ExecuteClassifier {

	public static void main(String[] args) {		 
		ArffLoader arff = new ArffLoader();
		File file = new File("../optdigits.arff");
		try {
			arff.setFile(file);
			Instances data = arff.getDataSet();
		    for(Instance inst : data){
		    	System.out.println("Instance:" + inst);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
