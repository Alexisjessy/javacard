package fr.afpa;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

     private static final Pattern POST_CODE_REGEX = Pattern.compile("^(?:0[1-9]|[1-8]\\d|9[0-8])\\d{3}$");
                
            
    private static final Pattern GITHUB_REGEX = Pattern.compile("^https?://github.com/([a-zA-Z0-9._-]+)$");

    private static boolean isPhoneNumberValid(String phoneNumber) {
        return PHONE_NUMBER_REGEX.matcher(phoneNumber).matches();
    }
    private static boolean isCodePostValid(String postalCode){
        return POST_CODE_REGEX.matcher(postalCode).matches();
    }

    private static boolean isEmailValid(String email) {
        return EMAIL_REGEX.matcher(email).matches();
    }

    private static boolean isGithub(String github) {
        return GITHUB_REGEX.matcher(github).matches();
    }

    private ObservableList<Contact> contacts = FXCollections.observableArrayList();

    @FXML
    private TableView<Contact> TVContact;
    @FXML
    private TableColumn<Contact, String> columnName;
    @FXML
    private TableColumn<Contact, String> columnSurname;
    @FXML
    private TableColumn<Contact, String> columnCity;
    @FXML
    private TableColumn<Contact, String> columnAdress;
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
    private TextField textFieldAdress;
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
        String adress = textFieldAdress.getText();
        String gender = splitMenuButtonGender.getText();
        LocalDate birthday = datePickerBirthday.getValue();
        String nickname = textFieldNickname.getText();
        String phoneNumber = textFieldPhoneNumber.getText();
        String phoneNumberProfessional = textFieldPhoneNumberProfessional.getText();
        String email = textFieldEmail.getText();
        String postalCode = textFieldPostalCode.getText();
        String github = textFieldGithub.getText();
        errorText.setText("");

        if (birthday != null && birthday.isAfter(LocalDate.now())) {
            errorText.setText(errorText.getText() + "La date de naissance ne peut pas être supérieure à la date actuelle.\n");
        }


        if (!github.isEmpty() && !isGithub(github)) {
            errorText.setText(errorText.getText() + "L'adresse Github n'est pas valide.\n");

        }
        if (!phoneNumberProfessional.isEmpty() && !isPhoneNumberValid(phoneNumberProfessional)) {
            errorText.setText(errorText.getText() + "Le numero de telephone professionnel n'est pas valide.\n");
        }
        
        /*
         * Validation of data form
         */
      

        if (name.isEmpty() || surname.isEmpty() || city.isEmpty() || adress.isEmpty() || gender.equals("Genre") ||postalCode.isEmpty() || !isCodePostValid(postalCode)
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
            if (adress.isEmpty()) {
                errorText.setText(errorText.getText() + "Le champ adresse est obligatoire.\n");
            }
            if (gender.equals("Genre")) {
                errorText.setText(errorText.getText() + "Le champ genre est obligatoire.\n");
            }
            if (postalCode.isEmpty()) {
                errorText.setText(errorText.getText() + "Le champ code postal est obligatoire.\n");
            }
            if (!isCodePostValid(postalCode)) {
                errorText.setText(errorText.getText() + "Le code postal n'est pas valide !\n");
            }
            if (!isPhoneNumberValid(phoneNumber)) {
                errorText.setText(errorText.getText() + "Le numéro de téléphone n'est pas valide.\n");
            }
            if (!isEmailValid(email)) {
                errorText.setText(errorText.getText() + "L'email n'est pas valide.\n");
            }
          
            return;
        }
        if (!errorText.getText().isEmpty()) {
            
            return;
        }

        Contact newContact = new Contact(name, surname, city, adress, gender, birthday, nickname, phoneNumber,
                phoneNumberProfessional, email, postalCode, github);
        contacts.add(newContact);

        /* Serialize contacts after adding a new one */
        ContactSerialization.serializeContacts(contacts, "contacts.ser");

        textFieldNom.clear();
        textFieldPrenom.clear();
        textFieldVille.clear();
        textFieldAdress.clear();
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
        textFieldAdress.clear();
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
        textFieldNom.setText("EJ");
        textFieldPrenom.setText("EJ");
        textFieldEmail.setText("al@gmail.com");
        textFieldNickname.setText("EJ");
        textFieldPhoneNumber.setText("0554525251");
        // textFieldPostalCode.setText("EJ");
        textFieldVille.setText("EJ");
        textFieldNickname.setText("EJ");
        textFieldAdress.setText("EJ");
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        columnCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        columnAdress.setCellValueFactory(new PropertyValueFactory<>("adress"));
        columnGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        columnBirthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        columnNickname.setCellValueFactory(new PropertyValueFactory<>("nickname"));
        columnPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        columnPhoneNumberProfessional.setCellValueFactory(new PropertyValueFactory<>("phoneNumberProfessional"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        columnGithub.setCellValueFactory(new PropertyValueFactory<>("github"));

        /* Deserialize contacts during initialization */
        String filename = "contacts.ser";
        List<Contact> deserializedContacts = ContactSerialization.deserializeContacts(filename);
        contacts.addAll(deserializedContacts);

        TVContact.setItems(contacts);
    }

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
