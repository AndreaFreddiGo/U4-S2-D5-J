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

        collezione.aggiungiGioco(new Videogioco(2018, 28.50, "Red Dead Redemption 2", 50, Genere.MMORPG, "PS4"));
        collezione.aggiungiGioco(new Videogioco(2018, 47.00, "Sea of Thieves", 30, Genere.AVVENTURA, "XBOX"));
        collezione.aggiungiGioco(new Videogioco(1993, 18.75, "DOOM", 100, Genere.SPARATUTTO, "PC"));
        collezione.aggiungiGioco(new Videogioco(1993, 15.20, "FIFA International Soccer", 5, Genere.SPORT, "PC"));
        collezione.aggiungiGioco(new Videogioco(1996, 27.50, "Diablo", 20, Genere.RPG, "PC"));
        collezione.aggiungiGioco(new Videogioco(2017, 21.30, "Slaps & Beans", 5, Genere.PICCHIADURO, "PC"));
        collezione.aggiungiGioco(new Videogioco(2000, 35.00, "The Sims", 40, Genere.SIMULAZIONE, "PC"));

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
                    int annoUscita = Integer.parseInt(scanner.nextLine());
                    scanner.nextLine();
                    System.out.println("Inserisci il prezzo:");
                    double prezzo = Double.parseDouble(scanner.nextLine());
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
                        int minGiocatori = Integer.parseInt(scanner.nextLine());
                        scanner.nextLine();
                        System.out.println("Inserisci il numero massimo di giocatori:");
                        int maxGiocatori = Integer.parseInt(scanner.nextLine());
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
                    double nuovoPrezzo = Double.parseDouble(scanner.nextLine());
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
                    double prezzoMassimo = Double.parseDouble(scanner.nextLine());
                    scanner.nextLine();
                    collezione.ricercaPerPrezzo(prezzoMassimo)
                            .forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Inserisci il numero di giocatori:");
                    int numeroGiocatori = Integer.parseInt(scanner.nextLine());
                    scanner.nextLine();
                    collezione.ricercaPerGiocatori(numeroGiocatori)
                            .forEach(System.out::println);
                    break;
                case 7:
                    System.out.println("Arrivederci!");
                    esecuzioneGestoreCollezione = false;
                    break;
            }
        }
        scanner.close();
    }
}