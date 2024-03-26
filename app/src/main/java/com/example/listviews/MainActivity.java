package com.example.listviews;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.listviews.databinding.ActivityMainBinding;
import com.example.listviews.entidades.Inmueble;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        private ActivityMainBinding binding;
        private MainActivityViewModel vmMain;
        private ListView lv;
        private Context context;
        private LayoutInflater li;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        lv = findViewById(R.id.milista);
        li = getLayoutInflater();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        vmMain = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        vmMain.getMutableLista().observe(this, new Observer<ArrayList<Inmueble>>() {
            @Override
            public void onChanged(ArrayList<Inmueble> inmuebles) {
                InmuebleAdapter ia = new InmuebleAdapter(getApplicationContext(), R.layout.item, inmuebles, getLayoutInflater());
                ListView lv = binding.milista;
                lv.setAdapter(ia);
            }
        });
        vmMain.cargarDatos();

    }


}