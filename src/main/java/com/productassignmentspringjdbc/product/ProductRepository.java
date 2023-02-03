package com.productassignmentspringjdbc.product;

import java.sql.*;
import java.util.ArrayList;

public class ProductRepository {


    public void createProduct(Product product) {
        String query = "INSERT INTO product(name, description, quantity, price, isAvailable) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement statement = this.getConnection().prepareStatement(query);

            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setInt(3, product.getQuantity());
            statement.setDouble(4, product.getPrice());
            statement.setBoolean(5, product.isAvailable());


            statement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }


    public ArrayList<Product> findAllProducts() {
        ArrayList<Product> productList = new ArrayList<>();
        String query = "SELECT * FROM spring_product.product";

        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                productList.add(new Product(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("description"),
                        result.getInt("quantity"),
                        result.getDouble("price"),
                        result.getBoolean("isAvailable")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }


    public void deleteProduct(int productId) {

        String query = "DELETE FROM spring_product.product WHERE id = ?";

        try {
            PreparedStatement statement = this.getConnection().prepareStatement(query);
            statement.setInt(1, productId);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }


    public void updateProduct(int productId, Product updatedProduct) {
        String query = "UPDATE product SET name=?, description=?, quantity=?, price=?, isAvailable=? WHERE id=?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setString(1, updatedProduct.getName());
            statement.setString(2, updatedProduct.getDescription());
            statement.setInt(3, updatedProduct.getQuantity());
            statement.setDouble(4, updatedProduct.getPrice());
            statement.setBoolean(5, updatedProduct.isAvailable());
            statement.setInt(6, productId);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        String username = "root";
        String password = "admin";
        String database = "spring_product";

        String url = "jdbc:mysql://localhost:3306/" + database;

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public Product findProductById(int id) {
        Product product = null;
        String query = "SELECT * FROM spring_product.product WHERE id = ?";

        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                product = new Product(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("description"),
                        result.getInt("quantity"),
                        result.getDouble("price"),
                        result.getBoolean("isAvailable")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

}
