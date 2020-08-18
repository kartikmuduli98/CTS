package practical;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class JSONExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JSONObject obj=new JSONObject();
		JSONObject obj2=new JSONObject();
		BufferedReader br=new BufferedReader(new FileReader("D:\\CPU.txt"));
		String str=" ";
		String[] record=null;
		double sum=0,max=0,avg;
		DecimalFormat dc=new DecimalFormat("#.00");
		List<Double> result = new ArrayList<>();
	
	
		while((str = br.readLine())!=null) {
			record = str.split(" ");
			//System.out.println(record[14]);
			result.add(Double.parseDouble(record[14]));
			
			
		}
		for(int j=0;j<result.size();j++) {
			sum=sum+result.get(j);
			}
		avg=Double.parseDouble(dc.format(sum/result.size()));
		max=Collections.max(result);
		
		for(int i=0;i<result.size();i++) {
			obj.put((i+1)+"s", result.get(i));
		}
		obj2.put("maxcpu",max);
		obj2.put("avgcpu",avg);
		
		JSONArray ar=new JSONArray();
		ar.add(obj);
		ar.add(obj2);
		
		
		
		FileWriter file=new FileWriter("D:\\output.json");
		file.write(ar.toJSONString());
		file.flush();
	}

}
