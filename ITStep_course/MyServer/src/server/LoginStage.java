/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Vilda-PC
 */
public class LoginStage extends Stage {
    
    

    LoginStage(MainStage mainStage) {
        
        ClientLogic cl = new ClientLogic(this, mainStage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Label serverAdress = new Label("Server Adress");
        grid.add(serverAdress, 0, 3);

        TextField serAdr = new TextField();
        grid.add(serAdr, 1, 3);

        Label port = new Label("Enter port #");
        grid.add(port, 0, 4);

        TextField portText = new TextField();
        grid.add(portText, 1, 4);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 5);

        final Text actiontarget = new Text();
        actiontarget.setId("label");
        grid.add(actiontarget, 1, 6);

        btn.setOnAction((ActionEvent e) -> {
            try {
                cl.login("localhost", 65535, userTextField.getText(), pwBox.getText(), actiontarget);
            } catch (IOException ex) {
                Logger.getLogger(LoginStage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Scene scene = new Scene(grid, 300, 275);

        this.setScene(scene);
        this.show();

    }

}
