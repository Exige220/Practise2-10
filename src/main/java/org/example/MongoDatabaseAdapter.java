package org.example;

import java.util.List;
import java.util.ArrayList;

class MongoDatabaseAdapter implements IDatabaseDriverAdapter {
    private boolean isConnected = false;

    @Override
    public void connect(String url) {
        isConnected = true;
        System.out.println("Під'єднано до MongoDB: " + url);
    }

    @Override
    public void disconnect() {
        isConnected = false;
        System.out.println("Від'єднано від MongoDB.");
    }

    @Override
    public List<String> runQuery(String query) {
        if (!isConnected) throw new IllegalStateException("MongoDB не під'єднано!");
        List<String> results = new ArrayList<>();
        results.add("Результат з MongoDB для запита: " + query);
        return results;
    }

    @Override
    public void executeUpdate(String query) {
        if (!isConnected) throw new IllegalStateException("MongoDB не під'єднано!");
        System.out.println("Оновлення в MongoDB: " + query);
    }
}
