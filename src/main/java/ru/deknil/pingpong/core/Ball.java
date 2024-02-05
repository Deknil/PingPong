package ru.deknil.pingpong.core;

/**
 * @Author Deknil
 * @GitHub <a href=https://github.com/Deknil>https://github.com/Deknil</a>
 * @Date 05.02.2024
 * @Description Ball object logic
 * <p></p>
 * PingPong © 2024. All rights reserved.
 */
public class Ball {
    public int posX; // Horizontal position
    public int posY; // Vertical position
    public int deltaX = 0; // Horizontal speed
    public int deltaY = 0; // Vertical speed

    /**
     * Ball constructor
     * @param x Horizontal position
     * @param y Vertical position
     */
    public Ball(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    /**
     * Adding acceleration to the ball
     * @param x Horizontal speed
     * @param y Vertical speed
     */
    public void addForce(int x, int y) {
        this.deltaX += x;
        this.deltaY += y;
    }
}
