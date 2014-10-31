package com.thoughtworks.gametemplate.game;
import static com.thoughtworks.gametemplate.game.EntityType.*;

import com.thoughtworks.gametemplate.render.Sprite;

import static com.thoughtworks.gametemplate.game.Vector2f.Zero;

public class Entity {
    private Vector2f position;
    private Vector2f velocity;
    private Sprite sprite;
    private Game game;

    public Entity(Vector2f position, Sprite sprite, Game game) {
        this.position = position;
        this.sprite = sprite;
        this.velocity = Zero;
        this.game = game;
    }

    public Vector2f getPosition() {
        return this.position;
    }


    public void move(){
        position = position.plus(velocity);
        sprite.move(position);
    }

    public void velocity(Vector2f velocity) {
        this.velocity = velocity;
    }

    public void fire(){
        Entity missile = game.spawnEntity(Shot, this.getPosition());
        missile.velocity(new Vector2f(0.0f, -10f));
    }

    public Box desiredLocation() {
        Vector2f desiredPosition = position.plus(velocity);
        return new Box(desiredPosition, desiredPosition.plus(sprite.width(), sprite.height()));
    }
}
