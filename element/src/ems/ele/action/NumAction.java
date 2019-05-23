package ems.ele.action;

import java.util.Scanner;

import ems.ele.dto.Element;
import ems.ele.svc.NumService;
import ems.ele.util.ConsoleUtils;

public class NumAction implements Action {
	public void execute(Scanner sc) throws Exception {
		ConsoleUtils cu = new ConsoleUtils();
		int num = cu.found_num(sc);			//�ش� ��ȣ�� �Ѱܹ���
		
		NumService numservice = new NumService();
		Element ele = numservice.found(num);		//�ش� ��ȣ�� �ִ��� Ȯ���ϴ� �۾�
		
		if(ele != null) {	//�ִٸ�
			System.out.println(ele.toString());
		}else System.out.println("ã���ô� �׸��� �����ϴ�.");		

	}

}
