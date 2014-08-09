package chapter9_open_closed_principle.oop;


public abstract class Account {
	private Integer id;
	private String name;
	private Integer type;
	
	
	public Account create(Integer id, String name, Integer type) {
		switch (type) {
		case 1:
			return new SpecalAccount(id,name);
		default:
			return new NormalAccount(id,name);
		}
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	public abstract String getTypeStr();

}