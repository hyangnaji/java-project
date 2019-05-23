package ems.ele.action;

import java.util.List;
import java.util.Scanner;

import ems.ele.dto.Element;
import ems.ele.svc.RowerService;
import ems.ele.util.ConsoleUtils;

public class RowerAction implements Action {
	public void execute(Scanner sc) throws Exception {
		ConsoleUtils cu = new ConsoleUtils();
		int rower = cu.found_rower(sc);			//�ش� ��ȣ�� �Ѱܹ���
		
		RowerService rowerservice = new RowerService();
		List<Element> ele = rowerservice.found(rower);		//�ش� ��ȣ�� �ִ��� Ȯ���ϴ� �۾�
		
		if(ele != null) {	//�ִٸ�
			for(int i =0; i<ele.size(); i++) {
				System.out.println(ele.get(i).toString());
			}
			
		}else System.out.println("ã���ô� �׸��� �����ϴ�.");		

	}

}
