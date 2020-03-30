package feelfreetocode.controllers;

import com.jfoenix.controls.JFXSpinner;
import feelfreetocode.models.DataCollector;
import feelfreetocode.models.DataManager;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Tab;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public Tab dashboardTab;
    public Tab tableviewTab;
    public Tab piechart;
    public JFXSpinner loading;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            Node node = FXMLLoader.load(getClass().getResource("../fxmls/tableviewfxml.fxml"));
            tableviewTab.setContent(node);


            Node node2 = FXMLLoader.load(getClass().getResource("../fxmls/dashboardFxml.fxml"));
            dashboardTab.setContent(node2);

            Node node3 = FXMLLoader.load(getClass().getResource("../fxmls/pieChartFxml.fxml"));
            piechart.setContent(node3);


            loadDataFromServer();

        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("File Not Found..");
        }
    }

    private void loadDataFromServer(){
        new Thread(new Runnable() {
            @Override
            public void run() {
               try{

                   DataCollector dataCollector = new DataCollector();
                   dataCollector.collectData();

//                   System.out.println(new DataManager().getData());
                   Platform.runLater(new Runnable() {
                       @Override
                       public void run() {
                           loading.setVisible(false);
                       }
                   });

               }catch (Exception ex){
                   ex.printStackTrace();
               }

            }
        }).start();
    }

}
