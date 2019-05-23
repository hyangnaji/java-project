package ems.ele.action;

import java.util.Scanner;

import ems.ele.dto.Element;
import ems.ele.svc.NumService;
import ems.ele.util.ConsoleUtils;

public class NumAction implements Action {
	public void execute(Scanner sc) throws Exception {
		ConsoleUtils cu = new ConsoleUtils();
		int num = cu.found_num(sc);			//해당 번호를 넘겨받음
		
		NumService numservice = new NumService();
		Element ele = numservice.found(num);		//해당 번호가 있는지 확인하는 작업
		
		if(ele != null) {	//있다면
			System.out.println(ele.toString());
		}else System.out.println("찾으시는 항목이 없습니다.");		

	}

}
