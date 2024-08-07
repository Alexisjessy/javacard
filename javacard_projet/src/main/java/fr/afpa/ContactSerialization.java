package fr.afpa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

public abstract class ContactSerialization {
    private ContactSerialization() {
    }

    public static void serializeContacts(ObservableList<Contact> contacts, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(new ArrayList<>(contacts));
            oos.flush();
            System.out.println(contacts + " a ete serialise");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Contact> deserializeContacts(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (ArrayList<Contact>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
