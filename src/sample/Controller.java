package sample;
import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.sql.*;
import java.util.concurrent.ThreadLocalRandom;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller  implements Initializable
{
    @FXML
    private ListView<RandomNumber> numberView;
    @FXML
    private TextField minTextField;
    @FXML
    private TextField maxTextField;
    @FXML
    Label finalrandom= new Label();
    @FXML
    JFXButton runbutton;
    @FXML
    JFXButton loadbutton;
    @FXML
    JFXListView materialListView;


    final String DB_URL = "jdbc:derby:NumberDB;create=true";
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        ObservableList<RandomNumber> items = numberView.getItems();

        runbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int randomInt = ThreadLocalRandom.current().nextInt(Integer.parseInt(minTextField.getText()), Integer.parseInt(maxTextField.getText())); //https://codippa.com/how-to-generate-a-random-number-with-in-a-range-in-java/
                finalrandom.setText(Integer.toString(randomInt));
                System.out.print(randomInt);

                RandomNumber rando1= new RandomNumber();
                rando1.setRandnum(randomInt);
                items.add(rando1);


            }
        });
        loadbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Connection conn = DriverManager.getConnection(DB_URL);
                    Statement stmt = conn.createStatement();
                    String sqlStatement = "SELECT * FROM RandomNumber";
                    ResultSet result = stmt.executeQuery(sqlStatement);
                    ObservableList<RandomNumber> dbNumList = FXCollections.observableArrayList();
                    while (result.next())
                    {
                        RandomNumber loadrando= new RandomNumber();
                        loadrando.randnum = result.getInt("Randnum");

                        dbNumList.add(loadrando);
                    }
                    materialListView.setItems(dbNumList);

                    System.out.println("DATA LOADED");

                    stmt.close();
                    conn.close();
                } catch (Exception ex) {
                    var msg = ex.getMessage();
                    System.out.println("DATA NOT LOADED");
                    System.out.println(msg);
                }

            }
        });

    }
}
