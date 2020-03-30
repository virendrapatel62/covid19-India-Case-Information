package feelfreetocode.controllers;

import feelfreetocode.models.Case;
import feelfreetocode.models.DataManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PieChartController implements Initializable {
    public PieChart all;
    public PieChart stateWise;
    public ChoiceBox selectValue;
    public ChoiceBox selectState;
    private ArrayList<Case> cases;
    String values[] = new String[]{"Confirmed"  , "Cured" , "Deaths"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cases = new DataManager().getData();
        setSettingsForChoiceBox();
        loadAll(values[0]);
        loadStates(this.cases.get(0));
    }

    private  void setSettingsForChoiceBox(){
        this.selectValue.getItems().addAll(values);
        for(Case c : cases){
            this.selectState.getItems().add(c);
        }

        this.selectState.getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener() {
                    @Override
                    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                        Case c = (Case)selectState.getValue();
                        loadStates(c);
                    }
                });

        this.selectValue.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener() {
                    @Override
                    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                        String value = (String)selectValue.getValue();
                        loadAll(value);
                    }
                });

    }

    private void loadAll(String valueType){
        this.all.getData().clear();

        for(Case cs : cases){

            Integer value = -1;
            if(valueType == "Confirmed")
                value = cs.getTotalConfirmed();
            if(valueType == "Cured")
                value = cs.getCured();
            if(valueType == "Deaths")
                value = cs.getDeaths();

            this.all.getData().add(new PieChart.Data(cs.getState()+"("+value+")" , value));
        }
    }

    private void loadStates(Case c){
        this.stateWise.getData().clear();
        this.stateWise.setTitle("Cases in "+c.getState());
        this.stateWise.getData().add(new PieChart.Data("Deaths("+c.getDeaths()+")" , c.getDeaths()));
        this.stateWise.getData().add(new PieChart.Data("Confirmed("+c.getTotalConfirmed()+")"
                , c.getTotalConfirmed()));
        this.stateWise.getData().add(new PieChart.Data("Cured("+c.getCured()+")" ,
                c.getCured()));
    }

}
