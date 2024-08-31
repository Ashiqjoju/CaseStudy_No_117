package com.working;
import com.models.Sales;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SaleWorking {
    private Connection connection;

    public SaleWorking(Connection connection) {
        this.connection = connection;
    }

    public void addSale(Sales sale) throws SQLException {
        String query = "INSERT INTO Sales (sale_id, album_id, sale_date, quantity_sold, total_price) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, sale.getSaleId());
            statement.setInt(2, sale.getAlbumId());
            statement.setString(3, sale.getSaleDate());
            statement.setInt(4, sale.getQuantitySold());
            statement.setDouble(5, sale.getTotalPrice());
            statement.executeUpdate();
        }
    }

    public Sales getSale(int saleId) throws SQLException {
        String query = "SELECT * FROM Sales WHERE sale_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, saleId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Sales(
                            resultSet.getInt("sale_id"),
                            resultSet.getInt("album_id"),
                            resultSet.getString("sale_date"),
                            resultSet.getInt("quantity_sold"),
                            resultSet.getDouble("total_price")
                    );
                }
            }
        }
        return null;
    }

    public void updateSale(Sales sale) throws SQLException {
        String query = "UPDATE Sales SET album_id = ?, sale_date = ?, quantity_sold = ?, total_price = ? WHERE sale_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, sale.getAlbumId());
            statement.setString(2, sale.getSaleDate());
            statement.setInt(3, sale.getQuantitySold());
            statement.setDouble(4, sale.getTotalPrice());
            statement.setInt(5, sale.getSaleId());
            statement.executeUpdate();
        }
    }

    public void deleteSale(int saleId) throws SQLException {
        String query = "DELETE FROM Sales WHERE sale_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, saleId);
            statement.executeUpdate();
        }
    }

    public List<Sales> getAllSales() throws SQLException {
        List<Sales> sales = new ArrayList<>();
        String query = "SELECT * FROM Sales";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Sales sale = new Sales(
                        resultSet.getInt("sale_id"),
                        resultSet.getInt("album_id"),
                        resultSet.getString("sale_date"),
                        resultSet.getInt("quantity_sold"),
                        resultSet.getDouble("total_price")
                );
                sales.add(sale);
            }
        }
        return sales;
    }
}
