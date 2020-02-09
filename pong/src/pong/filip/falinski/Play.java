package pong.filip.falinski;


import java.awt.*;
import java.awt.event.KeyEvent;

public class Play {

    public Paddle p1, p2;
    public Ball ball;

    public static int leftScore, rightScore;

    public Play() {
        init();
    }

    public void init() {
        p1 = new Paddle(new Rectangle(0, GameCanvas.HEIGHT / 2, 20, 100),  KeyEvent.VK_W, KeyEvent.VK_S);
        p2 = new Paddle(new Rectangle(GameCanvas.WIDTH - 20, GameCanvas.HEIGHT / 2, 20, 100), KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        ball = new Ball(GameCanvas.WIDTH / 2, GameCanvas.HEIGHT / 3, 10);
        leftScore = 0;
        rightScore = 0;
    }

    public void update() {
        p1.update(ball);
        p2.update(ball);
        ball.update();

        if(leftScore > 6 || rightScore > 6) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.exit(0);
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GameCanvas.WIDTH, GameCanvas.HEIGHT);
        p1.draw(g);
        p2.draw(g);
        ball.draw(g);

        g.setFont(new Font("Arial", Font.PLAIN, 100));
        g.drawString(Integer.toString(leftScore), GameCanvas.WIDTH / 2 - 120, 100);
        g.drawString(Integer.toString(rightScore), GameCanvas.WIDTH / 2 + 80, 100);

        for(int i = 0; i < 16; i++) {
            g.fillRect(GameCanvas.WIDTH / 2 - 10, 10 + i * 20 + i * 30, 20, 20);
        }
    }

    public void keyPressed(int k) {
        p1.keyPressed(k);
        p2.keyPressed(k);
    }

    public void keyReleased(int k) {
        p1.keyReleased(k);
        p2.keyReleased(k);
    }

}