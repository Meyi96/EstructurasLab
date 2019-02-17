package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import Model.Polynomial;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    @FXML
    private ComboBox<String> SelecGrade;
    @FXML
    private TextArea rootText;
    @FXML
    private Label refreshName;
    private int limited;
    private int current;
    private TextField[] textfield;
    private Polynomial poly;
    private boolean bairstow;

    @FXML
    void press0(ActionEvent event) {textfield[current].setText(textfield[current].getText()+"0");}
    @FXML
    void press1(ActionEvent event) {textfield[current].setText(textfield[current].getText()+"1");}
    @FXML
    void press2(ActionEvent event) {textfield[current].setText(textfield[current].getText()+"2");}
    @FXML
    void press3(ActionEvent event) {textfield[current].setText(textfield[current].getText()+"3");}
    @FXML
    void press4(ActionEvent event) {textfield[current].setText(textfield[current].getText()+"4");}
    @FXML
    void press5(ActionEvent event) {textfield[current].setText(textfield[current].getText()+"5");}
    @FXML
    void press6(ActionEvent event) {textfield[current].setText(textfield[current].getText()+"6");}
    @FXML
    void press7(ActionEvent event) {textfield[current].setText(textfield[current].getText()+"7");}
    @FXML
    void press8(ActionEvent event) {textfield[current].setText(textfield[current].getText()+"8");}
    @FXML
    void press9(ActionEvent event) {textfield[current].setText(textfield[current].getText()+"9");}
    @FXML
    void pressNegative(ActionEvent event) {textfield[current].setText("-");}
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
    @FXML
    void pressDivide(ActionEvent event) {
    	if(!textfield[current].getText().equals(""))
    		if(textfield[current].getText().indexOf("/")==-1)
    			textfield[current].setText(textfield[current].getText()+"/");}
    @FXML
    void pressBefore(ActionEvent event) {
    	if(textfield[current].getText().equals(""))
    		textfield[current].setText("0");
    	if(current ==limited) 
    		current = 0;
    	else
    		current++;
    	textfield[current].requestFocus();
    	if(textfield[current].getText().equals("0"))
    		textfield[current].setText("");}
    @FXML
    void pressNext(ActionEvent event) {
    	if(textfield[current].getText().equals(""))
    		textfield[current].setText("0");
    	if(current ==0) 
    		current = limited;
    	else
    		current--;
    	textfield[current].requestFocus();
    	if(textfield[current].getText().equals("0"))
    		textfield[current].setText("");}
    @FXML
    void pressRandom(ActionEvent event) {
    	for (int i = 0; i < limited+1; i++) {
			textfield[i].setText(""+(int)(Math.random()*15));
		}
    }
    @FXML
    void refreshGrade(ActionEvent event) {
    	limited = SelecGrade.getSelectionModel().getSelectedIndex()+2;
    	current = limited;
    	for (int i = 0; i < textfield.length; i++) {
    		if(i <= limited)
    			textfield[i].setDisable(false);
    		else {
    			textfield[i].setText("0");
    			textfield[i].setDisable(true);
    		}
		}
    	pressClean(event);
    	textfield[limited].setText("");
    	textfield[limited].requestFocus();
    }
    @FXML
    void pressClean(ActionEvent event) {
    	for (int i = 0; i < limited+1; i++) {
			textfield[i].setText("0");
		}
    	rootText.setText("");
    }
    @FXML
    void pressCalculate(ActionEvent event) {
    	poly = new Polynomial(groupCoefficients(), limited);
    	if(bairstow)
    		poly.startBairstow();
    	else
    		poly.startRootFinder();
    	rootText.setText(poly.getDate());
    }
    @FXML
    void pressBairstow(ActionEvent event) {
    	bairstow = true;
    	refreshName.setText("Bairstow");
    }
    @FXML
    void pressRootFider(ActionEvent event) {
    	bairstow = false;
    	refreshName.setText("Root finder");
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		limited = 10;
		current = 10;
		bairstow = true;
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
		SelecGrade.getItems().addAll("Grado 2", "Grado 3", "Grado 4", "Grado 5",
				                     "Grado 6", "Grado 7", "Grado 8", "Grado 9", "Grado 10");
	}
	public String groupCoefficients() {
		String date ="";
		for (int i = 0; i < limited+1; i++) {
			if(i < limited)
				date += textfield[i].getText() + " ";
			else
				date += textfield[i].getText();
		}
		return date;
	}
    

    
}
