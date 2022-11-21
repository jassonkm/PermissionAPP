package com.example.permissionapp.ui.fragment


import android.content.Intent

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.unit.Constraints
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.permissionapp.R
import com.example.permissionapp.databinding.FragmentScannerBinding
import com.example.permissionapp.utils.Constants
import com.example.permissionapp.utils.Dynamics
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import com.journeyapps.barcodescanner.ScanOptions
import kotlin.math.log

class ScannerFragment : Fragment() {
    private var _binding:FragmentScannerBinding?=null
    private val binding get()=_binding!!
    private lateinit var navController: NavController

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
        lauchRegister(view)
    }

    private fun lauchRegister(view: View) {
        val register = binding.btnFinish
            navController = Navigation.findNavController(view)
            register.setOnClickListener {
                if (Dynamics.CC.isEmpty()){
                    Toast.makeText(context,"Cancelado, escanee un documento",Toast.LENGTH_SHORT).show()
                }else{
                    navController.navigate(R.id.registerFragment)
            }
        }
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
                getDataId(result.contents)
                Toast.makeText(aplicationContext,"Escaneado correctamente",Toast.LENGTH_SHORT).show()
            }
        }
        else{
            super.onActivityResult(requestCode,resultCode,data)
        }
    }
    fun getDataId(data: String){
        Dynamics.CC = data.substring(48 , 58)
    }

}