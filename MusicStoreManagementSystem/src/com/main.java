package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.models.Album;
import com.models.Artist;
import com.models.Sales;
import com.working.AlbumWorking;
import com.working.ArtistWorking;
import com.working.SaleWorking;

public class main {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/musicStoredb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "0000";

    private static AlbumWorking albumWorking;
    private static ArtistWorking artistWorking;
    private static SaleWorking saleWorking;

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            albumWorking = new AlbumWorking(connection);
            artistWorking = new ArtistWorking(connection);
            saleWorking = new SaleWorking(connection);

            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            while (!exit) {
                showMenu();
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addAlbum(scanner);
                        break;
                    case 2:
                        viewAlbum(scanner);
                        break;
                    case 3:
                        updateAlbum(scanner);
                        break;
                    case 4:
                        deleteAlbum(scanner);
                        break;
                    case 5:
                        addArtist(scanner);
                        break;
                    case 6:
                        viewArtist(scanner);
                        break;
                    case 7:
                        updateArtist(scanner);
                        break;
                    case 8:
                        deleteArtist(scanner);
                        break;
                    case 9:
                        recordSale(scanner);
                        break;
                    case 10:
                        viewSale(scanner);
                        break;
                    case 11:
                        updateSale(scanner);
                        break;
                    case 12:
                        cancelSale(scanner);
                        break;
                    case 13:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void showMenu() {
        System.out.println("Music Store Management System");
        System.out.println("1. Add a new album");
        System.out.println("2. View album details");
        System.out.println("3. Update album information");
        System.out.println("4. Delete an album");
        System.out.println("5. Add a new artist");
        System.out.println("6. View artist details");
        System.out.println("7. Update artist information");
        System.out.println("8. Delete an artist");
        System.out.println("9. Record a new sale");
        System.out.println("10. View sales details");
        System.out.println("11. Update sale information");
        System.out.println("12. Cancel a sale");
        System.out.println("13. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addAlbum(Scanner scanner) throws SQLException {
        System.out.print("Enter album ID: ");
        int albumId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter album title: ");
        String title = scanner.nextLine();
        System.out.print("Enter artist ID: ");
        int artistId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter release date (YYYY-MM-DD): ");
        String releaseDate = scanner.nextLine();
        System.out.print("Enter album price: ");
        double price = scanner.nextDouble();

        Album album = new Album(albumId, title, artistId, releaseDate, price);
        albumWorking.addAlbum(album);
        System.out.println("Album added successfully.");
    }

    private static void viewAlbum(Scanner scanner) throws SQLException {
        System.out.print("Enter album ID: ");
        int albumId = scanner.nextInt();

        Album album = albumWorking.getAlbum(albumId);
        if (album != null) {
            System.out.println(album);
        } else {
            System.out.println("Album not found.");
        }
    }

    private static void updateAlbum(Scanner scanner) throws SQLException {
        System.out.print("Enter album ID: ");
        int albumId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new album title: ");
        String title = scanner.nextLine();
        System.out.print("Enter new artist ID: ");
        int artistId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new release date (YYYY-MM-DD): ");
        String releaseDate = scanner.nextLine();
        System.out.print("Enter new album price: ");
        double price = scanner.nextDouble();

        Album album = new Album(albumId, title, artistId, releaseDate, price);
        albumWorking.updateAlbum(album);
        System.out.println("Album updated successfully.");
    }

    private static void deleteAlbum(Scanner scanner) throws SQLException {
        System.out.print("Enter album ID: ");
        int albumId = scanner.nextInt();

        albumWorking.deleteAlbum(albumId);
        System.out.println("Album deleted successfully.");
    }

    private static void addArtist(Scanner scanner) throws SQLException {
        System.out.print("Enter artist ID: ");
        int artistId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter artist name: ");
        String name = scanner.nextLine();
        System.out.print("Enter artist genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter artist country: ");
        String country = scanner.nextLine();

        Artist artist = new Artist(artistId, name, genre, country);
        artistWorking.addArtist(artist);
        System.out.println("Artist added successfully.");
    }

    private static void viewArtist(Scanner scanner) throws SQLException {
        System.out.print("Enter artist ID: ");
        int artistId = scanner.nextInt();

        Artist artist = artistWorking.getArtist(artistId);
        if (artist != null) {
            System.out.println(artist);
        } else {
            System.out.println("Artist not found.");
        }
    }

    private static void updateArtist(Scanner scanner) throws SQLException {
        System.out.print("Enter artist ID: ");
        int artistId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new artist name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new artist genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter new artist country: ");
        String country = scanner.nextLine();

        Artist artist = new Artist(artistId, name, genre, country);
        artistWorking.updateArtist(artist);
        System.out.println("Artist updated successfully.");
    }

    private static void deleteArtist(Scanner scanner) throws SQLException {
        System.out.print("Enter artist ID: ");
        int artistId = scanner.nextInt();

        artistWorking.deleteArtist(artistId);
        System.out.println("Artist deleted successfully.");
    }

    private static void recordSale(Scanner scanner) throws SQLException {
        System.out.print("Enter sale ID: ");
        int saleId = scanner.nextInt();
        System.out.print("Enter album ID: ");
        int albumId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter sale date (YYYY-MM-DD): ");
        String saleDate = scanner.nextLine();
        System.out.print("Enter quantity sold: ");
        int quantitySold = scanner.nextInt();

        Album album = albumWorking.getAlbum(albumId);
        if (album != null) {
            double totalPrice = quantitySold * album.getPrice();
            Sales sale = new Sales(saleId, albumId, saleDate, quantitySold, totalPrice);
            saleWorking.addSale(sale);
            System.out.println("Sale recorded successfully.");
        } else {
            System.out.println("Album not found. Sale cannot be recorded.");
        }
    }

    private static void viewSale(Scanner scanner) throws SQLException {
        System.out.print("Enter sale ID: ");
        int saleId = scanner.nextInt();

        Sales sale = saleWorking.getSale(saleId);
        if (sale != null) {
            System.out.println(sale);
        } else {
            System.out.println("Sale not found.");
        }
    }

    private static void updateSale(Scanner scanner) throws SQLException {
        System.out.print("Enter sale ID: ");
        int saleId = scanner.nextInt();
        System.out.print("Enter new album ID: ");
        int albumId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new sale date (YYYY-MM-DD): ");
        String saleDate = scanner.nextLine();
        System.out.print("Enter new quantity sold: ");
        int quantitySold = scanner.nextInt();

        Album album = albumWorking.getAlbum(albumId);
        if (album != null) {
            double totalPrice = quantitySold * album.getPrice();
            Sales sale = new Sales(saleId, albumId, saleDate, quantitySold, totalPrice);
            saleWorking.updateSale(sale);
            System.out.println("Sale updated successfully.");
        } else {
            System.out.println("Album not found. Sale cannot be updated.");
        }
    }

    private static void cancelSale(Scanner scanner) throws SQLException {
        System.out.print("Enter sale ID: ");
        int saleId = scanner.nextInt();

        saleWorking.deleteSale(saleId);
        System.out.println("Sale cancelled successfully.");
    }
}
