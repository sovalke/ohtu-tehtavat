
package ohtu.verkkokauppa;

import org.springframework.stereotype.Component;

@Component
public interface Rahoitustoimija {
    

    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
    
}
