import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        Service service = new Service();
        Validator v1 = new Validator();
        List<Client> listClients = new ArrayList<>();
        List<Local> listLocals = new ArrayList<>();
        List<Reservation> listReservations = new ArrayList<>();
        int choix;
        do {
            choix = menu();
            switch (choix) {
                case 1:
                    // AJOUTER UN LOCAL
                    System.out.println("******************** Ajout d'un local ******************** : ");

                    // RECUPERATION DES DONNNEES AU CLAVIER :
                    // String typeCompte ;
                    int typeLocalInt;
                    do {
                        System.out.println(
                                "Quel type de local voulez vous : " + "\n 1- Chambre" + "\n 2- Appartement" + "\n");

                        int typeLocal = scanner.nextInt();

                        scanner.nextLine();
                        typeLocalInt = (typeLocal);

                    } while (typeLocalInt != 2 && typeLocalInt != 1);
                    Chambre chambre;
                    if (typeLocalInt == 1) {

                        System.out.println("Entrer la localisation : " + "\n");
                        String localisation = scanner.nextLine();

                        System.out.println("Entrer le prix : ");
                        String prix = scanner.nextLine();

                        System.out.println("Entrer le taux de location : " + "\n");
                        String tauxloc = scanner.nextLine();

                        System.out.println("Entrer la dimension : " + "\n");
                        String dimension = scanner.nextLine();

                        // ON CREE APPARTEMENT DANS LOCAL
                        chambre = new Chambre(typeLocalInt, localisation, Integer.parseInt(prix),
                                Integer.parseInt(tauxloc), Integer.parseInt(dimension));

                        // ON AJOUTE CHAMBRE DANS LOCAL
                        service.addLocal(chambre);
                    } else if (typeLocalInt == 2) {

                        System.out.println("Entrer la localisation : " + "\n");
                        String localisation = scanner.nextLine();

                        System.out.println("Entrer le prix : " + "\n");
                        String prix = scanner.nextLine();

                        System.out.println("Entrer le taux de location : " + "\n");
                        String tauxloc = scanner.nextLine();

                        int nbrpiece;
                        System.out.println("Veuillez saisir le nombre de piece " + "\n");
                        nbrpiece = scanner.nextInt();
                        do {
                            if (nbrpiece < 3) {
                                System.out.println("Attention l'appartement doit avoir au minimum trois piece " + "\n");
                                nbrpiece = scanner.nextInt();
                            }

                        } while ((nbrpiece) < 3);
                        System.out.println("L'appartement de " + nbrpiece + " pieces a été ajouté" + "\n");

                        Appartement appartement = new Appartement(typeLocalInt, localisation, Integer.parseInt(prix),
                                Integer.parseInt(tauxloc), nbrpiece);

                        // ON CREE APPARTEMENT DANS LOCAL
                        service.addLocal(appartement);
                    }
                    break;
                case 2:
                    // LISTER LES LOCAUX PAR TYPE

                    System.out.println(
                            "******************** Lister les locaux par type chambre ******************** : " + "\n");

                    Service.listerChambre(Service.listLocals);

                    System.out.println(
                            "*********************************************************************** : " + "\n");

                    System.out.println(
                            "******************** Lister les locaux par type Appartement ******************** : "
                                    + "\n");

                    Service.listerAppartement(Service.listLocals);

                    System.out.println(
                            "*********************************************************************** : " + "\n");

                    break;
                case 3:

                    System.out
                            .println("******************** Voir les détails d'un local ******************** : " + "\n");
                    Service.listerLocal();
                    break;

                case 4:

                    System.out.println("******************** Faire une reservation ******************** : " + "\n");

                    scanner.nextLine();
                    System.out.println("Entrer votre nci : " + "\n");
                    String nci = scanner.nextLine();
                    if (Validator.isValidNci(nci) && nci != null) {

                    } else {
                        System.out.println(" NCI incorrect ! Veuillez réessayer." + "\n");
                        break;
                    }
                    // SI LE CLIENT N'EXISTE PAS ON CREE UN COMPTE

                    Client client = service.searchClient((nci));
                    if (client == null) {

                        System.out.println("******************** Creer votre compte ******************** : ");

                        System.out.print("Entrer votre nom complet : " + "\n");
                        String nomComplet = scanner.nextLine();
                        if (Validator.isValidName(nomComplet) && nomComplet != null) {

                        } else {
                            System.out.println(" Nom incorrect ! Veuillez réessayer." + "\n");
                            break;
                        }

                        System.out.print("Entrer votre numero (+221 xx xxx xx xx): " + "\n");
                        String tel = scanner.nextLine();
                        if (Validator.isValidPhone(tel)) {

                        } else {
                            System.out.println("Numero incorrect ! Veuillez réessayer." + "\n");
                            break;
                        }

                        System.out.print("Entrer votre Adresse : " + "\n");
                        String adresse = scanner.nextLine();
                        if (Validator.isValidAdresse(adresse) && adresse != null) {

                        } else {
                            System.out.println("Adresse incorrect ! Veuillez réessayer." + "\n");
                            break;
                        }

                        System.out.print("Entrer votre email : " + "\n");
                        String email = scanner.nextLine();
                        if (v1.isValidEmail(email) && email != null) {
                        } else {
                            System.out.println("Email incorrect ! Veuillez réessayer.");
                            break;
                        }

                        client = new Client(nci, nomComplet, tel, adresse, email);
                        service.createClient(client);
                    }

                    String typeReservation;
                    int typeReservationInt;
                    do {
                        System.out.println("Quel type de local voulez vous Reserver ? " + "\n");
                        System.out.println("\t 1- Chambre");
                        System.out.println("\t 2- Appartement");
                        typeReservation = scanner.nextLine();
                        typeReservationInt = Integer.parseInt(typeReservation);

                    } while (typeReservationInt != 2 && typeReservationInt != 1);
                    // Local local;
                    if (typeReservationInt == 1) {

                        Service.listerChambre(Service.listLocals);

                        System.out.println("Entrer la reference de la chambre que vous voulez reserver :" + "\n");
                        String ref = scanner.nextLine();

                        LocalDate date = LocalDate.now();

                        String etat = "reservé";
                        System.out.println(" combien de jours mois ou annee voulez vous reservez : " + "\n");
                        String duree = scanner.nextLine();

                        Reservation reservation = new Reservation(ref, date, etat, duree);
                        service.addReservation(reservation);

                    } else {

                        Service.listerAppartement(Service.listLocals);

                        System.out.println("Entrer la reference de l'appartement que vous voulez reserver :" + "\n");
                        String reference = scanner.nextLine();

                        LocalDate date = LocalDate.now();

                        String etat = "reservé";
                        System.out.println(" combien de jours mois ou annee voulez vous reservez : " + "\n");
                        String duree = scanner.nextLine();

                        Reservation reservation = new Reservation(reference, date, etat, duree);
                        service.addReservation(reservation);

                    }
                    break;

                case 5:

                    System.out.println(
                            "******************** Lister les loocaux reservés par un client  ******************** : "
                                    + "\n");
                    Service.listerRerservation();

                case 6:

                    System.out.println("******************** Annuler une reservation ******************** : " + "\n");
                    System.out.println("Entrer la reference du local a supprimer :" + "\n");
                    String ref = scanner.nextLine();
                    Reservation reservation = new Reservation(ref);
                    Service.DeleteReservation(reservation);
                    break;

                case 7:
                    System.out.println(
                            "******************** Lister les locaux disponibles ******************** : " + "\n");
                    service.listerLocalReserve();
                case 8:
                    System.out.println("Bye :() ");
                    break;
                default:
                    System.out.println("Mauvais choix :( )");
            }

        } while (choix != 8);
    }

    public static int menu() {
        int choix;
        System.out.println("Menu" + "\n 1-Ajouter un Local" + "\n 2-Lister Les locaux par Type"
                + "\n 3-Voir les détails d'un local" + "\n 4-Faire une reservation"
                + "\n 5-Lister Les locaux reservés par un client" + "\n 6-Annuler une reservation"
                + "\n 7-Lister les locaux disponibles" + "\n 8-Quitter");
        System.out.println("Faites votre choix : " + "\n");
        choix = scanner.nextInt();
        return choix;
    }
}