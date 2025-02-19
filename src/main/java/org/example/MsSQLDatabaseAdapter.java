package org.example;

import java.util.List;
import java.util.ArrayList;

class MsSQLDatabaseAdapter implements IDatabaseDriverAdapter {
    private boolean isConnected = false;

    @Override
    public void connect(String url) {
        isConnected = true;
        System.out.println("Подключено к MS SQL: " + url);
    }

    @Override
    public void disconnect() {
        isConnected = false;
        System.out.println("Отключено от MS SQL.");
    }

    @Override
    public List<String> runQuery(String query) {
        if (!isConnected) throw new IllegalStateException("MS SQL не подключён!");
        List<String> results = new ArrayList<>();
        results.add("Результат из MS SQL для запроса: " + query);
        return results;
    }

    @Override
    public void executeUpdate(String query) {
        if (!isConnected) throw new IllegalStateException("MS SQL не подключён!");
        System.out.println("Обновление в MS SQL: " + query);
    }
}
