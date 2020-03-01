package sample;
import javafx.application.*;
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
    private TableView<RandomNumber> numberView;

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






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        TableColumn numCol= new TableColumn("Random Numbers");
        numberView.getColumns().addAll(numCol);
        runbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int randomInt = ThreadLocalRandom.current().nextInt(Integer.parseInt(minTextField.getText()), Integer.parseInt(maxTextField.getText()));
                finalrandom.setText(Integer.toString(randomInt));
                numberView.getItems().add(randomInt);

            }
        });
        loadbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });

    }
}
