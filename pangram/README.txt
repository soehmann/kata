************
** Prolog **
************

Diese Kata dient dazu über eine einfache Aufgabe Sicherheit und Routine in der Programmierung zu bekommen. Insbesondere in der Art Und Weise des TDD (siehe Ziele).Die Einfachheit der Aufgabe soll es ermöglichen diese ohne erheblichen Zeitaufwand mehrmals hintereinander durchzuspielen.
Sie dient nicht dazu das erkennen von Pattern oder Algorythmen zu trainieren. Gleichwohl können diese, mit wachsender Sicherheit und Vertrautheit mit der Kata, ebenfalls einen Schwerpunkt bekommen.

In dieser Kata geht es darum eine Eingabe (Satz) daraufhin zu Überprüfen, ob sie alle Buchstaben des Alphabets beinhaltet.

"Ein Pangramm ... oder holoalphabetischer Satz ist ein Satz, der alle Buchstaben des Alphabets enthält. Als echt werden Pangramme bezeichnet, in denen jeder Buchstabe genau einmal vorkommt, die also gleichzeitig Isogramme sind."
(Wikipedia, http://de.wikipedia.org/wiki/Pangramm)

***********
** Steps **
***********

1.) Eine beliebige Eingabe (Satz, nur Buchstaben), wie z.B.: "Ich finde es hier an der Quelle sehr warm" wieder ausgeben.
2.) Die in der Eingabe verwendeten Buchstaben als Collection ausgeben. Groß-/Kleinschreibung wird synonym verwendet.
3.) Die in der Eingabe verwendete Collection an Buchstaben gegen eine vorgegebene Collection (Alphabet) vergleichen und die Differenzmenge zur Vorgabe ausgeben.
4.) Filtern von Sonder- / Satzzeichen etc. die nicht zur Kollektion eines Pangrams gehört.
5.) Kollektion für ein Pangram dynamisieren.

***********
** Ziele **
***********

a.) TDD anwenden (http://www.martinfowler.com/bliki/TestDrivenDevelopment.html), Tests first !
    Alle Klassen sind zu 100% abgetestet.
b.) Nach Möglichkeit auf Objekten arbeiten & Verantwortlichkeiten bestimmen.
    (DDD Prinzip, http://code.google.com/p/ddd-cqrs-base-project/downloads/detail?name=DomainDrivenDesignQuicklyOnline.pdf)
