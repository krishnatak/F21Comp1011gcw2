package com.example.f21comp1011gcw2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class CameraSalesViewController implements Initializable {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis cameraAxis;

    @FXML
    private NumberAxis salesAxis;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series<String,Integer> sales = new XYChart.Series<>();
        // normally this data come from db and we would loop over
        // it to create theese fata points
        sales.getData().add(new XYChart.Data<>("Camera 1",15));
        sales.getData().add(new XYChart.Data<>("Camera 2",35));
        sales.getData().add(new XYChart.Data<>("Camera 3",55));
        sales.getData().add(new XYChart.Data<>("Camera 4",35));

        //laumch
        barChart.getData().addAll(sales);
        //customising chart
        barChart.setLegendVisible(false);
        cameraAxis.setLabel("Camera Brands");
        salesAxis.setLabel("Number of Units Sold");
    }
}
