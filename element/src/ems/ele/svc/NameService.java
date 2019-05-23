package ems.ele.svc;

import ems.ele.dao.ElementDAO;
import ems.ele.dto.Element;

public class NameService {

	public Element found(String name) {
		Element ele = null;
		
		ElementDAO dao = new ElementDAO();
		ele = dao.name(name);
		return ele;
	}

}
