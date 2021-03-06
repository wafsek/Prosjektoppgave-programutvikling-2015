package baminsurances.gui.window.scene;

import baminsurances.data.Customer;
import baminsurances.gui.eventhandler.GuiEventHandler;
import baminsurances.gui.eventhandler.KeyPressHandler;
import baminsurances.gui.window.GuiConfig;
import baminsurances.util.NorwegianComparator;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @author Adrian Melsom
 */
public abstract class PersonSearchScene extends GeneralScene{

    protected TextField firstNameField, lastNameField, addressField,
        zipCodeField, birthNumberField;
    protected Label firstNameLabel, lastNameLabel, adressLabel, zipCodeLabel,
        birthNoLabel, discribtionLabel;
    protected TableView<Customer> customerTable;
    protected TableColumn<Customer, String> birthNoColumn,
    firstNameColumn, lastNameColumn, addressColumn, tlfNoColumn;
    private Comparator<String> comparator = new NorwegianComparator();
    protected ArrayList<TextField> textFieldArrayList;
    protected Iterator<TextField> textFieldsIterator;
    protected Button choosePersonButton;
    protected GridPane itemContainer;

    /**
     * Creates the Components which are used
     *
     * @param guiEventHandler
     * @param keyPressHandler
     */
    public PersonSearchScene(GuiEventHandler guiEventHandler,
            KeyPressHandler keyPressHandler) {
        super(guiEventHandler, keyPressHandler);

        customerTable = new TableView<>();
        
        birthNoColumn = new TableColumn<Customer, String>("Fødselsnummer");
        birthNoColumn.setCellValueFactory(
                new Callback<CellDataFeatures<Customer, String>,
                        ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(
                            CellDataFeatures<Customer, String> p) {
                        return new SimpleStringProperty(p.getValue().getBirthNo());
                    }
                });

        firstNameColumn = new TableColumn<Customer, String>("Fornavn");
        firstNameColumn.setComparator(comparator);
        firstNameColumn.setCellValueFactory(
                new Callback<CellDataFeatures<Customer, String>,
                        ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(
                            CellDataFeatures<Customer, String> p) {
                        return new SimpleStringProperty(
                                p.getValue().getFirstName());
                    }
                });

        lastNameColumn = new TableColumn<Customer, String>("Etternavn");
        lastNameColumn.setComparator(comparator);
        lastNameColumn.setCellValueFactory(
                new Callback<CellDataFeatures<Customer, String>,
                        ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(
                            CellDataFeatures<Customer, String> p) {
                        return new SimpleStringProperty(
                                p.getValue().getLastName());
                    }
                });
        
        addressColumn = new TableColumn<Customer, String>("Adresse");
        addressColumn.setComparator(comparator);
        addressColumn.setCellValueFactory(
                new Callback<CellDataFeatures<Customer, String>,
                        ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(
                            CellDataFeatures<Customer, String> p) {
                        return new SimpleStringProperty(
                                p.getValue().getStreetAddress());
                    }
                });

        tlfNoColumn = new TableColumn<Customer, String>("Telefonnummer");
        tlfNoColumn.setCellValueFactory(
                new Callback<CellDataFeatures<Customer, String>,
                        ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(
                            CellDataFeatures<Customer, String> p) {
                        return new SimpleStringProperty(
                                p.getValue().getTelephoneNo());
                    }
                });

        ObservableList<TableColumn<Customer, ?>> columns =
                customerTable.getColumns();
        columns.add(birthNoColumn);
        columns.add(firstNameColumn);
        columns.add(lastNameColumn);
        columns.add(addressColumn);
        columns.add(tlfNoColumn);
        
        customerTable.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY);
        customerTable.setEditable(false);
        customerTable.setStyle("-fx-border-color: gray;");
        customerTable.setPrefWidth(GuiConfig.PRIMARY_WIDTH * 1 / 2);
        customerTable.setPlaceholder(new Label("Ingen resultater."));

        birthNumberField = new TextField();
        birthNoLabel = new Label("Fødselsnummer:");
        firstNameField = new TextField();
        firstNameLabel = new Label("Fornavn:");
        lastNameField = new TextField();
        lastNameLabel = new Label("Etternavn:");
        addressField = new TextField();
        adressLabel = new Label("Adresse:");
        zipCodeField = new TextField();
        zipCodeLabel = new Label("Postnummer:");
        discribtionLabel = new Label("Bruk feltene nedenfor til å søke.");
        discribtionLabel.setStyle("-fx-font: 15px Times");

        textFieldArrayList = new ArrayList<TextField>();
        textFieldArrayList.add(birthNumberField);
        textFieldArrayList.add(firstNameField);
        textFieldArrayList.add(lastNameField);
        textFieldArrayList.add(addressField);
        textFieldArrayList.add(zipCodeField);
        textFieldsIterator = textFieldArrayList.iterator();

        firstNameField.setOnKeyReleased(keyPressHandler);
        lastNameField.setOnKeyReleased(keyPressHandler);
        birthNumberField.setOnKeyReleased(keyPressHandler);
        addressField.setOnKeyReleased(keyPressHandler);
        zipCodeField.setOnKeyReleased(keyPressHandler);

        textFieldArrayList = new ArrayList<TextField>();
        textFieldArrayList.add(firstNameField);
        textFieldArrayList.add(lastNameField);
        textFieldArrayList.add(birthNumberField);
        textFieldArrayList.add(addressField);
        textFieldArrayList.add(zipCodeField);

        choosePersonButton = new Button("Velg Person");
        choosePersonButton.setDisable(true);
        customerTable.setOnMouseClicked(e -> {
                    choosePersonButton.setDisable(false);
            choosePersonButton.setOnAction(guiEventHandler);
                });

        itemContainer = new GridPane();
        itemContainer.addColumn(0, discribtionLabel, firstNameLabel, lastNameLabel, birthNoLabel,
                adressLabel, zipCodeLabel);
        itemContainer.addColumn(1, new Label(""), firstNameField, lastNameField, birthNumberField,
                addressField, zipCodeField, choosePersonButton);
        itemContainer.setAlignment(Pos.CENTER);
        itemContainer.setVgap(30);
        itemContainer.setHgap(20);
        itemContainer.setStyle("-fx-border-color: gray;");
    }

    public void setChoosePersonClickable() {
        if (birthNumberField.getText().trim().isEmpty() &&
                addressField.getText().trim().isEmpty() &&
                firstNameField.getText().trim().isEmpty() &&
                lastNameField.getText().trim().isEmpty() &&
                zipCodeField.getText().trim().isEmpty()){
            choosePersonButton.setDisable(true);
        }
    }

    /**
     * Returns the Scene created in this class.
     *
     * @return the Scene created in this class.
     */
    public Scene getScene() {
        return scene;
    }

    public void clearFields() {
        birthNumberField.setText("");
        addressField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        zipCodeField.setText("");
        setChoosePersonClickable();
        customerTable.setItems(FXCollections.observableArrayList());
    }

    /**
     * Returns the Button that requests the change between the two
     * stages.
     *
     * @return the button that requests the Scene change.
     */
    public Button getChoosePersonButton() {
        return choosePersonButton;
    }

    /**
     * Returns a String of the value in firstNameField.
     *
     * @return a String of the value in firstNameField.
     */
    public String getFirstName() {
        return firstNameField.getText();
    }

    /**
     * Returns a String of the value in lastNameField.
     *
     * @return a String of the value in lastNameField.
     */
    public String getLastName() {
        return lastNameField.getText();
    }

    /**
     * Returns a String of the value in addressField.
     *
     * @return a String of the value in addressField.
     */
    public String getAdress() {
        return addressField.getText();
    }

    /**
     * Returns a String of the value in zipCodeField.
     *
     * @return a String of the value in zipCodeField.
     */
    public String getZipCode() {
        return zipCodeField.getText();
    }

    /**
     * Returns a String of the value in birthNumberField.
     *
     * @return a String of the value in birthNumberField.
     */
    public String getBirthNumber() {
        return birthNumberField.getText();
    }

    /**
     * Returns an ArrayList of TextFields.
     *
     * @return an ArrayList of TextFields.
     */
    public ArrayList<TextField> getTextFieldArrayList() {
        return textFieldArrayList;
    }

    /**
     * Returns an Iterator of TextField.
     *
     * @return an Iterator of TextField.
     */
    public Iterator<TextField> getTextFieldIterator() {
        return textFieldsIterator;
    }

    public void resetIterator() {
        textFieldsIterator = textFieldArrayList.iterator();
    }

    public void setTableData(ObservableList<Customer> observableList) {
        customerTable.setItems(observableList);
    }

    public Customer getCustomer() {
        return customerTable.getSelectionModel().getSelectedItem();
    }
} // End of File
