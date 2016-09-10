package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import main.Data;
import main.Format;
import main.DataInstance;
import maps.Map;

public class ResultWindow extends JDialog {

	private String city;
	private List<String> temp;
	private List<String> date;
	private List<String> imageId;
	private JPanel content;
	private String timeperiod, timeperiod2, timeperiod3, timeperiod4,timeperiod5;
	private Data datain;

	public ResultWindow() {

		DataInstance instance = new DataInstance();
		datain = instance.getdata();

		content = new JPanel();
		gatherdata();
		addcontent();
	}
	
	protected void processWindowEvent(WindowEvent e) {
	    if(e.getID() == WindowEvent.WINDOW_CLOSING) {
	     datain.closeWindow();
	     dispose();
	     
	     
	    }
	}

	public void gatherdata() {

		city = datain.getCity();
		temp = datain.getTemp();
		date = datain.getDate();
		imageId = datain.getImageId();

	}

	public void addcontent() {

		content.setLayout(new BorderLayout());
		content.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(content);

		// Setting up panels for all the directions

		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel(new GridLayout(2, 0));
		JPanel northPanel = new JPanel();
		JPanel eastPanel = new JPanel(new GridLayout(2, 0));
		JPanel westPanel = new JPanel();

		content.add(centerPanel, BorderLayout.CENTER);
		content.add(northPanel, BorderLayout.NORTH);
		content.add(southPanel, BorderLayout.SOUTH);
		content.add(eastPanel, BorderLayout.EAST);
		content.add(westPanel, BorderLayout.WEST);

		westPanel.setLayout(new GridLayout(4, 0));

		JLabel place = new JLabel(city);
		place.setFont(new Font("SansSerif", Font.PLAIN, 18));
		northPanel.add(place);

		JLabel bottomtext = new JLabel();
		goWebsite(bottomtext);
		southPanel.add(bottomtext);
	

		Format textFormat = new Format();
		timeperiod = textFormat.showtimeformat(date.get(0));
		timeperiod2 = textFormat.showtimeformat(date.get(1));
		timeperiod3 = textFormat.showtimeformat(date.get(2));
		timeperiod4 = textFormat.showtimeformat(date.get(3));
		timeperiod5 = textFormat.showtimeformat(date.get(4));

		try {
			Map map = new Map(city);
			map.getStaticMapCords();
			URL link = new URL(map.getMapImage().toString());
			centerPanel.add(new JLabel(new ImageIcon(new ImageIcon(link)
					.getImage().getScaledInstance(200, 225,
							java.awt.Image.SCALE_SMOOTH))));

		} catch (Exception e) {

			e.printStackTrace();
		}

		JLabel timelabel = new JLabel("Tid  " + timeperiod);
		centerPanel.add(timelabel);
		timelabel.setFont(new Font("SansSerif", Font.BOLD, 16));

		// Adding the weather image
		ImageIcon icon = createImageIcon("../bilder/" + imageId.get(0) + ".png", "");
		JLabel imageLabel = new JLabel(icon);
		eastPanel.add(imageLabel);
		String var = tempColour(temp.get(0));

		JLabel temperatur = new JLabel(temp.get(0) + " c");
		eastPanel.add(temperatur);
		temperatur.setHorizontalAlignment(SwingConstants.CENTER);
		temperatur.setVerticalAlignment(SwingConstants.CENTER);

		temperatur.setFont(new Font("SansSerif", Font.PLAIN, 72));

		if (var.equalsIgnoreCase("1")) {
			temperatur.setForeground(Color.red);
		} else {
			temperatur.setForeground(Color.blue);
		}

		// Tidsperiode //temperatur
		JLabel timeperiodLabel = new JLabel(timeperiod2 + " " + temp.get(1)	+ "c");
		JLabel timePeriodLabel2 = new JLabel(timeperiod3 + "  " + temp.get(2) + "c");
		JLabel timeperiodLabel3 = new JLabel(timeperiod4 + "	 " + temp.get(3) + "c");
		JLabel timeperiodLabel4 = new JLabel(timeperiod5 + "  " + temp.get(4) + "c");
		
		centerPanel.add(timeperiodLabel);
		centerPanel.add(timePeriodLabel2);
		centerPanel.add(timeperiodLabel3);
		centerPanel.add(timeperiodLabel4);
		
		// borders
		centerPanel.setBorder(BorderFactory.createEtchedBorder(3, Color.cyan, Color.blue));
		temperatur.setBorder(BorderFactory.createRaisedBevelBorder());
		imageLabel.setBorder(BorderFactory.createRaisedBevelBorder());
		northPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		southPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		
		

	}
	
	
	public void update() {
		content.removeAll();
		gatherdata();
		addcontent();
		content.validate();
		content.repaint();
	}

	   private void goWebsite( JLabel website) {
		   
		   final String url = "www.yr.no";
		   String text= "«Værvarsel fra yr.no, levert av Meteorologisk institutt og NRK»";
		   
	        website.setText("<html><a href=\"\">"+text+"</a></html>");
	        website.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        website.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                    try {
	                            Desktop.getDesktop().browse(new URI(url));
	                    } catch (URISyntaxException | IOException ex) {
	                            //It looks like there's a problem
	                    }
	            }
	        });
	    }
	
	private String tempColour(String temp) {
		double temperature = 0;
		try {
			temperature = Double.parseDouble(temp);

		} catch (NumberFormatException e) {

			e.printStackTrace();
		}
		if (temperature >= 1) {
			return "1";
		} else {
			return "2";
		}
	}

	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("File not available: " + path);
			return null;
		}
	}

}
