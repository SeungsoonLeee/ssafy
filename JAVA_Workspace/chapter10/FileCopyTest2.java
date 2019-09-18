package chapter10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest2 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
//		String readFile = "src/chapter10/FileCopyTest.java";
//		String writeFile = "res/copy.txt";
		String readFile = "c:/ssafy/eclipse-jee-photon-R-win32-x86_64.zip";
		String writeFile = "res/copy2.zip";

		try {
			fis = new FileInputStream(readFile);
			fos = new FileOutputStream(writeFile);
			int read;
			byte[] buf = new byte[1024];
			while ((read = fis.read(buf)) != -1) {
				fos.write(buf, 0, read);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("main end");
	}
}
