package com.company;

import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
        Obliczanie oblicz = new Obliczanie();
        int operato;
        do {
            boolean pomocnikMetody=false;
            System.out.println("Obliczanie lat potrzebnych do osiągnięcia kwoty docelowej: ");
            System.out.println("Podaj swój wiek: ");
            int wiek = wpisywanie();
            System.out.println(wiek);
            System.out.println("Podaj kapitał początkowy");
            double kapitalPoczatkowy=wpisywanie(pomocnikMetody);
            System.out.println("Podaj kwote wpłacaną co miesiąc: ");
            double kwotaMiesieczna=wpisywanie(pomocnikMetody);
            System.out.println("Podaj kwotę docelową: ");
            double kwotaDocelowa=wpisywanie(pomocnikMetody);
            System.out.println("Podaj oprocentowanie roczne: ");
            double oprocentowanieRoczne=wpisywanie(pomocnikMetody);
            if (wiek>=0&&wiek<122&&kapitalPoczatkowy>=0&&kwotaMiesieczna>=0&&kwotaDocelowa>=0&&oprocentowanieRoczne>=0)
            {
                if (kapitalPoczatkowy<kwotaDocelowa)
                {
                    String pieniadze =oblicz.oszczedzanie(kapitalPoczatkowy, oprocentowanieRoczne, kwotaMiesieczna, kwotaDocelowa, wiek);
                    int lata=oblicz.iloscLat(wiek);
                    if (lata==0)
                    {
                        System.out.println("Będziesz miał ponad 90 lat jak osiągniesz cel!");
                    }
                    else {
                        System.out.println("Przy ostatnim naliczeniu osiągniesz " + pieniadze + " pln.");
                        int obliczoneLata=oblicz.ilePotrzebujeLat(wiek);
                        if(obliczoneLata!=0) System.out.println("Potrzebujesz na to " + obliczoneLata + " lat, oraz " + oblicz.ilePotrzebujeMiesiecy() + " miesięcy.");
                        else {System.out.println("Potrzebujesz na to " + oblicz.ilePotrzebujeMiesiecy() + " miesięcy.");}
                        System.out.println("Przy osiągnięciu celu będziesz mieć " + oblicz.iloscLat(wiek) + " lat/lata!");
                    }
                }
                else System.out.println("Kapitał jest już większy lub równy kwocie docelowej!!!");
            }
            else System.out.println("Błędne dane! Możliwe że kwota docelowa już jest osiągnięta lub któraś z podanych danych jest ujemna!");
            System.out.println("Jeżeli chcesz zakończyc program wpisz 1, jeżeli chcesz zmienić dane wciśnij dowolną liczbę: ");
            operato=wpisywanie();
            if(operato==1) System.out.println("Miłego dnia!");
        }while(operato!=1);
    }

     static int wpisywanie()
    {
        Scanner scan = new Scanner(System.in);
        int zwrotna=0;
        try {
            zwrotna=scan.nextInt();
        }catch(Exception e){
            System.out.println("Błędne dane spróbuj ponownie!");
            zwrotna=wpisywanie();
        }
        return zwrotna;
    }

    static double wpisywanie(boolean wykonanieMetody){
        Scanner scan = new Scanner(System.in);
        double zwrotna=0;
        try {
            zwrotna= scan.nextDouble();
        }catch(Exception e){
            System.out.println("Błędne dane spróbuj ponownie!");
            zwrotna=wpisywanie(wykonanieMetody);
        }
        return zwrotna;
    }

}