Java Basics
===========

Clase vs Instante
-----------------

Clasele sunt scheletele care contin modelarea si comportamentul
care va fi preluat de catre instante.

Instantele (numite si obiecte) sunt exact ca niste variabile care au
comportamentul definit in clasele respective.

Exemplu clasa:

public class Test {
  public int x;
  public int y;
}

Exemplu instanta:
  Test obiect = new Test(); // obiect este o instanta a clasei Test

Metode vs functii
-----------------

Functiile sunt exact ca cele din alte limbaje. De aici incolo voi folosi
notiunea de metoda: o metoda este o functie care opereaza pe un tip de date,
pe o clasa definita de tine:

public class Test {
  void printX() {
    System.out.println("x"); // echivalentul a cout << "x"; din C++
  }
}

Aici printX este o metoda, deoarece este in interiorul clasei Test.

Constructor
-----------

Constructorul este o metoda care se apeleaza la instantierea unui obiect
(la apelarea keywordului new). Daca nu definim noi unul, compilatorul ne va
face unul default, care initializeaza toate campurile cu valorile lor default
(pentru int/float este 0, pentru String este 'null', etc).

Pentru a defini un constructor, nu ii vom pune tip de return si acesta va
avea numele clasei:

public class Test {
  public Test() {
    System.out.println("Instantiem un nou obiect");
  }
}

Astfel, la crearea unui nou obiect in main:
  Test newObject = new Test(); // prints "Instantiem un nou obiect"
Practic, in interiorul unui constructor ne putem defini orice fel de comportament,
pana aici importanta este constientizarea existentei acestuia.

Keywordul "this"
----------------

Keywordul "this" este o referinta la instanta curenta. Cu alte
cuvinte, daca am avea si un "x" camp in clasa, si un "x" parametru in functie:

public class Test {
  private int x;

  public metoda(int x) {
    System.out.println(x); // afiseaza pe "x" parametrul functiei
    System.out.println(this->x); // afiseaza pe "x" dinauntrul clasei
  }
}

Metoda main
-----------

Pentru a rula codul, in Java efectiv rulam o clasa (click-dreapta pe un fisier
si apoi Run) si acesta va apela metoda main din interiorul clasei sale.
Doar clasele cu metoda main definita pot fi rulate.

Semnatura este: public static void main(String[] args) {}. Un cod complet
cu noile notiuni ar fi:

public class Test {
  private int x;
  private int y;

  public Test(int x, int y) {
    this.x = x; // setam x si y din clasa sa fie cei dati ca parametru
    this.y = y;
  }

  public void showXY() {
    System.out.println("x este: " + this.x + ", iar y: " + this.y); // "+" concateneaza doua stringuri
  }

  public static void main(String[] args) {
    Test a = new Test(5, 7);
    a.showXY(); // "x este: 5, iar y: 7"
  }
}
