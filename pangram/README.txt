************
** Prolog **
************

Diese Kata dient dazu über eine einfache

In dieser Kata geht es darum eine Eingabe (Satz) daraufhin zu Überprüfen, ob er alle Buchstaben des Alphabets beinhaltet.

"Ein Pangramm ... oder holoalphabetischer Satz ist ein Satz, der alle Buchstaben des Alphabets enthält. Als echt werden
Pangramme bezeichnet, in denen jeder Buchstabe genau einmal vorkommt, die also gleichzeitig Isogramme sind."
(Wikipedia, http://de.wikipedia.org/wiki/Pangramm)

***********
** Steps **
***********

1.) Eine beliebige Eingabe (Satz, nur Buchstaben), wie z.B.: "Ich finde es hier an der Quelle sehr warm" wieder ausgeben.
2.) Die in der Eingabe verwendeten Buchstaben als Collection ausgeben. Groß-/Kleinschreibung wird synonym verwendet.
3.) Die in der Eingabe verwendete Collection an Buchstaben gegen eine vorgegebene Collection (Alphabet) vergleichen und
    die Differenzmenge zur Vorgabe ausgeben.

***********
** Ziele **
***********

a.) TDD anwenden (http://www.martinfowler.com/bliki/TestDrivenDevelopment.html), Tests first !
    Alle Klassen sind zu 100% abgetestet.
b.) Nach Möglichkeit auf Objekten arbeiten.
    (DDD Prinzip, http://code.google.com/p/ddd-cqrs-base-project/downloads/detail?name=DomainDrivenDesignQuicklyOnline.pdf)
