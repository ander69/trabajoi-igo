package Hilos;

import java.awt.Component;

import javax.swing.JFrame;


public class Hilos {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			JFrame marco=new MarcoRebote();
			
			marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			marco.setVisible(true);

		}

	}


class PelotaHilos implements Runnable{
	private Pelota pelota;
	private Component componente;
	public PelotaHilos(Pelota unaPelota, Component unComponente){
		pelota=unaPelota;
		componente=unComponente;
		
	}
	public void run(){

		
		while(!Thread.interrupted()){
			
			pelota.mueve_pelota(componente.getBounds());
			
			componente.paint(componente.getGraphics());
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				//e.printStackTrace();
			}
		}
		
	}
	
}



