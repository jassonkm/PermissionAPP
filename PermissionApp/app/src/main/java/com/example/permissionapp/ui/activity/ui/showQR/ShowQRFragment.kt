package com.example.permissionapp.ui.activity.ui.showQR

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.permissionapp.R
import com.example.permissionapp.databinding.FragmentShowQRBinding
import com.example.permissionapp.ui.activity.ui.scan.ScanViewModel

class ShowQRFragment : Fragment() {

    companion object {
        fun newInstance() = ShowQRFragment()
    }

    private var _binding: FragmentShowQRBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val showQRViewModel=
            ViewModelProvider(this).get(ShowQRViewModel::class.java)
        _binding=FragmentShowQRBinding.inflate(inflater,container,false)
        val textView: TextView=binding.hello
        showQRViewModel.text.observe(viewLifecycleOwner){
            textView.text=it
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}