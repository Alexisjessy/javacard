package fr.afpa;

import javafx.event.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FXMLViewController implements Initializable {
    /** 
     * 
     */
    private static final Pattern PHONE_NUMBER_REGEX = Pattern.compile("^[0-9]{10}$");
    private static final Pattern EMAIL_REGEX = Pattern.compile(
            "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            Pattern.CASE_INSENSITIVE);

    private static final Pattern POST_CODE_REGEX = Pattern.compile("^(?:0[1-9]|[1-8]\\d|9[0-8])\\d{3}$");

    private static final Pattern GITHUB_REGEX = Pattern.compile("^https?://github.com/([a-zA-Z0-9._-]+)$");

    private static boolean isPhoneNumberValid(String phoneNumber) {
        return PHONE_NUMBER_REGEX.matcher(phoneNumber).matches();
    }

    private static boolean isCodePostValid(String postalCode) {
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
    private TableColumn<Contact, String> adressColumn;

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
    private Button deleteButton;

    @FXML
    private Button exportButton;

    @FXML
    private Label labelResultat;

    @FXML
    private Label labelResultatJson;
    @FXML
    private Button addAllButton;

    /**
     * Method to register a contact in the tableview
     * 
     * @param event
     */
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
            errorText.setText(
                    errorText.getText() + "La date de naissance ne peut pas être supérieure à la date actuelle.\n");
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

        if (name.isEmpty() || surname.isEmpty() || city.isEmpty() || adress.isEmpty() || gender.equals("Genre")
                || postalCode.isEmpty() || !isCodePostValid(postalCode)
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

        Contact selectedContact = tableView.getSelectionModel().getSelectedItem();
        if (selectedContact != null) {
            // Mise à jour du contact existant
            selectedContact.setName(name);
            selectedContact.setSurname(surname);
            selectedContact.setCity(city);
            selectedContact.setAdress(adress);
            selectedContact.setGender(gender);
            selectedContact.setBirthday(birthday);
            selectedContact.setNickname(nickname);
            selectedContact.setPhoneNumber(phoneNumber);
            selectedContact.setPhoneNumberProfessional(phoneNumberProfessional);
            selectedContact.setEmail(email);
            selectedContact.setPostalCode(postalCode);
            selectedContact.setGithub(github);

            tableView.refresh();
        } else {
            // Ajout d'un nouveau contact
            Contact newContact = new Contact(name, surname, city, adress, gender, birthday, nickname, phoneNumber,
                    phoneNumberProfessional, email, postalCode, github);
            contacts.add(newContact);
        }

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
    private void handleAddAll(ActionEvent event) {
        // Sélectionner tous les éléments dans la TableView
        tableView.getSelectionModel().selectAll();
    }

    /**
     * Method for Delete A Contact
     * 
     * @param event
     */
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

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        adressColumn.setCellValueFactory(new PropertyValueFactory<>("adress"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        phonenumberProfessionalColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumberProfessional"));
        nicknameColumn.setCellValueFactory(new PropertyValueFactory<>("nickname"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        githubColumn.setCellValueFactory(new PropertyValueFactory<>("github"));

        // Customisation du comportement de la TableView
        // activation de la sélection multiple
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // Début de la pirouette de traitement des sélections
        // Création d'un EventHandler (déclaré en dessous)
        EventHandler<MouseEvent> onClick = this::handleTableRowMouseClick; // référence de méthode -> lien vers la méthode
        // on ajouter le EventHandler à chaque ligne du tableau
        tableView.setRowFactory(param -> {
            TableRow<Contact> row = new TableRow<>();
            // ajout du EventHandler sur la ligne
            row.setOnMouseClicked(onClick);
            return row;
        });

        /* Deserialize contacts during initialization */
        String filename = "contacts.ser";
        List<Contact> deserializedContacts = ContactSerialization.deserializeContacts(filename);
        contacts.addAll(deserializedContacts);

        tableView.setItems(contacts);
        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                fillForm(newValue);
            }
        });

    }

    // public void mouseClicked (MouseEvent event) {
    // tableView.addEventHandler(MOUSE_CLICKED, click -> click.consume());
    // tableView.addEventFilter(MOUSE_CLICKED, click-> click.consume());
    // tableView.getSelectionModel().clearSelection();
    // }

    private void fillForm(Contact contact) {
        textFieldNom.setText(contact.getName());
        textFieldPrenom.setText(contact.getSurname());
        textFieldVille.setText(contact.getCity());
        textFieldAdress.setText(contact.getAdress());
        splitMenuButtonGender.setText(contact.getGender());
        datePickerBirthday.setValue(contact.getBirthday());
        textFieldNickname.setText(contact.getNickname());
        textFieldPhoneNumber.setText(contact.getPhoneNumber());
        textFieldPhoneNumberProfessional.setText(contact.getPhoneNumberProfessional());
        textFieldEmail.setText(contact.getEmail());
        textFieldPostalCode.setText(contact.getPostalCode());
        textFieldGithub.setText(contact.getGithub());
    }

    /**
     * Méthode permettant de gérer le clic sur le tableau (n'importe quand, même si pas de "contact" sélectionné)
     * Pemret  de gérer la dé-sélection
     * 
     * @param event Evenement souris !
     */
    private void handleTableRowMouseClick(MouseEvent event) {
        // vérification qu'il s'agit bien du clic gauche (PRIMARY)
        if (event.getButton() == MouseButton.PRIMARY) {

            // récupération de la source du clic
            @SuppressWarnings("unchecked") // désactivation du Warning indiquant que le cast (opération de transformation) est dangereux
            TableRow<Contact> row = (TableRow<Contact>) event.getSource();

            // vérification de la séleciton (getItem renvoie "null" si pas de sélection)
            if (row.getItem() == null) {
                // on désélectionne tout
                tableView.getSelectionModel().clearSelection();
                // on détruit l'évènement
                event.consume();
            }
        }
    }

    /**
     * Metho se
     * 
     * @param event
     */
    @FXML
    public void search(KeyEvent event) {
        String searchText = searchTextField.getText().toLowerCase();
        List<Contact> filteredContacts = contacts.stream()
                .filter(contact -> contact.getName().toLowerCase().contains(searchText) ||
                        contact.getSurname().toLowerCase().contains(searchText) ||
                        contact.getAdress().toLowerCase().contains(searchText) ||

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

    @FXML
    public void handleButtonActionExport(ActionEvent event) {

        ObservableList<Contact> selectedContacts = tableView.getSelectionModel().getSelectedItems();

        if (selectedContacts.size() == 0) {
            tableView.getSelectionModel().clearSelection();
            labelResultat.setText("Aucun contact sélectionné.");
             /* Timer to clear the label after a delay */
             Timer timer = new Timer();
             timer.schedule(new TimerTask() {
                 @Override
                 public void run() {

                     Platform.runLater(() -> labelResultat.setText(""));
                 }
             }, 3000);
        } else { // cas où il y a au moins 1 contact

            for (Contact contact : selectedContacts) {
                String filePath = contact.getName() + "_" + contact.getSurname() + ".vcf";
                try {
                    contact.exportToVCard(filePath);
                    labelResultat.setText("Contact exporté en tant que VCard !");

                    /* Timer to clear the label after a delay */
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Platform.runLater(() -> labelResultat.setText(""));
                        }
                    }, 3000);
                } catch (Exception e) {
                    labelResultat.setText("Erreur lors de l'exportation du contact : " + e.getMessage());
                }
            }
        }
    }


    @FXML
    public void handleUnselect() {
        tableView.getSelectionModel().clearSelection();

    }

    @FXML
    private void handleButtonActionExportJson(ActionEvent event) {

        ObservableList<Contact> selectedContacts = tableView.getSelectionModel().getSelectedItems();
        ContactJsonSerializer serializer = new ContactJsonSerializer();

        if (selectedContacts.size() == 0) {
            labelResultatJson.setText("Aucun contact sélectionné.");
            /* Timer to clear the label after a delay */
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {

                    Platform.runLater(() -> labelResultatJson.setText(""));
                }
            }, 3000);
        } else {
            for (Contact contact : selectedContacts) {
                String filePath = contact.getName() + "_" + contact.getSurname() + ".json";
                // serializer.serialize(selectedContacts, "contact.json")

                try {

                    serializer.exportToJson(selectedContacts, filePath);
                    System.out.println("Export avec Succès");
                    labelResultatJson.setText("Contact exporté en tant que fichier Json!");
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {

                        @Override
                        public void run() {

                            Platform.runLater(() -> labelResultatJson.setText(""));
                        }
                    }, 3000);

                } catch (

                IOException e) {
                    System.out.println("Erreur lors de l'export des contacts:" + e.getMessage());
                }
            }
        }
    }

    // Méthode pour supprimer
    @FXML
    private void delete(ActionEvent event) {
        Contact selectedContact = tableView.getSelectionModel().getSelectedItem();
        Alert dialogC = new Alert(AlertType.CONFIRMATION);
        dialogC.setTitle("Alert");
        dialogC.setHeaderText(null);
        dialogC.setContentText("Etes vous sur de vouloir supprimer ce contact ?");

        if (selectedContact != null) {

            Optional<ButtonType> answer = dialogC.showAndWait();
            if (answer.get() == ButtonType.OK) {

                contacts.remove(selectedContact);
                ContactSerialization.serializeContacts(contacts, "contacts.ser");
            }

        } else {
            labelResultatJson.setText("Aucun contact sélectionné.");
            /* Timer to clear the label after a delay */
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {

                    Platform.runLater(() -> labelResultatJson.setText(""));
                }
            }, 3000);
          

        }

    }

   
}
