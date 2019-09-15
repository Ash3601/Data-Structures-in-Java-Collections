/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package midpointcirclealgo;

///**
// *
// * @author Ash_360
// */
//public class MidPointCircleAlgo {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//    }
//    
//}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Manish Yadav
 */
//package computergraphics;
 
import java.io.*;
import java.awt.*;
import java.applet.*;
import java.util.*;
import java.awt.image.*;
 
public class MidPointCircleAlgo extends Applet {
 
    BufferedImage image = new BufferedImage(1900, 1000, BufferedImage.TYPE_INT_ARGB);
    WritableRaster raster = image.getRaster();
    int array[] = {255, 0, 0, 255};
    int array1[] = {0, 0, 0, 0};
 
    public void init() {
        setSize(1900, 1000);
        repaint();
    }
 
    public void paint(Graphics g) {
        double r = 100, x1 = 100, y1 = 100, x, y, xk, yk;
 
        double p0 = (1) - r;
        int k = 0;
        x = 0;
        y = r;
 
        for (k = 1; x <= y; k++) {
            // Ist Quad
            raster.setPixel((int) (x + x1), (int) (y + y1), array);
            raster.setPixel((int) (y + y1), (int) (x + x1), array);
            // IInd Quad
            raster.setPixel((int) (-x + x1), (int) (y + y1), array);
            raster.setPixel((int) (-y + y1), (int) (x + x1), array);
            // IIIrd Quad
            raster.setPixel((int) (-x + x1), (int) (-y + y1), array);
            raster.setPixel((int) (-y + y1), (int) (-x + x1), array);
            // IVth Quad
            raster.setPixel((int) (x + x1), (int) (-y + y1), array);
            raster.setPixel((int) (y + y1), (int) (-x + x1), array);
 
            if (p0 <= 0) {
                x++;
                p0 = p0 + (2 * x) + 1;
            } else {
                x++;
                y--;
                p0 = p0 + (2 * x) + 1 - (2 * y);
            }
        }
        g.drawImage(image, 0, 0, null);
    }
}
/*
<applet code="MidPointCircleDrawing.class" width=1900 height=1000>
</applet>
 */
