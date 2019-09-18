package chapter11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer1 {
	public static void main(String[] args) {
		ServerSocket ss = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;

		try {
			// 컴퓨터에 설정된 IP와 지정한 Port를 이용하여 서버를 구성
			ss = new ServerSocket(4321);
			System.out.println("Server Start...");
			while (true) {
				// sccept() 클라이언트가 접속할 때까지 대기
				Socket s = ss.accept();
				dos = new DataOutputStream(s.getOutputStream());
				dis = new DataInputStream(s.getInputStream());
				System.out.println("클라이언트 [" + s.getInetAddress() + "] 접속");
				String msg = dis.readUTF();
				System.out.println("전송받은 메세지 : " + msg);
				dos.writeUTF("Hello~ It's me~");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(dis);
			IOUtil.close(dos);
			IOUtil.close(ss);
		}
	}
}
