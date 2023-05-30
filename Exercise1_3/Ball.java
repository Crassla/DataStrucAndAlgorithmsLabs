/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise1_3;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.Timer;

/**
 *
 * @author GGPC
 */
public class Ball implements Runnable
{
     private int x;
    private int y;
    private Color color;
    private int velx;
    private int vely;
    private int diameter;
    private int WIDTH;
    private int HEIGHT;
    private volatile boolean exit = false;
    private Timer timer;
    
    public Ball(int x, int y, int WIDTH, int HEIGHT) {
        this.color = randomColor(); 
        this.velx = (int)(Math.random() * 10 + 5);
        this.vely = (int)(Math.random() * 10 + 5);
        this.diameter = (int)(Math.random() * 100 + 10);
        this.x = ((x > WIDTH - diameter) ? x - diameter : x);
        this.y = ((y > HEIGHT - diameter) ? y - diameter : y);
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }
    
    public void move() {
        x += velx;
        y += vely;
        
        if (x < 0) 
        {
            velx = -velx;
        } 
        
        else if(x > WIDTH - diameter) 
        {
            velx = -velx;
        }
        
        else if(y < 0) 
        {
            vely = -vely;
        } 
        
        else if(y > HEIGHT - diameter)    
        {
            vely = -vely;
        }
    }

    private Color randomColor() 
    {
        Color randomColor = Color.WHITE;
        
        while (randomColor == Color.WHITE)
        {
            int r = (int)(Math.random()*255);
            int g = (int)(Math.random()*255);
            int b = (int)(Math.random()*255);
            randomColor = new Color(r,g,b);
        }

        return randomColor;
    }
    
    public void draw(Graphics2D g2) 
    {
        g2.setColor(this.color);
        g2.fill(new Ellipse2D.Double(this.x, this.y, this.diameter, this.diameter));
    }
    
    public void stop()
    {
        this.exit = true;
    }
        
    @Override
    public void run() {
        while(!exit) 
        {
            move();
            try 
            {
                Thread.sleep(20);
            } 
            catch (InterruptedException ex) 
            {
            
            }
        }
    }
}
