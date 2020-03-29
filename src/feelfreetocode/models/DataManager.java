package feelfreetocode.models;

import java.util.ArrayList;

public class DataManager {
    private static ArrayList<Case> data = new ArrayList<Case>();


    public ArrayList<Case> getData() {
        return data;
    }

    public void setData(ArrayList<Case> data) {
        this.data = data;
    }

    public void append(Case cs){
        data.add(cs);
    }

    public void clear(){
        data.clear();
    }
}
