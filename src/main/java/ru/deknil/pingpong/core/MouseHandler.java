package ru.deknil.pingpong.core;

import ru.deknil.pingpong.Config;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * @Author Deknil
 * @GitHub <a href=https://github.com/Deknil>https://github.com/Deknil</a>
 * @Date 05.02.2024
 * @Description Mouse listener handler
 * <p></p>
 * PingPong © 2024. All rights reserved.
 */
public class MouseHandler implements MouseMotionListener {
    /**
     * Invoked when a mouse button is pressed on a component and then
     * dragged.  {@code MOUSE_DRAGGED} events will continue to be
     * delivered to the component where the drag originated until the
     * mouse button is released (regardless of whether the mouse position
     * is within the bounds of the component).
     * <p>
     * Due to platform-dependent Drag&amp;Drop implementations,
     * {@code MOUSE_DRAGGED} events may not be delivered during a native
     * Drag&amp;Drop operation.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        // Not used
    }

    /**
     * Invoked when the mouse cursor has been moved onto a component
     * but no buttons have been pushed.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        // Player Movement
        Player player = GameLogic.player;

        if (player == null) return;

        player.posY = Math.clamp(e.getY() - Config.PLAYER_HEIGHT / 2, 0, Config.WINDOW_HEIGHT - Config.PLAYER_HEIGHT);
    }
}
