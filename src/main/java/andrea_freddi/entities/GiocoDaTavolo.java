package andrea_freddi.entities;

public class GiocoDaTavolo extends Gioco {
    private int numeroGiocatori;
    private int durata;

    public GiocoDaTavolo(int annoPubblicazione, double prezzo, String titolo, int durata, int numeroGiocatori) {
        super(annoPubblicazione, prezzo, titolo);
        this.durata = durata;
        this.numeroGiocatori = numeroGiocatori;
    }

    public int getDurata() {
        return durata;
    }

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }

    @Override
    public String toString() {
        return "GiocoDaTavolo{" +
                "durata=" + durata +
                ", numeroGiocatori=" + numeroGiocatori +
                ", annoPubblicazione=" + annoPubblicazione +
                ", id='" + id + '\'' +
                ", prezzo=" + prezzo +
                ", titolo='" + titolo + '\'' +
                '}';
    }
}
