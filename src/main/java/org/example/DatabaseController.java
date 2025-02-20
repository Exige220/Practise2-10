package org.example;

class DatabaseController {
    private IDatabaseAccessProxy dbProxy;

    public DatabaseController(IDatabaseAccessProxy dbProxy) {
        this.dbProxy = dbProxy;
    }

    public void run() {
        dbProxy.open("jdbc:mysql://localhost:3306/mydatabase");

        if (dbProxy.checkDatabaseStatus()) {
            int[] queryLines = {1, 2, 3, 4, 5};
            System.out.println("Отримані дані: " + dbProxy.executeQuery(queryLines));
            dbProxy.executeQueryNoResult(queryLines);
            dbProxy.commit();
        }

        dbProxy.close();
    }
}
