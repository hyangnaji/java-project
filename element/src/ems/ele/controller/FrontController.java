package ems.ele.controller;

import java.util.Scanner;

import ems.ele.action.Action;

public class FrontController {
	public void processRequest(Action action, Scanner sc) {
		try {
			action.execute(sc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
