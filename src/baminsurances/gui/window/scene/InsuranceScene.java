package baminsurances.gui.window.scene;

import baminsurances.gui.eventhandler.GuiEventHandler;
import baminsurances.gui.eventhandler.KeyPressHandler;
import baminsurances.gui.window.GuiConfig;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by Adrian on 13/05/2015.
 */
public class InsuranceScene extends GeneralScene {

    protected ComboBox<String> insuranceDropDown;
    protected Label annualPremiumLabel, insuranceValueLabel, conditionLabel, insuranceType,
            rightSideHeaderLabel, leftSideHeaderLabel, discribtionLabel;
    protected TextField annualPremiumField, insuranceValueField;
    protected TextArea conditionArea;
    protected Button registerInsuranceButton;

    protected HBox leftSideHeader, rightSideHeader, leftSideFooter, rightSideFooter;
    protected GridPane leftSideFieldContainer, rightSideFieldContainer;
    protected BorderPane leftSideBorderPane, rightSideBorderPane;
    protected VBox leftSideContentContainer;


    public InsuranceScene(GuiEventHandler guiEventHandler, KeyPressHandler keyPressHandler, String displayName){
        super(guiEventHandler, keyPressHandler, displayName);
        insuranceDropDown = new ComboBox<>(FXCollections.observableArrayList(
                "Reiseforsikring", "Boligforsikring", "Bilforsikring", "B�tforsikring"));
        insuranceDropDown.setOnAction(guiEventHandler);
        insuranceType = new Label("Forsikringstype:");
        annualPremiumLabel = new Label("�rlig premie:");
        insuranceValueLabel = new Label("Forsikringsbel�p:");
        conditionLabel = new Label("Vilk�r:");
        leftSideHeaderLabel = new Label("Ny forsikring");
        leftSideHeaderLabel.setStyle("-fx-font: 28px Times");
        rightSideHeaderLabel = new Label("Kunde: ");
        rightSideHeaderLabel.setStyle("-fx-font: 28px Times");
        discribtionLabel = new Label("Her m� du f�rst velge en forsikringstype.\n" +
                "Avhenger av hva som velges, vil ytterligere\nutfyllingsfelt presenteres.");

        annualPremiumField = new TextField();
        annualPremiumField.setEditable(false);
        insuranceValueField = new TextField();
        insuranceValueField.setEditable(false);

        conditionArea = new TextArea();
        conditionArea.setEditable(false);
        registerInsuranceButton = new Button("Registrer");
        registerInsuranceButton.setDisable(true);

        leftSideHeader = new HBox(0, leftSideHeaderLabel);
        leftSideHeader.setAlignment(Pos.CENTER);
        leftSideHeader.setStyle("-fx-border-color: gray; ");

        leftSideFieldContainer = new GridPane();
        leftSideFieldContainer.add(discribtionLabel, 0, 0, 2, 1);
        leftSideFieldContainer.addColumn(0, insuranceType, annualPremiumLabel, insuranceValueLabel, conditionLabel);
        leftSideFieldContainer.addColumn(1, insuranceDropDown, annualPremiumField, insuranceValueField);
        leftSideFieldContainer.add(conditionArea, 0, 5, 3, 3);
        leftSideFieldContainer.setHgap(50);
        leftSideFieldContainer.setVgap(20);
        leftSideFieldContainer.setAlignment(Pos.CENTER);

        leftSideContentContainer = new VBox(10, leftSideFieldContainer);
        leftSideContentContainer.setAlignment(Pos.CENTER);

        leftSideBorderPane = new BorderPane(leftSideContentContainer, leftSideHeader, null, leftSideFooter, null);

        rightSideHeader = new HBox(0, rightSideHeaderLabel);
        rightSideHeader.setAlignment(Pos.CENTER);
        rightSideHeader.setStyle("-fx-border-color: gray;");

        rightSideFooter = new HBox(0, registerInsuranceButton);
        rightSideFooter.setAlignment(Pos.CENTER);
        rightSideFooter.setStyle("-fx-padding: 5;");

        rightSideBorderPane = new BorderPane(null, rightSideHeader, null, rightSideFooter, null);
        rightSideBorderPane.setPrefWidth(GuiConfig.PRIMARY_WIDTH * 1 / 2);

        footerRightSide.setPrefWidth(GuiConfig.PRIMARY_WIDTH * 1 / 2);
        footerLeftSide.setPrefWidth(GuiConfig.PRIMARY_WIDTH * 1 / 2);
        footer = new HBox(0, footerLeftSide, footerRightSide);
        footer.setStyle("-fx-border-color: gray;");

        borderPane = new BorderPane(leftSideBorderPane, null, rightSideBorderPane, footer, null);
        scene = new Scene(borderPane);
    }

    public ComboBox<String> getInsuranceDropDown() {
        return insuranceDropDown;
    }

    public TextField getAnnualPremiumField() {
        return annualPremiumField;
    }

    public TextField getInsuranceValueField() {
        return insuranceValueField;
    }

    public TextArea getConditionArea() {
        return conditionArea;
    }

    public Button getRegisterInsuranceButton() {
        return registerInsuranceButton;
    }
}
