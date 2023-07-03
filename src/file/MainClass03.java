package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainClass03 {
	public static void main(String[] args) throws Exception {
		File path = new File("E:\\핀테크_m\\test\\test.txt");
		// true :  파일이 없으면 새롭게 만들고, 있으면 기존파일 내용 뒤에 이어써준다.
		FileOutputStream fos = new FileOutputStream(path);
		fos.write("test".getBytes());
		fos.close();
		
		/* 가져오기 */
		FileInputStream fis = new FileInputStream(path);
//		System.out.println((char)fis.read());
//		System.out.println((char)fis.read());
//		System.out.println(fis.readAllBytes()); // 바이트배열형식으로 받아온다.
		
		while(true) {
			int res = fis.read();
			if(res<0) {
				// 파일끝에 -1값이 자동으로 추가가되기때문에 res 가 -1이면 빠져나오겠다.
				System.out.println("\n내용이 없습니다. :" +res);
				break;
			}
			System.out.print((char)res);
		
		}
		fis.close();
		
	}
}
