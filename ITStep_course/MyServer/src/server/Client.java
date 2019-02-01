/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Vilda-PC
 */
public class Client extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainStage mainStage = new MainStage();
        mainStage.hide();
        new LoginStage(mainStage);
        
    }

}
