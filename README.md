# SchedePG-be

Questo progetto è un backend (BE) sviluppato in Java Spring Boot per consentire a ogni giocatore di D&D 5e di avere sempre con sé tutte le sue schede del personaggio e generare nuovi personaggi in tempi più brevi rispetto allo standard.

## Gestione del BE

Il BE è stato gestito con solo due entità:

- **Utente**: rappresenta l'utente che si registra per accedere alle funzionalità del sito e può avere una lista potenzialmente infinita di personaggi.
- **PG**: rappresenta il personaggio creato dall'utente e contiene tutte le caratteristiche necessarie per essere utilizzato in una campagna di gioco.

I ruoli disponibili per l'utente sono "ROLE_ADMIN", "ROLE_MODERATOR" e "ROLE_USER". Al momento, tutte le funzionalità sono implementate per tutti i ruoli. È stata prevista la possibilità di creare gruppi di giocatori con un "Dungeon Master" ("ROLE_MODERATOR") a capo. Durante la registrazione, l'utente otterrà automaticamente il ruolo di "USER".

Le API esterne non sono state utilizzate in questo progetto. Tutto il codice presente è nativo.

## Come registrarsi ed accedere

Segui questi passaggi per utilizzare l'applicazione:

1. Scarica entrambe le repository.
2. Apri il file `schedaPG > src/main/java > com.VincenzoDePascale.schedePG > auth > runner > AuthRunner`.
   - Rimuovi il commento dalla funzione alla riga 31.
   - Esegui il tuo IDE.
   - Dopo aver completato questa operazione, ri-commenta la funzione e riavvia l'IDE. Nota: L'IDE deve rimanere attivo per utilizzare l'applicazione.

Per continuare, segui le istruzioni presenti nella parte frontend. Puoi trovare il frontend del progetto [qui](https://github.com/VincenzoDePascale/schedePG-fe).

## Test

I test, creati con JUnit 5, sono presenti ma non sono aggiornati.

## Collection Postman

Verrà aggiunta una collection completa che è stata utilizzata per testare tutte le API del progetto.

