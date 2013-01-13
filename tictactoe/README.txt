************
** Prolog **
************

Diese Kata dient dazu über eine einfache Aufgabe Sicherheit und Routine in der Programmierung zu bekommen. Insbesondere in der Art Und Weise des TDD (siehe Ziele).Die Einfachheit der Aufgabe soll es ermöglichen diese ohne erheblichen Zeitaufwand mehrmals hintereinander durchzuspielen.
Sie dient nicht dazu das erkennen von Pattern oder Algorythmen zu trainieren. Gleichwohl können diese, mit wachsender Sicherheit und Vertrautheit mit der Kata, ebenfalls einen Schwerpunkt bekommen.

In dieser Kata geht es darum das Spiel TicTacToe (http://de.wikipedia.org/wiki/Tic_Tac_Toe) in einfacher Art und Weise nach zu programmieren. Das Spiel wird von zwei menschlichen Spielern gegeneinander gespielt. In der Kata geht es nicht darum eine mögliche KI für das Spiel zu entwickeln. Ziel des Spiels das ein Spieler drei Felder in einer Reihe (horizontal, diagonal, vertical) mit seinem Zeichen besetzt.

*************
** Projekt **
*************

Das Projekt ist als Webprojekt angelegt. Ziel der Kata ist die Programmierung der Business-Logic und nicht der Ein- & Ausgabe. Diese ist dem Projekt schon fertig beigefügt.

Das Project wird über "mvn clean install" das Projekt gebaut und dann mittels "mvn jetty:run" der Server gestartet (Konsolenbefehle). Über die Einstiegsseite http://localhost:8080/tictactoe kann das Spiel gestartet werden. Mit dem eingeben des ersten SpielerTag (z.B. X) startet das Spiel. Danach ist dann der zweiten Spieler mit seinem Tag (z.B. O) dran. immer abwechselnd wird gespielt.

Codeseitig wird dies alles durch den TicTacToeController gesteuert. Das "Speichern" des jeweiligen Spielstandes geschieht mittel eines GoogleCaches im GameRepository. Sowohl am Controller als auch am Repository müssen keine Änderungen oder Ergänzungen für die Durchführung dieser Kata vorgenommen werden.

Das Initiale erstellen eines Spiels erfolgt in der GameFactory Implementierung. In der Anfangimplementierung wird hier aber kein Spiel erzeugt, so das auch kein Spielstand gespeichert wird. Ebenfalls schon vorgegeben sind die Klassen: Field & Gameboard und das Interfaces Game. Das Field representiert die einzelnen Inputfelder auf der Spielfläche (dem GameBoard). Field und GameBoard sind ledigliche Viewobjekte und müssen für die Kata nicht verändert werden.

Das Interface Game repräsentiert das eigentliche Spiel welches im Repository gespeichert und wieder abgerufen wird. Beim ersten Aufruf wird das Spiel (Game) über die GameFactory create(...) mit dem ersten eingegebenen SpielerTag initialisiert. Danach wird über play(...) des Spiels die jeweilige nächste Eingabe abgewickelt.

Der Controller kümmert sich um das richtige aufrufen (initialisieren) des Games bei der Eingabe des ersten SpielerTags bzw. darstellen ob das Spiel zuende ist und ob es einen Gewinner gab und wie dieser heißt bzw. ob es im Unendschieden endete. Mit dem Ende des Spiels wird dieses auch im Repository gelöscht und es kann ein neues Spiel gestartet werden.

Unter dem Package "solution" liegt eine mögliche Lösung zum nachvollziehen. Es geht aber nicht darum diese "Nachzuprogrammieren", sondern sich gemäß den Zielen iterativ eine eigene Lösung zu erarbeiten. Der Schwerpunkt einer Kata liegt weniger in der Lösung, als in dem Weg dorthin.

******************
** Bibliotheken **
******************

Das Web-Interface ist mit Spring umgesetzt. Als zusätzliche Bibliothek steht Guava (http://code.google.com/p/guava-libraries/wiki/GuavaExplained) zur Verfügung.
Als Testframework wird JUnit 4 eingesetzt mit Unterstützung durch EasyMock (http://www.easymock.org/) und Hamcrest (http://code.google.com/p/hamcrest/wiki/Tutorial).

***********
** Steps **
***********

1.  Bei der Spielinitialisierung aus dem Gameboard das Spiel TicTacToe erzeugen.
2.  Überprüfen welche Felder schon gespielt wurden (Abgleich GameBoard Felder und TicTacToe).
    Schon gespielte Felder dürfen nicht von dem anderen Spieler "gekapert" werden.
3.  Überprüfen ob es eine 3er-Folge gibt
3.1 Wenn ja Game als solved markieren mit dem Siegername
3.2 Wenn nein nächsten Versuch starten
4.  Wenn kein Zug mehr möglich, Sieger feststellen oder unendschieden
5.  Wenn kein Zug mehr sinnvoll, Sieger feststellen oder unendschieden

***********
** Ziele **
***********

a.) Durchlaufen der Steps, wobei im Idealfall (maximaler Übungseffekt) für jeden Step von vorne begonnen wird.
b.) Alle Klassen sind zu 100% abgetestet.
c.) TDD anwenden, Zuständigkeiten & Verantwortlichkeit klären. Tests first!
    (http://www.martinfowler.com/bliki/TestDrivenDevelopment.html),
d.) Nach Möglichkeit auf Objekten arbeiten & Verantwortlichkeiten bestimmen.
    (DDD Prinzip, http://code.google.com/p/ddd-cqrs-base-project/downloads/detail?name=DomainDrivenDesignQuicklyOnline.pdf)