package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import GUI.Controller;

public class Loader extends Application
{
  @Override public void start(Stage window) throws Exception
  {
    window.setTitle("VIAFit");
    window.setResizable(false);
    window.initStyle(StageStyle.UTILITY);
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("main.fxml"));
    Scene scene = new Scene(loader.load());
    window.setScene(scene);
    window.show();
  }
  public void init()
  {

  }
}
