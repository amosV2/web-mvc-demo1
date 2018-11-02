package cn.demo.dto;

public class CustomerQueryReq {

	private String name;

	private String address;

	private String phone;

	public CustomerQueryReq(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "CustomerQueryReq{" +
				"name='" + name + '\'' +
				", address='" + address + '\'' +
				", phone='" + phone + '\'' +
				'}';
	}

	public String getName() {
		return "".equals(name) || name==null ? "%%":"%"+name+"%";
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return "".equals(address) || address==null ? "%%":"%"+address+"%";
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return "".equals(phone) || phone==null ? "%%":"%"+phone+"%";
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
