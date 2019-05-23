package ems.ele.action;

import java.util.List;
import java.util.Scanner;

import ems.ele.dto.Element;
import ems.ele.svc.CycleService;
import ems.ele.util.ConsoleUtils;

public class CycleAction implements Action {
	public void execute(Scanner sc) throws Exception {
		ConsoleUtils cu = new ConsoleUtils();
		int cycle = cu.found_cycle(sc);			
		
		CycleService cycleservice = new CycleService();
		List<Element> ele = cycleservice.found(cycle);		//해당 번호가 있는지 확인하는 작업
		
		if(ele != null) {	//있다면
			for(int i =0; i<ele.size(); i++) {
				System.out.println(ele.get(i).toString());
			}
			
		}else System.out.println("찾으시는 항목이 없습니다.");		

	}

}
