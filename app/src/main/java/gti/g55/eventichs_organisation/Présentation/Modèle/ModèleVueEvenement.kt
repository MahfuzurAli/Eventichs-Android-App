package gti.g55.eventichs_organisation.Présentation.Modèle

import android.util.Log
import gti.g55.eventichs_organisation.Domaine.Entités.Évènement
import gti.g55.eventichs_organisation.Domaine.Interacteurs.InteracteurAcquisitionÉvènement
import gti.g55.eventichs_organisation.Domaine.Interacteurs.SourceÉvènement
import gti.g55.eventichs_organisation.sourceDeDonnées.SourceÉvènementBidon

class ModèleVueEvenement(val source: SourceÉvènement) {

        var ListeÉvènementCourante: ArrayList<Évènement> = ArrayList()

            fun RemplacerListeÉvènements(): List<Évènement>{
                var nouvelleListeEvenement = InteracteurAcquisitionÉvènement(source).obtenirNouvelleListeÉvènement()
                ListeÉvènementCourante = nouvelleListeEvenement
                return nouvelleListeEvenement
            }

            fun CreerEvenement(nouvelEvenement: Évènement): Évènement {
                InteracteurAcquisitionÉvènement(source).creerÉvènement(nouvelEvenement)
                Log.i("IT FUCKING WORKED", "WOOOOOO")

                return nouvelEvenement
            }

            fun ObtenirListe(): List<Évènement>{
                return InteracteurAcquisitionÉvènement(source).évènement
            }

            fun findEvenementByID(id: Int): Évènement?{
                return InteracteurAcquisitionÉvènement(source).findEvenementById(id)
            }

            fun remplacerElement(unEvenement:Évènement){
                val index =source.listeRetour.indexOfFirst { it.code==unEvenement.code }
                if (index != -1){
                    source.listeRetour[index]=unEvenement
                }
                val test=source.listeRetour[index].nom
                val test2=source.listeRetour[3].nom

                Log.e("remplcer the event","$test")
                Log.e("remplcer the event","$test2")

            }

            fun modifierElement(unEvenement: Évènement){
                Log.e("Code de retour pour modèle",unEvenement.code.toString())
                InteracteurAcquisitionÉvènement(source).modifierÉvènement(unEvenement)
            }
}