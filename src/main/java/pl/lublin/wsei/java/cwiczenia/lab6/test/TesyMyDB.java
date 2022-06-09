package pl.lublin.wsei.java.cwiczenia.lab6.test;

import java.sql.Connection;

public class TesyMyDB {

    public static void main(String[] args) {
        MyDB db = new MyDB("localhost", 3306, "mydb");
        db.setUser("root");
        db.setPassword("root");
        Connection conn = db.getConnection();
        if (conn != null)
            System.out.println("Połączenie z baza nawiazane");
        db.closeConnection();
        System.out.println("Połączenie z bazą zakończone");

    }
}
