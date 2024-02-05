package ru.deknil.pingpong.core;

import ru.deknil.pingpong.Config;
import ru.deknil.pingpong.core.enums.GameState;

/**
 * @Author Deknil
 * @GitHub <a href=https://github.com/Deknil>https://github.com/Deknil</a>
 * @Date 05.02.2024
 * @Description Main game logic handler
 * <p></p>
 * PingPong © 2024. All rights reserved.
 */
public class GameLogic {
    public static Ball ball; // Ball
    public static Player player; // Player
    public static Player enemy; // Enemy

    public static int playerScore = 0; // Current Player Points
    public static int enemyScore = 0; // Opponent's points

    public static GameState gameState = GameState.MENU; // Current state of the game

    /**
     * Removing the ball from the stage
     */
    private static void deleteBall() {
        ball = null;
    }

    /**
     * Removing players from the stage
     */
    private static void deletePlayers() {
        enemy = null;
        player = null;
    }


    /**
     * Spawn the ball in the center of the screen and add a speed vector
     */
    private static void spawnBall() {
        deleteBall();

        ball = new Ball(Config.WINDOW_CENTER_X, Config.WINDOW_CENTER_Y);
        int forceDirection = Math.random() >= 0.5 ? -1 : 1;
        ball.addForce((int) (Config.BALL_START_SPEED + Math.random() * Config.BALL_START_SPEED) * forceDirection,
                (int) (Config.BALL_START_SPEED + Math.random() * Config.BALL_START_SPEED) * forceDirection);

    }

    /**
     * Changing game state
     * @param state new state
     */
    public static void changeState(GameState state) {
        deleteBall();
        deletePlayers();
        GameLogic.gameState = state;
    }

    /**
     * Game logic update
     */
    public static void update() {
        updateGameState();

        if (gameState != GameState.PLAY) return;

        if (playerScore == Config.GAME_MAX_SCORE) {
            changeState(GameState.WIN);
        } else if (enemyScore == Config.GAME_MAX_SCORE) {
            changeState(GameState.LOSE);
        }

        if (ball == null || player == null || enemy == null) return;

        ball.posX += ball.deltaX;
        ball.posY += ball.deltaY;

        // Enemy Movement
        int targetEnemyPosY = ball.posY - Config.PLAYER_HEIGHT / 2;
        int deltaEnemyPosY = enemy.posY - targetEnemyPosY;
        if (enemy.posY != targetEnemyPosY) {
            enemy.posY = Math.clamp(enemy.posY + (int) (Config.ENEMY_SPEED * -Math.signum(deltaEnemyPosY)), 0, Config.WINDOW_HEIGHT - Config.PLAYER_HEIGHT);
        }

        // Player collision
        if(ball.posX < player.posX + Config.PLAYER_WIDTH && ball.posY >= player.posY && ball.posY <= player.posY + Config.PLAYER_HEIGHT ) {
            ball.deltaX *= -1;
            SoundUtils.playSound("knock.wav");
        }

        // Enemy collision
        if(ball.posX > enemy.posX  && ball.posY >= enemy.posY && ball.posY <= enemy.posY + Config.PLAYER_HEIGHT ) {
            ball.deltaX *= -1;
            SoundUtils.playSound("knock.wav");
        }

        // Checking the collision with the wall of the player and the enemy
        if (ball.posX <= 0){
            enemyScore += 1;
            spawnBall();
        } else if(ball.posX >= Config.WINDOW_WIDTH) {
            playerScore += 1;
            spawnBall();
        }

        // Top and bottom wall collision check
        if (ball.posY <= 0 || ball.posY >= Config.WINDOW_HEIGHT) {
            ball.deltaY *= -1;
            SoundUtils.playSound("knock.wav");
        }
    }

    /**
     * Game State Update
     */
    private static void updateGameState() {
        if (gameState == GameState.PLAY) {
            if (ball == null) {
                spawnBall();
            }
            if (enemy == null) {
                enemy = new Player(Config.WINDOW_WIDTH - Config.PLAYER_MARGIN - Config.PLAYER_WIDTH, Config.WINDOW_CENTER_Y - Config.PLAYER_HEIGHT / 2);
            }
            if (player == null) {
                player = new Player(Config.PLAYER_MARGIN, Config.WINDOW_CENTER_Y - Config.PLAYER_HEIGHT / 2);
            }
        }
    }
}
