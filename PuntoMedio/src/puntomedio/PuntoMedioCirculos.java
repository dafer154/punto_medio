/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puntomedio;

import java.util.ArrayList;
import puntomedio.gui.VentanaPanel;

/**
 *
 * @author edwin
 */
public class PuntoMedioCirculos {
    ArrayList <int []> puntos;
    VentanaPanel ventana;
    int [] punto;
    int xCentro, yCentro;

    public PuntoMedioCirculos(VentanaPanel ventana, int xc, int yc) {
        this.ventana = ventana;
        this.xCentro = xc;
        this.yCentro = yc;
    }  
        
    public void puntoMedioCirculos(int r){
        //Se asume circulo centrado en el origen
        puntos = new ArrayList();
        int x=0, y=r, d=1-r;
        calcularSimetriasYPintarpixel(x, y);
        while(y>x){
            if(d<0){
                //Seleccion del Este
                d = d+ 2*x +3;
                x++;
            }else{
                //Seleccion SurEste 
                d = d +2*(x-y)+5;
                x++;
                y--;
            }
            calcularSimetriasYPintarpixel(x, y);
        }       
        ventana.setPixels(puntos);
    }
    
    public void calcularSimetriasYPintarpixel(int x, int y){
        addPixel(x, y);
        addPixel(x, -y);
        addPixel(-x, y);
        addPixel(-x, -y);
        addPixel(y, x);
        addPixel(y, -x);
        addPixel(-y, x);
        addPixel(-y, -x);
    }
    
    public void addPixel (int x, int y){
        x+=xCentro;
        y+=yCentro;
        if(x>= -ventana.X_CENTRO && x<= ventana.X_CENTRO
                && y>= -ventana.Y_CENTRO && y<= ventana.Y_CENTRO){
            punto = new int[2];
            punto[0] = x;
            punto[1] = y;
            //System.out.print("(" + x + "," + y + ") ");
            puntos.add(punto);
        }               
    }
    
}
