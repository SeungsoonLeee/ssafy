package chapter10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataIOTest {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;

		String file = "Data.txt";

		try {
			fos = new FileOutputStream(file);
			dos = new DataOutputStream(fos);

			dos.writeLong(256);
			dos.writeDouble(3.14);
			dos.writeUTF("헬로 월드");
			dos.writeBoolean(true);

			fis = new FileInputStream(file);
			dis = new DataInputStream(fis);
			System.out.println(dis.readLong());
			System.out.println(dis.readDouble());
			System.out.println(dis.readUTF());
			System.out.println(dis.readBoolean());

//			dis.readFully(b);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(dis);
			IOUtil.close(fis);
			IOUtil.close(dos);
			IOUtil.close(fos);
		}
	}
}
