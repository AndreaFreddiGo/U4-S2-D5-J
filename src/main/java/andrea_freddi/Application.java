package andrea_freddi;

import andrea_freddi.entities.Collezione;
import andrea_freddi.entities.GiocoDaTavolo;
import andrea_freddi.entities.Videogioco;
import andrea_freddi.enums.Genere;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Collezione collezione = new Collezione();

        collezione.aggiungiGioco(new Videogioco(2018, 28.50, "Red Dead Redemption 2", 50, Genere.RPG, "PC"));
        collezione.aggiungiGioco(new Videogioco(2018, 57.00, "Sea of Thieves", 30, Genere.AVVENTURA, "XBOX"));
        collezione.aggiungiGioco(new Videogioco(2017, 18.75, "Fortnite", 100, Genere.SPARATUTTO, "PS5"));
        collezione.aggiungiGioco(new Videogioco(2020, 38.20, "FIFA 21", 40, Genere.SPORT, "PC"));
        collezione.aggiungiGioco(new Videogioco(2020, 47.50, "Cyberpunk 2077", 60, Genere.RPG, "PS4"));
        collezione.aggiungiGioco(new Videogioco(2018, 21.30, "Among Us", 100, Genere.PUZZLE, "PC"));
        collezione.aggiungiGioco(new Videogioco(2014, 35.00, "The Sims 4", 40, Genere.SIMULAZIONE, "PC"));

        collezione.aggiungiGioco(new GiocoDaTavolo(1935, 27.99, "Monopoli", 3, 8));
        collezione.aggiungiGioco(new GiocoDaTavolo(1957, 55.50, "Risiko", 4, 6));
        collezione.aggiungiGioco(new GiocoDaTavolo(1998, 22.10, "Cranium", 1, 8));
        collezione.aggiungiGioco(new GiocoDaTavolo(1995, 37.75, "Catan", 3, 4));
        collezione.aggiungiGioco(new GiocoDaTavolo(2008, 48.00, "Dixit", 3, 6));
        collezione.aggiungiGioco(new GiocoDaTavolo(1989, 20.50, "Taboo", 4, 8));

        boolean esecuzioneGestoreCollezione = true;
        System.out.println("************ GESTORE COLLEZIONE GIOCHI ************");
        while (esecuzioneGestoreCollezione) {
            System.out.println();
            System.out.println("1 - Aggiungi gioco");
            System.out.println("2 - Rimuovi gioco");
            System.out.println("3 - Aggiorna prezzo gioco");
            System.out.println("4 - Ricerca gioco per ID");
            System.out.println("5 - Ricerca giochi per prezzo");
            System.out.println("6 - Ricerca giochi per numero di giocatori");
            System.out.println("7 - Esci");
            System.out.println();

            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    System.out.println("Inserisci il titolo del gioco:");
                    String titolo = scanner.nextLine();
                    System.out.println("Inserisci l'anno di uscita:");
                    int annoUscita = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Inserisci il prezzo:");
                    double prezzo = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Inserisci il genere:");
                    Genere genere = Genere.valueOf(scanner.nextLine().toUpperCase());
                    System.out.println("Inserisci la piattaforma:");
                    String piattaforma = scanner.nextLine();
                    System.out.println("Il gioco è un videogioco o un gioco da tavolo?");
                    String tipoGioco = scanner.nextLine();
                    if (tipoGioco.equalsIgnoreCase("videogioco")) {
                        collezione.aggiungiGioco(new Videogioco(annoUscita, prezzo, titolo, 0, genere, piattaforma));
                    } else if (tipoGioco.equalsIgnoreCase("gioco da tavolo")) {
                        System.out.println("Inserisci il numero minimo di giocatori:");
                        int minGiocatori = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Inserisci il numero massimo di giocatori:");
                        int maxGiocatori = scanner.nextInt();
                        scanner.nextLine();
                        collezione.aggiungiGioco(new GiocoDaTavolo(annoUscita, prezzo, titolo, minGiocatori, maxGiocatori));
                    }
                    break;
                case 2:
                    System.out.println("Inserisci l'ID del gioco da rimuovere:");
                    String idRimozione = scanner.nextLine();
                    collezione.rimuoviGioco(idRimozione);
                    break;
                case 3:
                    System.out.println("Inserisci l'ID del gioco da aggiornare:");
                    String idAggiornamento = scanner.nextLine();
                    System.out.println("Inserisci il nuovo prezzo:");
                    double nuovoPrezzo = scanner.nextDouble();
                    scanner.nextLine();
                    collezione.aggiornaGioco(idAggiornamento, nuovoPrezzo);
                    break;
                case 4:
                    System.out.println("Inserisci l'ID del gioco da cercare:");
                    String idRicerca = scanner.nextLine();
                    System.out.println(collezione.ricercaPerId(idRicerca));
                    break;
                case 5:
                    System.out.println("Inserisci il prezzo massimo:");
                    double prezzoMassimo = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println(collezione.ricercaPerPrezzo(prezzoMassimo));
                    break;
                case 6:
                    System.out.println("Inserisci il numero di giocatori:");
                    int numeroGiocatori = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(collezione.ricercaPerGiocatori(numeroGiocatori));
                    break;
                case 7:
                    esecuzioneGestoreCollezione = false;
                    break;
            }
        }
        scanner.close();
    }
}