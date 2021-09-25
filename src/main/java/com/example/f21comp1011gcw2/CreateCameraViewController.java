package com.example.f21comp1011gcw2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private CheckBox digitalCheckbox;

    @FXML
    private Slider priceSlider;

    @FXML
    private Label priceLabel;

    @FXML
    private CheckBox mirrorglensCheckBox;

    @FXML
    private Label msgLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> cameraMakes = Arrays.asList("Canon","Nikon","Sony");
    makeComboBox.getItems().addAll(cameraMakes);

    //customising slider
        priceSlider.setMin(300);
        priceSlider.setMax(900);
        priceSlider.setValue(450);
        priceLabel.setText(String.format("$%.2f",priceSlider.getValue()));


    // making an inner class and referring to it
        //priceSlider.valueProperty().addListener(new PriceChangeListener2());

    //creating an anonymous inner class
//        priceSlider.valueProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
//                priceLabel.setText(String.format("$%.2f",newValue));
//            }
//        });

        //slider using lambda expression

        priceSlider.valueProperty().addListener((observableValue,oldValue,newValue) -> {
            priceLabel.setText(String.format("$%.2f",newValue));
        });

        // configure thw spinner to work with  integer in the range of 5-75
        // the arguements are min , max, default , step

            SpinnerValueFactory<Integer> spinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(5,50,15,5);
            mpSpinner.setValueFactory(spinnerValueFactory);
            mpSpinner.setEditable(true);
            // to set limitation on imput on mpspiiner textfield
            // now user can only type integers in field
            TextField spinnerTextField = mpSpinner.getEditor();
            spinnerTextField.textProperty().addListener(((observableValue, oldValue, newValue) -> {
                try{
                    Integer.parseInt(newValue);
                }catch (Exception e)
                {
                    spinnerTextField.setText(oldValue);
                }
            }));

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
           //double price = Double.parseDouble(this.priceTextArea.getText());
           boolean digital = this.digitalCheckbox.isSelected();
           boolean mirrorLens = this.mirrorglensCheckBox.isSelected();

           //Camera camera1 = new Camera(make, model,lenses,mp,price,digital,mirrorLens);
           //this.msgLabel.setText("Camera Created : "+camera1);
       }catch (Exception e)
       {
           this.msgLabel.setText(e.getMessage());
       }
    }
    public class PriceChangeListener2 implements ChangeListener {
        @Override
        public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
            //priceLabel.setText(String.format("$%.2f",newValue));
        }
    }
}
