package Patterns;
interface Database {
    void connect(String connectionInfo);
    void executeQuery(String query);
    void disconnect();
}

// STEP 2: Keep the same third-party libraries (unchanged)
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

// STEP 3: Create Adapters for each database
class MySQLAdapter implements Database {
    private MySQLDatabase mysqlDb;
    
    public MySQLAdapter() {
        this.mysqlDb = new MySQLDatabase();
    }
    
    @Override
    public void connect(String connectionInfo) {
        // Parse connection info and adapt to MySQL format
        mysqlDb.connectToMySQL("localhost", 3306, connectionInfo);
    }
    
    @Override
    public void executeQuery(String query) {
        mysqlDb.executeMySQLQuery(query);
    }
    
    @Override
    public void disconnect() {
        mysqlDb.closeMySQLConnection();
    }
}

class PostgreSQLAdapter implements Database {
    private PostgreSQLDatabase postgresDb;
    
    public PostgreSQLAdapter() {
        this.postgresDb = new PostgreSQLDatabase();
    }
    
    @Override
    public void connect(String connectionInfo) {
        String connectionString = "postgresql://localhost:5432/" + connectionInfo;
        postgresDb.pgConnect(connectionString);
    }
    
    @Override
    public void executeQuery(String query) {
        postgresDb.runQuery(query);
    }
    
    @Override
    public void disconnect() {
        postgresDb.disconnect();
    }
}

class MongoDBAdapter implements Database {
    private MongoDBDatabase mongoDb;
    
    public MongoDBAdapter() {
        this.mongoDb = new MongoDBDatabase();
    }
    
    @Override
    public void connect(String connectionInfo) {
        String uri = "mongodb://localhost:27017/" + connectionInfo;
        mongoDb.establishConnection(uri);
    }
    
    @Override
    public void executeQuery(String query) {
        mongoDb.executeMongoCommand(query);
    }
    
    @Override
    public void disconnect() {
        mongoDb.terminateConnection();
    }
}

// STEP 4: Factory to get the right adapter (Optional but recommended)
class DatabaseFactory {
    public static Database getDatabase(String type) {
        switch (type.toLowerCase()) {
            case "mysql":
                return new MySQLAdapter();
            case "postgresql":
                return new PostgreSQLAdapter();
            case "mongodb":
                return new MongoDBAdapter();
            default:
                throw new IllegalArgumentException("Unknown database type: " + type);
        }
    }
}

// STEP 5: Clean client code - works with ANY database!
public class ApplicationWithAdapter {
    
    // Method that works with any database
    public static void performDatabaseOperations(Database db, String dbName) {
        db.connect(dbName);
        db.executeQuery("SELECT * FROM users");
        db.disconnect();
        System.out.println("---");
    }
    
    public static void main(String[] args) {
        System.out.println("=== Using MySQL ===");
        Database mysqlDb = DatabaseFactory.getDatabase("mysql");
        performDatabaseOperations(mysqlDb, "mydb");
        
        System.out.println("=== Using PostgreSQL ===");
        Database postgresDb = DatabaseFactory.getDatabase("postgresql");
        performDatabaseOperations(postgresDb, "mydb");
        
        System.out.println("=== Using MongoDB ===");
        Database mongoDb = DatabaseFactory.getDatabase("mongodb");
        performDatabaseOperations(mongoDb, "mydb");
        
        // EASY TO SWITCH! Just change the factory parameter
        System.out.println("=== Switching databases dynamically ===");
        String configuredDb = "postgresql"; // from config file
        Database db = DatabaseFactory.getDatabase(configuredDb);
        performDatabaseOperations(db, "production_db");
    }
}
