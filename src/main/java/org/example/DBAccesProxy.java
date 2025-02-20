package org.example;

import java.util.List;
import java.time.LocalTime;

class DBAccessProxy implements IDatabaseAccessProxy {
    private IDatabaseDriverAdapter dbAdapter;

    public DBAccessProxy(IDatabaseDriverAdapter adapter) {
        this.dbAdapter = adapter;
    }

    @Override
    public List<String> executeQuery(int[] lineNumbers) {
        var startTime = LocalTime.now();
        List<String> result = dbAdapter.runQuery("Вибрати з таблиці де id (" + lineNumbers.length + ")");
        var endTime = LocalTime.now();
        System.out.println("Запит виконано за " + (endTime.toNanoOfDay() - startTime.toNanoOfDay()) / 1_000_000 + " мс");
        return result;
    }

    @Override
    public void executeQueryNoResult(int[] lineNumbers) {
        var startTime = LocalTime.now();
        dbAdapter.executeUpdate("UPDATE table SET value = 'X' WHERE id IN (" + lineNumbers.length + ")");
        var endTime = LocalTime.now();
        System.out.println("Обновление выполнено за " + (endTime.toNanoOfDay() - startTime.toNanoOfDay()) / 1_000_000 + " мс");
    }

    @Override
    public boolean checkDatabaseStatus() {
        return true; // В этом примере всегда true
    }

    @Override
    public void open(String url) {
        dbAdapter.connect(url);
    }

    @Override
    public void close() {
        dbAdapter.disconnect();
    }

    @Override
    public void commit() {
        System.out.println("Транзакция зафиксирована.");
    }

    @Override
    public void rollback() {
        System.out.println("Транзакция отменена.");
    }
}
