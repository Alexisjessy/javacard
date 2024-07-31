package fr.afpa;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FXMLViewController implements Initializable {
    private static final Pattern PHONE_NUMBER_REGEX = Pattern.compile("^[0-9]{10}$");
    private static final Pattern EMAIL_REGEX = Pattern.compile(
            "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            Pattern.CASE_INSENSITIVE);
    
    private static final Pattern GITHUB_REGEX = Pattern.compile("/<a.*?href\\s*=\\s*[\"\\']([^\"\\'>]+)[\"\\'][^>]*>.*?word.*?<\\/a>/si");
    
    private static boolean isPhoneNumberValid(String phoneNumber) {
        return PHONE_NUMBER_REGEX.matcher(phoneNumber).matches();
    }

    private static boolean isEmailValid(String email) {
        return EMAIL_REGEX.matcher(email).matches();
    }

    private static boolean isGithub(String github) {
        return GITHUB_REGEX.matcher(github).matches();
    }

    private ObservableList<Contact> ContactData = FXCollections.observableArrayList();

    @FXML
    private TableView<Contact> TVContact;
    @FXML
    private TableColumn<Contact, String> columnName;
    @FXML
    private TableColumn<Contact, String> columnSurname;
    @FXML
    private TableColumn<Contact, String> columnCity;
    @FXML
    private TableColumn<Contact, String> columnGender;
    @FXML
    private TableColumn<Contact, LocalDate> columnBirthday;
    @FXML
    private TableColumn<Contact, String> columnNickname;
    @FXML
    private TableColumn<Contact, String> columnPhoneNumber;
    @FXML
    private TableColumn<Contact, String> columnPhoneNumberProfessional;
    @FXML
    private TableColumn<Contact, String> columnEmail;
    @FXML
    private TableColumn<Contact, String> columnPostalCode;
    @FXML
    private TableColumn<Contact, String> columnGithub;

    @FXML
    private TextField textFieldNom;
    @FXML
    private TextField textFieldPrenom;
    @FXML
    private TextField textFieldVille;
    @FXML
    private SplitMenuButton splitMenuButtonGender;
    @FXML
    private DatePicker datePickerBirthday;
    @FXML
    private TextField textFieldNickname;
    @FXML
    private TextField textFieldPhoneNumber;
    @FXML
    private TextField textFieldPhoneNumberProfessional;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textFieldPostalCode;
    @FXML
    private TextField textFieldGithub;
    @FXML
    private Button button_save;
    @FXML
    private Button button_delete;
    @FXML
    private Label errorText;

    @FXML
    private void handleButtonActionSave(ActionEvent event) {
        String name = textFieldNom.getText();
        String surname = textFieldPrenom.getText();
        String city = textFieldVille.getText();
        String gender = splitMenuButtonGender.getText();
        LocalDate birthday = datePickerBirthday.getValue();
        String nickname = textFieldNickname.getText();
        String phoneNumber = textFieldPhoneNumber.getText();
        String phoneNumberProfessional = textFieldPhoneNumberProfessional.getText();
        String email = textFieldEmail.getText();
        String postalCode = textFieldPostalCode.getText();
        String github = textFieldGithub.getText();

        errorText.setText("");

        if (name.isEmpty() || surname.isEmpty() || city.isEmpty() || gender.equals( "Genre")  || postalCode.isEmpty()
                || !isPhoneNumberValid(phoneNumber) || !isEmailValid(email)) {
            if (name.isEmpty()) {
                errorText.setText("Le champ nom est obligatoire.\n");
            }
            if (surname.isEmpty()) {
                errorText.setText(errorText.getText() + "Le champ prénom est obligatoire.\n");
            }
            if (city.isEmpty()) {
                errorText.setText(errorText.getText() + "Le champ ville est obligatoire.\n");
            }
            if (gender.equals("Genre")) {
                errorText.setText(errorText.getText() + "Le champ genre  est obligatoire.\n");
            }
            if (postalCode.isEmpty()) {
                errorText.setText("Le code postal est obligatoire.\n");
            }
            if (!isPhoneNumberValid(phoneNumber)) {
                errorText.setText(errorText.getText() + "Le numéro de téléphone n'est pas valide.\n");
            }
            if (!isEmailValid(email)) {
                errorText.setText(errorText.getText() + "L'email n'est pas valide.\n");
            }
           
            return;
        }

        Contact newContact = new Contact(name, surname, city, gender, birthday, nickname, phoneNumber,
                phoneNumberProfessional, email, postalCode, github);
        ContactData.add(newContact);

        textFieldNom.clear();
        textFieldPrenom.clear();
        textFieldVille.clear();
        splitMenuButtonGender.setText("Genre");
        datePickerBirthday.setValue(null);
        textFieldNickname.clear();
        textFieldPhoneNumber.clear();
        textFieldPhoneNumberProfessional.clear();
        textFieldEmail.clear();
        textFieldPostalCode.clear();
        textFieldGithub.clear();
    }

    @FXML
    private void handleButtonActionCancel(ActionEvent event) {
        textFieldNom.clear();
        textFieldPrenom.clear();
        textFieldVille.clear();
        splitMenuButtonGender.setText("Genre");
        datePickerBirthday.setValue(null);
        textFieldNickname.clear();
        textFieldPhoneNumber.clear();
        textFieldPhoneNumberProfessional.clear();
        textFieldEmail.clear();
        textFieldPostalCode.clear();
        textFieldGithub.clear();
    }

    @FXML
    private void handleGenderMenu(ActionEvent event) {
        MenuItem source = (MenuItem) event.getSource();
        splitMenuButtonGender.setText(source.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        columnCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        columnGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        columnBirthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        columnNickname.setCellValueFactory(new PropertyValueFactory<>("nickname"));
        columnPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        columnPhoneNumberProfessional.setCellValueFactory(new PropertyValueFactory<>("phoneNumberProfessional"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        columnGithub.setCellValueFactory(new PropertyValueFactory<>("github"));

        ContactData.add(new Contact("Reese", "Kyle", "Bordeaux", "Men", LocalDate.of(1990, 1, 1), "Reezy", "123456789",
                "987654321", "reese@example.com", "33000", "reeseGithub"));
        ContactData.add(new Contact("Smith", "John", "Berlin", "Men", LocalDate.of(1985, 5, 15), "Johnny", "123123123",
                "321321321", "john@example.com", "10115", "johnGithub"));

        TVContact.setItems(ContactData);
    }

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
