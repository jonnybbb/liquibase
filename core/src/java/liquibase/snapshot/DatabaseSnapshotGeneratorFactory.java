package liquibase.snapshot;

import liquibase.database.Database;
import liquibase.diff.DiffStatusListener;
import liquibase.exception.DatabaseException;
import liquibase.util.log.LogFactory;
import liquibase.util.plugin.ClassPathScanner;

import java.util.*;
import java.util.logging.Logger;

public class DatabaseSnapshotGeneratorFactory {

    private static DatabaseSnapshotGeneratorFactory instance = new DatabaseSnapshotGeneratorFactory();

    private static final Logger log = LogFactory.getLogger();

    private List<DatabaseSnapshotGenerator> registry = new ArrayList<DatabaseSnapshotGenerator>();

    private DatabaseSnapshotGeneratorFactory() {
        try {
            Class[] classes = ClassPathScanner.getInstance().getClasses(DatabaseSnapshotGenerator.class);

            for (Class<? extends DatabaseSnapshotGenerator> clazz : classes) {
                register(clazz.getConstructor().newInstance());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static DatabaseSnapshotGeneratorFactory getInstance() {
        return instance;
    }

    public SortedSet<DatabaseSnapshotGenerator> getGenerators(final Database database) {
        SortedSet<DatabaseSnapshotGenerator> generators = new TreeSet<DatabaseSnapshotGenerator>(new Comparator<DatabaseSnapshotGenerator>() {
            public int compare(DatabaseSnapshotGenerator o1, DatabaseSnapshotGenerator o2) {
                return Integer.valueOf(o1.getPriority(database)).compareTo(o2.getPriority(database));
            }
        });

        for (DatabaseSnapshotGenerator generator : registry) {
            if (generator.supports(database)) {
                generators.add(generator);
            }
        }

        return generators;
    }

    public DatabaseSnapshot createSnapshot(Database database, String schema, Set<DiffStatusListener> listeners) throws DatabaseException {
        return getGenerators(database).iterator().next().createSnapshot(database, schema, listeners);
    }

    /**
     * Returns instances of all implemented database types.
     */
    public List<DatabaseSnapshotGenerator> getRegistry() {
        return registry;
    }

    public void register(DatabaseSnapshotGenerator snapshotGenerator) {
        registry.add(0, snapshotGenerator);
    }

}