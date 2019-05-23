package ems.ele.svc;

import java.util.List;

import ems.ele.dao.ElementDAO;
import ems.ele.dto.Element;

public class SymbolService {

	public Element found(String symbol) {
		Element ele = null;
		
		ElementDAO dao = new ElementDAO();
		ele = dao.symbol(symbol);
		
		
		return ele;

	}

}
