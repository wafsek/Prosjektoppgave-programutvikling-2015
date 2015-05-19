package baminsurances.gui.window;

import baminsurances.api.Searcher;
import baminsurances.data.DataBank;
import baminsurances.data.Employee;
import baminsurances.gui.eventhandler.GuiEventHandler;
import baminsurances.logging.CustomLogger;
import javafx.animation.Animation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.*;
import java.util.logging.Level;

import javafx.stage.Stage;
import javafx.scene.chart.*;

/**
 * Created by baljit on 17.05.2015.
 */
public class StatisticWindow {

    private Stage stage;
    private Scene scene;


    private VBox leftSide,rightSide;

    private VBox filters;
    private Image companyLogo;
    private ImageView companyLogoImageView;

    private Label usernameLabel, passwordLabel, logoLabel;
    private TextField usernameField;
    private GridPane gridPane;
    private LineChart lineChart;
    private PieChart pieChart;
    private BarChart barChart;

    private Button loginButton;
    private BorderPane borderPane;
    private GridPane fieldContainer;
    private Map<Double, Character> memory;
    private ObservableList<Employee> observableList;
    private ObservableList<PieChart.Data> pieChartData;
    private ComboBox comboBox;
    private CustomLogger logger;
    
    
    private GuiEventHandler handler;
    
    
    public StatisticWindow(){
        
        companyLogo = new Image(
                this.getClass().getResourceAsStream("../img/temp_logo.png"));
        stage = new Stage();
        stage.setTitle("Statistic Window");
        stage.getIcons().add(companyLogo);

        stage.setScene(scene);
        stage.setWidth(GuiConfig.PRIMARY_WIDTH);
        stage.setHeight(GuiConfig.PRIMARY_HEIGHT);
    }
    
    
    
    public void show(){
        stage.show();
    }
    
    
    
    private void setComboBox(){
        comboBox = new ComboBox(FXCollections.observableArrayList(
               "1",
                "2",
                "3",
                "4",
                "5",
                "6")
        );
        comboBox.setOnAction(e -> {
            if (comboBox.getValue() == "1") {
                this.launchOptionOne();
            } else if (comboBox.getValue() == "2") {
                this.launchOptionTwo();
            } else if (comboBox.getValue() == "3") {
                this.launchOptionThree();
            } else if (comboBox.getValue() == "4") {
                this.launchOptionFour();
            } else if (comboBox.getValue() == "5") {
                this.launchOptionFive();
            } else if (comboBox.getValue() == "6") {
                this.launchOptionSix();
            } else {
                System.out.println("dafaq");
            }
        });
    }
    private void clearRightSide(){
        rightSide.getChildren().removeAll(pieChart);
    }
    
    private void launchOptionOne(){
        this.clearRightSide();
        logger.log("Option one selected ", Level.FINE);
        this.setPieChartData(new Searcher().numInsurancesPerType());
        pieChart = new PieChart(pieChartData);
        pieChart.setVisible(true);
        pieChart.getLabelsVisible();
        rightSide.getChildren().add(pieChart);
    }
    
    
    
    private void launchOptionTwo(){
        this.clearRightSide();
        logger.log("Option one selected ", Level.FINE);
        this.setPieChartData(new Searcher().numInsurancesPerType());
        //barChart = new BarChart();
        pieChart.setVisible(true);
        pieChart.getLabelsVisible();
        rightSide.getChildren().add(pieChart);
    }

    private void launchOptionThree(){
        logger.log("Option three selected ", Level.FINE);
    }

    private void launchOptionFour(){
        logger.log("Option four selected ", Level.FINE);
    }

    private void launchOptionFive(){
        logger.log("Option five selected ", Level.FINE);
    }

    private void launchOptionSix(){
        logger.log("Option six selected ", Level.FINE);
    }
    
    public <T> void setPieChartData(Map<T ,Integer> map){
        pieChartData = FXCollections.observableArrayList();
        for(Map.Entry<T,Integer> entrySet : map.entrySet()){
            T key = entrySet.getKey();
            int value = entrySet.getValue();
            pieChartData.add(new PieChart.Data(key.toString()+" : "+value,value));
        }
    }
    
    
    
    public void setSeries(XYChart.Series series1){
        for (Employee employee: DataBank.getInstance().getEmployeeList()){
            this.addData(series1,employee.getFirstName(),employee.getAge());
        }
    }
    
    
    public void addData(XYChart.Series series,String s,int i){
        
    }
    
    public <T>void setBarChartData(Map<T,Integer> map){
        XYChart.Series series = new XYChart.Series();
        T key;
        int i;
        for(Map.Entry<T,Integer> entrySet : map.entrySet()){
            key = entrySet.getKey();
            i = entrySet.getValue();
            series.getData().add(new XYChart.Data<>(key,i));
        }
    }
}
