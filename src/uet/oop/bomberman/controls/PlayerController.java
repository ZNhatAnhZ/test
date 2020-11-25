package uet.oop.bomberman.controls;

import javafx.scene.input.KeyCode;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.scene.MapSetup;

import java.util.*;



public class PlayerController {
    public static void handlePlayerMovements() {
        List keyboardInputs = KeyController.getUserInput();
        Bomber player = MapSetup.getBomber();

        if (keyboardInputs.contains(KeyCode.UP)) {
            player.move(KeyCode.UP);
        }
        if (keyboardInputs.contains(KeyCode.DOWN)) {
            player.move(KeyCode.DOWN);
        }
        if (keyboardInputs.contains(KeyCode.LEFT)) {
            player.move(KeyCode.LEFT);
        }
        if (keyboardInputs.contains(KeyCode.RIGHT)) {
            player.move(KeyCode.RIGHT);
        }
    }
}
