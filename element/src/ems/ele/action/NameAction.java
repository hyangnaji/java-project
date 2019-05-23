package ems.ele.action;

import java.util.Scanner;

import ems.ele.dto.Element;
import ems.ele.svc.NameService;
import ems.ele.util.ConsoleUtils;

public class NameAction implements Action {
	public void execute(Scanner sc) throws Exception {
		ConsoleUtils cu = new ConsoleUtils();
		String name = cu.found_name(sc);			//해당 번호를 넘겨받음
		
		NameService nameservice = new NameService();
		Element ele = nameservice.found(name);		//해당 번호가 있는지 확인하는 작업
		
		if(ele != null) {	//있다면
			System.out.println(ele.toString());
		}else System.out.println("찾으시는 항목이 없습니다.");		

	}

}
