package chapter11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SimpleClient2 {
	public static void main(String[] args) {
		Socket s = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		ObjectOutputStream oos = null;
		try {
			s = new Socket("70.12.108.80", 5432);
//			dis = new DataInputStream(s.getInputStream());
//			dos = new DataOutputStream(s.getOutputStream());
			oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(new Employee("1234-56", "홍길동", 2100000000));
			oos.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(dis);
			IOUtil.close(dos);
			IOUtil.close(oos);
			IOUtil.close(s);
		}
	}
}
