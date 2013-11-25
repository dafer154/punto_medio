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
public class PuntoMedioLineas {
    ArrayList <int []> puntos;
    VentanaPanel ventana;
    boolean cambioXY;
    int [] punto;

    public PuntoMedioLineas(VentanaPanel ventana) {
        this.ventana = ventana;
    }      

    public void puntoMedio(int x0, int y0, int x1, int y1){
        puntos = new ArrayList();
        cambioXY= true;
        float pendiente = (float)(y1 - y0)/(float)(x1 - x0);
        if(pendiente < -1){           
            //Incremento Sur-SurEste
            puntoMedioE_SE(y0, x0, y1, x1);
        }else if(pendiente >= -1 && pendiente < 0){
            cambioXY= false;
            //Incremento Este-Incremento SurEste
            puntoMedioE_SE(x0, y0, x1, y1);
        }else if (pendiente >= 0 && pendiente <= 1){          
            //Incremento Este- NorEste
            cambioXY= false;
            puntoMedioE_NE(x0, y0, x1, y1);            
        }else{
            //Incremento Norte-NorEste
            puntoMedioE_NE(y0, x0, y1, x1);
        }        
        
    }
    
    
    public void puntoMedioE_NE(int x0, int y0, int x1, int y1){
        //Inicializamos las variables 
        int d, x, y, xEnd, dx, dy;
        if (x0 > x1) {
            x = x1;
            y = y1;
            xEnd = x0;
            dx = x0 - x1;
            dy = y0 - y1;
        }else {
            x = x0;
            y = y0;
            xEnd = x1;
            dx = x1 - x0;
            dy = y1 - y0;
        }
        d = 2*dy - dx;
        int incrE = 2*dy;
        int  incrNE = 2*(dy - dx);
        //Pintamos el punto inicial
        addPixel(x,y);       
        //Pintamos el resto de puntos
        while(x < xEnd){
            if(d <= 0){
                d= d + incrE;
                x++;
            }else{
                d= d + incrNE;
                x++;
                y++;
            }
            //Pintamos el punto que hemos escogido en esta iteración
            addPixel(x,y);
        }
        ventana.setPixels(puntos);        
    }
    
    public void puntoMedioE_SE(int x0, int y0, int x1, int y1){
        //Inicializamos las variables 
        int d, x, y, xEnd, dx, dy;             
        
        if (x0 > x1) {
            x = x1;
            y = y1;
            xEnd = x0;
            dx = x0 - x1;
            dy = y0 - y1; 
        }else {
            x = x0;
            y = y0;
            xEnd = x1;
            dx = x1 - x0;
            dy = y1 - y0; 
        }
        d = 2*dy + dx;
        int incrE = 2*dy;
        int incrSE = 2*(dx + dy);
        
        //Pintamos el punto inicial
        addPixel(x,y);                  
                
        //Pintamos el resto de puntos
        while(x < xEnd){
            if(d >= 0){
                d= d + incrE;
                x++;
            }else{
                d= d + incrSE;
                x++;
                y--;
            }
            //Pintamos el punto que hemos escogido en esta iteración
            addPixel(x,y);
        }
        ventana.setPixels(puntos);        
    }
    
    
    public void addPixel (int x, int y){
        punto = new int[2];
        if(cambioXY){
            //System.out.println("hizo cambio");
            punto[0] = y;
            punto[1] = x;
            //System.out.print("(" + y + "," + x + ") ");
        }else{
            punto[0] = x;
            punto[1] = y;
            //System.out.print("(" + x + "," + y + ") ");
        }
        puntos.add(punto);        
    }

 
   
    
}
