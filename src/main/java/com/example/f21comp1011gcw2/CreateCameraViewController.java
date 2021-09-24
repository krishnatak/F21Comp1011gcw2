package com.example.f21comp1011gcw2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class CreateCameraViewController implements Initializable {

    @FXML
    private ComboBox<String> makeComboBox;

    @FXML
    private TextField modelTextArea;

    @FXML
    private Spinner<Integer> mpSpinner;

    @FXML
    private TextField priceTextArea;

    @FXML
    private CheckBox digitalCheckbox;

    @FXML
    private CheckBox mirrorglensCheckBox;

    @FXML
    private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> cameraMakes = Arrays.asList("Canon","Nikon","Sony");
    makeComboBox.getItems().addAll(cameraMakes);
    }

    @FXML
    private void submitButton()
    {
       try {
           String make = this.makeComboBox.getSelectionModel().getSelectedItem();
           String model = this.modelTextArea.getText();
           ArrayList<String> lenses = new ArrayList<>();
           lenses.addAll(Arrays.asList("50-80 F10", "20-45 F30", "40-70 F50"));
           int mp = 34;
           //int mp = this.mpSpinner.getValue();
           double price = Double.parseDouble(this.priceTextArea.getText());
           boolean digital = this.digitalCheckbox.isSelected();
           boolean mirrorLens = this.mirrorglensCheckBox.isSelected();

           Camera camera1 = new Camera(make, model,lenses,mp,price,digital,mirrorLens);
           this.msgLabel.setText("Camera Created : "+camera1);
       }catch (Exception e)
       {
           this.msgLabel.setText(e.getMessage());
       }
    }
}
