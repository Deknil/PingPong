package ru.deknil.pingpong.core;

import ru.deknil.pingpong.Config;
import ru.deknil.pingpong.core.enums.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @Author Deknil
 * @GitHub <a href=https://github.com/Deknil>https://github.com/Deknil</a>
 * @Date 05.02.2024
 * @Description The canvas class on which game elements are drawn
 * <p></p>
 * PingPong © 2024. All rights reserved.
 */
public class Canvas extends JPanel {
    private final BufferedImage image = new BufferedImage(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB);
    private final Font textFont = new Font("Arial", Font.PLAIN, 32);

    /**
     * Game map constructor
     */
    public Canvas() {
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        setFocusable(true);
        requestFocus();
        addMouseMotionListener(new MouseHandler());
        addKeyListener(new KeyboardHandler());
    }

    /**
     * Drawing a game map
     */
    private void render() {
        Graphics2D g = image.createGraphics();

        // Clear the canvas
        clear(g);

        // Drawing the ball
        drawBall(g);

        // Draw player and enemy
        drawPlayerPlatform(g, GameLogic.player);
        drawPlayerPlatform(g, GameLogic.enemy);

        // Draw UI
        drawUI(g);
    }

    /**
     * Draw UI
     */
    private void drawUI(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.setFont(textFont);

        FontMetrics fontMetrics = g.getFontMetrics(textFont);
        String titleText = GameLogic.gameState == GameState.WIN ? "YOU WIN!" : "YOU LOSE!";
        String scoreText = String.format("Your score: %d", GameLogic.playerScore);
        String scoreEnemyText = String.format("Enemy score: %d", GameLogic.enemyScore);
        String playScoreText = String.format("%d | %d", GameLogic.playerScore, GameLogic.enemyScore);
        String menuTitle = "Ping Pong";
        String tipToPlay = "Press 'Space' to play";



        if (GameLogic.gameState == GameState.PLAY) {
            g.drawString(playScoreText, (int) (Config.WINDOW_CENTER_X - fontMetrics.getStringBounds(playScoreText, g).getWidth() / 2), 20 + fontMetrics.getHeight());
        }

        if (GameLogic.gameState == GameState.WIN || GameLogic.gameState == GameState.LOSE) {
            g.drawString(titleText, (int) (Config.WINDOW_CENTER_X - fontMetrics.getStringBounds(titleText, g).getWidth() / 2), Config.WINDOW_CENTER_Y - fontMetrics.getHeight() );
            g.drawString(scoreText, (int) (Config.WINDOW_CENTER_X - fontMetrics.getStringBounds(scoreText, g).getWidth() / 2), Config.WINDOW_CENTER_Y + fontMetrics.getHeight() );
            g.drawString(scoreEnemyText, (int) (Config.WINDOW_CENTER_X - fontMetrics.getStringBounds(scoreEnemyText, g).getWidth() / 2), Config.WINDOW_CENTER_Y + fontMetrics.getHeight() * 2 );
            g.drawString(tipToPlay, (int) (Config.WINDOW_CENTER_X - fontMetrics.getStringBounds(tipToPlay, g).getWidth() / 2), Config.WINDOW_CENTER_Y + fontMetrics.getHeight() * 3);

        }

        if (GameLogic.gameState == GameState.MENU) {
            g.drawString(menuTitle, (int) (Config.WINDOW_CENTER_X - fontMetrics.getStringBounds(menuTitle, g).getWidth() / 2), Config.WINDOW_CENTER_Y - fontMetrics.getHeight() );
            g.drawString(tipToPlay, (int) (Config.WINDOW_CENTER_X - fontMetrics.getStringBounds(tipToPlay, g).getWidth() / 2), Config.WINDOW_CENTER_Y + fontMetrics.getHeight() );
        }
    }

    /**
     * Rendering player platform
     */
    private void drawPlayerPlatform(Graphics2D g, Player player) {
        if (player == null) return;

        g.setColor(Config.PLAYER_COLOR);

        int startX = player.posX;
        int startY = player.posY;

        g.fillRect(startX, startY, Config.PLAYER_WIDTH, Config.PLAYER_HEIGHT);
    }

    /**
     * Drawing the ball
     */
    private void drawBall(Graphics2D g) {
        Ball ball = GameLogic.ball;

        if (ball == null) return;

        g.setColor(Config.BALL_COLOR);
        g.fillOval(ball.posX - Config.BALL_SIZE / 2, ball.posY - Config.BALL_SIZE / 2, Config.BALL_SIZE * 2, Config.BALL_SIZE * 2);
    }

    /**
     * Clearing the Canvas
     */
    private void clear(Graphics2D g) {
        g.setColor(Config.BACKGROUND_COLOR);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    /**
     * Canvas drawing logic
     */
    @Override
    public void paint(Graphics g) {
        render();
        ((Graphics2D)g).drawImage(image, null, 0, 0);
    }
}
