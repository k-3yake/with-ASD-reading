package chapter9_open_closed_principle.oop;

public class NormalAccount extends Account{

	public NormalAccount(Integer id, String name) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTypeStr() {
		return "normal";
	}

}
