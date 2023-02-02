package dao;

public class MemberVo {
	private String id;
	private String password; // 수정
//	private String pwd;
	private String name;
	private String birth;
	private String tel;
	private String address;

//	public MemberVo(String id, String password) {
//	public MemberVo(String id, String pwd ) {
	public MemberVo(String id, String password, String name, String birth, String tel, String address) {
		this.id = id;
		this.password = password;
//		this.pwd = pwd;
		this.name = name;
		this.birth = birth;
		this.tel = tel;
		this.address = address;

	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return password;
//		return pwd;
	}

	public String getName() {
		return name;
	}

	public String getBirth() {
		return birth;
	}

	public String getTel() {
		return tel;
	}

	public String getAddress() {
		return address;
	}

}
