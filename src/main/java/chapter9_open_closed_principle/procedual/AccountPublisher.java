package chapter9_open_closed_principle.procedual;

import java.util.ArrayList;
import java.util.List;

import chapter9_open_closed_principle.ContractIdGenerater;
import chapter9_open_closed_principle.DbGateway;



class AccountPublisher {
	private DbGateway dbGateway;
	
	List<String> publish(){
		List<Account> allAcount = dbGateway.findAllAccount();
		List<String> result = new ArrayList<String>();
		for (Account account : allAcount) {
			result.add(account.getId() + "," + account.getName() + "," + "normalAccount");
		}
		return result;
	}
}