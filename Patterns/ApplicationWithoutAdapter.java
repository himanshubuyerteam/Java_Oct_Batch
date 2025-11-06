// Third-party database libraries (each with different interfaces)
package Patterns;
class MySQLDatabase {
    public void connectToMySQL(String host, int port, String dbName) {
        System.out.println("MySQL: Connected to " + dbName + " at " + host + ":" + port);
    }
    
    public void executeMySQLQuery(String sql) {
        System.out.println("MySQL: Executing query: " + sql);
    }
    
    public void closeMySQLConnection() {
        System.out.println("MySQL: Connection closed");
    }
}

class PostgreSQLDatabase {
    public void pgConnect(String connectionString) {
        System.out.println("PostgreSQL: Connected using: " + connectionString);
    }
    
    public void runQuery(String sql) {
        System.out.println("PostgreSQL: Running query: " + sql);
    }
    
    public void disconnect() {
        System.out.println("PostgreSQL: Disconnected");
    }
}

class MongoDBDatabase {
    public void establishConnection(String uri) {
        System.out.println("MongoDB: Established connection: " + uri);
    }
    
    public void executeMongoCommand(String command) {
        System.out.println("MongoDB: Executing command: " + command);
    }
    
    public void terminateConnection() {
        System.out.println("MongoDB: Connection terminated");
    }
}

// CLIENT CODE - MESSY! Different code for each database
public class ApplicationWithoutAdapter {
    public static void main(String[] args) {
        String dbType = "mysql"; // could be mysql, postgresql, or mongodb
        
        // PROBLEM: Need different code for each database type
        if (dbType.equals("mysql")) {
            MySQLDatabase mysql = new MySQLDatabase();
            mysql.connectToMySQL("localhost", 3306, "mydb");
            mysql.executeMySQLQuery("SELECT * FROM users");
            mysql.closeMySQLConnection();
            
        } else if (dbType.equals("postgresql")) {
            PostgreSQLDatabase postgres = new PostgreSQLDatabase();
            postgres.pgConnect("postgresql://localhost:5432/mydb");
            postgres.runQuery("SELECT * FROM users");
            postgres.disconnect();
            
        } else if (dbType.equals("mongodb")) {
            MongoDBDatabase mongo = new MongoDBDatabase();
            mongo.establishConnection("mongodb://localhost:27017/mydb");
            mongo.executeMongoCommand("db.users.find()");
            mongo.terminateConnection();
        }
        
        // Switching databases requires changing lots of code!
        // Hard to maintain and test!
    }
}