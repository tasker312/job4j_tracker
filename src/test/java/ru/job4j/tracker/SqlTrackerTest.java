package ru.job4j.tracker;

import org.junit.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SqlTrackerTest {

    private static Connection connection;
    private SqlTracker tracker;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Before
    public void createTracker() {
        tracker = new SqlTracker(connection);
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenFindAll() {
        Item item1 = new Item("Item1");
        Item item2 = new Item("Item2");
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findAll(), is(List.of(item1, item2)));
    }

    @Test
    public void whenFindByName() {
        Item item1 = new Item("Item");
        Item item2 = new Item("Item");
        Item item3 = new Item("Hello");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findByName("Item"), is(List.of(item1, item2)));
        assertThat(tracker.findByName("Hey"), is(List.of()));
    }

    @Test
    public void whenReplace() {
        Item item1 = new Item("Item1");
        tracker.add(item1);
        Item replacedItem = new Item("New");
        replacedItem.setId(item1.getId());
        assertTrue(tracker.replace(item1.getId(), replacedItem));
        assertThat(tracker.findById(item1.getId()), is(replacedItem));
    }

    @Test
    public void whenDelete() {
        Item item1 = new Item("Item1");
        tracker.add(item1);
        assertTrue(tracker.delete(item1.getId()));
        assertNull(tracker.findById(item1.getId()));
        assertFalse(tracker.delete(item1.getId()));
    }
}
