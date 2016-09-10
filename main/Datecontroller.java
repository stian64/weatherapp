package main;

import gui.ResultWindow;
import xml.Xmlreader;

public class Datecontroller extends Thread {

	private String update, todaysdate, selectedvalue;
	private int selectedid;
    private ResultWindow resultwindow;
    private Data data;

	public Datecontroller(int selectedindex,String selectedvalue, ResultWindow resultat){
		selectedid = selectedindex;
		resultwindow = resultat;
		
		DataInstance instance = new DataInstance();
		data = instance.getdata();
	}

	public void run() {
		
		DataInstance instance = new DataInstance();
		data = instance.getdata();
		
		while (!Thread.currentThread().isInterrupted()) {

			// Finner dagens dato og formaterer det p� samme m�te som yr.no

			Format DatoFormat = new Format();
            
			 todaysdate = DatoFormat.yrdatoformatering();

			for (;;) {

				try {
					
					update = data.getUpdateTime();
					
					if (todaysdate.compareTo(update) == 0 || todaysdate.compareTo(update) > 0) {
						new Xmlreader(selectedid);
		                resultwindow.update();
		                resultwindow.revalidate();

					}
					
					Thread.sleep(1 * 300000);

				}

				catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		}
	}

}
