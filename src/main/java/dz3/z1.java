package dz3;

import java.time.LocalDate;
import java.util.*;

public class z1 {
    public static void main(String[] args) {
        Sotrudnik a1 = new Sotrudnik("Stiven", 100, "2023-10-09");
        Sotrudnik a2 = new Sotrudnik("Kartoshka", 100, "2023-10-10");
        Sotrudnik a3 = new Sotrudnik("Pisko", 100, "2023-10-11");
        List<Sotrudnik> comp = new ArrayList<Sotrudnik>();
        comp.add(a1);
        comp.add(a3);
        comp.add(a2);
        Comparator1 compani = new Comparator1();
        Collections.sort(comp,compani);
        for (Sotrudnik o:comp
             ) {
            System.out.println(o.getName() + " " + o.getData());
        }
    }
}

class Comparator1 implements Comparator<Sotrudnik> {

    @Override
    public int compare(Sotrudnik o1, Sotrudnik o2) {
        return o1.getData().compareTo(o2.getData());
    }
}

class Sotrudnik {
    String name;
    int payment;
    String date1;
    LocalDate data;

    Sotrudnik(String name, int payment, String date1) {
        this.name = name;
        this.payment = payment;
        this.date1 = date1;
        this.data = LocalDate.parse(date1);
    }


    public String getName() {
        return name;
    }

    public int getPayment() {
        return payment;
    }

    public String getDate1() {
        return date1;
    }

    public LocalDate getData() {
        return data;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
        this.data = LocalDate.parse(date1);
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
