package practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class fileService {
	public final String path = "E:\\핀테크_m\\test\\contents/";

	public fileService() {
	}

	public void listContents() {
		Scanner sc = new Scanner(System.in);
		System.out.println("[1] 글 목록보기");
		System.out.println("[2] 작성자별 글 보기");
		System.out.println("[3] 모든 글 보기");
		int choice = sc.nextInt();
		if (choice == 1) {
			list();
		} else if (choice == 2) {
			System.out.print("작성자 입력: ");
			String writer = sc.next();
			writerView(writer + ".txt");
		} else {
			allContentsView();
		}
	}

	public void writeContents() {
		int number = 0;
		
		while(true) {
		Scanner sc = new Scanner(System.in);
		String writer, title, contents;
		System.out.print("작성자 : ");
		writer = sc.next();
		System.out.print("제목: ");
		title = sc.next();
		System.out.print("내용: ");
		contents = sc.next();

		fileDto dto = new fileDto();
		

		dto.setNumber(number++);
		dto.setWriter(writer);
		dto.setContents(contents);
		dto.setTitle(title);
		
		
		File filePath = new File(path + writer + ".txt");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(filePath);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			oos.writeObject(dto);
			System.out.println("글 저장 완료");
			break;

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
				if (bos != null) {
					bos.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e2) {

			}
		}
	}
	}
	public String[] list() {
		File file = new File(path);
		String[] fileName = file.list();
		for (String fn : fileName) {
			String[] s = fn.split("\\.");
			System.out.println(s[0]);
		}
		return fileName;
	}

	public void writerView(String writer) {

		File file = new File(path + writer);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			fileDto dto = (fileDto) ois.readObject();

			ois.close();
			bis.close();
			fis.close();

			System.out.println("############################");
			System.out.println("글번호: " + dto.getNumber());
			System.out.println("작성자: " + dto.getWriter());
			System.out.println("제 목: " + dto.getTitle());
			System.out.println("내 용: " + dto.getContents());
			System.out.println("############################");

		} catch (Exception e) {
			System.out.println("해당하는 작성자의 글이 존재하지 않습니다.");
		}

	}

	public void allContentsView() {
		String[] fileNames = list();

		ArrayList<fileDto> fd = new ArrayList<>();

		for (String writer : fileNames) {
			File file = new File(path + writer);

			FileInputStream fis = null;
			BufferedInputStream bis = null;
			ObjectInputStream ois = null;
			try {

				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				ois = new ObjectInputStream(bis);

				fileDto dto = (fileDto) ois.readObject();
				fd.add(dto);

				ois.close();
				bis.close();
				fis.close();
			} catch (Exception e) {
				System.out.println("해당 사용자는 존재하지 않습니다.");
			}
		}
		System.out.println("====================================");
		System.out.println("번호\t작성자\t제목\t글");
		System.out.println("====================================");
		for (fileDto d : fd) {
			System.out.print(d.getNumber() + "\t");
			System.out.print(d.getWriter() + "\t");
			System.out.print(d.getTitle() + "\t");
			System.out.println(d.getContents() + "\t");
			System.out.println("----------------------------------");
		}
	}

}
