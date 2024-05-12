package com.azdev.testapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.azdev.testapp.databinding.FragmentBlank1Binding


class Blank1Fragment : Fragment() {
    private lateinit var binding: FragmentBlank1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_blank1, container, false)
        binding = FragmentBlank1Binding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
//            val fragment2 = Blank2Fragment()
//            val mFragmentManager = parentFragmentManager
//            val bundle by lazy { Bundle() }
//            bundle.putString(Blank2Fragment.EXTRA_VALUE, "My Value For Fragment 2")
//            fragment2.arguments = bundle
//
//            mFragmentManager
//                .beginTransaction().apply {
//                    replace(R.id.fragment_container, fragment2, Blank2Fragment::class.java.simpleName)
//                    addToBackStack(null)
//                    commit()
//                }
            val myStudent = Student("Azis", "12345678")
            view.findNavController().navigate(
                Blank1FragmentDirections.actionBlank1FragmentToBlank2Fragment(myStudent)
            )
        }

        binding.btnDialog.setOnClickListener {
            val mDialogFragment = DialogFragment()
            val mFragmentManager = childFragmentManager
            mDialogFragment.show(mFragmentManager, DialogFragment::class.java.simpleName)
        }
    }

    var dialogListener: DialogFragment.DialogListener = object:DialogFragment.DialogListener{
        override fun onSubmit(text: String) {
            Toast.makeText(requireActivity(),text,Toast.LENGTH_SHORT).show()
        }
    }
}