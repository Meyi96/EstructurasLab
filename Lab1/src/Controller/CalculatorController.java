package Controller;

import java.awt.event.FocusEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CalculatorController  implements Initializable{

	@FXML
    private TextField x10;

    @FXML
    private TextField x9;

    @FXML
    private TextField x8;

    @FXML
    private TextField x7;

    @FXML
    private TextField x6;

    @FXML
    private TextField x5;

    @FXML
    private TextField x4;

    @FXML
    private TextField x3;

    @FXML
    private TextField x2;

    @FXML
    private TextField x1;

    @FXML
    private TextField x0;
    
    private int current = 10;
    private TextField[] textfield;

    @FXML
    private ComboBox<?> SelecGrade;

    @FXML
    void press0(ActionEvent event) {
    	textfield[current].setText(textfield[current].getText()+"0");
    }

    @FXML
    void press1(ActionEvent event) {
    	textfield[current].setText(textfield[current].getText()+"1");
    }

    @FXML
    void press2(ActionEvent event) {
    	textfield[current].setText(textfield[current].getText()+"2");
    }

    @FXML
    void press3(ActionEvent event) {
    	textfield[current].setText(textfield[current].getText()+"3");
    }

    @FXML
    void press4(ActionEvent event) {
    	textfield[current].setText(textfield[current].getText()+"4");
    }

    @FXML
    void press5(ActionEvent event) {
    	textfield[current].setText(textfield[current].getText()+"5");
    }

    @FXML
    void press6(ActionEvent event) {
    	textfield[current].setText(textfield[current].getText()+"6");
    }

    @FXML
    void press7(ActionEvent event) {
    	textfield[current].setText(textfield[current].getText()+"7");
    }

    @FXML
    void press8(ActionEvent event) {
    	textfield[current].setText(textfield[current].getText()+"8");
    }

    @FXML
    void press9(ActionEvent event) {
    	textfield[current].setText(textfield[current].getText()+"9");
    }
    
    @FXML
    void pressNegative(ActionEvent event) {
    	textfield[current].setText("-");
    }

    @FXML
    void pressBefore(ActionEvent event) {
    	if(current ==10) 
    		current = 0;
    	else
    		current++;
    	textfield[current].requestFocus();
    }

    @FXML
    void pressCalculate(ActionEvent event) {
    }

    @FXML
    void pressClean(ActionEvent event) {

    }

    @FXML
    void pressDivide(ActionEvent event) {
    	textfield[current].setText(textfield[current].getText()+"/");
    }

    @FXML
    void pressNext(ActionEvent event) {
    	if(current ==0) 
    		current = 10;
    	else
    		current--;
    	textfield[current].requestFocus();
    		
    }

    @FXML
    void pressPost(ActionEvent event) {

    }

    @FXML
    void pressPre(ActionEvent event) {
    	
    }

    @FXML
    void pressRandom(ActionEvent event) {
    	Platform.runLater(() -> {
            if (!x8.isFocused()) {
                x8.requestFocus();
            }else
            	x7.requestFocus();
        });
    }
    
    @FXML
    void click0(MouseEvent event) {current =0;}
    @FXML
    void click1(MouseEvent event) {current =1;}
    @FXML
    void click2(MouseEvent event) {current =2;}
    @FXML
    void click3(MouseEvent event) {current =3;}
    @FXML
    void click4(MouseEvent event) {current =4;}
    @FXML
    void click5(MouseEvent event) {current =5;}
    @FXML
    void click6(MouseEvent event) {current =6;}
    @FXML
    void click7(MouseEvent event) {current =7;}
    @FXML
    void click8(MouseEvent event) {current =8;}
    @FXML
    void click9(MouseEvent event) {current =9;}
    @FXML
    void click10(MouseEvent event) {current =10;}
    
    private TextField focusIn() {
    	return textfield[current];
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		textfield = new TextField[11];
		textfield[0] = x0;
		textfield[1] = x1;
		textfield[2] = x2;
		textfield[3] = x3;
		textfield[4] = x4;
		textfield[5] = x5;
		textfield[6] = x6;
		textfield[7] = x7;
		textfield[8] = x8;
		textfield[9] = x9;
		textfield[10] = x10;
	}
    

    
}
