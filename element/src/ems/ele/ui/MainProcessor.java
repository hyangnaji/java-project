package ems.ele.ui;

import java.util.Scanner;

import ems.ele.action.Action;
import ems.ele.action.CycleAction;
import ems.ele.action.NameAction;
import ems.ele.action.NumAction;
import ems.ele.action.RowerAction;
import ems.ele.action.SymbolAction;
import ems.ele.action.ViewAction;
import ems.ele.controller.FrontController;
import ems.ele.dao.ElementDAO;
import ems.ele.util.ConsoleUtils;

public class MainProcessor {
	public static void main(String[] args) {
		ConsoleUtils cu = new ConsoleUtils();
		Scanner sc = new Scanner(System.in);
		ElementDAO dao = new ElementDAO();
		
		FrontController fc = new FrontController();
		
		boolean isStop = false;
		dao.deletedata();
		dao.makedata();
		
		System.out.println("** ���� ��ȣ ����  **");
		
		do {
			cu.menu();
			System.out.print("menu = ");
			int menu = Integer.parseInt(sc.nextLine());
			System.out.println("---------------------------------");
			
			Action action = null;
			
			switch(menu) {				
			case 1:	//���ڹ�ȣ�� ã��
				action = new NumAction();
				break;
			case 2:	//���ұ�ȣ�� ã��
				action = new SymbolAction();
				break;
			case 3:	//�����̸�����  ã��
				action = new NameAction();
				break;
			case 4:	//�ֱ�� ã��
				action = new CycleAction();
				break;
			case 5:	//������ ã��
				action = new RowerAction();
				break;
			case 6: //��ü����
				action = new ViewAction();
				break;
			case 7:
				isStop = true;
				break;
			default:
				System.out.println("�޴� �Է��� �߸��Ǿ����ϴ�.");
			}
			
			if(action != null) {
				fc.processRequest(action, sc);
				}	
						
		}while(!isStop);
		
		System.out.println("���α׷��� �����մϴ�.");
		

	}

}
