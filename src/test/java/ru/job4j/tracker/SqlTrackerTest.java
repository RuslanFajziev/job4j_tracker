package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class SqlTrackerTest {

    static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
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
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void testReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item itemNew = new Item("itemNew");
        tracker.add(item);
        tracker.replace(item.getId(), itemNew);
        assertThat(tracker.findById(item.getId()).getName(), is(itemNew.getName()));
    }

    @Test
    public void testDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        Item item3 = new Item("item3");
        Item itemNew = new Item("itemNew");
        itemNew.setId(item3.getId());
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        int idItem = item2.getId();
        assertTrue(tracker.delete(idItem));
        assertFalse(tracker.delete(idItem));
    }

    @Test
    public void testFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        Item item3 = new Item("item3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> list = tracker.findAll();
        assertThat(list.get(0).getName(), is("item1"));
        assertThat(list.get(1).getName(), is("item2"));
        assertTrue(list.get(2).getName().equals("item3"));
    }

    @Test
    public void testFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("pupok");
        Item item2 = new Item("item2");
        Item item3 = new Item("pupok");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> list = tracker.findByName("pupok");
        assertThat(list.get(0).getName(), is("pupok"));
        assertThat(list.get(1).getName(), is("pupok"));
    }

    @Test
    public void testFindById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("pupok");
        Item item2 = new Item("item2");
        Item item3 = new Item("pupok");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findById(item1.getId()).getName(), is("pupok"));
        assertThat(tracker.findById(item3.getId()).getName(), is("pupok"));
    }
}