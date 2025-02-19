package org.example;
import java.util.List;

interface IDatabaseDriverAdapter {
    void connect(String url);
    void disconnect();
    List<String> runQuery(String query);
    void executeUpdate(String query);
}
