package fr.afpa;

// import java.sql.Connection;
// import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO extends DAO<Contact> {

    // AJouter un contact
    public Contact addContact(Contact contact) {
        try {
            ResultSet result = this.connection
                    .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                    .executeQuery("SELECT NEXTVAL('contact_dao_id_seq') as id");
            if (result.first()) {
                long id = result.getLong("id");
                PreparedStatement statement = this.connection.prepareStatement(
                        "INSERT INTO contact_dao(id, name, surname, city, gender, birthday, phone_number, phone_number_professional, nickname, email, postal_code, github, adress)"
                                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                statement.setLong(1, id);
                statement.setString(2, contact.getName());
                statement.setString(3, contact.getSurname());
                statement.setString(4, contact.getCity());
                statement.setString(5, contact.getGender());

                if (contact.getBirthday() != null) {
                    statement.setDate(6, java.sql.Date.valueOf(contact.getBirthday()));

                } else {
                    statement.setNull(6, java.sql.Types.DATE);
                }
                statement.setString(7, contact.getPhoneNumber());
                statement.setString(8, contact.getPhoneNumberProfessional());
                statement.setString(9, contact.getNickname());
                statement.setString(10, contact.getEmail());
                statement.setString(11, contact.getPostalCode());
                statement.setString(12, contact.getGithub());
                statement.setString(13, contact.getAdress());

                statement.executeUpdate();
                contact = this.getById(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return contact;

    }

    public Contact getById(long id) {
        Contact contact = new Contact();

        try {
            ResultSet result = this.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                    .executeQuery("SELECT * FROM contact_dao WHERE id = " + id);

            if (result.first()) {
                LocalDate birthday = LocalDate.parse("1990-01-15");
                contact = new Contact("name", "surname", "city", "adress", "gender", birthday, "nickname",
                        "phoneNumber", "phoneNumberProfessional", "email", "postalCode", "github");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contact;
    }

    public Contact update(Contact contact) {

        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                    .executeQuery("UPDATE contact_dao set name = '" + contact.getName() +
                            "WHERE id = " + contact.getId());

            contact = this.getById(contact.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contact;
    }

    public void delete(Contact contact) {
        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeUpdate("DELETE FROM contact_dao WHERE id = " + contact.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Contact> getAll() {
        List<Contact> contact = new ArrayList<>();

        try {
            ResultSet result = this.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
                    .executeQuery("SELECT * FROM contact_dao");

            while (result.next()) {
                LocalDate birthday = LocalDate.parse("1990-01-15");
                Contact contactList = new Contact("name", "surname", "city", "adress", "gender", birthday, "nickname",
                        "phoneNumber", "phoneNumberProfessional", "email", "postalCode", "github");

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return contact;
    }
}