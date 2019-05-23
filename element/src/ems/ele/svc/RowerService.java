package ems.ele.svc;

import java.util.List;

import ems.ele.dao.ElementDAO;
import ems.ele.dto.Element;

public class RowerService {

	public List<Element> found(int rower) {
		List<Element> ele = null;
		
		ElementDAO dao = new ElementDAO();
		ele = dao.rower(rower);
		
		return ele;
	}

}
