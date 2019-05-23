package ems.ele.svc;

import java.util.ArrayList;

import ems.ele.dao.ElementDAO;
import ems.ele.dto.Element;

public class ViewService {

	public void view() {
		ElementDAO dao = new ElementDAO();
		
		ArrayList<Element> ele = new ArrayList<Element>();
		ele = dao.view();
		
		for(int i =0; i<ele.size(); i++) {
			System.out.println(ele.get(i).toString());
		}
	
	}

}
