package com.andriosi.fabio.firtapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.andriosi.fabio.firtapplication.databinding.ActivityMainBinding
import com.andriosi.fabio.firtapplication.model.CustoViagem

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate?.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(R.id.button_calculate == view.id){
            calculate()
        }
    }

    private fun isValid():Boolean{
        return(binding.editDistance?.text.toString() != ""
                && binding.editPrice?.text.toString() != ""
                && binding.editAutonomy?.text.toString() != ""
                && binding.editAutonomy?.text.toString().toFloat() != 0f
            )
    }

    fun calculate(){
        val custoViagem: CustoViagem = CustoViagem()
        try {
            custoViagem.distance = binding.editDistance?.text.toString().toInt()
            custoViagem.price    = binding.editPrice?.text.toString().toFloat()
            custoViagem.autonomy = binding.editAutonomy?.text.toString().toFloat()
            binding.textTotalPrice?.text ="RS ${"%.2f".format( custoViagem.calcula())}"
        }catch (execption: NumberFormatException  ){
            Toast.makeText(applicationContext,  R.string.fill_all_fields, Toast.LENGTH_LONG)
                .show()
        }
    }
}


