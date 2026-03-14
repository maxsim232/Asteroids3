package com.example.asteroids;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class HelloController {

    @FXML
    private ImageView bg1, bg2, rocket, asteroid1, asteroid2, asteroid3,flame;
    @FXML
    private Group groupRocket;

    private double offset = 0;
    private double asteroid_1_x =  900+Math.random()*300;
    private double asteroid_2_x = 900+Math.random()*300;
    private double asteroid_3_x = 900+Math.random()*300;

    @FXML
    public void initialize() {
        Image background = new Image(getClass().getResourceAsStream("/images/background.jpg"));
        Image imageAsteroid = new Image(getClass().getResourceAsStream("/images/asteroid.png"));
        rocket.setImage(new Image(getClass().getResourceAsStream("/images/rocket.png")));
        flame.setImage(new Image (getClass().getResourceAsStream("/images/flame.png")));

        asteroid1.setImage(imageAsteroid);
        asteroid1.setLayoutY(Math.random()*540);
        asteroid2.setImage(imageAsteroid);
        asteroid2.setLayoutY(Math.random()*540);
        asteroid3.setImage(imageAsteroid);
        asteroid3.setLayoutY(Math.random()*540);
        bg1.setImage(background);
        bg2.setImage(background);
        bg2.setLayoutX(900);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {

                offset -= 1; // offset = offset - 1;
                if (offset <= -900){
                    offset = 0;
                }
asteroid1.setRotate(asteroid_1_x);
                asteroid2.setRotate(asteroid_2_x);
                asteroid3.setRotate(asteroid_3_x);
                asteroid_1_x -= 2;
                 if (asteroid_1_x <=-100){

                     asteroid_1_x = 900 + Math.random()*300;
                     asteroid1.setLayoutY(Math.random()*540 );
                }
                asteroid1.setLayoutX(asteroid_1_x);
                asteroid_2_x -= 2.50;
                if (asteroid_2_x <=-100){
                    asteroid_2_x = 900 + Math.random()*300;
                    asteroid2.setLayoutY(Math.random()*540 );

                }
                asteroid2.setLayoutX(asteroid_2_x);
                asteroid_3_x -= 3;
                if (asteroid_3_x <=-100){
                    asteroid_3_x = 900 + Math.random()*300;
                    asteroid3.setLayoutY(Math.random()*540 );
                }
                asteroid3.setLayoutX(asteroid_3_x);

                bg1.setLayoutX(offset);
                bg2.setLayoutX(offset + 900);

            }
        };
        timer.start();
    }

    public void handleKeyPressed(KeyEvent keyEvent) {

        if (keyEvent.getCode() == KeyCode.UP && groupRocket.getLayoutY() >=0){
            groupRocket.setLayoutY(groupRocket.getLayoutY() - 10);
            groupRocket.setRotate(-15);
        }
        if (keyEvent.getCode() == KeyCode.DOWN && groupRocket.getLayoutY() <=510){
            groupRocket .setLayoutY(groupRocket.getLayoutY() + 10);
            groupRocket.setRotate(15);
        }
    }

    public void handleKeyReleased(KeyEvent keyEvent) {
        groupRocket.setRotate(0);
    }
}