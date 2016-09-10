package main;

import gui.ResultWindow;

public class WindowInstance {

	private static ResultWindow result = new ResultWindow();

	
	public ResultWindow getWindow() {

		if (result == null) {
			result = new ResultWindow();
		}

		return result;

	}
}
