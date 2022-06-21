public class DistributoreBevande {
    double importoAttuale;
    private Prodotto[] prodotti;//array di prodotti


    //passo la capienza del distrib
    public DistributoreBevande(int capienza){
        this.prodotti = new Prodotto[capienza];
        this.importoAttuale = 0;
    }

    public void caricaProdotto(Prodotto prodotto){
        for(int i = 0; i < prodotti.length; i++){
            if(this.prodotti[i] == null){
                prodotti[i] = prodotto;
                break;
            }
        }
    }
    //passo indice
    // rimuove prodotto di quell'indice
    public void rimuoviProdotto(int indice) {
        if (indice < prodotti.length) {
            prodotti[indice] = null;
        }
    }

    public void inserisciImporto(double importo){
        this.importoAttuale += importo;
    }
    public Prodotto scegliProdotto(String codice){
        for(int i = 0; i < this.prodotti.length; i++){
            if(prodotti[i]!= null && prodotti[i].getCodice().equals(codice) && prodotti[i].getPrezzo() <= importoAttuale){
                Prodotto tmp = prodotti[i];//variabile temporale
                importoAttuale -= prodotti[i].getPrezzo();
                rimuoviProdotto(i);
                return  tmp;
            }
        }
        return null;
    }
    public double saldo(){
        return importoAttuale;
    }

    public double getResto(){//prendo importo, salvo in var temporanea, azzero,
        double app = importoAttuale;
        importoAttuale = 0;
        return app;
    }
}

