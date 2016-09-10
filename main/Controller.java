package main;

import xml.Xmlreader;
import gui.ResultWindow;

public class Controller {

	private Data data;
	private int selectedid;
	private String selectedval;
	private ResultWindow result;
	private boolean window;
	private WindowInstance windowinstance;

	public Controller(int selectedindex, String selectedvalue) {

		selectedid = selectedindex;
		selectedval = selectedvalue;
		DataInstance instance = new DataInstance();
		data = instance.getdata();
		data.Removedata();
		new Xmlreader(selectedindex);
		WindowInstance windowinstance = new WindowInstance();
		ResultWindow resultwindow = windowinstance.getWindow();
		result = resultwindow;
		window = data.checkWindow();

		if (window == false) {
			newwindow();
			data.setWindow();
		}

		else {

			changeContent();

		}

		thread();

	}

	public void newwindow() {

		result.setSize(445, 550);
		result.setLocationRelativeTo(null);
		result.setVisible(true);
		result.update();
		result.validate();
		result.repaint();

	}

	public void changeContent() {

		result.update();
		result.revalidate();

	}

	public void thread() {

		Thread Gettime = new Datecontroller(selectedid, selectedval, result);
		Gettime.start();

	}
}
