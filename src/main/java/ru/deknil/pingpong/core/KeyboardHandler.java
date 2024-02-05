package ru.deknil.pingpong.core;

import ru.deknil.pingpong.core.enums.GameState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @Author Deknil
 * @GitHub <a href=https://github.com/Deknil>https://github.com/Deknil</a>
 * @Date 05.02.2024
 * @Description Keyboard listener handler
 * <p></p>
 * PingPong © 2024. All rights reserved.
 */
public class KeyboardHandler implements KeyListener {
    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // Not used
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            switch (GameLogic.gameState) {
                case MENU -> {
                    GameLogic.changeState(GameState.PLAY);
                }
                case WIN, LOSE -> {
                    GameLogic.changeState(GameState.PLAY);
                    GameLogic.playerScore = 0;
                    GameLogic.enemyScore = 0;
                }
            }
        }
    }
}
