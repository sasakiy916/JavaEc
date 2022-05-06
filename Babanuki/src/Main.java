import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		List<Tramp> tramps = new ArrayList<>();//山札用
		FileInputStream fis = new FileInputStream("tranp.csv");
		InputStreamReader isr = new InputStreamReader(fis,"utf-8");
		BufferedReader br = new BufferedReader(isr);
		String line;
		List<String[]> list = new ArrayList<>();
		while((line=br.readLine()) != null) {
			String[] lines = line.split(",");
			list.add(lines);
		}
		br.close();
	}

}
