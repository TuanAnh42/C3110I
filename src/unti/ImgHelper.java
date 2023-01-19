/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unti;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author AD
 */
public class ImgHelper {
    public static Image resize(Image originalImage,int targetWidth,int targetHeight){
            Image resultImage=originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
            
        return resultImage;
    }
     public static byte[] toByteArray(Image img,String type ) throws IOException{
         BufferedImage bi = new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_INT_RGB);
         Graphics2D gd = bi.createGraphics();
         gd.drawImage(img,0,0,null);
         gd.dispose();
         
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         ImageIO.write(bi, type, baos);
         byte[] imageByte = baos.toByteArray();
        return imageByte;
          
     }
     public static Image createImageFromByteArray(byte [] data ,String type) throws IOException{
         ByteArrayInputStream bais = new ByteArrayInputStream(data);
         BufferedImage bi2 = ImageIO.read(bais);
         Image img = bi2.getScaledInstance(bi2.getWidth(),bi2.getHeight(),Image.SCALE_SMOOTH);
        return img;
    }
            
            
            
            
            
            
            
            
            
            
}
