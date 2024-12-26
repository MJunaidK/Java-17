module com.module.db {
    requires java.sql;
    requires sqlite.jdbc;
    requires transitive com.module.db;

    exports com.module.db;
}