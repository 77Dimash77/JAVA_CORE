package dz2;

import java.util.Random;

class Massive{
    int[]array;
    Massive(int size){
        array = new int[size];
    }
    void zapolnitel(){
        Random a = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = a.nextInt(5);
        }
    }
    void showMass(){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    void chetnieKol(){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 0 && array[i] != 0){
                count = count + 1;
            }
        }
        System.out.println("Четных элинтов(не считая '0'): " + count);
    }
    void maxmin(){
        int temp = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i]>temp){
                temp = array[i];
            }
        }
        System.out.println("Максимальное число: " + temp);
        int max = temp;
        for (int i = 0; i < array.length; i++) {
            if(array[i]<temp){
                temp = array[i];
            }
        }
        System.out.println("Минимальное число: " + temp);
        int dist = max - temp;
        System.out.println("Разница между макс и мин: " + dist);

    }
    boolean sosed(){
        System.out.print("Есть ли соседи в виде нулей: ");
        boolean a = false;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 0 && array[i - 1] == 0){
                a = true;
                break;
            }
        }
        return a;
    }

    }
    public class N1 {
        public static void main(String[] args) {
            Massive a = new Massive(5);
            a.zapolnitel();
            a.showMass();
            a.chetnieKol();
            a.maxmin();
            System.out.println(a.sosed());;
        }
}
