package com.example.permissionapp.ui.fragment

import android.app.AlertDialog
import android.app.Dialog

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.example.permissionapp.databinding.DialogAdminBinding

class AdminDialogFragment(
    private val onSubmitClickListener: (String)->Unit
) : DialogFragment() {
    private lateinit var binding:DialogAdminBinding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding=DialogAdminBinding.inflate(LayoutInflater.from(context))
        val builder=AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)
        val dialog=builder.create()
        options()
        return dialog
    }
    private fun options(){
        binding.btnAdminAccepted.setOnClickListener{
            onSubmitClickListener.invoke(binding.password.text.toString())
            dismiss()
        }
        binding.btnAdminCancelled.setOnClickListener{
            dismiss()
        }
    }


}


