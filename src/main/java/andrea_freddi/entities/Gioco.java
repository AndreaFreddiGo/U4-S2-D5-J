package andrea_freddi.entities;

import java.util.UUID;

// creo la classe astratta Gioco (astratta perché non deve essere direttamente istanziata)
abstract class Gioco {
    protected String id;
    protected String titolo;
    protected int annoPubblicazione;
    protected double prezzo;

    // invece di creare un id in fase di istanza passandolo come parametro,
    // lo creo direttamente nel costruttore con UUID che mi permette di generare un id univoco
    public Gioco(int annoPubblicazione, double prezzo, String titolo) {
        this.id = String.valueOf(UUID.randomUUID());
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public String getId() {
        return id;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getTitolo() {
        return titolo;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
