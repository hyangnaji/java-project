package ems.ele.svc;

import ems.ele.dao.ElementDAO;
import ems.ele.dto.Element;

public class NumService {

	public Element found(int num) {		//있는지 확인
		Element ele = null;
		
		ElementDAO dao = new ElementDAO();
		ele = dao.num(num);
		
		return ele;
	}
	
	

}
