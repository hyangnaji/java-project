package ems.ele.action;

import java.util.List;
import java.util.Scanner;

import ems.ele.dto.Element;
import ems.ele.svc.SymbolService;
import ems.ele.util.ConsoleUtils;

public class SymbolAction implements Action {
	public void execute(Scanner sc) throws Exception {
		ConsoleUtils cu = new ConsoleUtils();
		String symbol = cu.found_symbol(sc);			
		
		SymbolService symbolservice = new SymbolService();
		Element ele = symbolservice.found(symbol);		//�ش� ��ȣ�� �ִ��� Ȯ���ϴ� �۾�
		
		if(ele != null) {	//�ִٸ�
			System.out.println(ele.toString());
		}else System.out.println("ã���ô� �׸��� �����ϴ�.");		
		
		

	}

}
