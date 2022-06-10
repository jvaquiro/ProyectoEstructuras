package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;


import app.Bovinos;
import app.Trazabilidad;
import estructuras.AVLTree;
import estructuras.BinaryNode;
import estructuras.Node;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Controller implements Initializable {
	static Trazabilidad t = new Trazabilidad();
	public AVLTree<Bovinos> a = new AVLTree<>();


	@FXML
	private Label Aviso;

	@FXML
	private Button aceptar;

	@FXML
	private Button aceptar1;

	@FXML
	private Button b_agregar;

	@FXML
	private Button b_buscar;

	@FXML
	private Button b_cargar;

	@FXML
	private Button b_guaradar;

	@FXML
	private Button b_mostrar;

	@FXML
	private TableColumn<Bovinos,String> c_codigo;

	@FXML
	private TableColumn<Bovinos,String> c_fecha;

	@FXML
	private TableColumn<Bovinos,String> c_raza;

	@FXML
	private TableColumn<Bovinos,String> c_sexo;
	@FXML
	private TableColumn<Bovinos,String> c_codigo1;

	@FXML
	private TableColumn<Bovinos,String> c_fecha1;

	@FXML
	private TableColumn<Bovinos,String> c_raza1;

	@FXML
	private TableColumn<Bovinos,String> c_sexo1;

	@FXML
	private Label label_status;

	@FXML
	private Label label_status1;

	@FXML
	private Label label_status2;

	@FXML
	private Label label_status21;

	@FXML
	private Label label_status3;

	@FXML
	private Label label_status31;

	@FXML
	private Label label_status4;

	@FXML
	private Label label_status41;

	@FXML
	private Label label_status5;

	@FXML
	private Label label_status51;

	@FXML
	private Label label_status511;

	@FXML
	private Pane panel_status;

	@FXML
	private Pane panel_status1;

	@FXML
	private Pane panel_status11;

	@FXML
	private Pane panel_status2;

	@FXML
	private TextField t_codigo;

	@FXML
	private TextField t_codigo1;

	@FXML
	private TextField t_fecha;

	@FXML
	private TextField t_fecha1;

	@FXML
	private TextField t_raza;

	@FXML
	private TextField t_raza1;

	@FXML
	private TextField t_sexo;

	@FXML
	private TextField t_sexo1;

	@FXML
	private Label label_status22;

	@FXML
	private TableView<Bovinos> tabla1;

	@FXML
	private TableView<Bovinos> tabla;


	// Event Listener on Button[#b_agregar].onAction
	@FXML
	void handleButtonClick_agreagar(MouseEvent event) {
		panel_status.toFront();
	}
	@FXML
	void handleButtonClick_Insertar(MouseEvent event) {
		String[] datos = new String[4];
		datos[0]=t_codigo.getText();
		datos[1]=t_fecha.getText();
		datos[2]=t_raza.getText();
		datos[3]=t_sexo.getText();
		t.registrarBovinoLL(datos);
		label_status22.setText("insertado");
	}
	public void printPreorder() {
		BinaryNode<Bovinos> root=t.a.root;
    	printPreorder(root);
    }
	   public void printPreorder(BinaryNode<Bovinos> node) {
	    	if(node != null) {
	    		list1.add(node.data);
	    	System.out.print(node.data);
			printPreorder(node.left);
			printPreorder(node.right);
	    	}
		}
	@FXML
	void handleButtonClick_mostrar1(MouseEvent event) {

		tabla1.getItems().clear();
	//	System.out.println(root);
		printPreorder();
		panel_status11.toFront();
		list1.add(new Bovinos("12", "dd", "sd", "ss"));
		tabla1.setItems(list1);
	}

	@FXML
	void handleButtonClick_mostrar(MouseEvent event) {


		tabla.getItems().clear();
		panel_status1.toFront();
		if (t.l.getHead() != null) {
			Node<Bovinos> iterator = t.l.getHead();
			while (iterator.next != null) {
				iterator = iterator.next;
				list.add(iterator.data);
				System.out.println(iterator.data);
			}
		} else {
			System.out.println();
		}

		tabla.setItems(list);

	}
	@FXML
	void handleButtonClick_buscar(MouseEvent event) {
		panel_status2.toFront();
	}
	@FXML
	void handleButtonClick_res(MouseEvent event) {
		String codigo=t_codigo1.getText();
		String fecha=t_fecha1.getText();
		String rasa=t_raza1.getText();
		String sexo=t_sexo1.getText();

		if (t.BuscarBovinoLL(codigo, fecha, rasa, sexo)==-1) {
			label_status511.setText(t.BuscarBovinoFaenado(codigo));

		}else {

			//System.out.println((t.BuscarBovinoLL(code,fecha,raza,sexo)!=-1)?"En trazabilidad":"El registro No existe"); 
			label_status511.setText((t.BuscarBovinoLL(codigo,fecha,rasa,sexo)!=-1)?"En trazabilidad":"El registro No existe!!");
		}
		//	String res=	String.valueOf(	t.BuscarBovinoLL(codigo, fecha, rasa, sexo));
	}
	@FXML
	void handleButtonClick_cargar(MouseEvent event) {
		Aviso.setText("Datos cargados");
		t.cargarBovinoTxT();
	}

	ObservableList<Bovinos> list =FXCollections.observableArrayList(new Bovinos("12", "sdsd", "es", "ss"));
	ObservableList<Bovinos> list1 =FXCollections.observableArrayList(new Bovinos("12", "sdsd", "es", "ss"));
	@FXML
	void handleButtonClick_save(MouseEvent event) {
		t.guardarBovinoTXT(1);
		t.guardarFaenados();
		Aviso.setText("Guardado con exito");

	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {




		c_codigo.setCellValueFactory(new PropertyValueFactory<Bovinos,String>("codigo"));
		c_fecha.setCellValueFactory(new PropertyValueFactory<Bovinos,String>("fechaNacimiento"));
		c_raza.setCellValueFactory(new PropertyValueFactory<Bovinos,String>("raza"));
		c_sexo.setCellValueFactory(new PropertyValueFactory<Bovinos,String>("sexo"));


		c_codigo1.setCellValueFactory(new PropertyValueFactory<Bovinos,String>("codigo"));
		c_fecha1.setCellValueFactory(new PropertyValueFactory<Bovinos,String>("fechaNacimiento"));
		c_raza1.setCellValueFactory(new PropertyValueFactory<Bovinos,String>("raza"));
		c_sexo1.setCellValueFactory(new PropertyValueFactory<Bovinos,String>("sexo"));

	}

}
