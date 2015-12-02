package zapisanacteniobjektudobinsouboru;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ZapisANacteniObjektuDoBINSouboru {

    public static void main(String[] args) {
        PolozkaTelSeznamu polozka1;
        polozka1 = new PolozkaTelSeznamu();
        polozka1.jmeno = "René";
        polozka1.prijmeni = "Hužva";
        polozka1.cislo = 608123456;
        
        // zápis serializovaného objektu do souboru
        FileOutputStream vystup;
        ObjectOutputStream ovystup;
        try {
            vystup = new FileOutputStream("vystup.txt");
            ovystup = new ObjectOutputStream(vystup);
            // zapíšeme objekt do souboru
            ovystup.writeObject(polozka1);
            ovystup.close();
        } catch (IOException ex) {
            Logger.getLogger(ZapisANacteniObjektuDoBINSouboru.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // načtení serlizovaného objektu ze souboru
        PolozkaTelSeznamu nactenapolozka;
        nactenapolozka = new PolozkaTelSeznamu();

        FileInputStream vstup;
        ObjectInputStream ovstup;
        try {
            vstup = new FileInputStream("vystup.txt");
            ovstup = new ObjectInputStream(vstup);
            // načteme objekt ze souboru
            nactenapolozka = (PolozkaTelSeznamu) ovstup.readObject();
            ovstup.close();
        } catch (IOException ex) {
            Logger.getLogger(ZapisANacteniObjektuDoBINSouboru.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ZapisANacteniObjektuDoBINSouboru.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(nactenapolozka.jmeno);
        System.out.println(nactenapolozka.prijmeni);
        System.out.println(nactenapolozka.cislo);
    }
}
