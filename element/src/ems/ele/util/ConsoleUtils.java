package ems.ele.util;

import java.util.Scanner;

public class ConsoleUtils {
	//���θ޴�
	public static void menu() {
		System.out.println("------------< Menu >------------");
		System.out.println("1. ���ڹ�ȣ�� ã��");
		System.out.println("2. ���ұ�ȣ�� ã��");
		System.out.println("3. �����̸����� ã��");
		System.out.println("4. �ֱ�� ã��(0~7)");
		System.out.println("5. ������ ã��(1~18)");
		System.out.println("6. ��ü����");
		System.out.println("7. ���α׷� ����");
		System.out.println("---------------------------------");		
	}
	
	//ã�� �޴�, num
	public int found_num(Scanner sc) {
		boolean flag = false;
		int num = 0;
		while(!flag) {
			System.out.println("---------------------------------");
			System.out.print("ã���ô� ���� ��ȣ�� �Է��ϼ���.> ");
			num = Integer.parseInt(sc.nextLine());
			
			if(1<=num&&num<=118) {
				flag = true; 
			}else {
				System.out.println("1~118 ������ ���� �Է����ּ���.");
			}
		}
		return num;
		
	}
	
	//ã�� �޴�, symbol
		public String found_symbol(Scanner sc) {
			System.out.println("---------------------------------");
			System.out.print("ã���ô� ���� ��ȣ�� �Է��ϼ���.> ");
			String symbol = sc.nextLine();
			
			return symbol;
		}
	
	//ã�� �޴�, name
		public String found_name(Scanner sc) {
			System.out.println("---------------------------------");
			System.out.print("ã���ô� ���� �̸��� �Է��ϼ���.> ");
			String name = sc.nextLine();
			
			return name;
		}	
		
	//ã�� �޴�, cycle
		public int found_cycle(Scanner sc) {
			boolean flag = false;
			int cycle = 0;
			while(!flag) {
				System.out.println("---------------------------------");
				System.out.print("ã���ô� �ֱ⸦ �Է��ϼ���.> ");
				cycle = Integer.parseInt(sc.nextLine());
				
				if(0<=cycle&&cycle<=7) {
					flag = true; 
				}else {
					System.out.println("0~7 ������ ���� �Է����ּ���.");
				}
			}
			return cycle;
		}
		
	//ã�� �޴�, cycle
		public int found_rower(Scanner sc) {
			boolean flag = false;
			int rower = 0;
			while(!flag) {
				System.out.println("---------------------------------");
				System.out.print("ã���ô� ���� �Է��ϼ���.> ");
				rower = Integer.parseInt(sc.nextLine());
				
				if(1<=rower&&rower<=18) {
					flag = true; 
				}else {
					System.out.println("1~18 ������ ���� �Է����ּ���.");
				}
			}
			return rower;
		}
}
