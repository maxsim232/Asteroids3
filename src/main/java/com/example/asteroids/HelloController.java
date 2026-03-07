package com.example.asteroids;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class HelloController {

    @FXML
    private ImageView bg1, bg2, rocket;

    private double offset = 0;

    @FXML
    public void initialize() {
        Image background = new Image(getClass().getResourceAsStream("/images/background.jpg"));
        rocket.setImage(new Image(getClass().getResourceAsStream("/images/rocket.png")));

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

                bg1.setLayoutX(offset);
                bg2.setLayoutX(offset + 900);

            }
        };
        timer.start();

    }

    public void handleKeyPressed(KeyEvent keyEvent) {

        if (keyEvent.getCode() == KeyCode.UP && rocket.getLayoutY() >=0){
            rocket.setLayoutY(rocket.getLayoutY() - 10);
        }
        if (keyEvent.getCode() == KeyCode.DOWN && rocket.getLayoutY() <=510){
            rocket.setLayoutY(rocket.getLayoutY() + 10);
        }
    }
}