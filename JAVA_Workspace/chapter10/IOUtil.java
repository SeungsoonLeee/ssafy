package chapter10;

import java.io.Closeable;

public class IOUtil {
	public static void close(Closeable c) {
		if (c != null) {
			try {
				c.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
