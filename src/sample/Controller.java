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



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        ObservableList<RandomNumber> items = numberView.getItems();
        runbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int randomInt = ThreadLocalRandom.current().nextInt(Integer.parseInt(minTextField.getText()), Integer.parseInt(maxTextField.getText()));
                finalrandom.setText(Integer.toString(randomInt));
                RandomNumber rando1= new RandomNumber(randomInt);
                items.add(rando1);


            }
        });
        loadbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });

    }
}
