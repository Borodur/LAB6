package pl.lublin.wsei.java.cwiczenia.lab6.test;
import java.sql.*;
import java.util.Properties;

public class MyDB {

    private String user = "root";
    private String password = "root";
    private String host = "LocalHost";
    private String dbName = "mydb";
    private Number port = 3306;

    public static void main(String[] args){
    }

    public MyDB(String host, Number port, String database){
        this.host = host;
        this.port = port;
        this.dbName = database;
    }

    private Connection conn = null;
    private Statement statement = null;

    private void connect(){
        Properties connectionProps = new Properties();
        connectionProps.put("user", user);
        connectionProps.put("password", password);
        connectionProps.put("serverTimezone", "Europe/Warsaw");

        String jdbcString = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
        try {
            conn = DriverManager.getConnection(
                    jdbcString, connectionProps);
            statement = conn.createStatement();
        }
        catch (SQLException e){
            System.out.println("Bład podłaczenia do bazy" + jdbcString);
            System.out.println("Komunikat błędu" + e.getMessage());
            conn = null;
        }
        System.out.println("Connected to database" + dbName);
    }
    public Connection getConnection(){
        if (conn ==  null)
            connect();
        return conn;
    }

    public void closeConnection(){
        if (conn != null)
            try{
                conn.close();
            }catch (SQLException e){
                System.out.println("Błąd przy zamykaniu połączenia bazodanowego:" +e.getMessage());
            }
        conn = null;
    }

    public ResultSet selectData(String selectStatement){
        if((conn != null) && (statement != null))
            try {
                return statement.executeQuery(selectStatement);
            }catch (SQLException e){
                System.out.println("Błąd przy realizacji zapytania: "+selectStatement+", "+e.getMessage());
            }
        return null;
    }
    public void setUser(String root) {
        this.user = root;
    }

    public void setPassword(String root) {
        this.password = root;
    }
}