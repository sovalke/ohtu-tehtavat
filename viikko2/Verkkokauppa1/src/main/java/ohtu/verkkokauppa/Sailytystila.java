
package ohtu.verkkokauppa;

import org.springframework.stereotype.Component;

@Component
public interface Sailytystila {

    Tuote haeTuote(int id);

    void otaVarastosta(Tuote t);

    void palautaVarastoon(Tuote t);

    int saldo(int id);

    
}
