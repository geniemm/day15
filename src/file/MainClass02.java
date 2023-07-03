package file;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class MainClass02 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		// \\ > / 로 표현할수있음
		// File path = new File("E:/핀테크_m\\test/test.txt");
		// String 으로 path를 생성하면 path 도트연산자 + String의 기능이 가능하다. >> file이면 file기능이 생성

		/* File 기능 */
//		File path = new File("E:/핀테크_m\\test/test.txt");
//		System.out.println(path.exists());// 파일이 존재하면 true 없으면 false
//		path.mkdir(); // 해당하는 위치에 폴더생성
//		path.delete(); // 삭제
//		String [] list = path.list();
//		System.out.println(list[0]);

		/* 파일생성 */
		String path = "E:\\핀테크_m\\test\\";
		System.out.println("파일명 입력");
		String name = sc.next();
		path += name + ".txt";

		File filePath = new File(path);
		if (filePath.exists()) {
			System.out.println("파일이 존재합니다. 다시 ...");

		} else {
			FileOutputStream fos = new FileOutputStream(path);
			// 파일이없으면 생성 , 기존에 파일이있으면 파일을 파괴 > 새로생성
			System.out.println("파일에 출력할 내용 입력");
			String msg = sc.next();
			fos.write(msg.getBytes());
			System.out.println("저장 되었습니다.");
		}
	}
}
