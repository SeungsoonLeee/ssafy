package chapter10;
/**
 *  Reader/Writer
 *   - 문자 전용 입출력 API
 *   - 문자가 아닌 데이터를 입출력하면 데이터가 송산됨
 *     ex) 이미지 데이터
 */
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyTest3 {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
//		String readFile = "src/chapter10/FileCopyTest.java";
//		String writeFile = "res/copy.txt";
		String readFile = "c:/ssafy/eclipse-jee-photon-R-win32-x86_64.zip";
		String writeFile = "res/copy3.zip";

		try {
			fr = new FileReader(readFile);
			fw = new FileWriter(writeFile);
			int read;
			char[] buf = new char[1024];
			while ((read = fr.read(buf)) != -1) {
				fw.write(buf, 0, read);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("main end");
	}
}
