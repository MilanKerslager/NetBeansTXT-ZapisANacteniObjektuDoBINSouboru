package zapisanacteniobjektudobinsouboru;

import java.io.Serializable;

// třída s položkou telefonního seznamu
// kvůli serializaci (zápisu/čtení ze souboru) bylo
// potřeba doplnit "implements Serializable"

public class PolozkaTelSeznamu implements Serializable {
    String jmeno;
    String prijmeni;
    long cislo;
}
