/** 
 * Lucas Ghigli
 * Different_DifficultyFXMLController.java -> Quiz FX
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
import javafx.stage.Stage;

/** FXML Controller class **/
public class Different_DifficultyFXMLController implements Initializable {

    @FXML
    private Button easy_btn; //button for the easy mode.
    @FXML
    private Button hard_Btn; //button for the hard mode.
    static String level;
    static String repeat;
  static Stage stage2=new Stage(); //it creates a new stage in stage2.
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void easy_M(ActionEvent event) throws IOException {
        StartmenuFXMLController.Level_Easy();
        level = "Easy";
        Stage stage = (Stage) hard_Btn.getScene().getWindow();
        stage.close(); 
        FXMLLoader loader=new FXMLLoader(getClass().getResource("GameScreenFXML2.fxml"));
        Parent root=loader.load();
        GameScreenFXMLController2 cont2=loader.getController();
        stage2.setScene(new Scene(root)); //it creates a new scene for stage2.
        stage2.show(); //shows the stage2.
        stage2.setTitle("Game"); //title of the game in stage2.
        
    }

   

    @FXML
    private void hard_M(ActionEvent event) throws IOException {
        StartmenuFXMLController.Level_Hard();
        level = "Hard";
        Stage stage = (Stage) hard_Btn.getScene().getWindow();
        stage.close(); 
        FXMLLoader loader=new FXMLLoader(getClass().getResource("GameScreenFXML2.fxml"));
        Parent root=loader.load();
        GameScreenFXMLController2 cont2=loader.getController();
        stage2.setScene(new Scene(root)); //it creates a new scene for stage2.
        stage2.show(); //shows the stage2.
        stage2.setTitle("Game"); //title of the game in stage2.
        
    }
    
    public static void Level_Repeat(){
       
        level=repeat;
       }
       public static void Level_Easy(){
         
        level="Easy"; //easy mode level.
       }
         public static void Level_Hard(){
         
        level="Hard"; //hard mode level.
       }


}
