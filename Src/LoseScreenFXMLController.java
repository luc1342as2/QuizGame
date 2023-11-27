/** 
 * Lucas Ghigli
 * LoseScreenFXMLController.java -> Quiz FX
 * 08/08/2022
 */

 
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/** FXML Controller class **/
public class LoseScreenFXMLController implements Initializable {

    @FXML
    private Button yes_Restart_btn; //this creates the restart button.
    @FXML
    private Button yes_different_Btn; //this creates the different option button.
    @FXML
    private Button no_Continue_Btn; //this creates the button that asks to continue the quiz.
    @FXML
    private Label loseLbl;
    static Stage stage2=new Stage(); //it creates a new stage in the stage2.
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      loseLbl.setText("Sadly you didn’t reach 100 but you still got "+GameScreenFXMLController.b+"/100\n would you like to try again?");
    }    

    @FXML
    private void yes_Restart_M(ActionEvent event) throws IOException {
        StartmenuFXMLController.Level_Repeat();
        Stage stage = (Stage) no_Continue_Btn.getScene().getWindow();
        stage.close(); 
        FXMLLoader loader=new FXMLLoader(getClass().getResource("GameScreenFXML.fxml"));
        Parent root=loader.load();
        GameScreenFXMLController cont2=loader.getController();
        stage2.setScene(new Scene(root)); //it creates a new scene in the stage2.
        stage2.show(); //it shows the stage2.
        stage2.setTitle("Game"); //it sets the title in the stage2 to Game.
    }

    @FXML
    private void yes_different_M(ActionEvent event) throws IOException {
        Stage stage = (Stage) no_Continue_Btn.getScene().getWindow();
        stage.close();  
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Different_DifficultyFXML.fxml"));
        Parent root=loader.load();
        Different_DifficultyFXMLController cont2=loader.getController();
        stage2.setScene(new Scene(root)); //it creates a new scene in the stage2.
        stage2.show(); //it shows the stage2.
        stage2.setTitle("Game"); //it sets the title in the stage2 to Game.
    }

    @FXML
    private void no_Continue_M(ActionEvent event) {
        Stage stage = (Stage) no_Continue_Btn.getScene().getWindow();
        stage.close(); 
       System.exit(0);
    }
    public void close(){
    
    
    }
}
