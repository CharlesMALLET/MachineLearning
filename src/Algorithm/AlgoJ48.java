package Algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class AlgoJ48 {	
	private DataSource source ;
	
	public AlgoJ48(String name) throws Exception {
		source = new DataSource(name);
	}
	
	public Map<Integer, Double> evaluation() {
		Map<Integer, Double> results = new HashMap<Integer, Double>();
		try {
			Instances data = this.source.getDataSet();
			if (data.classIndex() == -1) {
				data.setClassIndex(data.numAttributes() - 1);
			}
			
			int n = data.size();
			int limite = (int) (n * 0.1);
			int pas = limite / 10;
			
			J48 tree = new J48();
			for (int i = 2 ; i < n*0.1 ; i = i + pas) {
				tree.setMinNumObj(i);
				Evaluation eval = new Evaluation(data);
				eval.crossValidateModel(tree, data, 5, new Random());
				double err = eval.errorRate();
				results.put(i, err);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}
}
