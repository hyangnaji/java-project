package ems.ele.action;

import java.util.Scanner;

import ems.ele.svc.ViewService;
import ems.ele.util.ConsoleUtils;

public class ViewAction implements Action {

	public void execute(Scanner sc) throws Exception {
		ConsoleUtils cu = new ConsoleUtils();
			
		ViewService viewservice = new ViewService();
		viewservice.view();		
		

	}

}
