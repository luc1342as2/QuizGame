/** 
 * Lucas Ghigli
 * WinScreenFXMLController.java -> Quiz FX
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
public class WinScreenFXMLController implements Initializable {

    @FXML
    private Button yes_Restart_btn; //it creates a button that restarts the quiz.
    @FXML
    private Button yes_different_Btn; //it creates a button that allows to change the mode.
    @FXML
    private Button no_Continue_Btn; //it creates a button that continues the quiz that the user is in.
    @FXML
    private Label winLbl;
    static Stage stage2=new Stage(); 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    if(GameScreenFXMLController.c=="Yes")
    { 
      winLbl.setText("congratulations you got "+GameScreenFXMLController.b+" points would you like to try again?");
    }    
    else if(GameScreenFXMLController2.c=="Yes")
    {
      winLbl.setText("congratulations you got "+GameScreenFXMLController2.b+" points would you like to try again?");
    }
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
        stage2.setTitle("Game"); //it sets the title of the stage2 to  Game.
    }

    @FXML
    private void yes_different_m(ActionEvent event) throws IOException {
        Stage stage = (Stage) no_Continue_Btn.getScene().getWindow();
        // do what you have to do
        stage.close();  
      FXMLLoader loader=new FXMLLoader(getClass().getResource("Different_DifficultyFXML.fxml"));
        Parent root=loader.load();
        Different_DifficultyFXMLController cont2=loader.getController();
        stage2.setScene(new Scene(root)); //it creates a new scene in the stage2.
        stage2.show(); //it shows the stage2.
        stage2.setTitle("Game"); //it sets the title of the stage2 to  Game.
    }

    @FXML
    private void no_Continue_m(ActionEvent event) {
          Stage stage = (Stage) no_Continue_Btn.getScene().getWindow();
        stage.close(); 
       System.exit(0);
    }
    
}
