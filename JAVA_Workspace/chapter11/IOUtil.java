package chapter11;

import java.io.Closeable;
import java.net.ServerSocket;
import java.net.Socket;

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

	public static void close(Socket s) {
		if (s != null) {
			try {
				s.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ServerSocket ss) {
		if (ss != null) {
			try {
				ss.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
