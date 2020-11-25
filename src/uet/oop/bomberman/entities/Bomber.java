package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

import javafx.scene.input.*;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.scene.Gameloop;


public class Bomber extends Entity {
    private double speed = 0.1;
    public Bomber(double x, double y, Image img) {
        super( x, y, img);
    }

    public void move(KeyCode key) {
        if (key == KeyCode.UP) {
            y=y-speed;
            //img = Sprite.player_up.getFxImage();
            img = Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, Gameloop.animate, 20).getFxImage();
            if (Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, Gameloop.animate, 20) == Sprite.player_up) Gameloop.animate = 0;
        }
        else if (key == KeyCode.DOWN) {
            y=y+speed;
            //img = Sprite.player_down.getFxImage();
            img = Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, Gameloop.animate, 20).getFxImage();
            
        }
        else if (key == KeyCode.LEFT) {
            x=x-speed;
            //img = Sprite.player_left.getFxImage();
            img = Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, Gameloop.animate, 20).getFxImage();
            if (img.equals(Sprite.player_left_2.getFxImage())) Gameloop.animate = 0;
        }
        else if (key == KeyCode.RIGHT) {
            x=x+speed;
            //img = Sprite.player_right.getFxImage();
            img = Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, Gameloop.animate, 20).getFxImage();
            if (img.equals(Sprite.player_right_2.getFxImage())) Gameloop.animate = 0;
        }


    }

    @Override
    public void update() {
    }

}
