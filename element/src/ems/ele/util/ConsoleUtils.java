package ems.ele.util;

import java.util.Scanner;

public class ConsoleUtils {
	//메인메뉴
	public static void menu() {
		System.out.println("------------< Menu >------------");
		System.out.println("1. 원자번호로 찾기");
		System.out.println("2. 원소기호로 찾기");
		System.out.println("3. 원소이름으로 찾기");
		System.out.println("4. 주기로 찾기(0~7)");
		System.out.println("5. 족으로 찾기(1~18)");
		System.out.println("6. 전체보기");
		System.out.println("7. 프로그램 종료");
		System.out.println("---------------------------------");		
	}
	
	//찾기 메뉴, num
	public int found_num(Scanner sc) {
		boolean flag = false;
		int num = 0;
		while(!flag) {
			System.out.println("---------------------------------");
			System.out.print("찾으시는 원자 번호를 입력하세요.> ");
			num = Integer.parseInt(sc.nextLine());
			
			if(1<=num&&num<=118) {
				flag = true; 
			}else {
				System.out.println("1~118 사이의 값을 입력해주세요.");
			}
		}
		return num;
		
	}
	
	//찾기 메뉴, symbol
		public String found_symbol(Scanner sc) {
			System.out.println("---------------------------------");
			System.out.print("찾으시는 원소 기호를 입력하세요.> ");
			String symbol = sc.nextLine();
			
			return symbol;
		}
	
	//찾기 메뉴, name
		public String found_name(Scanner sc) {
			System.out.println("---------------------------------");
			System.out.print("찾으시는 원소 이름을 입력하세요.> ");
			String name = sc.nextLine();
			
			return name;
		}	
		
	//찾기 메뉴, cycle
		public int found_cycle(Scanner sc) {
			boolean flag = false;
			int cycle = 0;
			while(!flag) {
				System.out.println("---------------------------------");
				System.out.print("찾으시는 주기를 입력하세요.> ");
				cycle = Integer.parseInt(sc.nextLine());
				
				if(0<=cycle&&cycle<=7) {
					flag = true; 
				}else {
					System.out.println("0~7 사이의 값을 입력해주세요.");
				}
			}
			return cycle;
		}
		
	//찾기 메뉴, cycle
		public int found_rower(Scanner sc) {
			boolean flag = false;
			int rower = 0;
			while(!flag) {
				System.out.println("---------------------------------");
				System.out.print("찾으시는 족을 입력하세요.> ");
				rower = Integer.parseInt(sc.nextLine());
				
				if(1<=rower&&rower<=18) {
					flag = true; 
				}else {
					System.out.println("1~18 사이의 값을 입력해주세요.");
				}
			}
			return rower;
		}
}
