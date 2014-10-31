package com.thoughtworks.gametemplate.game;

import com.thoughtworks.gametemplate.render.*;
import com.thoughtworks.gametemplate.render.Renderer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.thoughtworks.gametemplate.render.Sprite.fromFile;

public class Game implements ActionListener {
    private final Timer timer;
    private World world;
    private Window window;
    private Renderer renderer;
    private QuitKeyListener user;

    public Game(World world, Window window, Renderer renderer, QuitKeyListener user) {
        this.world = world;
        this.window = window;
        this.user = user;
        this.renderer = renderer;
        timer = new Timer(20, this);
    }

    public void run() throws InterruptedException {
        window.activate();
        timer.start();

        while(!user.hasQuit()){
            Thread.sleep(1);
        }

        timer.stop();
        window.deactivate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        world.update();
        window.repaint();
    }

    public Entity spawnEntity(EntityType type, Vector2f position) {
        Sprite sprite = fromFile(type.image(), position);
        renderer.addSprite(sprite);
        Entity entity = new Entity(position, sprite, this);
        world.spawn(entity);
        return entity;
    }
}
