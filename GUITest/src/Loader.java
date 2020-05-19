import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Loader extends Application
{
  @Override public void start(Stage window) throws IOException
  {
    window.setTitle("Calculator");
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("GUI2.fxml"));

    Scene scene = new Scene(loader.load());
    window.setScene(scene);
    window.show();
  }
}
