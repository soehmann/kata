************
** Prolog **
************

Diese Kata dient dazu über eine einfache Aufgabe Sicherheit und Routine in der Programmierung zu bekommen. Insbesondere in der Art Und Weise des TDD (siehe Ziele).Die Einfachheit der Aufgabe soll es ermöglichen diese ohne erheblichen Zeitaufwand mehrmals hintereinander durchzuspielen.
Sie dient nicht dazu das erkennen von Pattern oder Algorythmen zu trainieren. Gleichwohl können diese, mit wachsender Sicherheit und Vertrautheit mit der Kata, ebenfalls einen Schwerpunkt bekommen.

In dieser Kata geht es darum das Spiel Mastermind (http://de.wikipedia.org/wiki/Mastermind) in einfacher Art und Weise nach zu programmieren. Im wesentlichen geht es darum, einen 4-Stelligen Farbcode zu erraten. Es stehen dafür die 6 Farben: Rot (R), Gelb (Y), Grün (G), Blau (B), Orange (O), Braun (N) zur Verfügung. Am Anfang sollte der zu erratende Farbcode keine doppelten Farben enthalten.
In max 8 Rateversuchen ist dieser "Mastermind" zu erraten und zwar sowohl die richtigen Farben, als auch die richtige Reihenfolge der Farben. Jeder Rateversuch wird auf diese zwei Kriterien hin bewertet und über zwei Farbcodes: Schwarz (S), Weiß (W) kenntlich gemacht. Dabei steht Weiß für das erraten einer richtige Farbe und Schwarz für das erraten einer richtigen Farbe am richtigen Platz. Es können somit für jede Raterunde max 4 Ergebnis-Farbcodes verteilt werden. Wobei 4x Schwarz der Lösung des Mastermind entsprechen würde.
Ist der Mastermin nach 8 Rateversuchen nicht erraten worden, wird er aufgelöst und ein neues Spiel kann beginnen.

*************
** Projekt **
*************

Das Projekt ist als Webprojekt angelegt. Ziel der Kata ist die Programmierung der Business-Logic und nicht der Ein- & Ausgabe. Diese ist dem Projekt schon (fast) fertig beigefügt. Lediglich eine Implementierung von GameFactory annotiert mit @Component muss angelegt werden. Dies ist wichtig da der Server sonst mit einer Fehlermeldung startet.

Nach der Implementierung der GameFactory wird über "mvn clean install" das Projekt gebaut und dann mittels "mvn jetty:run" der Server gestartet (Konsolenbefehle). Über die Einstiegsseite http://localhost:8080/mastermind kann das Spiel gestartet werden. Der erste eingegebene Farbcode ist derjenige, der in den folgenden 8 Spielrunden erraten werden muss. Nach der Eingabe und abschicken gelangt man auf die Ausgabeseite http://localhost:8080/mastermind/game. Hier wird das Spielergebnis dargestellt. Von hier aus gelangt man auch wieder zur Ausgangsseite zurück um einen weiteren Farbcode einzugeben.

Codeseitig wird dies alles durch den MastermindController gesteuert. Das "Speichern" des jeweiligen Spielstandes geschieht mittel eines GoogleCaches im GameRepository. Sowohl am Controller als auch am Repository müssen keine Änderungen oder Ergänzungen für die Durchführung dieser Kata vorgenommen werden.

Ebenfalls schon vorgegeben sind die Klassen: Code & ColorCode und die Interfaces Game & Guess. Code dient als ValueObject um die Eingabe in das Spiel Mastermind zu übertragen. ColorCode ist ein universelles Ausgabe ValueObject für die Farbcodes und Treffer (Pitches). An beiden müssen und sollten keine Änderungen vorgenommen werden.

Das Interface Game repräsentiert das eigentliche Spiel welches im Repository gespeichert und wieder abgerufen wird. Beim ersten Aufruf wird das Spiel (Game) über die GameFactory mit dem ersten eingegebenen Farbcode initialisiert. Danach wird über play(...) des Spiels die jeweilige Raterunde abgewickelt. Jede Spielrunde wird von einem Guess repräsentiert. Dieses enthält die Farbcodes des Rateversuchs und die Farbcodes der Bewertung (Pitches).

Der Controller kümmert sich um das richtige aufrufen (initialisieren) des Games bei der Eingabe des ersten Farbcodes bzw. das erraten (spielen) des Farbcodes bei den folgenden Eingaben (Rateversuchen). Wird der Mastermind erraten, wird er auch im Repository gelöscht und es kann ein neues Spiel gestartet werden.

Unter dem Package "solution" liegt eine mögliche Lösung zum nachvollziehen. Es geht aber nicht darum diese "Nachzuprogrammieren", sondern sich gemäß den Zielen iterativ eine eigene Lösung zu erarbeiten. Der Schwerpunkt einer Kata liegt weniger in der Lösung, als in dem Weg dorthin.

******************
** Bibliotheken **
******************

Das Web-Interface ist mit Spring umgesetzt. Als zusätzliche Bibliothek steht Guava (http://code.google.com/p/guava-libraries/wiki/GuavaExplained) zur Verfügung.
Als Testframework wird JUnit 4 eingesetzt mit Unterstützung durch EasyMock (http://www.easymock.org/) und Hamcrest (http://code.google.com/p/hamcrest/wiki/Tutorial).

***********
** Steps **
***********

1.) Ausgabe der eingebenen und zu erratenden mastermind Farbcodes. Farbcodes dürfen nur den 6 zugelassenen Farben entsprechen und nicht doppelt vorkommen (Initiale Eingabe mastermind).
    Im Falle eines falschen Farbcodes wird die Eingabe ignoriert und es wird kein Game initialisiert.
2.) Die mastermind Farbcodes als Secret-Farbcode (X) ausgeben, solange der mastermind nicht gelöst wurde.
3.) Ausgabe der Farbcodes des 1. Rateversuchs. (Guess) Auch hier sind unzulässige Eingaben zurückzuweisen. (Guess ignorieren)
4.) Ausgabe der Farbcodes, die den Rateversuch bewerten. (Pitches)
5.) Ausgabe von bis zu 8 Rateversuchen mit ihren Ergebnissen.
6.) Ausgabe der mastermind Farbcodes, wenn dieser erraten wurde. Ansonsten nach dem 8. Rateversuch.
7.) Ausgabereihenfolge der Pitches (Bewertung der Eingabefarbcodes), lässt keinen Rückschluß auf die richtigen/falschen Farbcodes des Rateversuchs zu. (Random)
8.) Zulassen von doppelten Farbcodes für den mastermind/guess.

***********
** Ziele **
***********

a.) Durchlaufen der Steps, wobei im Idealfall (maximaler Übungseffekt) für jeden Step von vorne begonnen wird.
b.) Alle Klassen sind zu 100% abgetestet.
c.) TDD anwenden, Zuständigkeiten & Verantwortlichkeit klären. Tests first!
    (http://www.martinfowler.com/bliki/TestDrivenDevelopment.html),
d.) Nach Möglichkeit auf Objekten arbeiten & Verantwortlichkeiten bestimmen.
    (DDD Prinzip, http://code.google.com/p/ddd-cqrs-base-project/downloads/detail?name=DomainDrivenDesignQuicklyOnline.pdf)