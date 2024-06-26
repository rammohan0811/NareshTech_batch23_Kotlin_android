package com.nareshit.fragmentsandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var num1:EditText
    lateinit var num2:EditText
    lateinit var r:TextView

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
        val v =  inflater.inflate(R.layout.fragment_second, container, false)
        num1 = v.findViewById<EditText>(R.id.num1_et)
        num2 = v.findViewById<EditText>(R.id.num2_et)
        val plus = v.findViewById<Button>(R.id.plus)
        val minus  = v.findViewById<Button>(R.id.minus)
        val prod = v.findViewById<Button>(R.id.prod)
        val div = v.findViewById<Button>(R.id.divi)
        r = v.findViewById(R.id.result)
        plus.setOnClickListener { performOperation(it) }
        minus.setOnClickListener { performOperation(it) }
        prod.setOnClickListener { performOperation(it) }
        div.setOnClickListener { performOperation(it) }
        return v
    }

    private fun performOperation(it: View?) {
        val n1:Double = num1.text.toString().toDouble()
        val n2:Double = num2.text.toString().toDouble()
        when(it?.id){
          R.id.plus ->  r.text = "${n1+n2}"
          R.id.minus -> r.text = "${n1-n2}"
          R.id.prod -> r.text = "${n1*n2}"
          R.id.divi -> {
              val result:Double = (n1/n2).toDouble()
              r.text = "$result"
          }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}