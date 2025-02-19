package org.example;

import java.util.List;
import java.util.ArrayList;

class PostgresSQLDatabaseAdapter implements IDatabaseDriverAdapter {
    private boolean isConnected = false;

    @Override
    public void connect(String url) {
        isConnected = true;
        System.out.println("Подключено к PostgreSQL: " + url);
    }

    @Override
    public void disconnect() {
        isConnected = false;
        System.out.println("Отключено от PostgreSQL.");
    }

    @Override
    public List<String> runQuery(String query) {
        if (!isConnected) throw new IllegalStateException("PostgreSQL не подключён!");
        List<String> results = new ArrayList<>();
        results.add("Результат из PostgreSQL для запроса: " + query);
        return results;
    }

    @Override
    public void executeUpdate(String query) {
        if (!isConnected) throw new IllegalStateException("PostgreSQL не подключён!");
        System.out.println("Обновление в PostgreSQL: " + query);
    }
}
