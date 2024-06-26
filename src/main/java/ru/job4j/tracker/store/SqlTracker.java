package ru.job4j.tracker.store;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Store;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    private void init() {
        try (InputStream in = new FileInputStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement ps = cn.prepareStatement("INSERT INTO items(name, created) VALUES(?, ?)");
                var statement = cn.createStatement()) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            ps.execute();
            var resSet = statement.executeQuery(String.format(
                    "SELECT * FROM %s ORDER BY ID DESC LIMIT 1", "items"
            ));
            resSet.next();
            item.setId(resSet.getInt("id"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean flag = false;
        try (var statement = cn.createStatement()) {
            if (statement.executeQuery(String.format(
                    "SELECT * FROM %s ORDER BY ID DESC LIMIT 1", "items"
            )).next()) {
                try (PreparedStatement ps =
                             cn.prepareStatement("UPDATE items SET name = ?, created = ? where id = ?")) {
                    ps.setString(1, item.getName());
                    ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
                    ps.setInt(3, id);
                    ps.execute();
                    flag = true;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try (var statement = cn.createStatement()) {
            if (statement.executeQuery(String.format(
                    "SELECT * FROM %s ORDER BY ID DESC LIMIT 1", "items"
            )).next()) {
                try (PreparedStatement ps =
                             cn.prepareStatement("DELETE FROM items where id = ?")) {
                    ps.setInt(1, id);
                    ps.execute();
                    flag = true;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    @Override
    public List<Item> findAll() {
        List<Item> findItems = new ArrayList<>();
        try (var statement = cn.createStatement()) {
            var resSet = statement.executeQuery("SELECT * FROM items");
            while (resSet.next()) {
                Item item = new Item();
                item.setId(resSet.getInt(1));
                item.setName(resSet.getString(2));
                item.setCreated(resSet.getTimestamp(3).toLocalDateTime());
                findItems.add(item);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return findItems;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> findItems = new ArrayList<>();
        try (var statement = cn.createStatement()) {
            var resSet = statement.executeQuery(String.format("SELECT * FROM items where name = '%s'", key));
            while (resSet.next()) {
                Item item = new Item();
                item.setId(resSet.getInt(1));
                item.setName(resSet.getString(2));
                item.setCreated(resSet.getTimestamp(3).toLocalDateTime());
                findItems.add(item);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return findItems;
    }

    @Override
    public Item findById(int id) {
        Item output = null;
        try (var statement = cn.createStatement()) {
            var resSet = statement.executeQuery(String.format("SELECT * FROM items where id = %d LIMIT 1", id));
            if (resSet.next()) {
                Item item = new Item();
                item.setId(resSet.getInt(1));
                item.setName(resSet.getString(2));
                item.setCreated(resSet.getTimestamp(3).toLocalDateTime());
                output = item;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output;
    }
}