package com.suresh;

import javax.swing.*;
import java.awt.*;

class GameDisplay extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //System.out.println("* Repaint *");

        if (Main.gameOver == true) {
            Color currentColor = g.getColor();//get current color to use later
            g.setColor(Color.red);//set the color to red
            g.drawString( "Game over!", 20, 30 );
            g.drawString("Your score is " + Main.humanScore, 20, 60);
            g.drawString("Computer score is " + Main.computerScore, 20, 90);
            g.drawString( "Press space key to restart the game!", 20, 120 );
            g.setColor(currentColor);//set the color to the one before changing it to red
            return;
        }

        if (Main.removeInstructions == false ) {
            Color currentColor = g.getColor();//get current color to use later
            g.setColor(Color.orange);//set the color to orange
            g.drawString("Pong! Press up or down to move", 20, 30);
            g.drawString("Press q to quit", 20, 60);
            g.setColor(currentColor);//set the color to the one before changing it to orange
        }

        g.setColor(Color.blue);

        //While game is playing, these methods draw the ball, paddles, using the global variables
        //Other parts of the code will modify these variables

        //Ball - a circle is just an oval with the height equal to the width
        Color currentColor = g.getColor();//get the current color to save for later
        g.setColor(Color.orange);//change the ball color to orange
        g.fillOval((int)Main.ballX, (int)Main.ballY, Main.ballSize, Main.ballSize);//fill the ball with orange
        g.drawOval((int)Main.ballX, (int)Main.ballY, Main.ballSize, Main.ballSize);
        g.setColor(currentColor);//set the current color
        //Computer paddle
        g.drawLine(Main.paddleDistanceFromSide, Main.computerPaddleY - Main.paddleSize, Main.paddleDistanceFromSide, Main.computerPaddleY + Main.paddleSize);
        //Human paddle
        g.drawLine(Main.screenSize - Main.paddleDistanceFromSide, Main.humanPaddleY - Main.paddleSize, Main.screenSize - Main.paddleDistanceFromSide, Main.humanPaddleY + Main.paddleSize);

    }
}
