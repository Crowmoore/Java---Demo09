/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.jamk.lines;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 *
 * @author Greatmelons
 */
public class LineDrawer extends JFrame implements Runnable{
    
    private int lineCount = 0;
    private final Thread thread;
    
    ArrayList<Line> lines = new ArrayList<>();
    
    public LineDrawer() {
        super("Them Lines");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        getContentPane().add(new DrawPanel());
        thread = new Thread(this);
        thread.start();
    }
    
    public void addLine() {
        lines.add(new Line(800,600));
        lineCount++;
    }
    
    public static void main(String[] args) {
        
        new LineDrawer().setVisible(true);
        
    }

    @Override
    public void run() {
        while(true) {
            addLine();
            repaint();
            try {
                thread.sleep(50);
            } catch (InterruptedException e) {}
            
        }
    }
    class DrawPanel extends JPanel {
        
    @Override
    public void paintComponent(Graphics g) {
        if(lineCount > 100) {
            removeAll();
            lines.clear();
            lineCount = 0;
        }            
        super.paintComponent(g);
        setBackground(Color.BLACK);
        for(Line line : lines) {
            g.setColor(line.getColor());
            g.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
        }
    }
    }
}
