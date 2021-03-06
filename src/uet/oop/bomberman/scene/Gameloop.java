package uet.oop.bomberman.scene;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.controls.PlayerController;
import uet.oop.bomberman.entities.Entity;

public class Gameloop {
    public static int animate;
    private static void update() {
        PlayerController.handlePlayerMovements();
        MapSetup.getEntities().forEach(Entity::update);
    }

    private static void render(GraphicsContext gc) {
        gc.clearRect(0, 0, MapSetup.WIDTH, MapSetup.HEIGHT);
        MapSetup.getStillObjects().forEach(g -> g.render(gc));
        MapSetup.getEntities().forEach(g -> g.render(gc));
    }

    public static void start(GraphicsContext gc) {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                animate++;
                render(gc);
                update();
            }
        };
        timer.start();
    }
}
