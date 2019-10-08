/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong_1;

import java.applet.Applet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Jose Pablo Sandoval
 */
public class Pong_1 extends Application {
    int ballCenterX = 10;
    
    int ballCurrentSpeedX = 3;
    int ballCurrentSpeedX1 = 3;
    int ballCenterY = 30;
    int ballCurrentSpeedY = 3;
    int ballCurrentSpeedY1 = 3;
    final int SCENE_TAM_X = 600;
    final int SCENE_TAM_Y = 400;
    final int STICK_WIDTH = 7;
    final int STICK_HEIGHT = 50;
    int stickPosY = (SCENE_TAM_Y - STICK_HEIGHT)/2;
    int stickPosY1 = (SCENE_TAM_Y - STICK_HEIGHT)/2;
    int stick_Current_speed = 0;
    int stick_Current_speed1 = 0;
    int TEXT_SIZE = 24;
    int score = 0;
    int highScore = 0;
    int ballCenterY1 = 30;
    int ballCenterX1 = (int) (SCENE_TAM_X * 0.7);
    
    @Override
    public void start(Stage primaryStage) {
        //URL url = SoundTest.class.getResource("back.wav");
        //AudioClip audio = Applet.newAudioClip(url);
        Pane root = new Pane();
        Scene scene = new Scene(root, SCENE_TAM_X , SCENE_TAM_Y, Color.BLACK);        
        primaryStage.setTitle("Pong");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Circle circleball = new Circle(ballCenterX, ballCenterY, 7, Color.WHITE);
        root.getChildren().add(circleball);    
        Circle circleball1 = new Circle(SCENE_TAM_X * 0.95, ballCenterY, 7, Color.WHITE);
        root.getChildren().add(circleball1);
        Rectangle rectangle = new Rectangle(SCENE_TAM_X * 0.95,stickPosY, STICK_WIDTH, STICK_HEIGHT);
        rectangle.setFill(Color.WHITE);
        
        Rectangle rectangle1 = new Rectangle(SCENE_TAM_X * 0.05,stickPosY, STICK_WIDTH, STICK_HEIGHT);
        rectangle1.setFill(Color.WHITE);
        
        HBox paneScores = new HBox();
        paneScores.setTranslateY(20);
        paneScores.setMinWidth(SCENE_TAM_X);
        paneScores.setAlignment(Pos.CENTER);
        paneScores.setSpacing(50);
        root.getChildren().add(paneScores);
        root.getChildren().add(rectangle);
        root.getChildren().add(rectangle1);
        
        
        HBox paneCurrentScore = new HBox();
        paneCurrentScore.setSpacing(10);
        paneScores.getChildren().add(paneCurrentScore);

        HBox paneHighScore = new HBox();
        paneHighScore.setSpacing(20);
        paneScores.getChildren().add(paneHighScore);
        
        Text textTitleScore = new Text("Jugador 1: ");
        textTitleScore.setFont(Font.font(TEXT_SIZE));
        textTitleScore.setFill(Color.WHITE);

        Text textScore = new Text("0");
        textScore.setFont(Font.font(TEXT_SIZE));
        textScore.setFill(Color.WHITE);
        
        Text textTitleHighScore = new Text("    Jugador 2: ");
        textTitleHighScore.setFont(Font.font(TEXT_SIZE));
        textTitleHighScore.setFill(Color.WHITE);

        Text textHighScore = new Text("0");
        textHighScore.setFont(Font.font(TEXT_SIZE));
        textHighScore.setFill(Color.WHITE);

        paneCurrentScore.getChildren().add(textTitleScore);
        paneCurrentScore.getChildren().add(textScore);
        paneCurrentScore.getChildren().add(textTitleHighScore);
        paneCurrentScore.getChildren().add(textHighScore);
        
        
        
        //aqui esta la linea punteada que divide la pantalla
        for(int i = 0; i < SCENE_TAM_Y; i+=30 ){
            Line line = new Line(SCENE_TAM_X/2, i, SCENE_TAM_X /2, i+10);
            line.setStroke(Color.WHITE);
            line.setStrokeWidth(4);
            root.getChildren().add(line);
            }
        
        
        
        AnimationTimer animationBall;           
        animationBall = new AnimationTimer(){           
            @Override
            public void handle(long now) {
                circleball.setCenterX(ballCenterX);
                circleball.setCenterY(ballCenterY);
                circleball1.setCenterX(ballCenterX1);
                circleball1.setCenterY(ballCenterY1);
                ballCenterX+= ballCurrentSpeedX;
                ballCenterY += ballCurrentSpeedY;
                
                stickPosY += stick_Current_speed;
                stickPosY1 += stick_Current_speed1;
                
                ballCenterX1+= ballCurrentSpeedX1;
                ballCenterY1 += ballCurrentSpeedY1;
                
                if(ballCenterX >= SCENE_TAM_X){
                    ballCurrentSpeedX = -3;
                }
                if(ballCenterX <= 0){
                    ballCurrentSpeedX = 3;
                }
                if(ballCenterY >= SCENE_TAM_Y){
                    ballCurrentSpeedY = -3;
                }
                if(ballCenterY <= 0){
                    ballCurrentSpeedY = 3;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Pong_1.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(ballCenterX1 >= SCENE_TAM_X){
                    ballCurrentSpeedX1 = -3;
                }
                if(ballCenterX1 <= 0){
                    ballCurrentSpeedX1 = 3;
                }
                if(ballCenterY1 >= SCENE_TAM_Y){
                    ballCurrentSpeedY1 = -3;
                }
                if(ballCenterY1 <= 0){
                    ballCurrentSpeedY1 = 3;
                }
                
                if(stickPosY < 0 ){
                    stickPosY = 0;
                }else{
                    if(stickPosY > SCENE_TAM_Y - STICK_HEIGHT){
                        stickPosY = SCENE_TAM_Y - STICK_HEIGHT;
                    }
                }
                
                
                if(stickPosY1 < 0 ){
                    stickPosY1 = 0;
                }else{
                    if(stickPosY1 > SCENE_TAM_Y - STICK_HEIGHT){
                        stickPosY1 = SCENE_TAM_Y - STICK_HEIGHT;
                    }
                }
                rectangle.setY(stickPosY);
                rectangle1.setY(stickPosY1);
                // Primer pelota
                Shape shapeColision = Shape.intersect(circleball, rectangle);
                Shape shapeColision1 = Shape.intersect(circleball, rectangle1);
                boolean colisionVacia = shapeColision.getBoundsInLocal().isEmpty();
                boolean colisionVacia1 = shapeColision1.getBoundsInParent().isEmpty();
                
                if(colisionVacia == false && ballCurrentSpeedX > 0 ){
                    ballCurrentSpeedX = -3;
                    score= score+1;
                    //System.out.println(score);
                    textScore.setText(String.valueOf(score));
                }                
                
                if(colisionVacia1 == false && ballCurrentSpeedX < 0){
                    ballCurrentSpeedX = 3;
                    highScore= highScore+1;              
                    System.out.println(highScore);
                    textHighScore.setText(String.valueOf(highScore));
                }
                
                //Segunda pelota
                Shape shapeColision1_1 = Shape.intersect(circleball1, rectangle);
                Shape shapeColision1_2 = Shape.intersect(circleball1, rectangle1);                
                boolean colisionVacia1_1 = shapeColision1_1.getBoundsInLocal().isEmpty();
                boolean colisionVacia1_2 = shapeColision1_2.getBoundsInParent().isEmpty();
                
                if(colisionVacia1_1 == false && ballCurrentSpeedX > 0 ){
                    ballCurrentSpeedX1 = -3;
                    score++;                    
                    //System.out.println(score);
                    textScore.setText(String.valueOf(score));
                }                
                
                if(colisionVacia1_2 == false && ballCurrentSpeedX < 0){
                    ballCurrentSpeedX1 = 3;
                    highScore++;
                    System.out.println(highScore);
                    textHighScore.setText(String.valueOf(highScore));
                }
                
                if(ballCenterX <= 0 | ballCenterX1 <= 0){
                    System.out.println("ya perdiste");
                }
                if(ballCenterX >= SCENE_TAM_X | ballCenterX1 >= SCENE_TAM_X){
                    System.out.println("Ya perdiste");
                }
                
               
            }
            
        };
        animationBall.start();
        
        
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()){
                case UP:
                    //caundo se pulsa la flecha de arriba
                    stick_Current_speed = -6;
                    break;
                case DOWN:
                    //C uando se úlsa la flecha de abajo
                    stick_Current_speed = 6;
                    break;
                case S:
                    //cuando presionas la letra s
                    stick_Current_speed1 = 6;
                    break;
                case W:
                    // cuando presionas la letra w
                    stick_Current_speed1 = -6;
                    break;
            }
            });
        
        scene.setOnKeyReleased((KeyEvent event) ->{
            stick_Current_speed = 0;
            stick_Current_speed1 = 0;
            });                        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
