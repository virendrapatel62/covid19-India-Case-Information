package feelfreetocode.controllers;

import feelfreetocode.models.Case;
import feelfreetocode.models.DataManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public BarChart barchart;
    public ChoiceBox choicebox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addChoice();
        new DataManager().getData().addListener(new ListChangeListener<Case>() {
            @Override
            public void onChanged(Change<? extends Case> c) {
                loadChart("Confirmed");
            }
        });

    }

    private void loadChart(String valueType){
        this.barchart.getData().clear();
        ObservableList<Case> cases = new DataManager().getData();
        XYChart.Series<String , Integer> series = new XYChart.Series<>();
        for(int i = 0 ; i < cases.size() ; i ++){
            Case cs = cases.get(i);
            Integer value = -1;
            if(valueType == "Confirmed")
                value = cs.getTotalConfirmed();
            if(valueType == "Cured")
                value = cs.getCured();
            if(valueType == "Deaths")
                value = cs.getDeaths();
            series.getData().add(new XYChart.Data<>(cs.getState() , value));

        }

        barchart.getData().add(series);
    }

    private void addChoice(){
        this.choicebox.getItems().addAll("Confirmed" , "Cured" , "Deaths");

        this.choicebox.getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener() {
                    @Override
                    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                        String selected = choicebox.getValue().toString();
                        loadChart(selected);
                    }
                });
    }
}
