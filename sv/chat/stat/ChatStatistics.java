package sv.chat.stat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ChatStatistics {

	public static void main(String[] args) {
	
		try {
			int count=0;
			int lineCount=0;
			BufferedReader br = new BufferedReader(new FileReader("fullChat_Apr15_2014_2333.txt"));

			Map<String, Integer> messagePerHeadCount=new HashMap();
			String line = br.readLine();

			while (line != null) {
				lineCount++;

				System.out.println(line);
				if(line.indexOf(" - ")==13){
					count++;
					String date=line.substring(0, line.indexOf(" - "));
					String name =line.substring(16, line.indexOf(":", 16));

					if(messagePerHeadCount.containsKey(name)){
						messagePerHeadCount.put(name, (messagePerHeadCount.get(name)+1));
					}else{
						messagePerHeadCount.put(name, 0);
					}

					
				}else{

				}
				line = br.readLine();

			}

			System.out.println("====================================\n"+"Line Count:"+lineCount);
			System.out.println("====================================\n"+"Message Count:"+count);
			System.out.println("====================================\n");
		

			String entrySet=messagePerHeadCount.entrySet().toString();
			StringTokenizer tokenizer=new StringTokenizer(entrySet,",");

			while(tokenizer.hasMoreElements()){
				System.out.println(tokenizer.nextElement());
			}
			System.out.println("====================================\n");

			br.close();
		} catch(Exception e){
			e.printStackTrace();

		}


	}

}
