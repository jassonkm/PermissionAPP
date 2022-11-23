package com.example.permissionapp.ui.fragment


import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.permissionapp.R
import com.example.permissionapp.databinding.FragmentShowBinding
import com.example.permissionapp.utils.Constants
import com.example.permissionapp.utils.Dynamics
import com.google.zxing.BarcodeFormat
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.journeyapps.barcodescanner.ScanOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowFragment : Fragment(R.id.showFragment) {
    private lateinit var binding: FragmentShowBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentShowBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showTextScan()
        showQR()
        initScanner()
        logOut()
    }
    private fun showTextScan(){
        if (Dynamics.ROL== "[ROLE_ADMIN]"){
            binding.texScan.visibility=View.VISIBLE
            binding.fab.visibility=View.VISIBLE
            binding.eventScan.visibility= View.GONE
        }
    }
    private fun showQR(){

            var barcodeEncoder: BarcodeEncoder = BarcodeEncoder()
            var bitmap: Bitmap = barcodeEncoder.encodeBitmap(
                Constants.CONFIRMATION,BarcodeFormat.QR_CODE,750,750
            )
            binding.eventScan.setImageBitmap(bitmap)
    }
    private fun initScanner() {
        binding.fab.setOnClickListener {
            val option = IntentIntegrator.forSupportFragment(this)
            option.setDesiredBarcodeFormats(ScanOptions.QR_CODE)
            option.setPrompt("Favor escanea el codigo QR")
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
                view?.let {  Snackbar.make(it,"Escaneo cancelado",Snackbar.LENGTH_SHORT).show()}
            }else{
                Log.e( "onActivityResult: ",""+result.contents )
                if (result.contents==Constants.CONFIRMATION){
                    view?.let {  Snackbar.make(it,"Escaneado correctamente",Snackbar.LENGTH_LONG).setAction("Desea salir?"){ it ->
                        signOut(it)
                    }.show()}}
                else
                    view?.let {  Snackbar.make(it,"Codigo QR incorrecto",Snackbar.LENGTH_SHORT).show()}
            }
        }
        else{
            super.onActivityResult(requestCode,resultCode,data)
        }
    }
    private fun logOut(){
        binding.logOut.setOnClickListener{
            view?.let {
                signOut(it)
            }
        }
    }


    private fun signOut(view: View) {
        navController = Navigation.findNavController(view)
        navController.navigate(R.id.loginFragment)
    }

}