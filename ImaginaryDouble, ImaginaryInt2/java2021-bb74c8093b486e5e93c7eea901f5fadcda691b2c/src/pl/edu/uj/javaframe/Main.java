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
            //        ImaginaryInt.create("12i4").add(Int.create("10"))
            //        Int.create("10").add(ImaginaryInt.create("12i4")))
            //        ImaginaryInt.create("12i4").add(ImaginaryInt.create("10i10"))

//      Nadpisz metodę public String toString() w kasach ImaginaryDouble i ImaginaryInt, tak aby poprawnie wyświetlała liczby urojone do postaci Stringa



    }
}
