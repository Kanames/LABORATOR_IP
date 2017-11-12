package lab_06_EroulCeSeFeresteDeInamici;

import java.awt.Color;
import java.awt.Graphics;

public class Obstacle {

    private Integer xPos;
    private Integer yPos = -20;
    private Integer lato = 20;

    public Integer getxPos() {
        return xPos;
    }

    public void setxPos(Integer xPos) {
        this.xPos = xPos;
    }

    public Integer getyPos() {
        return yPos;
    }

    public void setyPos(Integer yPos) {
        this.yPos = yPos;
    }

    public Integer getLato() {
        return lato;
    }

    public void setLato(Integer lato) {
        this.lato = lato;
    }

    public Obstacle(Integer xPos) {
        super();
        this.xPos = xPos;
    }

    public void move_down() {
        yPos = yPos + lato;
    }

    public void draw_obstacle(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(xPos, yPos, lato, lato);
    }
}