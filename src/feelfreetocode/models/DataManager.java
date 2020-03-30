package feelfreetocode.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class DataManager {
    private static ObservableList<Case> data = FXCollections.observableList(new ArrayList<>());


    public static ObservableList<Case> getData() {
        return data;
    }

    public static void setData(ObservableList<Case> data) {
        DataManager.data = data;
    }

    public void append(Case cs){
        data.add(cs);
    }

    public void clear(){
        data.clear();
    }

    public void addAll(ArrayList cases){
        data.addAll(cases);
    }
}
