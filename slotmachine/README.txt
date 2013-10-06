************
** Prolog **
************

Diese Kata dient dazu über eine einfache Aufgabe Sicherheit und Routine in der Programmierung zu bekommen. Insbesondere in der Art Und Weise des TDD (siehe Ziele).Die Einfachheit der Aufgabe soll es ermöglichen diese ohne erheblichen Zeitaufwand mehrmals hintereinander durchzuspielen.
Sie dient nicht dazu das erkennen von Pattern oder Algorythmen zu trainieren. Gleichwohl können diese, mit wachsender Sicherheit und Vertrautheit mit der Kata, ebenfalls einen Schwerpunkt bekommen.

In dieser Kata geht es darum einen Spielautomaten (einarmiger Bandit) einfach nach zu programmieren. Die von der Maschine ausgeworfenen Kombinationen (am Anfang nur Buchstaben) sollen daraufhin überprüft werden, ob Sie ein sinnvolles Wort ergeben. Ist dies der Fall, soll eine Gewinnnachricht ausgegeben werden.

*************
** Projekt **
*************

Das Projekt ist als Konsolen-Aufgabe angelegt. D.h. außer plain Java sind keine weiteren Bibliotheken zur Programmierung notwenig. Für die Tests stehen JUnit und Easymock zur Verfügung. Die Aufgabe besteht in der Implementierung der Slotmachine. Die App.java dient lediglich dazu die Slotmachine (Einarmiger Bandit) n-Mal zu spielen. Ähnlich dem Vorgehen in einer Spielhalle. Die näheren Anforderungen sind dem Punkt "Steps" zu entnehmen.

Unter dem Package "solution" liegt eine mögliche Lösung zum nachvollziehen. Es geht aber nicht darum diese "Nachzuprogrammieren", sondern sich gemäß den Zielen iterativ eine eigene Lösung zu erarbeiten. Der Schwerpunkt einer Kata liegt weniger in der Lösung, als in dem Weg dorthin.

******************
** Bibliotheken **
******************

Das Web-Interface ist mit Spring umgesetzt.
Als Testframework wird JUnit 4 eingesetzt mit Unterstützung durch EasyMock (http://www.easymock.org/) und Hamcrest (http://code.google.com/p/hamcrest/wiki/Tutorial).

***********
** Steps **
***********

1.) Programmierung eines Einarmigen Banditen (Slotmachine) mit eine festen Anzahl an Walzen (Slots) die nach dem Zufallsprinzip aus einer feste Menge (Buchstaben: a-z, üöä) ein Ergebnis zurückgeben.
    Das Gesamt-Ergebnis aller Walzen ist gegen eine vorgegebene Menge an Worten zu prüfen. Bei einem Treffer, ist dieser (Wort) mit dem erspielten Ergebnis (Walzen) und einer Gewinnnachricht auszugeben. Das ermitteln des Treffers ist case-insensitive.
    Die vorgegebene Menge an Worten kann als fixes Set der Slotmachine zur Verfügung gestellt werden.
2.) Die Slotmachine soll dahingehend erweitert werden, dass die Menge an Worten aus einer konfigurierbaren Datei (Name, Beispiel: words-de.txt) ermittelt wird. Der Aufbau der Datei kann frei gewählt werden.
3.) Die Slotmachine soll dahingehend erweitert werden, dass sowohl die Anzahl an Walzen (Slots) als auch die Werte-Menge der Walzen konfiguriert werden kann.
4.) Die Slotmachine ermittelt die Treffer case sensitive. D.h. die Werte-Menge (Buchstaben) muss um Großbuchstaben erweitert werden.
5.) Die Slotmachine ermittelt einen Treffer, der nur aus einer Teilmenge des erspielten Ergebnisses besteht.
6.) Die Slotmachine ermittelt mehrere Wörter innerhalb des erspielten Ergebnis (unter Berücksichtigung des Leerzeichen). Die Werte Menge wird um ein Leerzeichen ergänzt.

***********
** Ziele **
***********

a.) Durchlaufen der Steps unter Berücksichtigung von Refactoring
b.) Alle Klassen sind zu 100% abgetestet.
c.) TDD anwenden, Zuständigkeiten & Verantwortlichkeit klären. Tests first!
    (http://www.martinfowler.com/bliki/TestDrivenDevelopment.html),
d.) Nach Möglichkeit auf Objekten arbeiten & Verantwortlichkeiten bestimmen.
    (DDD Prinzip, http://code.google.com/p/ddd-cqrs-base-project/downloads/detail?name=DomainDrivenDesignQuicklyOnline.pdf)