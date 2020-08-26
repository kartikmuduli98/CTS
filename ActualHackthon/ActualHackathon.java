package practical;
import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ActualHackathon {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr=new FileReader("D:\\Memory.txt");
		BufferedReader br =new BufferedReader(fr);
		JSONObject values=new JSONObject();
		JSONObject finalvalues=new JSONObject();
		JSONArray finalArray=new JSONArray();
		String[] record;
		String str=" ";
		int i=0,count=1;
		double sum=0;
		double max=0;
		while((br.readLine())!=null) {
			if(i%2==0) {
				str=br.readLine();
				record=str.split("\\s+");
				Double x=(Double.parseDouble(record[2])/1024);
				if(x>max) {
					max=x;
				}
				sum=sum+x;
				String seconds = count+"s";
				values.put(seconds,String.format("%.2f",x));
				count++;
			}
		}
		double avg=sum/count;
		finalvalues.put("AverageMemory(MB)",(String.format("%.2f", avg)));
		finalvalues.put("values",values);
		finalvalues.put("MaxMemory(MB)",(String.format("%.2f", max)));
		finalvalues.put("Usecasename","Homepage");
		
		finalArray.add(finalvalues);
		System.out.println(finalArray);
		FileWriter fw=new FileWriter("D:\\output1.json");
		fw.write(finalArray.toJSONString());
		fw.close();
		
		
		
	}

}
