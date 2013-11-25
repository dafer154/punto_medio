/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puntomedio.gui;

/**
 *
 * @author edwin
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class VentanaPanel extends JPanel {
    public final int PIXEL_SIZE = 1;
    public final int X_CENTRO = 400;
    public final int Y_CENTRO = 300;
    public final int X_MAX = 800;
    public final int Y_MAX = 600;
    
    ArrayList<int[]> puntos;
    
    public VentanaPanel(){
        super.setBackground(Color.WHITE);
    }
    
    public void setPixels(ArrayList<int[]> puntos){
        this.puntos = puntos;
        this.repaint();
    }
        
    @Override
    public void paintComponent (Graphics g) {        
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        g.drawLine(X_CENTRO, 0, X_CENTRO, Y_MAX);
        g.drawLine(0, Y_CENTRO, X_MAX, Y_CENTRO);
        for(int i=50; i<Y_CENTRO; i+=50){
            g.drawLine(X_CENTRO, i, X_CENTRO+8, i);
            g.drawString(String.valueOf(Y_CENTRO-i),X_CENTRO+10 , i+4);
        }
        for(int i=Y_CENTRO+50; i<Y_MAX; i+=50){
            g.drawLine(X_CENTRO, i, X_CENTRO+8, i);
            g.drawString(String.valueOf(Y_CENTRO-i),X_CENTRO+10 , i+4);
        }
        for(int i=50; i<X_CENTRO; i+=50){
            g.drawLine(i, Y_CENTRO, i, Y_CENTRO+8);
            g.drawString(String.valueOf(i-X_CENTRO), i-12, Y_CENTRO+20);
        }
        for(int i=X_CENTRO+50; i<X_MAX; i+=50){
            g.drawLine(i, Y_CENTRO, i, Y_CENTRO+8);
            g.drawString(String.valueOf(i-X_CENTRO), i-12, Y_CENTRO+20);
        }
        g.setColor(Color.BLACK);
        if(puntos != null){
           for(int i=0; i<puntos.size(); i++){
               /* Se suma 400 en x y se resta 300 en y para simular un sistema 
                * de coordenadas de 4 cuadrantes.
                */
               g.fillRect(puntos.get(i)[0]+X_CENTRO, 
                       (Math.abs(puntos.get(i)[1] - 300)), 
                       PIXEL_SIZE, PIXEL_SIZE);
           } 
        }        
    }
} 
