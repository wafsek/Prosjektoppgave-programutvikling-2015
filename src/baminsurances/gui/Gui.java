package baminsurances.gui;
import baminsurances.gui.eventhandler.GuiEventHandler;
import baminsurances.gui.window.LoginWindow;
import baminsurances.gui.window.RegistrationWindow;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Adrian PC on 10/04/2015.
 */
public class Gui extends Application {

    public static void main(String[] args){

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        new GuiEventHandler();
    }
}
