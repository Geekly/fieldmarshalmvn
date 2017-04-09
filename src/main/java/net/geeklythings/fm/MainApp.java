package net.geeklythings.fm;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import net.geeklythings.fm.jpa.TournamentJpaController;
import net.geeklythings.fm.managers.TournamentManager;
import net.geeklythings.fm.ui.fxml.MainWindowController;


public class MainApp extends Application {

    private final EntityManagerFactory _emf;
    private TournamentJpaController tournamentJpaController;
    public static TournamentManager tournamentManager;
    
    public MainApp()
    {
        super();
        _emf = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("net.geeklythings.FieldMarshalMySqlPU");
        
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        tournamentJpaController = new TournamentJpaController(_emf);
        tournamentManager = new TournamentManager( tournamentJpaController ); 
        
        Parent root = FXMLLoader.load(getClass().getResource("/resources/fxml/MainWindow.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/resources/styles/Styles.css");
        
        stage.setTitle("Field Marshal Tournament Runner");
        stage.setScene(scene);
        
        MainWindowController.primaryStage = stage;  // to be used later
        
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
