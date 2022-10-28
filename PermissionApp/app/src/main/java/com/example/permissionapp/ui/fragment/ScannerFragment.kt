package com.example.permissionapp.ui.fragment


import android.content.Intent

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.permissionapp.databinding.FragmentScannerBinding
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import com.journeyapps.barcodescanner.ScanOptions

class ScannerFragment : Fragment() {
    private var _binding:FragmentScannerBinding?=null
    private val binding get()=_binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentScannerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initScanner()
    }

    private fun initScanner() {
        binding.btnScanner.setOnClickListener {
            val option = IntentIntegrator.forSupportFragment(this)
            option.setDesiredBarcodeFormats(ScanOptions.PDF_417)
            option.setPrompt("Favor escanea el codigo de barras")
            option.setBeepEnabled(true)
            option.setBarcodeImageEnabled(true)
            option.initiateScan()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result: IntentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result !=null){
            val aplicationContext= activity?.applicationContext
            Log.e( "onActivityResult: ", ""+result.contents)
            if (result.contents==null){
                Toast.makeText(aplicationContext,"Cancelado",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(aplicationContext,"Escaneado correctamente",Toast.LENGTH_SHORT).show()
            }
        }
        else{
            super.onActivityResult(requestCode,resultCode,data)
        }
    }

}