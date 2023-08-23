package member.model;

import java.sql.Timestamp;

public class MemberDto {
	private String num;
	private String id;
	private String name;
	private String pass;
	private String hp;
	private String photo;
	private Timestamp gaip;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Timestamp getGaip() {
		return gaip;
	}
	public void setGaip(Timestamp gaip) {
		this.gaip = gaip;
	}
	
	
	
	
}
