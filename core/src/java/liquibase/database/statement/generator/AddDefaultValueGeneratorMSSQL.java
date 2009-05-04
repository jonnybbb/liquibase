package liquibase.database.statement.generator;

import liquibase.database.statement.AddDefaultValueStatement;
import liquibase.database.statement.syntax.Sql;
import liquibase.database.statement.syntax.UnparsedSql;
import liquibase.database.Database;
import liquibase.database.MSSQLDatabase;
import liquibase.database.structure.Column;
import liquibase.database.structure.Table;

public class AddDefaultValueGeneratorMSSQL extends AddDefaultValueGenerator {
    public int getSpecializationLevel() {
        return SPECIALIZATION_LEVEL_DATABASE_SPECIFIC;
    }

    public boolean isValidGenerator(AddDefaultValueStatement statement, Database database) {
        return database instanceof MSSQLDatabase;
    }

    public Sql[] generateSql(AddDefaultValueStatement statement, Database database) {
        return new Sql[] {
                new UnparsedSql("ALTER TABLE " + database.escapeTableName(statement.getSchemaName(), statement.getTableName()) + " ADD CONSTRAINT " + ((MSSQLDatabase) database).generateDefaultConstraintName(statement.getTableName(), statement.getColumnName()) + " DEFAULT " + database.convertJavaObjectToString(statement.getDefaultValue()) + " FOR " + statement.getColumnName(),
                        new Column()
                        .setTable(new Table(statement.getTableName()).setSchema(statement.getSchemaName()))
                        .setName(statement.getColumnName()))
        };
    }
}