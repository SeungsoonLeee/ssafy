package chapter10;

import java.io.FileOutputStream;
import java.io.IOException;

public class KeyboardIOTest {
	public static void main(String[] args) throws IOException {
		int read;
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream("res/keyboard1.txt");
			do {
				read = System.in.read();
				fos.write(read);
				if (read != '\n' && read != '\r')
					System.out.println((char) read);
			} while (read != 'x' && read != -1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
}
