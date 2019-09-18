package chapter10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ObjectOutputStream
 *  Serializable 인터페이스를 구현한 클래스의 객체를 직렬화하여 출력
 *  단, static와 transient로 선언된 속성은 출력하지 않는다.
 *  Serializable 미구현시 에러 발생
 *  - 직렬화 : 객체의 정보(클래스명, 속성타입, 속성이름, 속성 값)를 Byte 배열로 만듦
 * 
 * ObjectInputStream
 *  Byte 배열을 읽어 객체로 복원
 * 	static으로 선언된 속성은 객체를 복원하는 JVM에 설정된 static 값으로 복원
 * 	transient으로 선언된 속성은 기본값으로 복원
 */
public class ObjectIOTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		String file = "object.txt";

		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			// Employee에 Serializable을 구현하지 않으면 NotSerializableException 발생
			oos.writeObject(new Employee("1", "ssafy", 10000000));
			
			Employee.empno = "10";
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			System.out.println(ois.readObject());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(ois);
			IOUtil.close(fis);
			IOUtil.close(oos);
			IOUtil.close(fos);
		}
	}
}
