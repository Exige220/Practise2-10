package org.example;

import java.util.List;
import java.util.ArrayList;

class PostgresSQLDatabaseAdapter implements IDatabaseDriverAdapter {
    private boolean isConnected = false;

    @Override
    public void connect(String url) {
        isConnected = true;
        System.out.println("Під'єднано до PostgreSQL: " + url);
    }

    @Override
    public void disconnect() {
        isConnected = false;
        System.out.println("Від'єднано від PostgreSQL.");
    }

    @Override
    public List<String> runQuery(String query) {
        if (!isConnected) throw new IllegalStateException("PostgreSQL не під'єднано!");
        List<String> results = new ArrayList<>();
        results.add("Результат з PostgreSQL для запита: " + query);
        return results;
    }

    @Override
    public void executeUpdate(String query) {
        if (!isConnected) throw new IllegalStateException("PostgreSQL не під'єднано!");
        System.out.println("Оновлення в PostgreSQL: " + query);
    }
}
