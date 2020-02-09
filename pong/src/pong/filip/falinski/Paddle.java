package pong.filip.falinski;


import java.awt.*;

public class Paddle extends Rectangle {

    private boolean up = false, down = false;

    private int upKey, downKey;

    public Paddle(Rectangle r, int upKey, int downKey) {
        setBounds(r);
        y -= (height / 2);
        this.upKey = upKey;
        this.downKey = downKey;
    }

    public void update(Ball ball) {
        if(y <= 0) up = false;
        if(y + height >= GameCanvas.HEIGHT) down = false;

        if(checkCollision(new Point(ball.getX() + ball.getR(), ball.getY())) || checkCollision(new Point(ball.getX() - ball.getR(), ball.getY()))) {
            ball.setDx(ball.getDx() * -1.5);
        }

        if(up) y--;
        if(down) y++;
    }

    public boolean checkCollision(Point p) {
        boolean colliding = false;
        if(contains(p)) colliding = true;
        else colliding = false;
        return colliding;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    public void keyPressed(int k) {
        if(k == upKey) up = true;
        if(k == downKey) down = true;
    }

    public void keyReleased(int k) {
        if(k == upKey) up = false;
        if(k == downKey) down = false;
    }



}