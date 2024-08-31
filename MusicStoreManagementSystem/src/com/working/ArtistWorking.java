package com.working;

import com.models.Artist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistWorking {
    private Connection connection;

    public ArtistWorking(Connection connection) {
        this.connection = connection;
    }

    public void addArtist(Artist artist) throws SQLException {
        String query = "INSERT INTO Artist (artist_id, name, genre, country) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, artist.getArtistId());
            statement.setString(2, artist.getName());
            statement.setString(3, artist.getGenre());
            statement.setString(4, artist.getCountry());
            statement.executeUpdate();
        }
    }

    public Artist getArtist(int artistId) throws SQLException {
        String query = "SELECT * FROM Artist WHERE artist_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, artistId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Artist(
                            resultSet.getInt("artist_id"),
                            resultSet.getString("name"),
                            resultSet.getString("genre"),
                            resultSet.getString("country")
                    );
                }
            }
        }
        return null;
    }

    public void updateArtist(Artist artist) throws SQLException {
        String query = "UPDATE Artist SET name = ?, genre = ?, country = ? WHERE artist_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, artist.getName());
            statement.setString(2, artist.getGenre());
            statement.setString(3, artist.getCountry());
            statement.setInt(4, artist.getArtistId());
            statement.executeUpdate();
        }
    }

    public void deleteArtist(int artistId) throws SQLException {
        String query = "DELETE FROM Artist WHERE artist_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, artistId);
            statement.executeUpdate();
        }
    }

    public List<Artist> getAllArtists() throws SQLException {
        List<Artist> artists = new ArrayList<>();
        String query = "SELECT * FROM Artist";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Artist artist = new Artist(
                        resultSet.getInt("artist_id"),
                        resultSet.getString("name"),
                        resultSet.getString("genre"),
                        resultSet.getString("country")
                );
                artists.add(artist);
            }
        }
        return artists;
    }
}
