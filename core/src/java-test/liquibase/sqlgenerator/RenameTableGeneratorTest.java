package liquibase.sqlgenerator;

public class RenameTableGeneratorTest {
//    @Test
//    public void execute_defaultSchema() throws Exception {
//        new DatabaseTestTemplate().testOnAvailableDatabases(
//                new SqlStatementDatabaseTest(null, new RenameTableStatement(null, TABLE_NAME, NEW_TABLE_NAME)) {
//
//                    protected void preExecuteAssert(DatabaseSnapshot snapshot) {
//                        assertNotNull(snapshot.getTable(TABLE_NAME));
//                        assertNull(snapshot.getTable(NEW_TABLE_NAME));
//                    }
//
//                    protected void postExecuteAssert(DatabaseSnapshot snapshot) {
//                        assertNull(snapshot.getTable(TABLE_NAME));
//                        assertNotNull(snapshot.getTable(NEW_TABLE_NAME));
//                    }
//
//                });
//    }
//
//    @Test
//    public void execute_altSchema() throws Exception {
//        new DatabaseTestTemplate().testOnAvailableDatabases(
//                new SqlStatementDatabaseTest(TestContext.ALT_SCHEMA, new RenameTableStatement(TestContext.ALT_SCHEMA, TABLE_NAME, NEW_TABLE_NAME)) {
//
//                    protected void preExecuteAssert(DatabaseSnapshot snapshot) {
//                        assertNotNull(snapshot.getTable(TABLE_NAME));
//                        assertNull(snapshot.getTable(NEW_TABLE_NAME));
//                    }
//
//                    protected void postExecuteAssert(DatabaseSnapshot snapshot) {
//                        assertNull(snapshot.getTable(TABLE_NAME));
//                        assertNotNull(snapshot.getTable(NEW_TABLE_NAME));
//                    }
//
//                });
//    }
//
////     @Test
////    public void isValidGenerator() throws Exception {
////        new DatabaseTestTemplate().testOnAllDatabases(new DatabaseTest() {
////            public void performTest(Database database) throws Exception {
////
////                if (database instanceof CacheDatabase || database instanceof FirebirdDatabase) {
////                    assertFalse(createGeneratorUnderTest().supportsDatabase(database));
////                } else {
////                    assertTrue(createGeneratorUnderTest().supportsDatabase(database));
////                }
////            }
////        });
////    }

}