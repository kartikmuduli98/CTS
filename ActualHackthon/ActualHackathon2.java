package practical;

import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ActualHackathon2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		FileReader fr=new FileReader("D:\\Battery.txt");
		BufferedReader br=new BufferedReader(fr);
		JSONObject obj=new JSONObject();
		JSONArray array=new JSONArray();
		String str=" ";
		String[] record1;
		String[] record2;
		while((str=br.readLine())!=null) {
			if(str.contains("Foreground activities:")) {
				record2=str.split("\\s+");
				String s=record2[3]+" "+record2[4]+" "+record2[5]+" "+record2[6]+" "+record2[7]+" "+record2[8];
				obj.put("Foreground_time",s);
			}
			if(str.contains("Uid u0a202:")) {
				record1=str.split("\\s+");
				double battdrain=Double.parseDouble(record1[3]);
				String battpercent=String.format("%.3f", battdrain/1000);
				obj.put("Battery_percentage",battpercent);
				obj.put("Battery_drain", battdrain);
			}
			
					
			
		}
		array.add(obj);
		System.out.println(array);
		FileWriter fw=new FileWriter("D:\\output2.json");
		fw.write(array.toJSONString());
		fw.close();
		


	}

}
