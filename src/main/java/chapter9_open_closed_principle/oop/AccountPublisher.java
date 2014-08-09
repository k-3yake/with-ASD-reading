package chapter9_open_closed_principle.oop;

import java.util.ArrayList;
import java.util.List;

import chapter9_open_closed_principle.DbGateway;



class AccountPublisher {
	private DbGateway dbGateway;
	
	List<String> publish(){
		List<Account> allAcount = dbGateway.findAllAccountForOop();
		List<String> result = new ArrayList<String>();
		for (Account account : allAcount) {
			result.add(account.getId() + "," + account.getName() + "," + account.getTypeStr());
		}
		return result;
	}
}