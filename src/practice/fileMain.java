package practice;

import java.util.Scanner;

public class fileMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		fileService fs = new fileService();
		while(true) {
			System.out.println("[1]글목록 [2]글쓰기");
			System.out.print(">>> ");
			int choice = sc.nextInt();
			if(choice ==1){
				fs.listContents();
			}else if(choice ==2) {
				fs.writeContents();
			}else {
				System.out.println("잘못선택하셨습니다.");
			}
		}
	}
}
