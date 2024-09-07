
---

# Codelympics

Un'applicazione di giochi per imparare le basi di Java, creata dal team "Trio Of Codelympics (TOC)" composto da Alexis1513, Ilaria-Lee e Fede046.

---

## Descrizione

Codelympics è una piattaforma interattiva pensata per rendere l'apprendimento di Java divertente e coinvolgente attraverso una serie di mini-giochi. Ogni gioco introduce un concetto di programmazione chiave, permettendo agli utenti di imparare facendo.

---

## Funzionalità principali

- Giochi interattivi basati su concetti Java di base (cicli, condizioni, variabili, ecc.)
- Punteggio e classifiche
- Livelli progressivi di difficoltà
- Sistema di tutorial e suggerimenti

---

## Caratteristiche tecniche

- **Linguaggio**: Java (versione 22)
- **Architettura**: il progetto segue un'architettura MVC (Model-View-Controller) per separare la logica di gioco dalla visualizzazione e dal controllo.
- **Persistenza dati**: il salvataggio dei dati avviene in locale tramite file **CSV** per memorizzare classifiche e stati dei giocatori, e file **JSON** per la gestione della configurazione e altre informazioni strutturate.
- **GUI**: sviluppata utilizzando la libreria **JavaFX** per garantire un'interfaccia utente interattiva e responsiva.
- **Testing**: test unitari implementati con **JUnit 5**.
- **Build System**: il progetto utilizza **Maven** per la gestione delle dipendenze e della build.

Per l'elenco completo delle dipendenze, puoi consultare il file `pom.xml`.

---

## Requisiti di sistema

- Java JDK 22+
- Maven (per gestire le dipendenze e la build)

---

## Installazione

1. Clona la repository:
   ```bash
   git clone https://github.com/tuo-username/Codelympics.git
   ```
2. Naviga nella directory del progetto:
   ```bash
   cd Codelympics
   ```
3. Compila ed esegui il progetto:
   ```bash
   mvn clean install
   mvn exec:java
   ```

---

## Utilizzo

1. Dopo aver avviato l'applicazione, seleziona un gioco dalla schermata iniziale.
2. Segui le istruzioni del gioco e risolvi gli esercizi.
3. Accumula punti e scala le classifiche!

---

## Contribuire

Se vuoi contribuire al progetto, segui questi passi:

1. Fai un fork della repository.
2. Crea un branch per le tue modifiche:
   ```bash
   git checkout -b feature/nuova-funzionalità
   ```
3. Fai un commit delle tue modifiche:
   ```bash
   git commit -m 'Aggiunta di una nuova funzionalità'
   ```
4. Fai il push del branch:
   ```bash
   git push origin feature/nuova-funzionalità
   ```
5. Apri una Pull Request.

---

## Licenza

Questo progetto è rilasciato sotto la licenza [MIT](https://choosealicense.com/licenses/mit/).

---

## Autori

Team **Trio Of Codelympics (TOC)**:
- Alexis1513
- Ilaria-Lee
- Fede046

---

