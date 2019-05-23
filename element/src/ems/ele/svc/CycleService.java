package ems.ele.svc;

import java.util.List;

import ems.ele.dao.ElementDAO;
import ems.ele.dto.Element;

public class CycleService {

	public List<Element> found(int cycle) {
		List<Element> ele = null;
		
		ElementDAO dao = new ElementDAO();
		ele = dao.cycle(cycle);
		
		
		return ele;
	}


}
