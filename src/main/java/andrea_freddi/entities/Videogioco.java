package andrea_freddi.entities;

import andrea_freddi.enums.Genere;

// creo la classe Videogioco figlia della classe Gioco (eredità)
public class Videogioco extends Gioco {
    private String piattaforma;
    private int durataOre;
    private Genere genere;

    // costruttore della classe Videogioco che implementa nuovi attributi
    public Videogioco(int annoPubblicazione, double prezzo, String titolo, int durataOre, Genere genere, String piattaforma) {
        super(annoPubblicazione, prezzo, titolo);
        this.durataOre = durataOre;
        this.genere = genere;
        this.piattaforma = piattaforma;
    }

    public int getDurataOre() {
        return durataOre;
    }

    public Genere getGenere() {
        return genere;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
