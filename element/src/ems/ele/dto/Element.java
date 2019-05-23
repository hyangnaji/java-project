package ems.ele.dto;

public class Element {
	
	private int num;			//원자번호
	private String symbol;		//원소기호
	private String name;		//원소이름
	private int cycle;			//주기
	private int rower;			//족
	

	public Element() {
		
	}
	
	public Element(int num, String symbol, String name, int cycle, int rower) {
		this.symbol = symbol;
		this.name = name;
		this.num = num;
		this.cycle = cycle;
		this.rower = rower;
	}
	

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getCycle() {
		return cycle;
	}

	public void setCycle(int cycle) {
		this.cycle = cycle;
	}

	public int getRower() {
		return rower;
	}

	public void setRower(int rower) {
		this.rower = rower;
	}


	public String toString() {
		return "[원자번호 = " + num + ", 원소기호 = " + symbol + ", 원소이름 = " + name + ", 주기 = " + cycle + ", 족 = " + rower
				+ "]";
	}
	
	
	
}
