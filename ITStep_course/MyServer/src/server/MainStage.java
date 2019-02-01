/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Vilda-PC
 */
public class MainStage extends Stage {

    public void start(Stage primaryStage) throws Exception {
        new MainStage();

    }

    MainStage() {

        this.setTitle("Client");
        final ToggleGroup tg = new ToggleGroup();

        Label headline = new Label();
        headline.setText("Welcome to DB client");

        Label headline2 = new Label();
        headline2.setText("Choose DB to get data from");

        RadioButton rbAll = new RadioButton("All");
        rbAll.setSelected(true);
        rbAll.setToggleGroup(tg);

        RadioButton rbCinemas = new RadioButton("Cinemas");
        rbCinemas.setToggleGroup(tg);

        RadioButton rbMovies = new RadioButton("Movies");
        rbMovies.setToggleGroup(tg);

        RadioButton rbScreenTimes = new RadioButton("Screen Times");
        rbScreenTimes.setToggleGroup(tg);

        Label headline3 = new Label();
        headline3.setText("Choose action");

        Button getAll = new Button("GetAll");
        getAll.setText("Get all data from DB");
        getAll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //      BUTTON LOGIC
            }
        });

        Button search = new Button("Search");
        search.setText("Search");

        TextField searchInput = new TextField();

        Label searchLabel = new Label("searchLabel");
        searchLabel.setText("input String to search");
        //searchLabel.setTextFill(Color.RED);

        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(0, 10, 0, 10));

        root.add(headline, 1, 0); //column 2, row 0
        root.add(headline2, 1, 1, 2, 1);
        root.add(rbAll, 0, 2);
        root.add(rbCinemas, 1, 2);
        root.add(rbMovies, 2, 2);
        root.add(rbScreenTimes, 3, 2);

        root.add(headline3, 1, 3); //column 2, row 3
        root.add(getAll, 0, 4); //column 1, row 1

        root.add(searchLabel, 0, 5);
        root.add(searchInput, 1, 5);
        root.add(search, 2, 5); //column 1, row3

        this.setScene(new Scene(root, 500, 250));
        this.show();

    }

}
