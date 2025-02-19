package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IDatabaseDriverAdapter adapter;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Оберіть тип БД: ");

        String dbType = scanner.nextLine();

        switch (dbType) {
            case "MS SQL":
                adapter = new MsSQLDatabaseAdapter();
                break;
            case "PostgreSQL":
                adapter = new PostgresSQLDatabaseAdapter();
                break;
            case "MongoDB":
                adapter = new MongoDatabaseAdapter();
                break;
            default:
                throw new IllegalArgumentException("Невідомий тип БД!");
        }

        IDatabaseAccessProxy dbProxy = new DBAccessProxy(adapter);
        DatabaseController controller = new DatabaseController(dbProxy);
        controller.run();
    }
}
