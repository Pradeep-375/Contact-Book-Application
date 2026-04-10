import java.util.*;
public class ContactBook {
    static HashMap<String, String> contacts = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    public static void addContact() {
        System.out.print("Enter name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine().trim();
        if (contacts.containsKey(name)) {
            System.out.println("Contact already exists. Updating number.");
        }
        contacts.put(name, phone);
        System.out.println("Contact saved successfully.");
    }
    public static void deleteContact() {
        System.out.print("Enter name to delete: ");
        String name = sc.nextLine().trim();
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }
    public static void searchContact() {
        System.out.print("Enter name to search: ");
        String name = sc.nextLine().trim();
        if (contacts.containsKey(name)) {
            System.out.println(name + " -> " + contacts.get(name));
        } else {
            System.out.println("Contact not found.");
        }
    }
    public static void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("\nAll Contacts:");
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }
    public static void menu() {
        while (true) {
            System.out.println("\n--- Contact Book ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    deleteContact();
                    break;
                case "3":
                    searchContact();
                    break;
                case "4":
                    displayContacts();
                    break;
                case "5":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    public static void main(String[] args) {
        menu();
    }
}