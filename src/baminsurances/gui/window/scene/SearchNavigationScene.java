package baminsurances.gui.window.scene;

import baminsurances.gui.Gui;
import baminsurances.gui.button.IconButton;
import baminsurances.gui.eventhandler.GuiEventHandler;
import baminsurances.gui.eventhandler.KeyPressHandler;
import baminsurances.gui.window.GuiConfig;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by Adrian on 18/05/2015.
 */
public class SearchNavigationScene extends GeneralScene {

    private Button customerSearchButton, insuranceSearchButton, claimAdviceButton;
    private static final double WIDTH = GuiConfig.PRIMARY_WIDTH*1/2, HEIGHT = GuiConfig.PRIMARY_HEIGHT*1/10;;
    private VBox container;

    public SearchNavigationScene(GuiEventHandler guiEventHandler, KeyPressHandler keyPressHandler) {
        super(guiEventHandler, keyPressHandler);
        customerSearchButton = new IconButton().IconButtonWithText(HEIGHT,
                HEIGHT, IconButton.CUSTOMERS_BUTTON, "Kundes�k");
        customerSearchButton.setPrefWidth(WIDTH * 2/3);
        insuranceSearchButton = new IconButton().IconButtonWithText(HEIGHT,
                HEIGHT, IconButton.SEARCH_BUTTON, "Forsikringss�k");
        insuranceSearchButton.setPrefWidth(WIDTH * 2/3);
        claimAdviceButton = new IconButton().IconButtonWithText(HEIGHT,
                HEIGHT, IconButton.CUSTOMERS_BUTTON, "Skademeldingss�k");
        claimAdviceButton.setPrefWidth(WIDTH * 2/3);
        container = new VBox(10, customerSearchButton, insuranceSearchButton, claimAdviceButton);
        container.setAlignment(Pos.CENTER);
        container.setStyle("-fx-padding: 10");

        footerRightSide.setPrefWidth(WIDTH * 1 / 2);
        footerLeftSide.setPrefWidth(WIDTH * 1 / 2);
        footer = new HBox(0, footerLeftSide, footerRightSide);
        footer.setStyle("-fx-border-color: gray;");

        borderPane = new BorderPane(container, null, null, footer, null);
        borderPane.setPrefWidth(WIDTH);
        borderPane.setPrefHeight(HEIGHT);

        scene = new Scene(borderPane);
    }

    public Scene getScene() {
        return scene;
    }
}