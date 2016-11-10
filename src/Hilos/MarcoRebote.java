package Hilos;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MarcoRebote extends JFrame {

	public static int x = 0;
	public static int y = 0;
	private LaminaPelota lamina;
	Thread t1,t2,t3;
	JButton pelota1,pelota2,pelota3,detener1,detener2,detener3;
	
	
	//creamos el marco donde meteremos los botones y la pelota
	
	public MarcoRebote(){
		
		setBounds(500,300,900,400);
		
		setTitle ("Pelota");
		
		lamina=new LaminaPelota();
		
		add(lamina, BorderLayout.CENTER);
		
		JPanel laminaBotones=new JPanel();
		
		pelota1=new JButton("hilo1");
		pelota1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comienza_el_juego(e);	
			}
		});
		laminaBotones.add(pelota1);
		
		
		
		
		pelota2=new JButton("hilo2");
		pelota2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comienza_el_juego(e);	
			}
		});
		laminaBotones.add(pelota2);
		
		
		
		pelota3=new JButton("hilo3");
		pelota3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comienza_el_juego(e);	
			}
		});
		laminaBotones.add(pelota3);
		
		
		
		detener1=new JButton("detener1");
		detener1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				detener(e);	
			}
		});
		laminaBotones.add(detener1);
		
		
		detener2=new JButton("detener2");
		detener2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				detener(e);	
			}
		});
		laminaBotones.add(detener2);
		
		
		detener3=new JButton("detener3");
		detener3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				detener(e);	
			}
		});
		laminaBotones.add(detener3);
		

		add(laminaBotones, BorderLayout.SOUTH);
	}

	//Añade pelota
	
	public void comienza_el_juego (ActionEvent e){
		
		Pelota pelota=new Pelota();
		lamina.add(pelota);
		Runnable r = new PelotaHilos(pelota, lamina);
		
		Thread hilo = new Thread(r);
		if(e.getSource().equals(pelota1)){
			t1=new Thread(r);
			t1.start();
			
		}else if(e.getSource().equals(pelota2)){
			t2=new Thread(r);
			t2.start();
		}else if(e.getSource().equals(pelota3)){
			t3=new Thread(r);
			t3.start();
					
		}
		
	
}
	//Detiene la pelota
	public void detener(ActionEvent e){
		if(e.getSource().equals(detener1)){
			
			t1.interrupt();
			
		}else if (e.getSource().equals(detener2)){
			
			t2.interrupt();
		}else if (e.getSource().equals(detener3)){
			
			t3.interrupt();
		}
	}
	
}
