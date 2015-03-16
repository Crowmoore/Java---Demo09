/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.jamk.lines;

import java.awt.Color;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Greatmelons
 */
public class Line extends JPanel{
    
    private int x1, y1;
    private int x2, y2;
    private int maxX;
    private int maxY;
    private Color color;


    public Line(int maxX, int maxY) {
        Random random = new Random();
        this.x1 = random.nextInt(maxX);
        this.x2 = random.nextInt(maxX);
        this.y1 = random.nextInt(maxY);
        this.y2 = random.nextInt(maxY);
        this.color = new Color(
                random.nextInt(255),
                random.nextInt(255),
                random.nextInt(255));
        this.maxX = maxX;
        this.maxY = maxY;
    }
    public Color getColor() {
        return this.color; }
    
    public int getX1() {
        return this.x1;
    }

    public int getY1() {
        return this.y1;
    }

    public int getX2() {
        return this.x2;
    }

    public int getY2() {
        return this.y2;
    }
}
