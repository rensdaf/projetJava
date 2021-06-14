public abstract class Local {

    // #-->protected
    // +-->public
    // - -->privé

    protected String reference;
    protected int typeLocal;
    protected String localisation;
    protected int prix;
    protected double tauxloc;
    private int FORMAT = 4;
    protected boolean reserve=false;

    // premier constructeur

    public Local() {

    }

    // deuxieme constructeur

    public Local(int typeLocal, String localisation, int prix, double tauxloc) {
        this.reference = generatRef();
        this.typeLocal = typeLocal;
        this.localisation = localisation;
        this.prix = prix;
        this.tauxloc = tauxloc;

    }

    public static int nombreLocaux;

    private String generatRef() {
        String firstPart = "REF";
        String nombreZero = "";
        String nombreCompteString = String.valueOf(++nombreLocaux);
        while (nombreZero.length() + nombreCompteString.length() != FORMAT) {
            nombreZero += "0";
        }
        return firstPart + nombreZero + nombreCompteString;
    }

    // GETTER && SETTER

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public double getTauxloc() {
        return tauxloc;
    }

    public void setTauxloc(double tauxloc) {
        this.tauxloc = tauxloc;
    }

    public int getTypeLocal() {
        return typeLocal;
    }

    public static void setTypeLocal(int typeLocal) {
        typeLocal = typeLocal;
    }
    public boolean getReserve() {
        return reserve;
    }


    // METHODE COUT
    public double cout() {
        return this.prix + (this.tauxloc * this.prix);
    }

    // METHODE AFFICHER

    public abstract String toString();

}