package com.example.patientslist

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment(),PatientsListCallBack {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    val patients = arrayListOf<Patient>(
        Patient("Mr","Peter","Parker","Was born in 2001","psychoemotional state. " +
                    "Imagines himself as a spider"),
        Patient("Mr","Boris",
            "Johnson", "Was born in 1964","Repeated complaints about hairdressers are chronic"),
        Patient("Mrs","Angela",
            "Merkel", "Was born in 1954","Survey results: trying to solve their " +
                    "problems at someone else\'s expense, which leads to exacerbations"),
        Patient("Mr","Volodimir",
            "Putin", "Was born in 1952","Diagnosis: acute lack of compassion for humanity." +
                    " It is required to isolate from dangerous objects. When treating, take into account the" +
                    " acute complex of the king"),
        Patient("Mr","Volodimir",
            "Zelenskiy", "Was born in 1978","The main treatment strategy: to emphasize " +
                    "that he is an adult, smart and handsome, you can add that he is slim. Under no circumstances" +
                    " should he allow his meeting with Vladimir Putin, the \"Russian Tsar\""),
        Patient("Mr","Peter","Parker","Was born in 2001","psychoemotional state. " +
                "Imagines himself as a spider"),
        Patient("Mr","Boris",
            "Johnson", "Was born in 1964","Repeated complaints about hairdressers are chronic"),
        Patient("Mrs","Angela",
            "Merkel", "Was born in 1954","Survey results: trying to solve their " +
                    "problems at someone else\'s expense, which leads to exacerbations"),
        Patient("Mr","Volodimir",
            "Putin", "Was born in 1952","Diagnosis: acute lack of compassion for humanity." +
                    " It is required to isolate from dangerous objects. When treating, take into account the" +
                    " acute complex of the king"),
        Patient("Mr","Volodimir",
            "Zelenskiy", "Was born in 1978","The main treatment strategy: to emphasize " +
                    "that he is an adult, smart and handsome, you can add that he is slim. Under no circumstances" +
                    " should he allow his meeting with Vladimir Putin, the \"Russian Tsar\""),
        Patient("Mr","Peter","Parker","Was born in 2001","psychoemotional state. " +
                "Imagines himself as a spider"),
        Patient("Mr","Boris",
            "Johnson", "Was born in 1964","Repeated complaints about hairdressers are chronic"),
        Patient("Mrs","Angela",
            "Merkel", "Was born in 1954","Survey results: trying to solve their " +
                    "problems at someone else\'s expense, which leads to exacerbations"),
        Patient("Mr","Volodimir",
            "Putin", "Was born in 1952","Diagnosis: acute lack of compassion for humanity." +
                    " It is required to isolate from dangerous objects. When treating, take into account the" +
                    " acute complex of the king"),
        Patient("Mr","Volodimir",
            "Zelenskiy", "Was born in 1978","The main treatment strategy: to emphasize " +
                    "that he is an adult, smart and handsome, you can add that he is slim. Under no circumstances" +
                    " should he allow his meeting with Vladimir Putin, the \"Russian Tsar\"")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvPatients.adapter = PatientsAdapter(patients,requireContext(),this)
        rvPatients.layoutManager = LinearLayoutManager(context)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onItemSelected(index: Int) {
       requireActivity().supportFragmentManager
           .beginTransaction()
           .replace(R.id.flDetails,DetailsFragment.newInstance(patients[index].sex, patients[index].name,
                        patients[index].lastName,patients[index].age,patients[index].details))
           .addToBackStack(null)
           .commit()
    }
}