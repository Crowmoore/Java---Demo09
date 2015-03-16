/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.jamk.digitalclock;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Greatmelons
 */
public class Clock extends JFrame implements Runnable{
    
    Calendar calendar = new GregorianCalendar();
    private int hour;
    private int minute;
    private int second;
    private Color color;
    private final Thread thread;
    
    public Clock() {
        super("Digital Clock");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        getContentPane().add(new ClockPanel());
        thread = new Thread(this);
        thread.start();
    }
    
    public static void main(String[] args) {
        
        new Clock().setVisible(true);
        
    }

    @Override
    public void run() {
        while(true) {
            calendar = Calendar.getInstance();
            hour = calendar.get(Calendar.HOUR_OF_DAY);
            minute = calendar.get(Calendar.MINUTE);
            second = calendar.get(Calendar.SECOND); 
            repaint();
            try {
                thread.sleep(1000);
            } catch (InterruptedException e) {}
            
        }
    }
    class ClockPanel extends JPanel {
        
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Random random = new Random();
        color = new Color(
                random.nextInt(255),
                random.nextInt(255),
                random.nextInt(255));
        setBackground(Color.BLACK);
        Font font1 = new Font("verdana",Font.BOLD,50);
        g.setColor(color);
        g.setFont(font1);
        String hours = getHourFormat();
        String minutes = getMinuteFormat();
        String seconds = getSecondFormat();
        g.drawString(hours, 250, 300);
        g.drawString(minutes, 350, 300);
        g.drawString(seconds, 450, 300);

        }
    }
    public String getHourFormat() {
        String hours;
        if(hour < 10) {
            hours = "0" + Integer.toString(hour);
        }
        else {
            hours = Integer.toString(hour);
        }
        return hours;
    }
    public String getMinuteFormat() {
        String minutes;
        if(minute < 10) {
            minutes = "0" + Integer.toString(minute);
        }
        else {
            minutes = Integer.toString(minute);
        }
        return minutes;
    }
    public String getSecondFormat() {
        String seconds;
        if(second < 10) {
            seconds = "0" + Integer.toString(second);
        }
        else {
            seconds = Integer.toString(second);
        }
        return seconds;
    }
}

