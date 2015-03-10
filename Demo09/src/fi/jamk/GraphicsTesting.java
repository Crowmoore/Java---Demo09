/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.jamk;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author h3090
 */
public class GraphicsTesting extends JFrame implements Runnable{
    
    private Image bg;
    private MediaTracker tracker;
    //private Ball ball;
    private Thread thread;
    
    private ArrayList<Ball> balls = new ArrayList<>();
    
    public GraphicsTesting() {
        super("Graphics Testing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        
        //this.ball = new Ball(800, 600);
        for(int i=1; i<1000; i++) {
            balls.add(new Ball(800,600));
        }
        
        bg = getToolkit().createImage("bg.jpg");
        tracker = new MediaTracker(this);
        tracker.addImage(bg, 0);
        try {
            tracker.waitForAll();
        } catch (InterruptedException e) {
            System.out.println("Failed to load image");
        }
        //add JPanel to JFrame
        getContentPane().add(new DrawPanel());
        //start thread
        thread = new Thread(this);
        thread.start(); //calls run()
    }
    
    public static void main(String[] args) {
        
        new GraphicsTesting().setVisible(true);
        
    }
    //runs in its own thread
    @Override
    public void run() {
        while(true) {
            //move
            //ball.move();
            for (Ball ball : balls) {
                ball.move();
            }
            //draw
            repaint();
            //wait
            try {
                thread.sleep(10);
            } catch (InterruptedException e) {}
            
        }
    }
    //class takes care of JPanel drawing
    class DrawPanel extends  JPanel {
        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(bg, 0, 0, this);
            
            for (Ball ball : balls) {            
            g.setColor(ball.getColor());
            g.fillOval(ball.getX(),
                       ball.getY(),
                       ball.getSize(),
                       ball.getSize());
            }
            Font font1 = new Font("verdana",Font.BOLD,20);
            g.setColor(Color.red);
            g.setFont(font1);
            g.drawString("This text is red", 10, 20);
            
        }
    }

    
}
