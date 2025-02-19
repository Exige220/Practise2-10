package org.example;

import java.util.List;
import java.util.ArrayList;

class MongoDatabaseAdapter implements IDatabaseDriverAdapter {
    private boolean isConnected = false;

    @Override
    public void connect(String url) {
        isConnected = true;
        System.out.println("Подключено к MongoDB: " + url);
    }

    @Override
    public void disconnect() {
        isConnected = false;
        System.out.println("Отключено от MongoDB.");
    }

    @Override
    public List<String> runQuery(String query) {
        if (!isConnected) throw new IllegalStateException("MongoDB не подключён!");
        List<String> results = new ArrayList<>();
        results.add("Результат из MongoDB для запроса: " + query);
        return results;
    }

    @Override
    public void executeUpdate(String query) {
        if (!isConnected) throw new IllegalStateException("MongoDB не подключён!");
        System.out.println("Обновление в MongoDB: " + query);
    }
}
