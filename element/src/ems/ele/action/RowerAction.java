package ems.ele.action;

import java.util.List;
import java.util.Scanner;

import ems.ele.dto.Element;
import ems.ele.svc.RowerService;
import ems.ele.util.ConsoleUtils;

public class RowerAction implements Action {
	public void execute(Scanner sc) throws Exception {
		ConsoleUtils cu = new ConsoleUtils();
		int rower = cu.found_rower(sc);			//해당 번호를 넘겨받음
		
		RowerService rowerservice = new RowerService();
		List<Element> ele = rowerservice.found(rower);		//해당 번호가 있는지 확인하는 작업
		
		if(ele != null) {	//있다면
			for(int i =0; i<ele.size(); i++) {
				System.out.println(ele.get(i).toString());
			}
			
		}else System.out.println("찾으시는 항목이 없습니다.");		

	}

}
