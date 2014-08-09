package chapter9_open_closed_principle.oop;

public class SpecalAccount extends Account{

	public SpecalAccount(Integer id, String name) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTypeStr() {
		return "special";
	}
}