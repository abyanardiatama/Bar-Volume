package com.example.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edit_panjang: EditText
    private lateinit var edit_lebar: EditText
    private lateinit var edit_tinggi: EditText
    private lateinit var btn_hitung: Button
    private lateinit var text_hasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit_panjang = findViewById(R.id.edit_panjang)
        edit_lebar = findViewById(R.id.edit_lebar)
        edit_tinggi = findViewById(R.id.edit_tinggi)
        btn_hitung = findViewById(R.id.btn_hitung)
        text_hasil = findViewById(R.id.text_hasil)

        //Set On Click Listener pada btn_hitung
        btn_hitung.setOnClickListener(this)
    }

    override fun onClick(v: View?){
        if (v?.id == R.id.btn_hitung) {
            val inputPanjang = edit_panjang.text.toString().trim()
            val inputLebar = edit_lebar.text.toString().trim()
            val inputTinggi = edit_tinggi.text.toString().trim()
            //Validasi input kosong
            var isEmptyFields = false
            if(inputPanjang.isEmpty()){
                isEmptyFields = true
                edit_panjang.error = "Field ini tidak boleh kosong"
            }
            if(inputLebar.isEmpty()){
                isEmptyFields = true
                edit_lebar.error = "Field ini tidak boleh kosong"
            }
            if(inputTinggi.isEmpty()){
                isEmptyFields = true
                edit_tinggi.error = "Field ini tidak boleh kosong"
            }
            if(!isEmptyFields){
                val volume = inputPanjang.toDouble() * inputLebar.toDouble() * inputTinggi.toDouble()
                text_hasil.text = volume.toString()
            }

        }
    }
}