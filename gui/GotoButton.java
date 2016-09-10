package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GotoButton extends JPanel {
	
	public GotoButton() {
				
	}
	
	  public void paint(Graphics g) {  
		 super.paint(g);
	
		 int[]x={(int) 37.5,(int) 37.5,75};  
	      	 
	     int[]y={(int) 37.5,0,(int) 22.5};  
	       
	     g.setColor(new Color(23,201,10));  
	     g.fillPolygon(x,y,3);  
	   //  g.setColor(new Color(1,1,1));   
	     
	    }  
		 @Override
		   public Dimension getPreferredSize() {
		      if (isPreferredSizeSet()) {
		         return super.getPreferredSize();
		      }
		      return new Dimension(75, (int) 37.5);
		   }
	     
}
	