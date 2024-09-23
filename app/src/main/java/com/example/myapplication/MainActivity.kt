package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {


    companion object {
        private const val STATE_RESULT = "state_result"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) { // equal to main()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding = ActivityMainBinding.inflate(layoutInflater)

        /*
         btnCalculate.setOnClickListener(View.OnClickListener { // bisa disingkat seperti ini
            aksi ketika tombol diklik
         }
         */
        binding.btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null) { // implementasi onSaveInstanceState
            val result = savedInstanceState.getString(STATE_RESULT)
            binding.tvResult.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, binding.tvResult.text.toString())  // menggunakan konsep Key-Value
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_calculate) {
            val inputLength = binding.edtLength.text.toString().trim() // berfungsi untuk mengambil isi dari sebuah EditText
            val inputWidth = binding.edtWidth.text.toString().trim()
            val inputHeight = binding.edtHeight.text.toString().trim()

            var isEmptyFields = false

            /*
            Validasi apakah inputan masih ada yang kosong
             */
            if (inputLength.isEmpty()) {
                isEmptyFields = true
                binding.edtLength.error = "Field ini tidak boleh kosong"
            }
            if (inputWidth.isEmpty()) {
                isEmptyFields = true
                binding.edtWidth.error = "Field ini tidak boleh kosong"
            }
            if (inputHeight.isEmpty()) {
                isEmptyFields = true
                binding.edtHeight.error = "Field ini tidak boleh kosong"
            }

            /*
            Jika semua inputan valid maka tampilkan hasilnya
             */
            if (!isEmptyFields) {
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                binding.tvResult.text = volume.toString()
            }
        }
    }
}
