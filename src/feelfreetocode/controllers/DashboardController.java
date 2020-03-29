package feelfreetocode.controllers;

import feelfreetocode.models.Case;
import feelfreetocode.models.DataManager;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public BarChart barchart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Case> cases = new DataManager().getData();
        XYChart.Series<String , Integer> series = new XYChart.Series<>();
        for(int i = 0 ; i < cases.size() ; i ++){
            Case cs = cases.get(i);
            series.getData().add(new XYChart.Data<>(cs.getState() , cs.getTotalConfirmed()));

        }

        barchart.getData().add(series);
    }
}
