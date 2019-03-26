package Algorithm;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class J48 {	
	private DataSource source ;
	
	public J48(String name) throws Exception {
		source = new DataSource(name);
		Instances data = source.getDataSet();
		// setting class attribute if the data format does not provide this information
		// For example, the XRFF format saves the class attribute information as well
		if (data.classIndex() == -1)
		  data.setClassIndex(data.numAttributes() - 1);
		}
}
