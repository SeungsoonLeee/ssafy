package chapter10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		String readFile = "src/chapter10/FileCopyTest.java";
		String writeFile = "res/copy.txt";

		try {
			fis = new FileInputStream(readFile);
			// 출력 파일이 경로에 없으면 파일을 생성함
			fos = new FileOutputStream(writeFile);
			int read;

			// 파일을 읽지 못한경우
			// file : End Of File(EOF)
			// memory : End Of Memory(EOM)
			// network : 네트웤이 끊긴 경우 = Socket이 close된 경우
			// keyboard
			// - window : ctrl + z
			// - linux/unix : ctrl + c
			while ((read = fis.read()) != -1) {
				fos.write(read);
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
	}
}
