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
		
		System.out.println("** 원소 기호 사전  **");
		
		do {
			cu.menu();
			System.out.print("menu = ");
			int menu = Integer.parseInt(sc.nextLine());
			System.out.println("---------------------------------");
			
			Action action = null;
			
			switch(menu) {				
			case 1:	//원자번호로 찾기
				action = new NumAction();
				break;
			case 2:	//원소기호로 찾기
				action = new SymbolAction();
				break;
			case 3:	//원소이름으로  찾기
				action = new NameAction();
				break;
			case 4:	//주기로 찾기
				action = new CycleAction();
				break;
			case 5:	//족으로 찾기
				action = new RowerAction();
				break;
			case 6: //전체보기
				action = new ViewAction();
				break;
			case 7:
				isStop = true;
				break;
			default:
				System.out.println("메뉴 입력이 잘못되었습니다.");
			}
			
			if(action != null) {
				fc.processRequest(action, sc);
				}	
						
		}while(!isStop);
		
		System.out.println("프로그램을 종료합니다.");
		

	}

}
