package file;

import java.io.File;
import java.io.FileOutputStream;

/*
 	file Input Out
 	- 파일에 특정 데이터를 저장하고 불러오는 것
  	- 영구적으로 데이터를 사용할수 있다.
 */
public class MainClass01 {
	public static void main(String[] args) throws Exception {
		// File : 특정 경로를 설정하는 역할
		File path = new File("E:\\핀테크_m\\test\\test.txt"); // 위치지정
		/*
		 FileOutputStream
		 - 해당 파일과 연결을 시켜주고, 해당 파일이 존재하지 않으면 새롭게 만들어준다.
		 - 만약 해당하는 파일이 존재하면 기존 파일은 삭제하고 새롭게 만든다.
		*/
		FileOutputStream fos = new FileOutputStream(path); // fos객체를 통해 자바 - 파일 연결
		fos.write(97);
		fos.write('A');
		fos.write("test".getBytes());	

	}
}
