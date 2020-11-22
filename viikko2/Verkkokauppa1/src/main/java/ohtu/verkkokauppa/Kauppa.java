package ohtu.verkkokauppa;

import org.springframework.stereotype.Component;

@Component
public class Kauppa {

    private Sailytystila varasto;
    private Rahoitustoimija pankki;
    private Ostoskori ostoskori;
    private Viitteet viitegeneraattori;
    private String kaupanTili;

    public Kauppa(Sailytystila s, Rahoitustoimija r,  Viitteet v) {
        this.varasto = s;
        this.pankki = r;
        this.viitegeneraattori = v;
        this.kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        this.ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = this.varasto.haeTuote(id); 
        ostoskori.poista(t);
        this.varasto.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (this.varasto.saldo(id)>0) {
            Tuote t = this.varasto.haeTuote(id);             
            this.ostoskori.lisaa(t);
            this.varasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = this.viitegeneraattori.uusi();
        int summa = this.ostoskori.hinta();
        
        return this.pankki.tilisiirto(nimi, viite, tiliNumero, this.kaupanTili, summa);
    }

}
