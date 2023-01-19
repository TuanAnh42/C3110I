/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unti;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import unti.PatternForm;

/**
 *
 * @author Admin
 */
public class Clock extends Thread{
    private JLabel lbl;

    public Clock(JLabel lbl) {
        this.lbl = lbl;
    }

    public void run() {
        while (true) {
            try {
                Date date = new Date();
                String time = unti.PatternForm.getTimeNow("M/dd/yyyy - hh:mm:ss aa");

                lbl.setText(time);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
