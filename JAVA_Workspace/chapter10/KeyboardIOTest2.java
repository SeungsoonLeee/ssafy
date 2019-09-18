package chapter10;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardIOTest2 {
	public static void main(String[] args) throws IOException {
		FileWriter fw = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			fw = new FileWriter("./res/keyboard2.txt");

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				fw.write(line + "\r\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(fw);
			IOUtil.close(br);
			IOUtil.close(isr);
		}
	}
}
