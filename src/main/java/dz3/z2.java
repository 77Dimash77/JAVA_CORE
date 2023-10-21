package dz3;

import java.util.ArrayList;
import java.util.List;

public class z2 {
    public static void main(String[] args) {
        Compmania compania = new Compmania();
        Rabotnik a = new Rabotnik("David", 100);
        Nachalnik b = new Nachalnik("Max", 100);
        Rabotnik c = new Rabotnik("USHEPOK", 100);
        compania.sotrudniki.add(a);
        compania.sotrudniki.add(b);
        compania.sotrudniki.add(c);

        for (Rabotnik r : compania.sotrudniki
        ) {
            r.povishenieZP(200);

        }
        for (Rabotnik r : compania.sotrudniki
        ) {
            System.out.println(r.getZarplata());


        }
    }
}
class Rabotnik{
String name;
int zarplata;
    Rabotnik(String name, int zarplata){
        this.name = name;
        this.zarplata = zarplata;
    }
    public void povishenieZP(int zarplata) {
        if (this instanceof Nachalnik) {
            System.out.println("Повышение зарплаты не применяется к начальнику " + name);
        } else {
            this.zarplata += zarplata;
        }
    }

    public int getZarplata() {
        return zarplata;
    }
}
class Nachalnik extends Rabotnik{
    Nachalnik(String name, int zarplata) {
        super(name, zarplata);

    }
}
class Compmania{
    List<Rabotnik> sotrudniki;
    Compmania(){sotrudniki = new ArrayList<>();     }
}
