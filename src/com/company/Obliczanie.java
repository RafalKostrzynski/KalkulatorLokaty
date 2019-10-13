
package com.company;

public class Obliczanie {
    int lata,miesiace;
    double kapitalMiesieczny;
    String oszczedzanie(double kapital,double oprocentowanie, double kwotaMiesieczna, double kwotaDocelowa, int wiek)
    {
        java.text.DecimalFormat df=new java.text.DecimalFormat();
        df.setMaximumFractionDigits(2);
        kapitalMiesieczny=kapital;
        lata=0;
        miesiace=0;
        if(kapital<kwotaDocelowa) {
            while (kapitalMiesieczny < kwotaDocelowa && lata + wiek <= 90) {
                kapital = kapitalMiesieczny + kwotaMiesieczna;
                kapitalMiesieczny = kapital * (1 + (oprocentowanie / 12) / 100);
                double odsetki = kapitalMiesieczny - kapital;
                kapitalMiesieczny = kapitalMiesieczny - odsetki * 0.19;
                miesiace++;
                if (miesiace % 12 == 0) {
                    miesiace = 0;
                    lata++;
                }
            }
        }
        return df.format(kapitalMiesieczny);
    }
    int ilePotrzebujeLat(int wiek)
    {
        return lata;
    }
    int ilePotrzebujeMiesiecy()
    {
        return miesiace;
    }
    public int iloscLat(int wiek)
    {
        if(wiek+lata>90)return 0;
        else return wiek +lata;
    }
}