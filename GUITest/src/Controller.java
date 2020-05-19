import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller
{
  @FXML private TextField field;
  @FXML private Button clearButton;
  @FXML private Button Button7;
  @FXML private Button Button4;
  @FXML private Button Button1;
  @FXML private Button Button0;

  @FXML private Button Button8;
  @FXML private Button Button5;
  @FXML private Button Button2;
  @FXML private Button ButtonDot;

  @FXML private Button Button9;
  @FXML private Button Button6;
  @FXML private Button Button3;
  @FXML private Button ButtonEquals;

  @FXML private Button ButtonDivision;
  @FXML private Button ButtonMultiplication;
  @FXML private Button ButtonSubtract;
  @FXML private Button ButtonAdd;
  byte operand =-1; // 1 adition 2 supbtraction 3 multiplication 4 division 5 equals
  double firstNr;
  double secondNr;
  double result;
  public void handleClick(ActionEvent actionEvent)
  {

    if(actionEvent.getSource() == clearButton)
    {
      field.setText("");
      operand=-1;
    }
    if(actionEvent.getSource() == Button0)
    {
      String temp = field.getText();
      if(!temp.equals("0"))
      {
        temp+="0";
        field.setText(temp);
      }
    }
    if(actionEvent.getSource() == Button1)
    {
      String temp = field.getText();
      temp+="1";
      field.setText(temp);
    }
    if(actionEvent.getSource() == Button2)
    {
      String temp = field.getText();
      temp+="2";
      field.setText(temp);
    }
    if(actionEvent.getSource() == Button3)
    {
      String temp = field.getText();
      temp+="3";
      field.setText(temp);
    }
    if(actionEvent.getSource() == Button4)
    {
      String temp = field.getText();
      temp+="4";
      field.setText(temp);
    }
    if(actionEvent.getSource() == Button5)
    {
      String temp = field.getText();
      temp+="5";
      field.setText(temp);
    }
    if(actionEvent.getSource() == Button6)
    {
      String temp = field.getText();
      temp+="6";
      field.setText(temp);
    }
    if(actionEvent.getSource() == Button7)
    {
      String temp = field.getText();
      temp+="7";
      field.setText(temp);
    }
    if(actionEvent.getSource() == Button8)
    {
      String temp = field.getText();
      temp+="8";
      field.setText(temp);
    }
    if(actionEvent.getSource() == Button9)
    {
      String temp = field.getText();
      temp+="9";
      field.setText(temp);
    }
    if(actionEvent.getSource() == ButtonDot)
    {
      String temp = field.getText();
      temp+=".";
      field.setText(temp);
    }
    if(actionEvent.getSource() == ButtonAdd)
    {
      String temp = field.getText();
      operand = 1;
      if(!temp.equals(""))
      {
        firstNr = Double.parseDouble(temp);
        field.setText("0");
      }
    }
    if(actionEvent.getSource() == ButtonSubtract)
    {
      String temp = field.getText();
      operand = 2;
      if(!temp.equals(""))
      {
        firstNr = Double.parseDouble(temp);
        field.setText("0");
      }
    }
    if(actionEvent.getSource() == ButtonMultiplication)
    {
      String temp = field.getText();
      operand = 3;
      if(!temp.equals(""))
      {
        firstNr = Double.parseDouble(temp);
        field.setText("");
      }
    }
    if(actionEvent.getSource() == ButtonDivision)
    {
      String temp = field.getText();
      operand = 4;
      if(!temp.equals(""))
      {
        firstNr = Double.parseDouble(temp);
        field.setText("0");
      }
    }
    if(actionEvent.getSource() == ButtonEquals)
    {
      String temp = field.getText();
      if(!temp.equals(""))
      {
        secondNr = Double.parseDouble(temp);
      }
      if(operand==1)
      {
        result = firstNr+secondNr;
      }
      else if (operand==2)
      {
        result = firstNr-secondNr;
      }
      else if (operand==3)
      {
        result = firstNr*secondNr;
      }
      else if (operand==4)
      {
        double resultLong = (firstNr*1.0)/secondNr;
        field.setText(""+resultLong);
      }
      else if (operand==-1)
      {
        result =0;
      }
      if(operand!=4)
      {
        field.setText(""+result);
      }
      operand=5;

    }
    System.out.println("nr1:" +firstNr+" nr2: "+secondNr+" operation:"+ operand);

  }
}
