import java.time.LocalDate;

public class Reservation {

    private  LocalDate date;
    private  String duree;
    private  String etat;
    private  String id;
    private  String ref;

    private int FORMAT = 1;

    /** Definition du constructeur */
    public Reservation() {

    }
    public Reservation(String ref){
        this.ref=ref;
    }

    /** Surcharge du constructeur 3 */
    public Reservation(String ref, LocalDate date, String etat, String duree) {
        this.id = generatId();
        setEtat(etat);
        setDate(date);
        setDuree(duree);
        setRef(ref);
    }

    public Reservation(int id2, LocalDate date2, String etat2) {
        setId(id);
        setEtat(etat);
        setDate(date);
    }

    public static int nombreCompte;

    private String generatId() {

        String nombreZero = "";
        String nombreCompteString = String.valueOf(++nombreCompte);
        while (nombreZero.length() + nombreCompteString.length() != FORMAT) {
            nombreZero += "0";
        }
        return nombreZero + nombreCompteString;
    }

    // GETTER

    public LocalDate getDate() {
        return date;
    }

    public String getDuree() {
        return duree;
    }

    public String getEtat() {
        return etat;
    }

    public String getId() {
        return id;
    }

    public String getRef() {
        return ref;
    }

    // SETTER

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String afficher() {
        return "\n La date : " + date + "\n La duree : " + duree + "\n L'etat : " + etat + "\n L'id : " + id
                + "\n La reference : " + ref;
    }

}
