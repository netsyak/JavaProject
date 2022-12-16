package javapro;

public class MemberVo {
	private String id; // 수정
	private String password; // 수정
//	private int sal;

	public MemberVo(String id, String password) {
		this.id = id;
		this.password = password;
//		this.sal = sal;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

//	public int getSal() {
//		return sal;

}
