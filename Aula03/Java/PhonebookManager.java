import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Phonebook {
    private Map<String, String> contacts = new HashMap<>();

    // Adicionar um novo contato
    public void addContact(String name, String phone) {
        contacts.put(name, phone);
        System.out.println("Contato adicionado: " + name);
    }

    // Editar um contato existente
    public boolean editContact(String name, String phone) {
        if (contacts.containsKey(name)) {
            contacts.put(name, phone);
            System.out.println("Contato atualizado: " + name);
            return true;
        }
        return false;
    }

    // Excluir um contato
    public boolean deleteContact(String name) {
        if (contacts.remove(name) != null) {
            System.out.println("Contato excluído: " + name);
            return true;
        }
        return false;
    }

    // Listar todos os contatos
    public void listContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Nenhum contato encontrado.");
        } else {
            System.out.println("Contatos:");
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                System.out.println("Nome: " + entry.getKey() + ", Telefone: " + entry.getValue());
            }
        }
    }

    // Validar o formato do número de telefone
    public static boolean validatePhoneNumber(String phone) {
        return phone.matches("\\(\\d{2}\\) \\d{4}-\\d{4}");
    }

    // Carregar contatos de um arquivo JSON
    public void loadFromFile(String fileName) {
        try (Reader reader = new FileReader(fileName)) {
            Type type = new TypeToken<Map<String, String>>() {}.getType();
            contacts = new Gson().fromJson(reader, type);
        } catch (FileNotFoundException e) {
            System.out.println("Nenhum arquivo encontrado, iniciando com agenda vazia.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar contatos: " + e.getMessage());
        }
    }

    // Salvar contatos em um arquivo JSON
    public void saveToFile(String fileName) {
        try (Writer writer = new FileWriter(fileName)) {
            new Gson().toJson(contacts, writer);
            System.out.println("Contatos salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar contatos: " + e.getMessage());
        }
    }
}

public class PhonebookManager {

    private static final String FILE_NAME = "contacts.json";
    private static final Phonebook phonebook = new Phonebook();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        phonebook.loadFromFile(FILE_NAME);

        boolean running = true;
        while (running) {
            showMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1 -> addContact();
                case 2 -> editContact();
                case 3 -> deleteContact();
                case 4 -> phonebook.listContacts();
                case 5 -> {
                    phonebook.saveToFile(FILE_NAME);
                    running = false;
                    System.out.println("Saindo...");
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    // Exibir o menu principal
    private static void showMenu() {
        System.out.println("1. Adicionar contato");
        System.out.println("2. Editar contato");
        System.out.println("3. Excluir contato");
        System.out.println("4. Listar contatos");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Receber a escolha do usuário
    private static int getUserChoice() {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, insira um número.");
        }
        return choice;
    }

    // Lidar com a adição de um contato
    private static void addContact() {
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("Número de telefone (formato: (XX) XXXX-XXXX): ");
        String phone = scanner.nextLine();

        if (Phonebook.validatePhoneNumber(phone)) {
            phonebook.addContact(name, phone);
        } else {
            System.out.println("Número de telefone inválido.");
        }
    }

    // Lidar com a edição de um contato
    private static void editContact() {
        System.out.print("Nome do contato a ser editado: ");
        String name = scanner.nextLine();
        System.out.print("Novo número de telefone (formato: (XX) XXXX-XXXX): ");
        String phone = scanner.nextLine();

        if (Phonebook.validatePhoneNumber(phone)) {
            if (!phonebook.editContact(name, phone)) {
                System.out.println("Contato não encontrado.");
            }
        } else {
            System.out.println("Número de telefone inválido.");
        }
    }

    // Lidar com a exclusão de um contato
    private static void deleteContact() {
        System.out.print("Nome do contato a ser excluído: ");
        String name = scanner.nextLine();

        if (!phonebook.deleteContact(name)) {
            System.out.println("Contato não encontrado.");
        }
    }
}
