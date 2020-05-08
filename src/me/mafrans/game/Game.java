package me.mafrans.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.Raster;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * This is a class
 * Created 2020-03-25
 *
 * @author Magnus Silverdal
 */
public class Game extends Canvas implements Runnable {
    private String title = "Graphics";
    private int width;
    private int height;

    private JFrame frame;
    private int scale;
    private BufferedImage image;
    private int[] pixels;

    private Thread thread;
    private boolean running = false;
    private int fps = 60;
    private int ups = 60;

    private List<GameObject> gameObjects = new ArrayList<>();

    public void instantiate(GameObject object) {
        gameObjects.add(object);
    }

    public Game(int w, int h, int scale) {
        this.width = w;
        this.height = h;
        this.scale = scale;
        image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
        Dimension size = new Dimension(scale * width, scale * height);
        setPreferredSize(size);
        frame = new JFrame();
        frame.setTitle(title);
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        this.addKeyListener(new MyKeyListener());
        this.addMouseListener(new MyMouseListener());
        this.addMouseMotionListener(new MyMouseMotionListener());
        this.requestFocus();
    }

    private void draw() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0xFFFFFF;
        }

        for (GameObject object : gameObjects) {
            object.draw(pixels, width, height);
        }

        java.awt.Graphics g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.dispose();
        bs.show();
    }

    private void update() {

        for (GameObject o1 : gameObjects) {
            for(Collider c1 : o1.colliders) {
                for (GameObject o2 : gameObjects) {
                    for(Collider c2 : o1.colliders) {
                        if(o1 != o2) {
                            Collision collision1 = null;
                            Collision collision2 = null;
                            if(c2 instanceof CircleCollider) {
                                collision1 = c1.withCircle(o1.transform.position, o2.transform.position, (CircleCollider) c2);
                            }

                            if(c2 instanceof RectCollider) {
                                collision1 = c1.withRect(o1.transform.position, o2.transform.position, (RectCollider) c2);
                            }

                            if(c1 instanceof CircleCollider) {
                                collision2 = c2.withCircle(o2.transform.position, o1.transform.position, (CircleCollider) c1);
                            }

                            if(c1 instanceof RectCollider) {
                                collision2 = c2.withRect(o2.transform.position, o1.transform.position, (RectCollider) c1);
                            }

                            if(collision1 != null) {
                                collision1.collider = c2;
                                o1._collide(collision1);
                            }
                            else {
                                o1._uncollide(new Collision(c2));
                            }

                            if(collision2 != null) {
                                collision2.collider = c1;
                                o2._collide(collision2);
                            }
                            else {
                                o2._uncollide(new Collision(c1));
                            }
                        }
                    }
                }
            }
        }

        for (GameObject object : gameObjects) {
            object.update();
        }

        Input.update();
    }

    public synchronized void start() {
        running = true;

        for (GameObject object : gameObjects) {
            object.start();
        }

        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        for (GameObject object : gameObjects) {
            object.destroy();
        }

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        double frameUpdateinteval = 1000000000.0 / fps;
        double stateUpdateinteval = 1000000000.0 / ups;
        double deltaFrame = 0;
        double deltaUpdate = 0;
        long lastTime = System.nanoTime();

        while (running) {
            long now = System.nanoTime();
            deltaFrame += (now - lastTime) / frameUpdateinteval;
            deltaUpdate += (now - lastTime) / stateUpdateinteval;
            lastTime = now;

            while (deltaFrame >= 1) {
                draw();
                deltaFrame--;
            }

            while (deltaUpdate >= 1) {
                update();
                deltaUpdate--;
            }
        }
        stop();
    }

    private class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            Input.setKey(keyEvent.getKeyCode(), true);
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            Input.setKey(keyEvent.getKeyCode(), false);
        }
    }

    private class MyMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {
        }
    }

    private class MyMouseMotionListener implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent mouseEvent) {
            Input.mousePosition = new Vector2(mouseEvent.getPoint()).dot(1d/scale).round();
        }

        @Override
        public void mouseMoved(MouseEvent mouseEvent) {
            Input.mousePosition = new Vector2(mouseEvent.getPoint()).dot(1d/scale).round();
        }
    }
}

