package util;

public class TestConnection {
    public static void main(String[] args) {
        try (var conn = DatabaseConnection.getConnection()) {
            System.out.println("Connexion réussie à la base de données!");
        } catch (Exception e) {
            System.out.println("Erreur de connexion: " + e.getMessage());
            e.printStackTrace();
        }
    }
}