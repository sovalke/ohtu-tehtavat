
package ohtu.intjoukkosovellus;

public class IntJoukko {
    
    // Muuttujien luonti & alkuarvot
    private int kasvatuskoko = 5;
    private int[] lukujono;     
    private int alkioidenLkm = 0;


    public IntJoukko() {
        lukujono = new int[5];
        for (int i = 0; i < lukujono.length; i++) {
            lukujono[i] = 0;
        }
    }
    
    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        lukujono = new int[kapasiteetti];
        for (int i = 0; i < lukujono.length; i++) {
            lukujono[i] = 0;
        }

    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Lukujonon koko ei voi olla negatiivinen");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Lukujono ei voi pienentyä, asea kasvatuskooksi positiivinen luku");
        }
        lukujono = new int[kapasiteetti];
        for (int i = 0; i < lukujono.length; i++) {
            lukujono[i] = 0;
        }
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaaLuku(int luku) {
        
        if (alkioidenLkm == 0) {
            lukujono[0] = luku;
            alkioidenLkm++;
            return true;
        }
        
        if (!kuuluuJoukkoon(luku)) {
            // Lisätään ensimmäiseen vapaaseen indeksiin
            lukujono[alkioidenLkm] = luku;
            alkioidenLkm++;
            
            if (alkioidenLkm % lukujono.length == 0) {
                int[] vanhaLukujono = lukujono;
                lukujono = new int[alkioidenLkm + kasvatuskoko];
                kopioiTaulukko(vanhaLukujono, lukujono);
            }
            return true;
        }
        return false;
    }

    public boolean kuuluuJoukkoon(int luku) {
        int kuuluuJoukkoon = 0;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                kuuluuJoukkoon++;
            }
        }
        if (kuuluuJoukkoon > 0) {
            return true;
        }
        
        return false;
    }

    public boolean poistaLuku(int luku) {
        int luvunIndeksi = -1;
        
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                luvunIndeksi = i;
                lukujono[luvunIndeksi] = 0;
                break;
            }
        }
        
        // Siirretään lukujonon loppuja lukuja yksi taaksepäin, jotta poistetun
        // luvun kohdalle ei synny reikää.
        tiivistaJoukko(luvunIndeksi, this.lukujono);
        return false;
    }

    public boolean tiivistaJoukko(int luvunIndeksi, int[] jono) {
        int apu;
        if (luvunIndeksi != -1) {
            for (int i = luvunIndeksi; i < alkioidenLkm - 1; i++) {
                apu = lukujono[i];
                lukujono[i] = lukujono[i + 1];
                lukujono[i + 1] = apu;
            }
            alkioidenLkm--;
            return true;
        }
        return false;
    }
    
    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int alkioidenLkm() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + lukujono[0] + "}";
        } else {
            String palautettavaTeksti = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                palautettavaTeksti += lukujono[i];
                palautettavaTeksti += ", ";
            }
            palautettavaTeksti += lukujono[alkioidenLkm - 1];
            palautettavaTeksti += "}";
            return palautettavaTeksti;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukujono[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko joukkoA, IntJoukko joukkoB) {
        IntJoukko yhdisteJoukko = new IntJoukko();
        
        int[] tauluA = joukkoA.toIntArray();
        int[] tauluB = joukkoB.toIntArray();
        
        for (int i = 0; i < tauluA.length; i++) {
            yhdisteJoukko.lisaaLuku(tauluA[i]);
        }
        
        for (int i = 0; i < tauluB.length; i++) {
            yhdisteJoukko.lisaaLuku(tauluB[i]);
        }
        
        return yhdisteJoukko;
    }

    
    public static IntJoukko leikkaus(IntJoukko joukkoA, IntJoukko joukkoB) {
        
        IntJoukko yhdisteJoukko = new IntJoukko();
        int[] tauluA = joukkoA.toIntArray();
        int[] tauluB = joukkoB.toIntArray();
        
        for (int i = 0; i < tauluA.length; i++) {
            for (int j = 0; j < tauluB.length; j++) {
                if (tauluA[i] == tauluB[j]) {
                    yhdisteJoukko.lisaaLuku(tauluB[j]);
                }
            }
        }
        return yhdisteJoukko;

    }
    
    public static IntJoukko erotus (IntJoukko joukkoA, IntJoukko joukkoB) {
        
        IntJoukko erotusJoukko = new IntJoukko();
        int[] aTaulu = joukkoA.toIntArray();
        int[] bTaulu = joukkoB.toIntArray();
        
        for (int i = 0; i < aTaulu.length; i++) {
            erotusJoukko.lisaaLuku(aTaulu[i]);
        }
        
        for (int i = 0; i < bTaulu.length; i++) {
            erotusJoukko.poistaLuku(bTaulu[i]);
        }
 
        return erotusJoukko;
    }
        
}
