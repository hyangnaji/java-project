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
		Element ele = symbolservice.found(symbol);		//해당 번호가 있는지 확인하는 작업
		
		if(ele != null) {	//있다면
			System.out.println(ele.toString());
		}else System.out.println("찾으시는 항목이 없습니다.");		
		
		

	}

}
