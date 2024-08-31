package com.working;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.models.Album;

public class AlbumWorking {
	private Connection connection;

    public AlbumWorking(Connection connection) {
        this.connection = connection;
    }

    public void addAlbum(Album album) throws SQLException {
        String query = "INSERT INTO Album (album_id, title, artist_id, release_date, price) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, album.getAlbumId());
            statement.setString(2, album.getTitle());
            statement.setInt(3, album.getArtistId());
            statement.setString(4, album.getReleaseDate());
            statement.setDouble(5, album.getPrice());
            statement.executeUpdate();
        }
    }

    public Album getAlbum(int albumId) throws SQLException {
        String query = "SELECT * FROM Album WHERE album_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, albumId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Album(
                            resultSet.getInt("album_id"),
                            resultSet.getString("title"),
                            resultSet.getInt("artist_id"),
                            resultSet.getString("release_date"),
                            resultSet.getDouble("price")
                    );
                }
            }
        }
        return null;
    }

    public void updateAlbum(Album album) throws SQLException {
        String query = "UPDATE Album SET title = ?, artist_id = ?, release_date = ?, price = ? WHERE album_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, album.getTitle());
            statement.setInt(2, album.getArtistId());
            statement.setString(3, album.getReleaseDate());
            statement.setDouble(4, album.getPrice());
            statement.setInt(5, album.getAlbumId());
            statement.executeUpdate();
        }
    }

    public void deleteAlbum(int albumId) throws SQLException {
        String query = "DELETE FROM Album WHERE album_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, albumId);
            statement.executeUpdate();
        }
    }

    public List<Album> getAllAlbums() throws SQLException {
        List<Album> albums = new ArrayList<>();
        String query = "SELECT * FROM Album";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Album album = new Album(
                        resultSet.getInt("album_id"),
                        resultSet.getString("title"),
                        resultSet.getInt("artist_id"),
                        resultSet.getString("release_date"),
                        resultSet.getDouble("price")
                );
                albums.add(album);
            }
        }
        return albums;
    }
}
