package chapter11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer2 {
	public static void main(String[] args) {
		ServerSocket ss = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;

		try {
			ss = new ServerSocket(5432);
			System.out.println("Server2 Start...");

			while (true) {
				Socket s = ss.accept();
				String fileName = s.getInetAddress().toString() + "Object.txt";
				System.out.println("클라이언트 [" + s.getInetAddress() + "] 접속");

				FileOutputStream fos = null;
				ObjectOutputStream oos = null;
				ObjectInputStream ois = null;

				try {
					ois = new ObjectInputStream(s.getInputStream());
					fos = new FileOutputStream(fileName);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(ois.readObject());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					IOUtil.close(oos);
					IOUtil.close(fos);
					IOUtil.close(ois);
					IOUtil.close(s);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(ss);
		}
	}
}
