package gti.g55.eventichs_organisation.Présentation.Vue

import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.fragment.app.Fragment
import gti.g55.eventichs_organisation.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.navigation.Navigation
import gti.g55.eventichs_organisation.Présentation.Modèle.ModèleVueEvenement
import gti.g55.eventichs_organisation.Présentation.Présenteur.PrésenteurCréation
import gti.g55.eventichs_organisation.Présentation.Présenteur.PrésenteurEvenement
import gti.g55.eventichs_organisation.sourceDeDonnées.SourceÉvènementBidon
import java.text.SimpleDateFormat
import java.util.Locale


class VueCreation : Fragment() {
    // TODO: Rename and change types of parameters
    private var _présenteur: PrésenteurCréation? = null
    private var fieldNomEvenement: EditText? = null
    private var switchEvenementPrivé: Switch? = null
    private var fieldAddresseEvenement: EditText? = null
    private var fieldDescriptionEvenement: EditText? = null
    private var btnDateDebut: Button? = null
    private var btnDateFin: Button? = null
    private var btnSubmit: Button? = null
    private var textDateDebut: TextView? = null
    private var textDateFin: TextView? = null

    lateinit var btnVersAcceuil: Button

    //    val sourceBidon = SourceÉvènementBidon()

    fun setPrésenteur(PrésenteurCréation: PrésenteurCréation?) {
        _présenteur = PrésenteurCréation
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_creer, container, false)

        fieldNomEvenement = vue.findViewById(R.id.fieldNomEvenement) // whyyy
        switchEvenementPrivé = vue.findViewById(R.id.switchEvenementPrivé)
        fieldAddresseEvenement = vue.findViewById(R.id.AddresseEvenement)
        fieldDescriptionEvenement = vue.findViewById(R.id.DescriptionEvenement)
        btnDateDebut = vue.findViewById(R.id.btnDateDebut)
        textDateDebut = vue.findViewById(R.id.textDateDébut)
        btnDateFin = vue.findViewById(R.id.btnDateFin)
        textDateFin = vue.findViewById(R.id.textDateFin)
        btnSubmit = vue.findViewById(R.id.btnSubmit)
        btnVersAcceuil = vue.findViewById(R.id.btnRetourAcceuil)

        btnVersAcceuil.setOnClickListener {
            Log.e("NavToMenu","WHAT THE FUCK")
            Navigation.findNavController(vue).navigate(R.id.action_creerEvenement_to_evenement)
        }


        btnDateDebut?.setOnClickListener {

            changerDateDébut()
        }

        btnDateFin?.setOnClickListener {

            changerDateFin()
        }

        val modèle = ModèleVueEvenement(SourceÉvènementBidon())
        _présenteur = PrésenteurCréation(this, modèle)


        setPrésenteur(_présenteur!!)

        return vue
    }

    fun changerDateDébut() {
        Log.e("DatePicker", "IT WAS CALLED")
        val currentDate = Calendar.getInstance()
        val DatePicker = DatePickerDialog(requireContext())

        DatePicker.datePicker.minDate = currentDate.timeInMillis

        DatePicker.setOnDateSetListener { _, year, month, day ->
            val selectedDate = Calendar.getInstance()
            selectedDate.set(year, month, day)
            val dateString = SimpleDateFormat("MMMM d, yyyy", Locale.getDefault()).format(selectedDate.time)

            textDateDebut?.text = dateString
        }


        DatePicker.show()

    }

    fun changerDateFin() {
        Log.e("DatePicker", "IT WAS CALLED")
        val currentDate = Calendar.getInstance()
        val DatePicker = DatePickerDialog(requireContext())

        DatePicker.datePicker.minDate = currentDate.timeInMillis

        DatePicker.setOnDateSetListener { _, year, month, day ->
            val selectedDate = Calendar.getInstance()
            selectedDate.set(year, month, day)
            val dateString = SimpleDateFormat("MMMM d, yyyy", Locale.getDefault()).format(selectedDate.time)

            textDateFin?.text = dateString
        }


        DatePicker.show()

    }
}

