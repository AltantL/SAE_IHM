package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import vue.GridPaneSelectionAlgo;
import vue.HBoxRoot;
import vue.Resultat;

import java.io.IOException;

import static constantes.ConstanteIHM.*;

public class Controleur implements EventHandler{

//    PlanningCollection planning;

    @Override
    public void handle(Event event) {
        VBoxSelectionAlgo selectionAlgo = HBoxRoot.getGridPaneSelectionAlgo();
        Resultat resultat = HBoxRoot.getResultat();

        //la source de event est le bouton "Enregistrer" du formulaire de selection
        if (event.getSource() instanceof Button){

            ComboBox numScenario = selectionAlgo.getComboScenarios();

            int Senario = numScenario.getSelectionModel().getSelectedIndex();

            String testSenario = SCENARIOS[Senario];

            try {
                resultat.affichageResultat(testSenario);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        //la source de event est le bouton "Enregistrer" du formulaire de réservatuion

//        if (event.getSource() instanceof Button){
//
//            Date date = reservationPane.dateReserve;
//
//            TextField textField = reservationPane.textField;
//
//
//            ComboBox heureDepart = reservationPane.heureDepart;
//            ComboBox minuteDepart = reservationPane.minuteDepart;
//            ComboBox heureFin = reservationPane.heureFin;
//            ComboBox minuteFin = reservationPane.minuteFin;
//
//            int heureD = heureDepart.getSelectionModel().getSelectedIndex()+6;
//            int minuteD = minuteDepart.getSelectionModel().getSelectedIndex()*15;
//            int heureF = heureFin.getSelectionModel().getSelectedIndex()+6;
//            int minuteF = minuteFin.getSelectionModel().getSelectedIndex()*15;
//
//            Horaire horaire1 = new Horaire(heureD,minuteD);
//            Horaire horaire2 = new Horaire(heureF,minuteF);
//
//
//
//            PlageHoraire plageHoraire = null;
//            try {
//                plageHoraire = new PlageHoraire(horaire1,horaire2);
//                Reservation reservation = new Reservation(textField.getText(), date, plageHoraire);
//
//                HBoxRoot.getPlanning().ajout(reservation);
//                System.out.println(reservation);
//                System.out.println(HBoxRoot.getPlanning().toString());
//
//            } catch (ExceptionPlanning e) {
//                throw new RuntimeException(e);
//            }
//
//            affichagePlanning.setNumSemaineSelectionnee(date);
//
//        }
//        if (event.getSource() instanceof .......){
//            //
//        }
    }
}