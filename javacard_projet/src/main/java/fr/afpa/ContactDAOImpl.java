package fr.afpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactDAOImpl implements DAOInterface<Contact> {

    private List<Contact> contactList = new ArrayList<>();
    public Connection conn = DbConnection.getInstance();
//    static Connection conn;
   static Statement stmt ;
   static String user;
   static String pass;
    // private Connection getConnection() throws SQLException {
        // String url = "jdbc:postgresql://localhost:6132/contact_db";
        // System.out.println("Tentative de connexion à la base de données...");
        // Connection connection = DriverManager.getConnection(url, "postgres", "B@nLgU4qz*9?D~3n83");
        // System.out.println("Connexion établie avec succès !");
    //     return conn;
    // }

    @Override
    public void add(Contact contact) {
        String sql = "INSERT INTO contact (name, surname, city, adress, gender, birthday, nickname, phone_number, phone_number_professional, email, postal_code, github) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id";

        try (
                PreparedStatement pstmt = this.conn.prepareStatement(sql)) {

            pstmt.setString(1, contact.getName());
            pstmt.setString(2, contact.getSurname());
            pstmt.setString(3, contact.getCity());
            pstmt.setString(4, contact.getAdress());
            pstmt.setString(5, contact.getGender());
            // Vérifiez si birthday est null avant de le définir
            if (contact.getBirthday() != null) {
                pstmt.setDate(6, java.sql.Date.valueOf(contact.getBirthday()));
            } else {
                pstmt.setNull(6, java.sql.Types.DATE);
            }

            pstmt.setString(7, contact.getNickname());
            pstmt.setString(8, contact.getPhoneNumber());
            pstmt.setString(9, contact.getPhoneNumberProfessional());
            pstmt.setString(10, contact.getEmail());
            pstmt.setString(11, contact.getPostalCode());
            pstmt.setString(12, contact.getGithub());

            // Exécution de l'insertion et récupération de l'ID
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                contact.setId(generatedId);
                System.out.println("Contact ajouté avec ID : " + generatedId);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du contact : " + e.getMessage());
        }
        contactList.add(contact);
    }

    @Override
    public Contact getById(int id) {
        String query = "SELECT * FROM contact WHERE id = ?";
        Contact contact = null;

        try (
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                contact = mapToContact(rs);
                System.out.println("Contact récupéré avec succès : " + contact.getName() + " " + contact.getSurname());
            } else {
                System.out.println("Aucun contact trouvé avec l'ID : " + id);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du contact : " + e.getMessage());
        }

        return contact;
    }

    @Override
    public List<Contact> getAll() {
        String query = "SELECT * FROM contact";
        List<Contact> contacts = new ArrayList<>();

        try (
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query)) {
            while (rs.next()) {
                contacts.add(mapToContact(rs));
            }
            System.out.println("Tous les contacts récupérés avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des contacts : " + e.getMessage());
        }

        return contacts;
    }

    @Override
    public void update(Contact contact) {
        String query = "UPDATE contact SET name = ?, surname = ?, city = ?, adress = ?, gender = ?, birthday = ?, nickname = ?, phone_number = ?, phone_number_professional = ?, email = ?, postal_code = ?, github = ? WHERE id = ?";

        try (
            PreparedStatement pstmt = this.conn.prepareStatement(query)) {
            pstmt.setString(1, contact.getName());
            pstmt.setString(2, contact.getSurname());
            pstmt.setString(3, contact.getCity());
            pstmt.setString(4, contact.getAdress());
            pstmt.setString(5, contact.getGender());
            if (contact.getBirthday() != null) {
                pstmt.setDate(6, java.sql.Date.valueOf(contact.getBirthday()));
            } else {
                pstmt.setNull(6, java.sql.Types.DATE);
            }
            pstmt.setString(7, contact.getNickname());
            pstmt.setString(8, contact.getPhoneNumber());
            pstmt.setString(9, contact.getPhoneNumberProfessional());
            pstmt.setString(10, contact.getEmail());
            pstmt.setString(11, contact.getPostalCode());
            pstmt.setString(12, contact.getGithub());
            pstmt.setInt(13, contact.getId());

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " contact(s) mis à jour avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour du contact : " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM contact WHERE id = ?";

        try (
            PreparedStatement pstmt = this.conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Contact supprimé avec succès !");
            } else {
                System.out.println("Aucun contact trouvé avec l'ID : " + id);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du contact : " + e.getMessage());
        }
    }

    private Contact mapToContact(ResultSet rs) throws SQLException {
        Contact contact = new Contact();
        contact.setId(rs.getInt("id"));
        contact.setName(rs.getString("name"));
        contact.setSurname(rs.getString("surname"));
        contact.setCity(rs.getString("city"));
        contact.setAdress(rs.getString("adress"));
        contact.setGender(rs.getString("gender"));
        // contact.setBirthday(rs.getDate("birthday").toLocalDate());
        java.sql.Date birthday = rs.getDate("birthday");
        if (birthday != null) {
            contact.setBirthday(birthday.toLocalDate());
        } else {
            contact.setBirthday(null);
        }
        contact.setNickname(rs.getString("nickname"));
        contact.setPhoneNumber(rs.getString("phone_number"));
        contact.setPhoneNumberProfessional(rs.getString("phone_number_professional"));
        contact.setEmail(rs.getString("email"));
        contact.setPostalCode(rs.getString("postal_code"));
        contact.setGithub(rs.getString("github"));
        return contact;
    }
    
}
