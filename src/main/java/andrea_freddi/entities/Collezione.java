package andrea_freddi.entities;

import andrea_freddi.exceptions.ExistingIdException;
import andrea_freddi.exceptions.NotExistingIdException;

import java.util.ArrayList;
import java.util.List;

public class Collezione {
    private List<Gioco> giochi;

    public Collezione() {
        this.giochi = new ArrayList<>();
    }

    // creo metodo per aggiungere un gioco alla collezione
    public void aggiungiGioco(Gioco gioco) {
        if (giochi.stream().anyMatch(g -> g.getId() == gioco.getId())) {
            throw new ExistingIdException("Gioco già presente nella collezione");
        }
        giochi.add(gioco);
    }

    // creo metodo per rimuovere un gioco dalla collezione
    public void rimuoviGioco(String id) {
        if (giochi.stream().allMatch(g -> g.getId() != id)) {
            throw new NotExistingIdException("Nessun gioco trovato con ID: " + id);
        }
        giochi.removeIf(g -> g.getId() == id);
    }

    // creo metodo per aggiornare il prezzo del gioco in base all'id
    public void aggiornaGioco(String id, double nuovoPrezzo) {
        if (giochi.stream().allMatch(g -> g.getId() != id)) {
            throw new NotExistingIdException("Nessun gioco trovato con ID: " + id);
        }
        giochi.stream()
                .filter(g -> g.getId() == id)
                .forEach(g -> g.setPrezzo(nuovoPrezzo));
    }

    // creo metodo per cercare un gioco per id
    public Gioco ricercaPerId(String id) {
        Gioco giocoTrovato = giochi.stream()
                .filter(g -> g.getId() == id)
                .findFirst().orElseThrow(() -> new NotExistingIdException("Nessun gioco trovato con ID: " + id));
        return giocoTrovato;
    }

    // creo metodo per cercare giochi per prezzo
    public List<Gioco> ricercaPerPrezzo(double prezzoMassimo) {
        List<Gioco> giochiTrovati = giochi.stream()
                .filter(g -> g.getPrezzo() < prezzoMassimo)
                .toList();
        return giochiTrovati;
    }

    // creo metodo per cercare giochi per numero di giocatori
    public List<GiocoDaTavolo> ricercaPerGiocatori(int numeroGiocatori) {
        List<GiocoDaTavolo> giochiTrovati = giochi.stream()
                .filter(g -> g instanceof GiocoDaTavolo)
                .map(g -> (GiocoDaTavolo) g)
                .filter(g -> g.getNumeroGiocatori() == numeroGiocatori)
                .toList();
        return giochiTrovati;
    }

    // creo metodo per visualizzare le statistiche della collezione
    public void visualizzaStatistiche() {
        int numeroVideogiochi = (int) giochi.stream()
                .filter(g -> g instanceof Videogioco)
                .count();
        if (numeroVideogiochi > 0) {
            System.out.println("Numero videogiochi: " + numeroVideogiochi);
        } else {
            System.out.println("Nessun videogioco presente nella collezione");
        }

        int numeroGiochiDaTavolo = (int) giochi.stream()
                .filter(g -> g instanceof GiocoDaTavolo)
                .count();
        if (numeroGiochiDaTavolo > 0) {
            System.out.println("Numero giochi da tavolo: " + numeroGiochiDaTavolo);
        } else {
            System.out.println("Nessun gioco da tavolo presente nella collezione");
        }

        double prezzoMassimo = giochi.stream()
                .mapToDouble(Gioco::getPrezzo)
                .max().orElse(0);
        System.out.println("Prezzo massimo di tutti i giochi nella collezione: " + prezzoMassimo);

        double prezzoMedio = giochi.stream()
                .mapToDouble(Gioco::getPrezzo)
                .average().orElse(0);
        System.out.println("Prezzo medio di tutti i giochi nella collezione: " + prezzoMedio);
    }

}
