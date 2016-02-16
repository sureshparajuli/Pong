package com.suresh;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Listen for user pressing a key, and moving human paddle in response
class KeyHandler implements KeyListener {

    @Override
    public void keyTyped(KeyEvent ev) {
        char keyPressed = ev.getKeyChar();
        char q = 'q';
        if( keyPressed == q){
            System.exit(0);    //quit if user presses the q key.
        }
    }

    @Override
    public void keyReleased(KeyEvent ev) {}   //Don't need this one, but required to implement it.

    @Override
    public void keyPressed(KeyEvent ev) {

        Main.removeInstructions = true;   //game has started

        if (ev.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("down key");
            moveDown();
        }
        if (ev.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("up key");
            moveUp();
        }

        if (ev.getKeyCode() == KeyEvent.VK_SPACE && Main.gameOver == true) {//listen to space bar press after game over
            System.out.println("space key");
            Main.restartGame();
        }

        //ev.getComponent() returns the GUI component that generated this event
        //In this case, it will be GameDisplay JPanel
        ev.getComponent().repaint();   //This calls paintComponent(Graphics g) again
    }

    private void moveDown() {
        //Coordinates decrease as you go up the screen, that's why this looks backwards.
        if (Main.humanPaddleY < Main.screenSize - Main.paddleSize) {
            Main.humanPaddleY+=Main.humanPaddleMaxSpeed;
        }
    }

    private void moveUp() {
        //Coordinates increase as you go down the screen, that's why this looks backwards.
        if (Main.humanPaddleY > Main.paddleSize) {
            Main.humanPaddleY-=Main.humanPaddleMaxSpeed;
        }
    }

}