package Hilos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Pelota {
	
	public static final int TAMX=15;
	
	public static final int TAMY=15;
	
	public double x=0;
	
	public double y=150;
	
	public double dx=1;
	
	public double dy=1;
	
	
		// Mueve la pelota invirtiendo posición si choca con límites

		public void mueve_pelota(Rectangle2D limites){
			
			x+=dx;
			
			y+=dy;
			
			if(x<limites.getMinX()){
				
				x=limites.getMinX();
				
				
				dx=-dx;
			}
			
			if(x + TAMX>=limites.getMaxX()){
				
				x=limites.getMaxX() - TAMX;
				
				dx=-dx;
				

			}
			
			if(y<limites.getMinY()){
				
				y=limites.getMinY();
				
				dy=-dy;
			}
			
			if(y + TAMY>=limites.getMaxY()){
				
				y=limites.getMaxY()-TAMY;
				
				dy=-dy;
				
			}
			
		}
		
		//Forma de la pelota en su posición inicial
		
		public Ellipse2D getBounds(){
			
			return new Ellipse2D.Double(x,y,TAMX,TAMY);
			
		}	
			
	}
class LaminaPelota extends JPanel {
	private ArrayList <Pelota> pelotas=new ArrayList<Pelota>();
	
	//Añadimos pelota a la lámina

	
	public void add(Pelota b){
		
		pelotas.add(b);
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		
		for(int i=0; i<pelotas.size(); i++) {
			Pelota b = pelotas.get(i);
			g2.fill(b.getBounds());
		}
		
	}

	
}


