/** 
 * Lucas Ghigli
 * App.java -> Quiz FX
 * 08/08/2022
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** App program **/
public class App extends Application 
{

@Override
public void start(Stage stage) throws Exception
{
    Parent root = FXMLLoader.load(getClass().getResource("StartmenuFXML.fxml"));
    Scene scene = new Scene(root); //creates a new scene.
    stage.setScene(scene); //set the scene.
    stage.show(); //shows the stage.
}
    public static void main(String[] args) 
    {
        launch(args); //it runs the program.
    }
}
