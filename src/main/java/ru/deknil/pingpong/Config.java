package ru.deknil.pingpong;

import java.awt.*;

/**
 * @Author Deknil
 * @GitHub <a href=https://github.com/Deknil>https://github.com/Deknil</a>
 * @Date 05.02.2024
 * @Description Main application configuration file
 * <p></p>
 * PingPong © 2024. All rights reserved.
 */
public class Config {
    public static final String WINDOW_TITLE = "Ping Pong"; // Window title
    public static final int WINDOW_WIDTH = 1600; // Window width
    public static final int WINDOW_HEIGHT = 800; // Window height
    public static final int WINDOW_CENTER_X = WINDOW_WIDTH / 2; // Window center horizontally
    public static final int WINDOW_CENTER_Y = WINDOW_HEIGHT / 2; // Vertical window center
    public static final int GAME_SPEED = 10; // Game update speed, in ms.
    public static final int GAME_MAX_SCORE = 5; // Max score to win or lose

    public static final int BALL_SIZE = 8; // Ball size
    public static final int BALL_START_SPEED = 4; // Ball start speed

    public static final int PLAYER_MARGIN = 5; // Margin platform
    public static final int PLAYER_WIDTH = 16; // Player platform width
    public static final int PLAYER_HEIGHT = 120; // Player platform height

    public static final float ENEMY_SPEED = 3.5f; // Enemy speed reaction

    public final static Color BACKGROUND_COLOR = new Color(10, 10, 10, 255); // Canvas background color
    public final static Color PLAYER_COLOR = new Color(94, 166, 84, 255); // Player color
    public final static Color BALL_COLOR = new Color(45, 115, 243, 255); // Ball color
}
