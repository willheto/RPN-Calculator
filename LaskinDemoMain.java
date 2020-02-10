package laskin;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


/**
 * @author henri
 * @version 25.1.2020
 * Pääohjelma yksinkertaiselle RPN-Laskimelle
 */
public class LaskinDemoMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("LaskinDemoGUIView.fxml"));
            final Pane root = ldr.load();
            //final LaskinDemoGUIController laskindemoCtrl = (LaskinDemoGUIController) ldr.getController();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("laskindemo.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("laskinDemo");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args Ei k�yt�ss�
     */
    public static void main(String[] args) {
        launch(args);
    }
}