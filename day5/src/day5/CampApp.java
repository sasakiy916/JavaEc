package day5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CampApp {
	public static void main(String[] args)throws Exception {
		FileInputStream fis = new FileInputStream("data.csv");
		InputStreamReader isr = new InputStreamReader(fis,"utf-8");
		BufferedReader br = new BufferedReader(isr);
		Map<String,Integer> names = new HashMap<>();
		Map<String,Integer> items = new HashMap<>();

		int total = 0;
		System.out.println("csvデータ");
		System.out.println("------------------");
		String line;
		while((line = br.readLine()) != null) {
			System.out.println(line);
			String[] data = line.split(",");
			String name = data[0];
			String item = data[1];
			int price = Integer.parseInt(data[2]);
			total += price;
			if(names.containsKey(name)) {
				names.put(name, names.get(name)+price);
			}else {
				names.put(name, price);
			}
			if(items.containsKey(item)) {
				items.put(item, items.get(item)+price);
			}else {
				items.put(item, price);
			}
		}
		br.close();
		System.out.println("\nキャンプ会計");
		System.out.println("------------------");
		for(String item:items.keySet()) {
			System.out.println(item + ":" + items.get(item));
		}
		int perYen = total/names.size();
		System.out.println("\n個人別会計(１人あたり:"+perYen+"円)");
		for(String name:names.keySet()) {
			System.out.printf("%s:%s%d%n",name,names.get(name) < perYen?"-":"+",Math.abs(names.get(name) - perYen));
		}
	}
}
