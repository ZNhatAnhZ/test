package uet.oop.bomberman.scene;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.controls.KeyController;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.graphics.Sprite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MapSetup {
    static Scene s;
    static Group root;
    static Canvas canvas;
    static GraphicsContext gc;
    static Bomber bomberman;
    private static List<Entity> entities = new ArrayList<>();
    private static List<Entity> stillObjects = new ArrayList<>();
    public static int WIDTH;
    public static int HEIGHT;
    private static void readFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("res/levels/Level1.txt"));
            String a = reader.readLine();
            String temp[] = a.split(" ");
            int level = Integer.valueOf(temp[0]);
            HEIGHT = Integer.valueOf(temp[1]);
            WIDTH = Integer.valueOf(temp[2]);
            reader.close();
        } catch (Exception ex) {
            System.out.println("loi");
        }
    }

    public static void createMap() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("res/levels/Level1.txt"));
            reader.readLine();
            for (double  y = 0; y < HEIGHT; y++) {
                String s = reader.readLine();
                for (double x = 0; x < WIDTH; x++) {
                    switch (s.charAt( (int) x)) {
                        case '#':
                            stillObjects.add(new Wall(x, y, Sprite.wall.getFxImage()));
                            break;
                        case '*':
                            stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                            stillObjects.add(new Brick(x, y, Sprite.brick.getFxImage()));
                            break;
                        case '1':
                            stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                            entities.add(new Balloon(x, y, Sprite.balloom_left1.getFxImage()));
                            break;
                        case '2':
                            stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                            entities.add(new Oneal(x, y, Sprite.oneal_left1.getFxImage()));
                            break;
                        case 'x':
                            stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                            stillObjects.add(new Portal(x, y, Sprite.portal.getFxImage()));
                            break;
                        case 'f':
                            stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                            stillObjects.add(new Item(x, y, Sprite.powerup_flames.getFxImage()));
                            break;
                        default:
                            stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Loi doc file");
        }
            bomberman = new Bomber(1, 1, Sprite.player_right.getFxImage());
            entities.add(bomberman);
        }
    public static void init() {
        readFromFile();
        canvas = new Canvas(Sprite.SCALED_SIZE*WIDTH,  Sprite.SCALED_SIZE*HEIGHT);
        gc = canvas.getGraphicsContext2D();

        root = new Group();
        root.getChildren().add(canvas);

        s = new Scene(root);
        Gameloop.start(gc);

        createMap();
        KeyController.attach(s);
    }

    public static Scene getScene() {
        return s;
    }
    public static Bomber getBomber() {
        return bomberman;
    }
    public static List<Entity> getEntities() {
        return entities;
    }
    public static List<Entity> getStillObjects() {
        return stillObjects;
    }
}
