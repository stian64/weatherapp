package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import main.Controller;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


public class Yrgui extends JFrame implements MouseListener, ActionListener {

	private JPanel content;
	private JComboBox placeDropDown;
	private int selectedindex;
	private String selectedvalue;


	@SuppressWarnings("unchecked")
	public Yrgui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(240, 400);
		content = new JPanel();
		content.setLayout(new BorderLayout());
		content.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(content);
        content.setBorder(BorderFactory.createRaisedBevelBorder());
		
		JPanel eastPanel = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();
		JPanel westPanel = new JPanel();
		JPanel centerPanel = new JPanel();
				
		westPanel.setBorder(new EmptyBorder(0, 5, 0, 5));
		westPanel.setLayout(new GridLayout(3, 0, 0, 0));

		content.add(eastPanel, BorderLayout.EAST);
		content.add(northPanel, BorderLayout.NORTH);
		content.add(southPanel, BorderLayout.SOUTH);
		content.add(centerPanel, BorderLayout.CENTER);
		content.add(westPanel, BorderLayout.WEST);
				
		centerPanel.setLayout(new GridLayout(3, 3, 0, 15));
			
		//Labels
		JLabel headlinelabel = new JLabel("<html> Søk på ønsket stedsnavn i tekstfeltet<br><br>Klikk på den grønne knappen eller trykk enter for å se været!<br><br></html>");
		JLabel bottomlabel = new JLabel("«Værvarsel fra yr.no, levert av Meteorologisk institutt og NRK»");
		JLabel placeLbl = new JLabel("Sted");
		placeLbl.setToolTipText("Skriv inn stedsnavn eller by");
		
		
		//Dropdown Combobox
		this.placeDropDown = new JComboBox(new Object[] { "", "Bata",
				"Holmenkollen", "Antarktis", "Colombo", "Bygdøy", "Tokyo",
				"Vestre Aker","Eidsvoll","Bodø","Singapore","Kairo","Santo Domingo"});
		AutoCompleteDecorator.decorate(this.placeDropDown);
		placeDropDown.setEditable(true);
		placeDropDown.setSelectedIndex(0);
		placeDropDown.setToolTipText("Tast inn by eller sted her");
		
		placeDropDown.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					selectedindex = (int) placeDropDown.getSelectedIndex();
					selectedvalue = (String) placeDropDown.getSelectedItem();
					if (selectedindex != 0) {
						new Controller(selectedindex, selectedvalue);
					} else {
						JOptionPane.showMessageDialog(null,
								"Vennligst velg sted", "Ops",
								JOptionPane.WARNING_MESSAGE);
					}

				}
			}
		});
		
		placeDropDown.setBorder(BorderFactory.createEtchedBorder(3, Color.black, Color.black));
		
		
		
		//Adding things to panels
		westPanel.add(placeLbl);
		northPanel.add(headlinelabel);
		southPanel.add(bottomlabel);
		eastPanel.add(new GotoButton());
		eastPanel.addMouseListener(this);
		centerPanel.add(placeDropDown);
		eastPanel.setToolTipText("Klikk her etter å ha valgt noe i menyen");
		
		//Look and feel
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {

		}
		
	
	}

	
/////////////////////////////////////////////////////////////////////////
//          Mouse events                                               //
////////////////////////////////////////////////////////////////////////
	
	public void mouseClicked(MouseEvent e) {
		
		selectedindex = (int) placeDropDown.getSelectedIndex();
		selectedvalue = (String) placeDropDown.getSelectedItem();
		if(selectedindex != 0)
		{
		
	    new Controller(selectedindex,selectedvalue);
		
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Vennligst velg sted","Ops",JOptionPane.WARNING_MESSAGE);
		}
		
	}

	public void actionPerformed(ActionEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

}
