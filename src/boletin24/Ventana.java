
package boletin24;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana implements ActionListener{
    JFrame marco;
    JPanel panel;
    JButton bDibujar,bLimpiar;
    JLabel circulo;
    JTextField numero;    
    boolean dibujar = false;
    
    public Ventana(){
        marco = new JFrame("Marco");
        panel = new JPanel();
        bDibujar = new JButton("Dibujar");
        bLimpiar = new JButton("Limpiar");
        circulo = new JLabel("Circulos: ");
        numero = new JTextField(8);
        marco.setSize(800, 400);
        panel.add(bDibujar);
        panel.add(bLimpiar);
        panel.add(circulo);
        panel.add(numero);
        marco.add(panel);
        bLimpiar.addActionListener(this);
        bDibujar.addActionListener(this);    
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setLocationRelativeTo(marco);
        marco.setVisible(true);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Graphics g = panel.getGraphics();
        Object boton = e.getSource();
        if(boton == bDibujar){
           g.setColor(Color.RED);
            int circulos = Integer.parseInt(numero.getText());
            for(int i=0;i<circulos;i++){
                int x = (int)(Math.random()*100)+60;
                int y = (int)(Math.random()*100)+80;
                g.drawOval(x, y, 200, 200);
            }
        }else if(boton == bLimpiar){
            panel.paint(g);
        }
    }
}
