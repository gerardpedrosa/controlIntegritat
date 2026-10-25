public class Usuari {

    String nom;
    byte[] salt;
    String hash;

    public Usuari(String nom, byte[] salt, String hash) {
        this.nom = nom;
        this.salt = salt;
        this.hash = hash;
    }
}
