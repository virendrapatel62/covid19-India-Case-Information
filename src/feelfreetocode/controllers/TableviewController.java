package feelfreetocode.controllers;

import feelfreetocode.models.Case;
import feelfreetocode.models.DataManager;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TableviewController implements Initializable {
    public TableView<Case> table;
    public TableColumn<Integer , Case> sno;
    public TableColumn<Integer , Case> state;
    public TableColumn<Integer , Case> totalConfirmed;
    public TableColumn<Integer , Case> cured;
    public TableColumn<Integer , Case> deaths;

    private DataManager dataManager ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataManager = new DataManager();

        sno.setCellValueFactory(new PropertyValueFactory("sno"));
        state.setCellValueFactory(new PropertyValueFactory("state"));
        totalConfirmed.setCellValueFactory(new PropertyValueFactory("totalConfirmed"));
        cured.setCellValueFactory(new PropertyValueFactory("cured"));
        deaths.setCellValueFactory(new PropertyValueFactory("deaths"));
        ObservableList<Case> data = table.getItems();
        data.addAll(dataManager.getData());
    }
}
