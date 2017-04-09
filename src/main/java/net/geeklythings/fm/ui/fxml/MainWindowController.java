package net.geeklythings.fm.ui.fxml;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MainWindowController implements Initializable {
    
    public static Stage primaryStage;
    @FXML private Label label;
    @FXML private Window loadTournamentDialog;
    @FXML private LoadTournamentDialogController loadTournamentDialogController;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    private void loadTournament(ActionEvent event) {
        loadTournamentDialogController = new LoadTournamentDialogController();
        try {
                loadTournamentDialogController.showDialog(primaryStage);
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
}
