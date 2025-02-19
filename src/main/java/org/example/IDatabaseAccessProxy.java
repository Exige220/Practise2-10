package org.example;

import java.util.List;

interface IDatabaseAccessProxy {
    List<String> executeQuery(int[] lineNumbers);
    void executeQueryNoResult(int[] lineNumbers);
    boolean checkDatabaseStatus();
    void open(String url);
    void close();
    void commit();
    void rollback();
}
