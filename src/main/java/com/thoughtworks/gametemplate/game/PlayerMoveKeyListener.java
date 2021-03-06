package com.thoughtworks.gametemplate.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.thoughtworks.gametemplate.game.Vector2f.Zero;

public class PlayerMoveKeyListener implements KeyListener {
    private Entity player;
    private Vector2f left = new Vector2f(-1.0f, 0.0f);
    private Vector2f right = new Vector2f(1.0f, 0.0f);
    private Vector2f up = new Vector2f(0.0f, -1.0f);
    private Vector2f down = new Vector2f(0.0f, 1.0f);

    public PlayerMoveKeyListener(Entity player) {

        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent event) {
        if (event.getKeyChar() == ' ') {
            player.fire();
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyChar() == 'a') {
            player.velocity(left);
        }

        if (event.getKeyChar() == 'd') {
            player.velocity(right);
        }

        if (event.getKeyChar() == 'w') {
            player.velocity(up);
        }

        if (event.getKeyChar() == 's') {
            player.velocity(down);
        }


    }

    @Override
    public void keyReleased(KeyEvent event) {
        if (event.getKeyChar() == 'a') {
            player.velocity(Zero);
        }

        if (event.getKeyChar() == 'd') {
            player.velocity(Zero);
        }

        if (event.getKeyChar() == 'w') {
            player.velocity(Zero);
        }

        if (event.getKeyChar() == 's') {
            player.velocity(Zero);
        }

    }
}
