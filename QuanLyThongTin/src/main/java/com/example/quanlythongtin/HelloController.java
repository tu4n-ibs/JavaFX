package com.example.quanlythongtin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class HelloController implements Initializable {
    private Student[] students = {new Student(0,"a","b","c","d",10),
                                  new Student(1,"b","b","m","f",3),
                                  new Student(2,"c","b","n","g",6)   };
    @FXML
    private TableView<Student> tableview;
    @FXML
    private TableColumn<Student, Integer> id;
    @FXML
    private TableColumn<Student, String> name;
    @FXML
    private TableColumn<Student, String> ClasS;
    @FXML
    private TableColumn<Student, String> gender;
    @FXML
    private TableColumn<Student, String> address;
    @FXML
    private TableColumn<Student, Integer> score;

    private final ObservableList<Student> data = FXCollections.observableArrayList(students);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        ClasS.setCellValueFactory(new PropertyValueFactory<>("Class"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));

        tableview.setItems(data);
    }

    @FXML
    private TextField id1;
    @FXML
    private TextField name1;
    @FXML
    private TextField ClasS1;
    @FXML
    private TextField gender1;
    @FXML
    private TextField address1 ;
    @FXML
    private TextField score1;
    public void add() {
        Student student = new Student();
        student.setId(parseInt(id1.getText()));
        student.setName(name1.getText());
        student.setClass(ClasS1.getText());
        student.setGender(gender1.getText());
        student.setAddress(address1.getText());
        student.setScore(parseInt(score1.getText()));

        data.add(student);
    }

    public void remove() {
        Student selected = tableview.getSelectionModel().getSelectedItem();
        data.remove(selected);
    }
}