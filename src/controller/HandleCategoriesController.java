package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Category;
import repository.CategoryRepository;


public class HandleCategoriesController {
   @FXML
    private TableView<Category> categoryTable;

    @FXML
    private TableColumn<Category, Integer> categoryKeyCol;

    @FXML
    private TableColumn<Category, String> categoryNameCol;

    @FXML
    private TextField categoryKeyTxt;

    @FXML
    private TextField categoryNameTxt;

    @FXML
    private TextArea messageTextArea;

    @FXML
    private Button showCategoryBtn;

    @FXML
    private Button addCategoryBtn;

    @FXML
    private Button updateCategoryBtn;

    @FXML
    private Button deleteCategoryBtn;

    @FXML
    private Button homeBtn;
    
    
    ArrayList<Category> categoriesList;
    Category cat;
    CategoryRepository categoryRepo = new CategoryRepository();
    
    /**
     * Initializing the controller class.
     */
    //This method is automatically called after the fxml file has been loaded.
    @FXML
    private void initialize () {
    	System.out.println("ShowUsersController initiated!");
	
    	// mouseclick eventhandler
    	categoryTable.setOnMouseClicked(this::TableClicked);
    	// Match column with property
    	categoryKeyCol.setCellValueFactory(new PropertyValueFactory<Category, Integer>("categoryKey"));
    	categoryNameCol.setCellValueFactory(new PropertyValueFactory<Category, String>("categoryName"));
    	updateTable();
    }

    
    /**
     * Table clicked.
     *
     * @param event the event
     */
    @FXML
    private void TableClicked(MouseEvent event) {
       cat = categoryTable.getSelectionModel().getSelectedItem();
       categoryKeyTxt.setText(String.valueOf(cat.getCategoryKey())); // Convert to String.
       categoryNameTxt.setText(cat.getCategoryName());
    }
    
    /**
	  * Update table.
	  */
	 // Updating table with result from Db search
		private void updateTable() {
	    	categoriesList = new ArrayList<Category>();
	    	categoriesList = categoryRepo.getAllCategories();
			ObservableList<Category> list = FXCollections.observableArrayList(categoriesList);
			categoryTable.setItems((ObservableList<Category>) list);
		}
		
	@FXML
    void openStartView(ActionEvent event) {
    	//System.out.println("Start view should open");
    	ViewController.activate("StartView");
    }
	
	void showAllCategories() {
		System.out.println("showAllCategories called");
		//TODO
	}
	
	@FXML
    void showSelectedCategory(ActionEvent event) {
    	System.out.println("showSelectedCategory called");
    	//TODO
    }

    @FXML
    void addCategory(ActionEvent event) {
    	System.out.println("addCategory called");
    	//TODO
    }
    
    @FXML
    void updateCategory(ActionEvent event) {
    	System.out.println("updateCategory called");
    	//TODO
    }
    
    
    @FXML
    void deleteCategory(ActionEvent event) {
    	System.out.println("deleteCategory called");
    	//TODO
    }

 

}