Completari
==========

Supraincarcarea constructorului
-------------------------------

O notiune foarte importanta este cea de supraincarcare: posibilitatea
de a avea mai multe metode cu acelasi nume dar tip/numar de parametri diferit.
Momentan ne va interesa doar supraincarcarea constructorului.

public class Test {
  private int x;
  private int y;

  // 1
  public Test(int x, int y) {
    this.x = x;
    this.y = y;
  }

  // 2
  public Test() {
    this.x = 0;
    this.y = 0;
  }

  public void showXY() {
    System.out.println("x este: " + this.x + ", iar y: " + this.y); // "+" concateneaza doua stringuri
  }

  public static void main(String[] args) {
    Test a = new Test(5, 7); // se apeleaza constructorul 1
    Test b = new Test();     // se apeleaza constructorul 2
    a.showXY(); // "x este: 5, iar y: 7"
    b.showXY(); // "x este: 0, iar y: 0"
  }
}

Este important de notat ca fiecare instanta are zona sa de memorie, astfel
campurile din "a" nefiind in nicio legatura cu cele din "b".
Astfel, modificand orice camp din "a", nu le vom afecta pe cele din "b".

Specificatori de acces, getteri si setteri
------------------------------------------

In Java, absolut orice (camp, metoda) trebuie sa aiba un specificator de acces.
Acesta arata de unde poate fi accesat campul::
public - permite acces complet atat din exteriorul cat si din interiorul clasei curente
private - limiteaza accesul doar în cadrul clasei curente
protected - limiteaza accesul doar în cadrul clasei curente si al tuturor descendentilor ei
      (conceptul de descendenta sau de mostenire va fi explicat mai tarziu)
(default) - in cazul în care nu este utilizat explicit nici unul din specificatorii
    de acces de mai sus, accesul este permis doar în cadrul pachetului (package private).

Exemplu:

public class Test {
  public int x;
}

public class OtherClass {
  public static void main(String[] args) {
    Test a = new Test();
    a.x = 7;
    System.out.println(a.x); // prints 7
  }
}

VS:

public class Test {
  private int x;
}

public class OtherClass {
  public static void main(String[] args) {
    Test a = new Test();
    a.x = 7; // eroare, in clasa OtherClass nu putem vedea ca Test are un membru x
    System.out.println(a.x);
  }
}

Cum rezolvam? Vom folosi metode de tip getter si setter.
Un camp care are si getter si setter se mai numeste si proprietate a clasei.
Astfel, un getter este o metoda publica, care returneaza valoarea unui membru,
iar un setter o metoda care o seteaza:

public class Test {
  private int x;

  public void setX(int x) {
    this.x = x;
  }

  public int getX() {
    return this.x;
  }
}

public class OtherClass {
  public static void main(String[] args) {
    Test a = new Test();
    a.setX(7);
    System.out.println(a.getX()); // prints 7
  }
}

Metoda toString
---------------

Observam ca daca vrem sa afisam o instanta a clasei Test cu println, ne va afisa
zona de memorie a acelei instante. Cum evitam acest lucru? Suprascriind metoda
toString (tineti minte semnatura):

public class Test {
  private int x;
  private int y;

  public Test(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public String toString() {
    return "x este: " + this.x + ", iar y: " + this.y;
  }

  public static void main(String[] args) {
    Test a = new Test(5, 7); // se apeleaza constructorul 1
    Test b = new Test();     // se apeleaza constructorul 2
    System.out.println(a); // "x este: 5, iar y: 7"
    System.out.println(b); // "x este: 0, iar y: 0"
  }
}
