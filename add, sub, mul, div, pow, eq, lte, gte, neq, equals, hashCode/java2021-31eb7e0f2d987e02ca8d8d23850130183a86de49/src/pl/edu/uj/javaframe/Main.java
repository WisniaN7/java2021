package pl.edu.uj.javaframe;

import java.io.IOException;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        // DataFrame df = new DataFrame(new Class[] {Int.class, Int.class}, new String[] {"kol1","kol2"});

        // df.addRow(new String[]{"12","23"});
        // df.addRow(new String[]{"1244","23"}); df.addRow(new String[]{"1244","2553"});
        // df.addRow(new String[]{"12","2300"});

//      INSTRUKCJE DO ĆWICZEŃ I

//      Dopisz metodę print w klasie DataFrame wypisującą zawartość dataframe
//      df.print();

//      Dodaj klasę ImaginaryDouble oraz ImaginaryInt, które dziedziczą po odpowiednio klasach Int i Double . Powinne one być tworzone ze Stringów postaci "<CzęśćRzeczywissta>i<CzęśćUrojona>", np "12i3".

//      Nadpisz metody create i add w klasach ImaginaryDoubgle oraz ImaginaryInt. Pamiętaj, że do liczb urojonych możemy też dodawać inne typy (np. Int, Double).
//      Przetestuj wyniki operacji:
        Int myInt = new Int();
        ImaginaryInt imInt = new ImaginaryInt();
        ImaginaryInt imInt2 = new ImaginaryInt();

        System.out.println(imInt.create("12i4").add(myInt.create("10")));
        System.out.println(imInt.create("10").add(imInt2.create("10")));
        System.out.println(imInt.create("12i4").add(imInt2.create("10i11")));
        System.out.println();
        //        ImaginaryInt.create("12i4").add(Int.create("10"))
        //        Int.create("10").add(ImaginaryInt.create("12i4")))
        //        ImaginaryInt.create("12i4").add(ImaginaryInt.create("10i10"))

        Int myInt2 = new Int();
        Int myInt3 = new Int();
        System.out.println(myInt2.create("10").add(myInt3.create("5")));
        System.out.println(myInt2.create("10").sub(myInt3.create("5")));
        System.out.println(myInt2.create("10").mul(myInt3.create("5")));
        System.out.println(myInt2.create("10").div(myInt3.create("5")));
        System.out.println(myInt2.create("10").pow(myInt3.create("5")));
        System.out.println();

        MyDouble myDouble2 = new MyDouble();
        MyDouble myDouble3 = new MyDouble();
        System.out.println(myDouble2.create("10").add(myDouble3.create("5")));
        System.out.println(myDouble2.create("10").sub(myDouble3.create("5")));
        System.out.println(myDouble2.create("10").mul(myDouble3.create("5")));
        System.out.println(myDouble2.create("10").div(myDouble3.create("5")));
        System.out.println(myDouble2.create("10").pow(myDouble3.create("5")));
        System.out.println();

        Int myImaginaryInt2 = new ImaginaryInt();
        Int myImaginaryInt3 = new ImaginaryInt();
        System.out.println(myImaginaryInt2.create("10i10").add(myImaginaryInt3.create("5i5")));
        System.out.println(myImaginaryInt2.create("10i10").sub(myImaginaryInt3.create("5i5")));
        System.out.println(myImaginaryInt2.create("10i10").mul(myImaginaryInt3.create("5i5")));
        System.out.println(myImaginaryInt2.create("10i10").div(myImaginaryInt3.create("5i5")));
        System.out.println(myImaginaryInt2.create("10i10").pow(myImaginaryInt3.create("5i5")));
        System.out.println();

        Int myImaginaryDouble2 = new ImaginaryInt();
        Int myImaginaryDouble3 = new ImaginaryInt();
        System.out.println(myImaginaryDouble2.create("10i10").add(myImaginaryDouble3.create("5i5")));
        System.out.println(myImaginaryDouble2.create("10i10").sub(myImaginaryDouble3.create("5i5")));
        System.out.println(myImaginaryDouble2.create("10i10").mul(myImaginaryDouble3.create("5i5")));
        System.out.println(myImaginaryDouble2.create("10i10").div(myImaginaryDouble3.create("5i5")));
        System.out.println(myImaginaryDouble2.create("10i10").pow(myImaginaryDouble3.create("5i5")));
        System.out.println();

        MyString s1 = new MyString(),s2 = new MyString();
        s1 = (MyString)s1.create("lorem");
        s2 = (MyString)s2.create("ipsum");

        System.out.println((s1.add(s2)).toString());
        System.out.println((s1.eq(s2)));
        System.out.println((s1.hashCode()));

//      Nadpisz metodę public String toString() w kasach ImaginaryDouble i ImaginaryInt, tak aby poprawnie wyświetlała liczby urojone do postaci Stringa



    }
}
