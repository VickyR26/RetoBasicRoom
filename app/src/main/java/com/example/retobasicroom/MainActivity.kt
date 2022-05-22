package com.example.retobasicroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.example.retobasicroom.database.User
import com.example.retobasicroom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val mainViewModel:MainViewModel by viewModels()
    private lateinit var queue: RequestQueue
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        queue = Volley.newRequestQueue(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonEnviar.setOnClickListener{
            var nombre = binding.txtNombreUs.text
            mainViewModel.saveUser(
                User(
                0,
                    nombre.toString()
            )
            )
            binding.txtNombreUs.setText("")
        }

        binding.buttonRefrescar.setOnClickListener{
            mainViewModel.getUsers()
            mainViewModel.savedUsers.observe(this) { usersList ->
                if (!usersList.isNullOrEmpty()) {
                    //for (user in usersList) {
                    binding.rvUsersEntries.adapter = MainAdapter(usersList)
                    //Log.d("thesearretheusers", user.user_name)
                    //}
                } else {
                    Log.d("thesearretheusers", "null or empty")
                }
            }
        }
    }
}