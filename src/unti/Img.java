/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unti;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author admin
 */
public class Img {
    public static String getRelativePath (){
        URL url = Img.class.getResource("../ImgRoom");
        String selectedImagePath = new File(url.getPath()).toString()+ "/" ;
        return selectedImagePath;
    }
    
    public static void setImageLabel(JLabel img, String name){
        
        ImageIcon ii = new ImageIcon(getRelativePath() + name);
        //Resize
        Image image = ii.getImage().getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH);
        //Display
        img.setIcon(new ImageIcon(image));
    }
    
    
}
