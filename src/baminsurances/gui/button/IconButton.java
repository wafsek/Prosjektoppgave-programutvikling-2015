package baminsurances.gui.button;

import baminsurances.gui.window.GuiConfig;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Adrian Melsom
 */
public class IconButton {

    public static final int ADD_BUTTON = 1, STATISTIC_BUTTON = 2, SEARCH_BUTTON = 3,
            INSURE_HOUSE_BUTTON = 4, INSURE_CAR_BUTTON = 5, INSURE_PERSON_BUTTON = 6,
            INSURE_BOAT_BUTTON = 7, BACK_BUTTON = 8, CUSTOMERS_BUTTON = 9, SETTINGS_BUTTON = 10;
    private Image addImage, statisticImage, searchImage, houseImage, carImage,
            personImage, boatImage, backImage, customersImage, settingsImage;
    private ImageView addImageView, statisticImageView, searchImageView,
            houseImageView, carImageView, personImageView, boatImageView,
            backImageView, customersImageView, settingsImageView;
    private Button button;
    private ImageView imageViewToBeUsed;

    /**
     * Declares the components which are general for the different return values.
     */
    public IconButton() {
        button = new Button();

        addImage = new Image(this.getClass().getClassLoader().getResourceAsStream(
                "add_user.png"));
        addImageView = new ImageView(addImage);

        statisticImage = new Image(this.getClass().getClassLoader().getResourceAsStream(
                "statistics.png"));
        statisticImageView = new ImageView(statisticImage);

        searchImage = new Image(this.getClass().getClassLoader().getResourceAsStream(
                "search.png"));
        searchImageView = new ImageView(searchImage);

        houseImage = new Image(this.getClass().getClassLoader().getResourceAsStream(
                "house.png"));
        houseImageView = new ImageView(houseImage);

        carImage = new Image(this.getClass().getClassLoader().getResourceAsStream(
                "car.png"));
        carImageView = new ImageView(carImage);

        personImage = new Image(this.getClass().getClassLoader().getResourceAsStream(
                "airplane.png"));
        personImageView = new ImageView(personImage);

        boatImage = new Image(this.getClass().getClassLoader().getResourceAsStream(
                "boat.png"));
        boatImageView = new ImageView(boatImage);

        backImage = new Image(this.getClass().getClassLoader().getResourceAsStream(
                "back.png"));
        backImageView = new ImageView(backImage);

        customersImage = new Image(this.getClass().getClassLoader().getResourceAsStream(
                "multiplecustomers.png"));
        customersImageView = new ImageView(customersImage);

        settingsImage = new Image(this.getClass().getClassLoader().getResourceAsStream(
                "settings.png"));

        settingsImageView = new ImageView(settingsImage);
    }

    /**
     * returns an ImageView based on the integer given as argument.
     *
     * @param magical_constant
     *
     * @return ImageView based on the values given as argument.
     */
    private ImageView testMagicalInput(int magical_constant) {
        if (magical_constant == ADD_BUTTON) {
            return addImageView;
        } else if (magical_constant == STATISTIC_BUTTON) {
            return statisticImageView;
        } else if (magical_constant == SEARCH_BUTTON) {
            return searchImageView;
        } else if (magical_constant == INSURE_HOUSE_BUTTON) {
            return houseImageView;
        } else if (magical_constant == INSURE_CAR_BUTTON) {
            return carImageView;
        } else if (magical_constant == INSURE_PERSON_BUTTON) {
            return personImageView;
        } else if (magical_constant == INSURE_BOAT_BUTTON) {
            return boatImageView;
        } else if (magical_constant == BACK_BUTTON) {
            return backImageView;
        } else if (magical_constant == CUSTOMERS_BUTTON) {
            return customersImageView;
        } else if (magical_constant == SETTINGS_BUTTON) {
            return settingsImageView;
        } else return null;
    }

    /**
     * Returns a Button based on the given arguments.
     *
     * @param width
     * @param height
     * @param magical_constant
     *
     * @return Button based on the given arguments.
     */
    public Button iconButton(double width, double height, int magical_constant) {
        imageViewToBeUsed = testMagicalInput(magical_constant);
        imageViewToBeUsed.setFitWidth(width);
        imageViewToBeUsed.setFitHeight(height);
        button = new Button();
        button.setGraphic(imageViewToBeUsed);
        return button;
    }

    /**
     * Returns a Button based on the given arguments.
     *
     * @param width
     * @param height
     * @param magical_constant
     * @param buttonText
     *
     * @return a Button based on the given arguments.
     */
    public Button IconButtonWithText(double width, double height,
            int magical_constant, String buttonText) {
        imageViewToBeUsed = testMagicalInput(magical_constant);
        imageViewToBeUsed.setFitWidth(width);
        imageViewToBeUsed.setFitHeight(height);
        Button returnButton = new Button(buttonText, imageViewToBeUsed);
        returnButton.setAlignment(Pos.CENTER_LEFT);
        returnButton.setGraphicTextGap(GuiConfig.PRIMARY_HEIGHT * 1 / 15);
        return returnButton;
    }
}