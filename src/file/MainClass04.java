package file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class MainClass04 {
	public static void main(String[] args) throws Exception {
		File path = new File("E:\\핀테크_m\\test\\test.txt");
		FileOutputStream fos = new FileOutputStream(path);
		
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		// 기존스트림을 바탕으로 보조스트림을 만든다.
		for(char ch = '0';ch<='9';ch++) {
			Thread.sleep(1000);
//			fos.write(ch);
			bos.write(ch);
		}//buffer저장소에 들어간 내용을 보내주세요(한방에 보냄)
		bos.flush(); 
		bos.write('a');
		bos.flush();
		bos.write('b');
		bos.flush();
		bos.close();
	}
	
}
