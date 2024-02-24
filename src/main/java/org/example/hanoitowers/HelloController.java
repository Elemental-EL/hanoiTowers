package org.example.hanoitowers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {
    private Stage stage;
    private Scene scene;
    @FXML
    private ChoiceBox<Integer> diskNum;
    @FXML
    private Button startBtn;
    @FXML
    private Text errorText;
    public static int disksNum=0;
    public void initialize(){
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i=3 ; i<11;i++)
            nums.add(i);
        diskNum.getItems().addAll(nums);
    }
    @FXML
    private void onStartClicked(ActionEvent event) throws IOException {

        if (diskNum.getValue()!=null){
            disksNum = diskNum.getValue();
            Parent root = FXMLLoader.load(getClass().getResource("hanoiTowers.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.centerOnScreen();
        }
        else
            errorText.setText("*Please select a number");
    }
}