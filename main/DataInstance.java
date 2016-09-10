package main;

public class DataInstance {

	private static Data data = new Data();

	public Data getdata() {
		
		if (data == null) {
			data = new Data();
		}

		return data;

	}

}
