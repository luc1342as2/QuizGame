/** 
 * Lucas Ghigli
 * PromptScreenFXMLController.java -> Quiz FX
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
public class PromptScreenFXMLController implements Initializable {

    @FXML
    private Label lbltxt; //it creates the label.
    @FXML
    private Button yesbtn; //it creates the YES button.
    @FXML
    private Button no_Btn; //it creates the NO button.
    static Stage stage2=new Stage(); //it creates a new stage in stage2.
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       lbltxt.setText("You’re currently halfway done with "+GameScreenFXMLController.a+" points at this rate you \n will not finish the test with 100 points  would you like to\n change the diffculty of questions to earn more? ");
    }    

    @FXML
    private void yesbtn_M(ActionEvent event) throws IOException {
        Stage stage = (Stage) no_Btn.getScene().getWindow();
        // do what you have to do
        stage.close();  
        StartmenuFXMLController game_obj= new StartmenuFXMLController();
        game_obj.close();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Different_DifficultyFXML.fxml"));
        Parent root=loader.load();
        Different_DifficultyFXMLController cont2=loader.getController();
        stage2.setScene(new Scene(root)); //it creates a new scene in the stage2.
        stage2.show(); //it shows the stage2.
        stage2.setTitle("Game"); //it sets the title in the stage2 to Game.
    }

    @FXML
    private void noBtn_M(ActionEvent event) {
       Stage stage = (Stage) no_Btn.getScene().getWindow();
        // do what you have to do
        stage.close();   
        
    }
    
}
