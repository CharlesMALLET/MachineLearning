package creationGraph;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;



public class CreateGraph {
	
	public void createInstances() throws Exception {
		DataSource source = new DataSource("/some/where/data.arff");
		Instances data = source.getDataSet();
		// setting class attribute if the data format does not provide this information
		// For example, the XRFF format saves the class attribute information as well
		if (data.classIndex() == -1)
		  data.setClassIndex(data.numAttributes() - 1);
		}
}