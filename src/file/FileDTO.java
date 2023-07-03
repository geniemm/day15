package file;

import java.io.Serializable;

public class FileDTO implements Serializable{ 
	// serializable 을 상속받아야 직렬화를 해줌
	private String name,addr;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int agel) {
		this.age = agel;
	}
}
