package ru.deknil.pingpong.core;

/**
 * @Author Deknil
 * @GitHub <a href=https://github.com/Deknil>https://github.com/Deknil</a>
 * @Date 05.02.2024
 * @Description Implementing a player object
 * <p></p>
 * PingPong © 2024. All rights reserved.
 */
public class Player {
    public int posX; // Horizontal position
    public int posY; // Vertical position

    /**
     * Player constructor
     * @param x Horizontal position
     * @param y Vertical position
     */
    public Player(int x, int y) {
        this.posX = x;
        this.posY = y;
    }
}
