import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 * This is a class
 * Created 2020-01-21
 *
 * @author Magnus Silverdal
 */
public class main extends Canvas implements Runnable{
 private String title = "We Are Robots";
 private JFrame frame;
 private int fps = 1;
 private int ups = 1;
 private boolean running = false;
 private Thread thread;
 private robot r;
 private food f;

 public main (int w, int h) {
  Dimension size = new Dimension(w, h);
  setPreferredSize(size);
  frame = new JFrame();
  frame.setTitle(title);
  r = new robot(25, 25);
  f = new food(215, 215);
 }

 private synchronized void start() {
  running = true;
  thread = new Thread(this);
  thread.start();
 }

 private synchronized void stop() {
  running = false;
  try {
   thread.join();
  } catch (InterruptedException e) {
   e.printStackTrace();
  }
 }

 @Override
 public void run() {
  double frameUpdateInterval = 1000000000.0 / fps;
  double stateUpdateInterval = 1000000000.0 / ups;
  double deltaFrame = 0;
  double deltaUpdate = 0;
  long lastTime = System.nanoTime();

  while (running) {
   long now = System.nanoTime();
   deltaFrame += (now - lastTime) / frameUpdateInterval;
   deltaUpdate += (now - lastTime) / stateUpdateInterval;
   lastTime = now;

   while (deltaUpdate >= 1) {
    update();
    deltaUpdate--;
   }

   while (deltaFrame >= 1) {
    draw();
    deltaFrame--;
   }
  }
  stop();
 }

 private void draw() {
  BufferStrategy bs = getBufferStrategy();
  if (bs == null) {
   createBufferStrategy(3);
   return;
  }

     Graphics g = bs.getDrawGraphics();
     g.setColor(Color.BLUE);
     g.fillOval(200, 200, 50, 50);
     g.setColor(Color.RED);
     g.fillRect(r.getX(), r.getY(), 25, 35);
     g.setColor(Color.WHITE);
     g.fillRect(0, 0, 1920, 1080);
     g.setColor(Color.BLUE);
     g.fillOval(200, 200, 50, 50);
     g.setColor(Color.GREEN);
     g.fillRect(f.getX(), f.getY(), 15, 15);
     g.setColor(Color.RED);
     g.fillRect(r.getX(), r.getY(), 25, 35);
     bs.show();
 }

 public void Move () {
  r.getX();
  r.getY();
     Random randomGeneratorX = new Random();
     int randomIntX = randomGeneratorX.nextInt(10) + 1;
     Random randomGeneratorY = new Random();
     int randomIntY = randomGeneratorY.nextInt(10) + 1;
     r.setX(r.getX()+randomIntX);
     r.setY(r.getY()+randomIntY);

     if (r.getX() > 800) {
         int randomNegativeX = randomGeneratorX.nextInt(10) + 1;
         r.setX(800 - randomNegativeX);
     } else if (r.getY() > 800) {
         int randomNegativeY = randomGeneratorY.nextInt(10) + 1;
         r.setY(800 - randomNegativeY);
     }

     }



 private void update() {
  Move();
 }

 public static void main(String[] args) {
  main game = new main (800,800);
  game.frame.add(game);
  game.frame.pack();
  game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  game.frame.setLocationRelativeTo(null);
  game.frame.setVisible(true);
  game.start();
 }
}