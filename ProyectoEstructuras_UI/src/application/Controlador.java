package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controlador {

    @FXML
    private Label Contraseña;

    @FXML
    private Pane Pane_der;
    
    @FXML
    private TextField text_contraseña;

    @FXML
    private TextField text_usuario;

    @FXML
    private Pane Pane_izq;

    @FXML
    private Button boton;

    @FXML
    private Label usuario;
    
    @FXML
    private Label abiso;
    
    @FXML
    void handleButtonClick_Validar(MouseEvent event)  {
    	Stage primaryStage = new Stage();
    	abiso.setText(usuario.getText()+"__"+Contraseña.getText());
    	if (text_usuario.getText().equals("andres")&&text_contraseña.getText().equals("123")) {
    		Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("pf.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();

				primaryStage.setOnCloseRequest(e -> Controller.closeWindow());
				Stage myStage =(Stage) this.boton.getScene().getWindow();
				myStage.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			abiso.setText("credenciales invalidas");
			
		}
    }

}
