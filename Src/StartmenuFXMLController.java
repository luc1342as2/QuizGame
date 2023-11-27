/** 
 * Lucas Ghigli
 * StartmenuFXMLController.java -> Quiz FX
 * 08/08/2022
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/** FXML Controller class **/
public class StartmenuFXMLController implements Initializable {

    @FXML
    private TextField nametxt; //name of the player.
    @FXML
    private TextField wordtxt; 
    @FXML
    private Button startbtn; //start button.
    static Stage stage2=new Stage(); //it creates a new stage in the stage2.
    static String level; //level of the quiz.
    static String repeat;
    static String filename;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void start_Game(ActionEvent event) {
        if(!nametxt.getText().equals("")){
        if(wordtxt.getText().equals(""))
        {
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Error...");
          alert.setHeaderText("Fill the blank");
          alert.setContentText("kindly input number in range of 1 to 5 ");
          alert.showAndWait(); 
        
        }
        else if(wordtxt.getText().equals("1")){
         try
        {
            level="Easy";
            repeat=level;
             create();
        Stage stage = (Stage) startbtn.getScene().getWindow();
        // do what you have to do
        stage.close();  
        
        FXMLLoader loader=new FXMLLoader(getClass().getResource("GameScreenFXML.fxml"));
        Parent root=loader.load();
        GameScreenFXMLController cont2=loader.getController();
        stage2.setScene(new Scene(root)); //it creates a new scene in stage2.
        stage2.show(); //it shows the stage2.
        stage2.setTitle("Game"); //it sets the title of the stage2 to Game.
        }
        catch(Exception e)
        {
            System.out.println("game"+e.getMessage()); //it prints the following message.
        } 
        
        

        }
        else if (wordtxt.getText().equals("2")){ 
       try
        {
            level="Hard";
            repeat=level;
             create();
       Stage stage = (Stage) startbtn.getScene().getWindow();
        // do what you have to do
        stage.close();  
        FXMLLoader loader=new FXMLLoader(getClass().getResource("GameScreenFXML.fxml"));
        Parent root=loader.load();
        GameScreenFXMLController cont2=loader.getController();
        stage2.setScene(new Scene(root)); //it creates a new scene in stage2.
        stage2.show(); //it shows the stage2.
        stage2.setTitle("Quiz Game"); //it sets the title of the stage2 to Quiz Game.
        
        }
        catch(Exception e)
        {
            System.out.println("error in loadscreen2 method"+e.getMessage());
        } }
        else{
        
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Error...");
          alert.setHeaderText("Input Again");
          alert.setContentText("input again in range[1,2]");
          alert.showAndWait();
        
        }
        }
        else 
        {
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Error...");
          alert.setHeaderText("Fill the blank");
          alert.setContentText("Write your name First");
          alert.showAndWait(); 
        }
        }
       
      
    
    
  
     public  void close(){
           stage2.close();
      
     }
      public static void Level_Repeat(){
       
      level=repeat;
     }
     public static void Level_Easy(){
       
      level="Easy"; //easy mode.
     }
       public static void Level_Hard(){
       
      level="Hard"; //hard mode.
     }
       
     public void create() throws IOException{  
     filename=nametxt.getText()+"filename.txt";    
      File myObj = new File(nametxt.getText()+"filename.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists."); //it prints the following message.
      }
      try {
      FileWriter myWriter = new FileWriter(nametxt.getText()+"filename.txt");
      myWriter.write("Player_Name:"+nametxt.getText()+"  Level Selected="+level+"\n");
      myWriter.close();
      System.out.println("Successfully wrote to the file."); //it prints the following message.
    } catch (IOException e) {
      System.out.println("An error occurred."); //it prints the following message.
      e.printStackTrace();
    }
      
     }
       
       
       
       
}
