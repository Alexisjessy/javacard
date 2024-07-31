package fr.afpa;



import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

public class ListContactController {

    @FXML
    private TextField searchTextField;

    @FXML
    private Button clearButton;

    @FXML
    private TableView<Contact> tableView;

    @FXML
    private TableColumn<Contact, String> nameColumn;

    @FXML
    private TableColumn<Contact, String> surnameColumn;

    @FXML
    private TableColumn<Contact, String> address;

    @FXML
    private TableColumn<Contact, String> genderColumn;

    @FXML
    private TableColumn<Contact, String> birthdayColumn;

    @FXML
    private TableColumn<Contact, String> phoneNumberColumn;

    @FXML
    private TableColumn<Contact, String> phonenumberProfessionalColumn;

    @FXML
    private TableColumn<Contact, String> nicknameColumn;

    @FXML
    private TableColumn<Contact, String> cityColumn;

    @FXML
    private TableColumn<Contact, String> emailColumn;

    @FXML
    private TableColumn<Contact, String> postalCodeColumn;

    @FXML
    private TableColumn<Contact, String> githubColumn;

    @FXML
    private Button deleteButton;

    @FXML
    private Button exportButton;

    @FXML
    private ObservableList<Contact> contacts = FXCollections.observableArrayList();

    // Initialisation des objets avec les champs correspondants en colonne
    @FXML
    private void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        phonenumberProfessionalColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumberProfessional"));
        nicknameColumn.setCellValueFactory(new PropertyValueFactory<>("nickname"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        githubColumn.setCellValueFactory(new PropertyValueFactory<>("github"));

        // Implementation
        contacts.add(new Contact("Toto", "Tata", "69 rue toto", "Male", LocalDate.of(2000, 2, 4), "Tota", "123456789",
                "987654321", "john.doe@example.com", "Bordeaux", "12345", "johnDoeGitHub"));
        contacts.add(new Contact("Titi", "Tutu", "56 rue titi", "Female", LocalDate.of(2002, 9, 24), "Titu",
                "123456789", "987654321", "jane.doe@example.com", "Begles", "12345", "janeDoeGitHub"));

        tableView.setItems(contacts);
    }

    // Gestionnaire d'événement

    // Methode pour rechercher dans la liste

    // public Contact findUsingEnhancedForLoop(
    // String name, List<Contact> contacts) {

    // for (Contact contact : contacts) {

    // if (contact.getName().equals(name)) {
    // return contact;
    // }

    // }
    // return null;
    // }

    @FXML
    public void search(KeyEvent event) {
        String searchText = searchTextField.getText().toLowerCase();
        List<Contact> filteredContacts = contacts.stream()
                .filter(contact -> contact.getName().toLowerCase().contains(searchText) ||
                        contact.getSurname().toLowerCase().contains(searchText) ||
                        contact.getAddress().toLowerCase().contains(searchText) ||
                        // contact.getBirthday().toLowerCase().contains(searchText) ||
                        contact.getEmail().toLowerCase().contains(searchText) ||
                        contact.getNickname().toLowerCase().contains(searchText) ||
                        contact.getPhoneNumber().toLowerCase().contains(searchText))
                .collect(Collectors.toList());

        tableView.setItems(FXCollections.observableArrayList(filteredContacts));
        System.out.println();

    }

    // Méthode pour effacer le champ de la recherche et réinitialiser la liste des
    // contacts
    @FXML
    public void clearSearch(ActionEvent event) {
        searchTextField.clear();
        tableView.setItems(contacts);
    }

    // Méthode pour supprimer
    @FXML
    private void delete(ActionEvent event) {
        Contact selectedContact = tableView.getSelectionModel().getSelectedItem();
        if (selectedContact != null) {
            contacts.remove(selectedContact);
        } else {
            System.out.println("Veuiller selectionner le contact à supprimer");

        }
    }

  
       
    



    

}
