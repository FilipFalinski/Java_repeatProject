package pong.filip.falinski;

import java.awt.*;

public class Ball {

    private int x, y, r;
    private double dx, dy;

    public Ball(int x, int y, int r) {
        this.setX(x);
        this.setY(y);
        this.setR(r);
        this.setX(this.getX() - r);
        this.setY(this.getY() - r);

        dx = 1;
        dy = 1;
    }

    public void update() {
        // colliding with top and bottom of screen
        if(getY() - getR() <= 0 || getY() + getR() >= GameCanvas.HEIGHT) dy *= -1;

        // outside of map?... if so, add score and reset
        if(getX() + getR() >= GameCanvas.WIDTH) {
            setX(GameCanvas.WIDTH / 2 - getR());
            setY(GameCanvas.HEIGHT / 2 - getR());
            Play.leftScore += 1;
            dx *= -1;
        }

        // same as above, but for left side instead
        if(getX() - getR() <= 0) {
            setX(GameCanvas.WIDTH / 2 - getR());
            setY(GameCanvas.HEIGHT / 2 - getR());
            Play.rightScore += 1;
            dx *= -1;
        }

        setX(getX() + (int)dx);
        setY(getY() + (int)dy);
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(getX() - getR(), getY() - getR(), getR() * 2, getR() * 2);
    }

    public void setDx(double d) {
        this.dx = (int)d;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public double getDx() { return dx; }
    public double getDy() { return dy; }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}