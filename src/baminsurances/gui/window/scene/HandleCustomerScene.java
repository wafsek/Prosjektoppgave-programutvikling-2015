package baminsurances.gui.window.scene;

import baminsurances.data.Insurance;
import baminsurances.gui.eventhandler.GuiEventHandler;
import baminsurances.gui.eventhandler.KeyPressHandler;
import baminsurances.gui.window.GuiConfig;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by Adrian PC on 12/05/2015.
 */
public class HandleCustomerScene extends GeneralScene {

    private TextField birthNoField, nameField, telephoneNoField, emailField,
            adressField, billingadressField, dateOfRegistrationField;
    private Label birthNoLabel, nameLabel, telephoneNoLabel, emailLabel,
            adressLabel, billingadressLabel, dateOfRegistrationLabel, headerInfo,
            tableHeaderLabel, dateColumnLabel, isActiveColumnLabel;
    private Button updateInfoButton, newInsuranceButton, chooseInsuranceButton;
    private TableView<Insurance> insuranceTable;
    private TableColumn<Insurance, String> insuranceNumberColumn, typeColumn,
            dateOfRegistrationColumn, isActiveColumn;
    private BorderPane leftSideContainer, rightSideContainer;
    private GridPane topContainer, uppermiddleContainer,
            lowerMiddleContainer, bottomContainer, fieldButtonContainer;
    private HBox headerContainer, tableButtons, tableHeaderContainer, leftTableHeader, rightTableHeader;
    private VBox fieldContainer;

    public HandleCustomerScene(GuiEventHandler guiEventHandler, KeyPressHandler keyPressHandler, String displayName){
        super(guiEventHandler, keyPressHandler, displayName);

        birthNoField = new TextField();
        birthNoField.setEditable(false);
        nameField = new TextField();
        nameField.setEditable(false);
        telephoneNoField = new TextField();
        telephoneNoField.setEditable(false);
        emailField = new TextField();
        emailField.setEditable(false);
        adressField = new TextField();
        adressField.setEditable(false);
        billingadressField = new TextField();
        billingadressField.setEditable(false);
        dateOfRegistrationField = new TextField();
        dateOfRegistrationField.setEditable(false);

        birthNoLabel = new Label("Fødselsnummer:");
        nameLabel = new Label("Navn:");
        telephoneNoLabel = new Label("Telefonnummer:");
        emailLabel = new Label("Email:");
        adressLabel = new Label("Adresse:");
        billingadressLabel = new Label("Betalingsadresse:");
        dateOfRegistrationLabel = new Label("Dato registrert:   ");
        headerInfo = new Label("Kundeinformasjon:");
        headerInfo.setStyle("-fx-font: 28px Times;");

        tableHeaderLabel = new Label("Forsikringer:");
        tableHeaderLabel.setStyle("-fx-font: 28px Times;");

        updateInfoButton = new Button("Oppdater informasjon");
        newInsuranceButton = new Button("Tegn ny forsikring");
        chooseInsuranceButton = new Button("Velg forsikring");

        insuranceNumberColumn = new TableColumn<>("Nummer");
        typeColumn = new TableColumn<>("Type");
        dateOfRegistrationColumn = new TableColumn<>("Registrert (Dato)");
        isActiveColumn = new TableColumn<>("Aktiv (Ja/Nei)");

        insuranceTable = new TableView();
        insuranceTable.getColumns().addAll(insuranceNumberColumn, typeColumn,
                dateOfRegistrationColumn, isActiveColumn);
        insuranceTable.setEditable(false);
        insuranceTable.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY);

        topContainer = new GridPane();
        topContainer.addColumn(0, birthNoLabel, nameLabel);
        topContainer.addColumn(1, birthNoField, nameField);
        topContainer.setVgap(10);
        topContainer.setHgap(20);
        topContainer.setAlignment(Pos.CENTER);

        uppermiddleContainer = new GridPane();
        uppermiddleContainer.addColumn(0, telephoneNoLabel, emailLabel);
        uppermiddleContainer.addColumn(1, telephoneNoField, emailField);
        uppermiddleContainer.setVgap(10);
        uppermiddleContainer.setHgap(20);
        uppermiddleContainer.setAlignment(Pos.CENTER);

        lowerMiddleContainer = new GridPane();
        lowerMiddleContainer.addColumn(0, adressLabel, billingadressLabel);
        lowerMiddleContainer.addColumn(1, adressField, billingadressField);
        lowerMiddleContainer.setVgap(10);
        lowerMiddleContainer.setHgap(20);
        lowerMiddleContainer.setAlignment(Pos.CENTER);

        bottomContainer = new GridPane();
        bottomContainer.addColumn(0, dateOfRegistrationLabel);
        bottomContainer.addColumn(1, dateOfRegistrationField);
        bottomContainer.setVgap(10);
        bottomContainer.setHgap(20);
        bottomContainer.setAlignment(Pos.CENTER);

        fieldButtonContainer = new GridPane();
        fieldButtonContainer.addColumn(0, backButton);
        fieldButtonContainer.addColumn(1, updateInfoButton);
        fieldButtonContainer.setHgap(GuiConfig.PRIMARY_WIDTH*1/18);
        fieldButtonContainer.setAlignment(Pos.CENTER);


        fieldContainer = new VBox(40, topContainer, uppermiddleContainer,
                lowerMiddleContainer, bottomContainer, fieldButtonContainer);
        fieldContainer.setStyle("-fx-border-color: gray;");
        fieldContainer.setAlignment(Pos.CENTER);

        headerContainer = new HBox(0, headerInfo);
        headerContainer.setStyle("-fx-border-color: gray;");
        headerContainer.setAlignment(Pos.CENTER);

        leftSideContainer = new BorderPane(fieldContainer, headerContainer, null, null, null);
        leftSideContainer.setStyle("-fx-border-color: gray;");
        leftSideContainer.setPrefWidth(GuiConfig.PRIMARY_WIDTH * 1 / 3);

        tableHeaderContainer = new HBox(0, tableHeaderLabel);
        tableHeaderContainer.setStyle("-fx-border-color: gray;");
        tableHeaderContainer.setAlignment(Pos.CENTER);

        tableButtons = new HBox(GuiConfig.PRIMARY_WIDTH * 1/4, newInsuranceButton, chooseInsuranceButton);
        tableButtons.setStyle("-fx-padding: 5;");

        rightSideContainer = new BorderPane(insuranceTable, tableHeaderContainer, null, tableButtons, null);
        rightSideContainer.setStyle("-fx-border-color: gray;");
        rightSideContainer.setPrefWidth(GuiConfig.PRIMARY_WIDTH * 2 / 3);

        footer = new HBox(GuiConfig.PRIMARY_WIDTH*4/5, informationLabel, logOutButton);
        footer.setStyle("-fx-border-color: gray; " +
                "-fx-padding: 2;");

        borderPane = new BorderPane(null, null, rightSideContainer, footer, leftSideContainer);

        scene = new Scene(borderPane);
    }
}
