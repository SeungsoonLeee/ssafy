package chapter11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {
	public static void main(String[] args) {
		Socket s = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			// loaclhost, 127.0.0.1 : 내부 네트워크 연결
			// 70.12.108.80
			s = new Socket("70.12.108.82", 4321);
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());

			Scanner sc = new Scanner(System.in);
			String myMsg = null;
			while (true) {
				myMsg = sc.next();
				dos.writeUTF(myMsg);
				dos.flush();
			}
//			System.out.println("전송받은 데이터 : " + dis.readUTF());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(dis);
			IOUtil.close(dos);
			IOUtil.close(s);
		}
	}
}
