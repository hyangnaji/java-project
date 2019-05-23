package ems.ele.action;

import java.util.Scanner;

import ems.ele.dto.Element;
import ems.ele.svc.NameService;
import ems.ele.util.ConsoleUtils;

public class NameAction implements Action {
	public void execute(Scanner sc) throws Exception {
		ConsoleUtils cu = new ConsoleUtils();
		String name = cu.found_name(sc);			//�ش� ��ȣ�� �Ѱܹ���
		
		NameService nameservice = new NameService();
		Element ele = nameservice.found(name);		//�ش� ��ȣ�� �ִ��� Ȯ���ϴ� �۾�
		
		if(ele != null) {	//�ִٸ�
			System.out.println(ele.toString());
		}else System.out.println("ã���ô� �׸��� �����ϴ�.");		

	}

}
