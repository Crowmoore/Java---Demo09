/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.jamk;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author h3090
 */
public class Ball {
    
    private int x, y;
    private int dx, dy;
    private int size;
    private Color color;
    private int maxX, maxY;
    
    public Ball(int maxX, int maxY) {
        Random random = new Random();
        this.size = 25;
        //position
        this.x = random.nextInt(maxX-this.size);
        this.y = random.nextInt(maxY-this.size);
        //movement
        this.dx = random.nextInt(6)-3; //-3 <-> 3
        if(this.dx == 0) this.dx = 3;
        this.dy = random.nextInt(6)-3;
        if(this.dy == 0) this.dy = 3;
        //color
        this.color = new Color(
                random.nextInt(255),
                random.nextInt(255),
                random.nextInt(255));
        //bounds
        this.maxX = maxX;
        this.maxY = maxY;
    }
    
    //Ball movement
    public void move() {
        //move
        this.x += dx;
        this.y += dy;
        //bounds
        if(this.x + this.size > maxX || this.x < 0) dx *= -1;
        if(this.y + this.size > maxY || this.y < 0) dy *= -1;
    }
    
    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getSize() { return this.size; }
    public Color getColor() { return this.color; }
    
}
