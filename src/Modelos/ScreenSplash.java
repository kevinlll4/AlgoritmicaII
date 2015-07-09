/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import Formularios.frmLogin;
import java.awt.*;
import java.awt.SplashScreen;
/**
 *
 * @author kevin
 */
public final class ScreenSplash {
      final SplashScreen splash ;
  //texto que se muestra a medida que se va cargando el screensplah
  final String[] texto = {"Cargando" ,"Configuracion", "Librerias",
                          "Archivos","Formularios","Iconos","Propiedades",
                          "X archivos", "Negocios",
                          "Imagenes" ,"Servidor","Listo",
                          ""};

  public ScreenSplash() {
  splash = SplashScreen.getSplashScreen();
  }

   public void animar()
   {
        if (splash != null)
        {
            Graphics2D g = splash.createGraphics();
            for(int i=1; i<texto.length; i++)
            {                       
                //se pinta texto del array
                g.setColor( new Color(4,52,101));//color de fondo
         g.fillRect(203, 328,280,12);//para tapar texto anterior
                g.setColor(Color.white);//color de texto 
                g.drawString("Loading "+texto[i-1]+"...", 203, 338);                
                g.setColor(Color.green);//color de barra de progeso
                g.fillRect(204, 308,(i*307/texto.length), 12);//la barra de progreso
                //se pinta una linea segmentada encima de la barra verde
                float dash1[] = {2.0f};
                BasicStroke dashed = new BasicStroke(9.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f, dash1, 0.0f);
                g.setStroke(dashed);
                g.setColor(Color.GREEN);//color de barra de progeso
                g.setColor( new Color(4,52,101));
                g.drawLine(205,314, 510, 314);                
                //se actualiza todo
                splash.update();
  try {
   Thread.sleep(321);
  } catch(InterruptedException e) { }
            }
    splash.close();
 }
        //una vez terminada la animación se muestra la aplicación principal
         try {
             frmLogin x=new frmLogin();
             x.show();
         }
 catch (Exception e) {
            System.out.println(e.getMessage());
        }
   }
}
