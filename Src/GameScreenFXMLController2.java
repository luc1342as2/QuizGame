/** 
 * Lucas Ghigli
 * GameScreenFXMLController2.java -> Quiz FX
 * 08/08/2022
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/** FXML Controller class **/
public class GameScreenFXMLController2 implements Initializable
{
    @FXML
    private Label questionlbl; //question of the quiz.
    @FXML
    private Label option_a_Lbl; //first option.
    @FXML
    private Label option_b_Lbl; //second option.
    @FXML
    private Label option_c_Lbl; //third option.
    @FXML
    private Label option_d_Lbl; //fourth option.
    @FXML
    private Label current_score_Lbl; //current points of the player.
    @FXML
    private Label progress_Lbl; //current progress of the player.
    @FXML
    private Label qslbl;

/** Information about the questions for each mode. **/
    String[] questions_Easy = { //easy mode question.
        "What is the Capital of Canada?",
        "What is the Capital of Mexico?",
        "Where do Penguins Inhabit?",
        "Alaska is owned by which Country?",
        "BBC is a Televison Network in Which Country?",
        "What is the Capital of France?",
        "What is the Capital of Russia?",
        "The Sahara Desert is located in which Continent?",
        "How many States are there in the United States?",
        "What Currency is used in Switzerland?",
        "Who led the Cuban Revolution?",
        "Who led Fascist Italy During WWII?",
        "What company owns WhatsApp?",
        "What is the Average Speed of a Horse?",
        "Who Invented the Tesla Coil?",
        "Morgan Stanley is a Company in what Field?",
        "What is the Capital of Brazil?",
        "The Andes Mountains are in Which Continent?",
        "What Language is Spoken in Australia?",
        "What is the Capital of Germany?",
        "What is the Capital of Italy?",
        "Which Country was a part of the Former Yugoslavia?",
        "What Language is Spoken in Brazil?",
        "Who Company owns Youtube?",
        "Pablo Escobar was a Drug Lord from Which Country?",
        "Barak Obama was the President of which Country?",
        "Miami is a city in which American State?",
        "Dallas is a city in which American State?",
        "Avacado's are typically which Colour?",
        "Mt St. Helen's is a Volocano Located in which State?",
        "What is the Capital of Alberta?",
        "What Language is Spoken in Haiti?",
        "Fedex is operating in which Industry?",
        "The Capital of New Zealand is?",
        "Greenland is owned by which Nation?",
        "Which Country borders the Caspian Sea?",
        "Which Country has Pandas?",
        "The Capital of Nova Scoita is?",
        "Which American State borders Canada?",
        "Who was the First President of the United States?",
        "The Trade Network that Connected Europe and Asia was Called…?",
        "Augustas Caesar was Emporer of?",
        "How many Terriorties are there is Canada?",
        "Joseph Stalin was from which Country?",
        "Perth is located in which Country?",
        "The term Viet Cong refer to?",
        "Kit-Kat is a type of?",
        "Napoleon is a Historical Figure from which Nation?",
        "Peter the Great is a Historical Figure from which Nation?"
    };

    
String[] questions_Hard = { //hard mode question.
        "Who is the Current President of Turkmenistan?",
       "What Country owns Christmas Island?",
       "Where is Sarawak Island?",
       "The Russian's and Japanese have disputes over which Islands?",
       "North Sentinel Island is apart of which Island Chain?",
       "Chetumal is a city in which country?",
       "Kingstown is the Capital of which country?",
       "What is Chad's top export?",
       "What is the top export of Paraguay?",
       "Which Country made Bitcoin their National Currency?",
       "Which Island was Napolean sent for exile?",
       "Conakry is the Capital of which Country?",
       "What is the National Animal of Rwanda?",
       "Which Country has the most Languages in the World?",
       "Which Country was accused of running a Corruption Racket  dubbed 'The Bro Economy'",
       "Which US State has the highest percentage of forest?",
       "What is the most populated state in Brazil?",
       "Which Country has the most Nobel Laureates?",
       "Which Country has the worst fixed Broadband Download Speed?",
       "The Dragon Blood Tree is native to what Island?", 
       "Which Island was Napolean sent for exile?",
       "Conakry is the Capital of which Country?",
       "What is the National Animal of Rwanda?",
       "Which Country has the most Languages in the World?",
       "Which Country was accused of running a Corruption Racket  dubbed 'The Bro Economy'",
       "Which US State has the highest percentage of forest?",
       "What is the most populated state in Brazil?",
       "Which Country has the most Nobel Laureates?",
       "Which Country has the worst fixed Broadband Download Speed?",
       "The Dragon Blood Tree is native to what Island?",
       "Ustyurt National Preserve is Located in which Country?",
       "The City of Ordu is located in which Country?",
       "What is the Second Largest City by Population in Tunisia?",
       "Which Country has the Lowest Recidivism Rate?",
       "Which Country is Exempt from VISA restrictions in Equatorial Guinea?",
       "Teodoro Obiang Nguema Mbasogo has been the leader of Equatorial Guinea Since?",
       "What year did Mexico stop allowing Brazilians to visit VISA free?",
       "What's the 5th Largest city in Japan by population?",
       "The Gibson Desert Nature Reserve is located in which Country?",
       "Which Island was famously populated by mutineers from the HMS Bounty?",
       "The Sampoong Department Store Collapse Occurred in Which City?",
       "Who got to the South Pole First?",
       "The Hawaiian Islands has how many islands?",
       "Skeleton Coast National Park is located in which Country?",
       "What Language is Spoken in New Caledonia?",
       "Freeport Maine is known for their…",
       "The Padma River flows through which Country?",
       "Radom National Park is located in which Country?",
       "Atlanta's International Airport is Named?",
       "Which Country exports the most Lemons?",
       "What is Uganda's main export?",
       "Sucre is a City Located in Which Country?",
       "The Kon-Tiki Expedition in 1947 set sail from which Country?",
       "Which Country exports the most Almonds?",
       "The Great Toyota War ended in what year?",
       "Which Mexican Region does not border the Ocean?",
       "Palma is a city in what Country?",
       "Mbabane is a city in what Country?",
       "Ottawa National Forest belongs to which US State?"
    };
/**  Information of the different options for each mode. **/
String [][] options_Easy =  { //multiple choices easy mode.
        {"Ottawa", "Washington", "Winnipeg", "Toronto"},
        {"Tijuana", "Havana", "Mexico City", "Cancun"},
        {"Nigeria", "Antarctica", "Iceland", "Greenland"},
        {"United States", "Russia", "Canada", "United Kingdom"},
        {"Canada", "Australia", "New Zealand", "United Kingdom"},
        {"Paris", "Madrid", "Leon", "Dijon"},
        {"St. Petersburg", "Moscow", "Kazan", "Minsk"},
        {"Australia", "Africa", "North America", "South America"},
        {"45", "52", "48", "50"},
        {"Swiss Franc", "Euro", "Pound Sterling", "Lira"},
        {"Fidel Castro", "Italo Calvino", "Raul Castro", "Che Guevara"},
        {"Matteo Ranzi", "Benito Mussolini", "Marco Polo", "Antonio Meucci"},
        {"Amazon", "Apple", "Meta Platforms", "Google"},
        {"25km/h", "20km/h", "30km/h", "40km/h"},
        {"Thomas Edison", "Elon Musk", "Nikola Tesla", "Trevor Milton"},
        {"Finance", "Manufacturing", "Shipping & Freight", "Marketing"},
        {"Rio de Janeiro", "Sao Paulo", "Brasilia", "Belem"},
        {"South America", "North America", "Europe", "Asia"},
        {"German", "English", "Spanish", "French"},
        {"Hamburg", "Berlin", "Nuremburg", "Vienna"},
        {"Venice", "Milan", "Genoa", "Rome"},
        {"Greece", "Bulgaria", "Romania", "Serbia"},
        {"Portuguese", "English", "Spanish", "French"},
        {"Apple", "Meta Platforms", "Google", "Amazon"},
        {"Ecuador", "Venezuela", "Colombia", "Peru"},
        {"United States", "United Kingdom", "Australia", "Kenya"},
        {"Georiga", "Alabama", "Texas", "Florida"},
        {"New Mexico", "Texas", "North Carolina", "South Carolina"},
        {"Green", "Yellow", "Red", "Blue"},
        {"Idaho", "Oregon", "Washington", "Montana"},
        {"Calgary", "Vancouver", "Edmonton", "Regina"},
        {"English", "French", "Spanish", "Portuguese"},
        {"Shipping", "Manufacturing", "Finance", "Marketing"},
        {"Christchurch", "Canberra", "Auckland", "Wellington"},
        {"Canada", "Denmark", "United States", "Norway"},
        {"Iraq", "Uzbekistan", "Turkmenistan", "Georgia"},
        {"China", "Sri Lanka", "India", "Oman"},
        {"Moncton", "Saint John", "Halifax", "Fredericton"},
        {"Massachusetts", "Delaware", "New Jersey", "Vermont"},
        {"Thomas Jefferson", "Abraham Lincoln", "Grover Cleveland", "George Washington"},
        {"The Silk Road", "The Main Road", "The Right Road", "The Long Road"},
        {"Carthage", "Gaul", "Rome", "Iberia"},
        {"4", "3", "1", "2"},
        {"Russia", "Georgia", "Belarus", "Ukraine"},
        {"Fiji", "New Zealand", "Australia", "Malaysia"},
        {"South Vietnamese", "Cambodians", "Thai", "North Vietnamese"},
        {"Gummy Bear", "Chocolate Bar", "Fruit", "Hard Candy"},
        {"France", "Spain", "England", "Germany"},
        {"Germany", "Austria", "France", "Russia"},
    };

       
String [][] options_Hard = { //multiple choices hard mode.
       {"Serdar Berdimuhamedow", "Saparmurat Niyazov", "Ogulgerek Berdimuhamedova", "Myalikguly Berdimuhamedov"},
       {"Australia", "Indonesia", "Timor-Leste", "Papua New Guinea"},
       {"Philippines","Indonesia","Brunei","Malaysia"},
       {"Rebun Islands","Okinawa Islands","Kuril Islands","Chastye Islands"},
       {"Andaman & Nicobar Islands","Comoros Islands","Caroline Isalnds","Kerguelen Islands"},
       {"Belize", "Mexico", "Guatemala", "Honduras"},
       {"Grenada", "St.Lucia", "St. Vincent and the Grenadines", "Barbados"},
       {"Fertilizer", "Cotton", "Cattle", "Petroleum"},
       {"Cereals", "Bananas", "Seed oil", "Cattle"},
       {"Panama", "El Salvador", "Costa Rica", "Nicaragua"},
       {"São Tomé", "Nova Cuba", "Ascension Island", "St Helena"},
       {"Liberia", "The Gambia", "Western Guinea", "Senegal"},
       {"Leopard", "Lion", "Baboon", "Chimpanzee"},
       {"Indonesia", "Papua New Guinea", "French Polyenisa", "Solomon Islands"},
       {"Brazil", "Chad", "Maldives", "Greece"},
       {"New Hampshire", "Maine", "Montana", "Minnesota"},
       {"State of São Paulo", "State of Rio de Janeiro", "State of Mato Grosso", "State of Goiás"},
       {"Germany", "United States", "Japan", "United Kingdom"},
       {"Yemen", "Cuba", "Malawi", "Turkmenistan"},
       {"Galapagos", "Heard Island", "Socotra", "Fiji"}, 
       {"São Tomé", "Nova Cuba", "Ascension Island", "St Helena"},
       {"Liberia", "The Gambia", "Western Guinea", "Senegal"},
       {"Leopard", "Lion", "Baboon", "Chimpanzee"},
       {"Indonesia", "Papua New Guinea", "French Polyenisa", "Solomon Islands"},
       {"Brazil", "Chad", "Maldives", "Greece"},
       {"New Hampshire", "Maine", "Montana", "Minnesota"},
       {"State of São Paulo", "State of Rio de Janeiro", "State of Mato Grosso", "State of Goiás"},
       {"Germany", "United States", "Japan", "United Kingdom"},
       {"Yemen", "Cuba", "Malawi", "Turkmenistan"},
       {"Galapagos", "Heard Island", "Socotra", "Fiji"},
       {"Kazakhstan", "Uzbekistan", "Azerbaijan", "Turkmenistan"},
       {"Greece", "Lebanon", "Turkey", "Iraq"},
       {"Sousse", "Sfax", "Tunis", "Bizerte"},
       {"Sweden", "Finland", "Denmark", "Norway"},
       {"United Kingdom", "Camaroon", "United States", "Nigeria"},
       {"1979", "1973", "1981", "1987"},
       {"2019", "2021", "2013", "2020"},
       {"Kobe", "Osaka", "Sapporo", "Kyoto"},
       {"South Africa", "United States", "Israel", "Australia"},
       {"Cook Island", "Pitcairn Island", "Bora-Bora", "Amuri"},
       {"Seoul", "Manila", "Tokyo", "Hong Kong"},
       {"Ernest Shakleton", "Roald Amunsen", "Jules Dumont", "James Clark Ross"},
       {"86", "101", "137", "156"},
       {"Nambia", "South Africa", "Angola", "Mozambique"},
       {"English", "Spanish", "Portuguese", "French"},
       {"Lobster", "Dunes", "Crab", "Caves"},
       {"China", "Myanmar", "Malysia", "Bangladesh"},
       {"Chad", "South Sudan", "Central African Republic", "Sudan"},
       {"O'Hare", "Harry Reid", "Hartsfield-Jackson", "Logan"},
       {"Spain", "United States", "Mexico", "South Africa"},
       {"Tea", "Cattle", "Coffee", "Fish"},
       {"Peru", "Paraguay", "Chile", "Boliva"},
       {"Chile", "Peru", "Ecuador", "Panama"},
       {"United States", "China", "Mexico", "Chile"},
       {"1992", "1987", "1990", "1985"},
       {"Oxaca", "Tabasco", "Durango", "Sinaloa"},
       {"Italy", "Malta", "France", "Spain"},
       {"Eswatini", "Lesotho", "South Africa", "Mozambique"},
       {"Michigan", "Minnesota", "Wisconsin", "New York"}
     };
/** Information of the answers for each mode. **/
char[] answers_Easy =   { //answers of the easy mode.
    'A',
    'C',
    'B',
    'A',
    'D',
    'A',
    'B',
    'B',
    'D',
    'A',
    'A',
    'B',
    'C',
    'D',
    'C',
    'A',
    'C',
    'A',
    'B',
    'B',
    'D',
    'D',
    'A',
    'C',
    'C',
    'A',
    'D',
    'B',
    'A',
    'C',
    'C',
    'B',
    'A',
    'D',
    'B',
    'C',
    'A',
    'C',
    'D',
    'D',
    'A',
    'C',
    'B',
    'B',
    'C',
    'D',
    'B',
    'A',
    'D',
};
  
char[] answers_Hard =   { //answers of the hard mode.
       'A',
       'A',
       'D',
       'C',
       'A',
       'B',
       'C',
       'D',
       'C',
       'B',
       'D',
       'C',
       'A',
       'B',
       'C',
       'B',
       'A',
       'B',
       'D',
       'C',
       'D',
       'C',
       'A',
       'B',
       'C',
       'B',
       'A',
       'B',
       'D',
       'C',
       'A',
       'C',
       'B',
       'D',
       'C',
       'A',
       'B',
       'C',
       'D',
       'B',
       'A',
       'B',
       'C',
       'A',
       'D',
       'B',
       'D',
       'B',
       'C',
       'A',
       'C',
       'D',
       'B',
       'A',
       'B',
       'C',
       'D',
       'A',
       'C'
   }; 

    char guess; //guess of the player.
    char answer; //answer to each question.
    int result; //result of the question.
    int index = 0;
    int CGusses = GameScreenFXMLController.a;
    int count = 10;
    int TQuestions_Easy = questions_Easy.length; //size of the easy mode questions.
    int TQuestions_Hard = questions_Hard.length; //size of the hard mode questions.
    int qn = 9;
    
    static Stage stage2=new Stage(); //it creates a new stage in stage2.
    static int a,b;
    static String c;
    @FXML
    private Button btna; //button
    @FXML
    private Label notification_Lbl;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            nextQuestion();
        } catch (IOException ex) {
            Logger.getLogger(GameScreenFXMLController2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void optionA_Btn(ActionEvent event) throws InterruptedException, IOException {
        
        answer = 'A';
        if(Different_DifficultyFXMLController.level=="Easy"){ //easy mode.
        if(answer==answers_Easy[index])
            {
                CGusses+=5;
            }
            else
            {
                CGusses-=5;
                 answer_Check();
            }
            count++;
            qn++;
            nextQuestion();
            check();
            notification();
        
        
        }

        else if(Different_DifficultyFXMLController.level=="Hard"){ //hard mode.
         if(answer==answers_Hard[index])
            {
                CGusses+=10;
            }
            else
            {
                CGusses-=10;
                answer_Check();
            }
            count++;
            qn++;
            nextQuestion();
            check();
            notification();
        }
        else{
            System.out.println("restart quiz "); //it prints the following message.
        
        }
            
    }

    @FXML
    private void optionB_Btn(ActionEvent event) throws InterruptedException, IOException {
        answer = 'B';
             if(Different_DifficultyFXMLController.level=="Easy"){ //easy mode.
        if(answer==answers_Easy[index])
            {
                CGusses+=5;
            }
            else
            {
                CGusses-=5;
                 answer_Check();
            }
            count++;
            qn++;
            nextQuestion();
            check();
            notification();
        
        
        }
       
        else if(Different_DifficultyFXMLController.level=="Hard"){ //hard mode.
         if(answer==answers_Hard[index])
            {
                CGusses+=10;
            }
            else
            {
                CGusses-=10;
                 answer_Check();
            }
            count++;
            qn++;
            nextQuestion();
            check();
            notification();
        }
        else{
            System.out.println("restart quiz "); //it prints the following message.
        
        }
    }

    @FXML
    private void optionC_Btn(ActionEvent event) throws InterruptedException, IOException {
        answer = 'C';
            if(Different_DifficultyFXMLController.level=="Easy"){ //easy mode
        if(answer==answers_Easy[index])
            {
                CGusses+=5;
            }
            else
            {
                CGusses-=5;
                 answer_Check();
            }
            count++;
            qn++;
            nextQuestion();
            check();
            notification();
        
        
        }
        
        else if(Different_DifficultyFXMLController.level=="Hard"){ //hard mode.
         if(answer==answers_Hard[index])
            {
                CGusses+=10;
            }
            else
            {
                CGusses-=10;
                 answer_Check();
            }
            count++;
            qn++;
            nextQuestion();
            check();
            notification();
        }
        else{
            System.out.println("restart quiz "); //it prints the following message.
        
        }
    }

    @FXML
    private void optionD_Btn(ActionEvent event) throws InterruptedException, IOException {
        answer = 'D';
           if(Different_DifficultyFXMLController.level=="Easy"){ //easy mode.
        if(answer==answers_Easy[index])
            {
                CGusses+=5;
            }
            else
            {
                CGusses-=5;
                 answer_Check();
            }
            count++;
            qn++;
            nextQuestion();
            check();
            notification();
        
        
        }
       
        else if(Different_DifficultyFXMLController.level=="Hard"){ //hard mode.
         if(answer==answers_Hard[index])
            {
                CGusses+=10;
            }
            else
            {
                CGusses-=10;
                answer_Check();
            }
            count++;
            qn++;
            nextQuestion();
            check();
            notification();
        }
        else{
            System.out.println("restart quiz "); //it prints the following message.
        
        }
    }

    Random rand = new Random();
    int n = rand.nextInt(49);

     public void nextQuestion() throws IOException
    {
    
        int n = rand.nextInt(49); 
        index = n;
    
        

        if(count>=20)
        { 
            results(); 
        }
/** Information about the easy mode. **/
        else
        { if(Different_DifficultyFXMLController.level=="Easy"){ //easy mode quiz.
            questionlbl.setText("Question "+(qn+1));
            qslbl.setText(questions_Easy[n]);
            option_a_Lbl.setText(options_Easy[n][0]);
            option_b_Lbl.setText(options_Easy[n][1]);
            option_c_Lbl.setText(options_Easy[n][2]);
            option_d_Lbl.setText(options_Easy[n][3]);
            current_score_Lbl.setText("Current Points: "+CGusses+"/100"); //it keeps track of the points of the player.
            progress_Lbl.setText("Progress: "+(qn+1)+"/20"); //it keeps track of the progress of the player.
            n++;
        
        
        }
/** Information about the easy mode. **/        
        else if(Different_DifficultyFXMLController.level=="Hard"){ //hard mode quiz.
           questionlbl.setText("Question "+(qn+1));
            qslbl.setText(questions_Hard[n]);
            option_a_Lbl.setText(options_Hard[n][0]);
            option_b_Lbl.setText(options_Hard[n][1]);
            option_c_Lbl.setText(options_Hard[n][2]);
            option_d_Lbl.setText(options_Hard[n][3]);
            current_score_Lbl.setText("Current Points: "+CGusses+"/100"); //it keeps track of the points of the player.
            progress_Lbl.setText("Progress: "+(qn+1)+"/20"); //it keeps track of the progress of the player.
            n++;
        }
        else{
            System.out.println("restart quiz "); //it prints the following message.
        
        }
        }    
    }
    

    public void results() throws IOException
    {
        StartmenuFXMLController obj = new StartmenuFXMLController();
        obj.close();
         b=CGusses;
        if(CGusses<=50){
           FXMLLoader loader=new FXMLLoader(getClass().getResource("loseScreenFXML.fxml"));
        Parent root=loader.load();
        LoseScreenFXMLController cont2=loader.getController();
        stage2.setScene(new Scene(root)); //it creates a new scene in the stage2.
        stage2.show(); //it shows the stage2.
        stage2.setTitle("Lose Screen"); //it sets the title in the stage2 to Lose Screen.
        
        }
        else
        {  
        c="Yes";
         FXMLLoader loader=new FXMLLoader(getClass().getResource("winScreenFXML.fxml"));
        Parent root=loader.load();
        WinScreenFXMLController cont2=loader.getController();
        stage2.setScene(new Scene(root)); //it creates a new scene in the stage2.
        stage2.show(); //it shows the stage2.
        stage2.setTitle("Win Screen"); //it sets the title in the stage2 to Win Screen.
        
        }
          
     
         
    }
     public void check() throws InterruptedException, IOException{
     
     if(count==9){
      a=CGusses;
     FXMLLoader loader=new FXMLLoader(getClass().getResource("promptScreenFXML.fxml"));
        Parent root=loader.load();
        PromptScreenFXMLController cont2=loader.getController();
        stage2.setScene(new Scene(root)); //it creates a new scene in the stage2.
        stage2.show(); //it shows the stage2.
        stage2.setTitle("Game"); //it sets the title in the stage2 to Game.
     }
     
     }
/** Information about the answers for each mode. **/
    public void answer_Check() throws IOException{
        if(StartmenuFXMLController.level=="Easy"){ //right answer for easy mode.
       
         BufferedWriter out = new BufferedWriter(new FileWriter(StartmenuFXMLController.filename, true));
  
          out.write(questions_Easy[index]+" WRONG!"+"\n"+"  It's Correct Ans:"+answers_Easy[index]+"\n");
          out.close();
       
        
        
        }
        
        else if(StartmenuFXMLController.level=="Hard"){ //right answer for hard mode.
         
          BufferedWriter out = new BufferedWriter(new FileWriter(StartmenuFXMLController.filename, true));
  
          out.write(questions_Hard[index]+" WRONG!"+"\n"+"  It's Correct Ans:"+answers_Hard[index]+"\n");
          out.close();
          
          }
    }
   public void close(){
   stage2.close();
   }
   public void notification(){
   if(CGusses>=0||40<=CGusses)
   {
   notification_Lbl.setText("You are not really prepared to re-do the quiz."); //it prints the following message if you are in the 0%-40% score. 
   }
   if(CGusses>=50||80<=CGusses)
   {
   notification_Lbl.setText("You are doing good, you can do better than this."); //it prints the following message if you are in the 50%-80% score.
   }
   if(CGusses>=90||100<=CGusses)
   {
   notification_Lbl.setText("You are really good. Keep up the good work."); //it prints the following message if you are in the 90%-100% score.
   }
   
   }
} 

