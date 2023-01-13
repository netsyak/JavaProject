package dao;

public class DentalMemberVo {
	private String id;
	private String pwd;
	private String name;
	private String birth;
	private String tel;
	private String address;

	public DentalMemberVo(String id, String pwd, String name, String birth, String tel, String address) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birth = birth;
		this.tel = tel;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "DentalMemberVo [id=" + id + ", pwd=" + pwd + ", name=" + name + ", birth=" + birth + ",  tel=" + tel
				+ ", address=" + address + " + ]";
	}
}