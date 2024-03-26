package com.example.listviews;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import com.example.listviews.entidades.Inmueble;

public class MainActivityViewModel extends AndroidViewModel {
    private ArrayList<Inmueble> lista;
    private MutableLiveData<ArrayList<Inmueble>> mutableLista;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<ArrayList<Inmueble>> getMutableLista(){
        if(mutableLista == null){
            mutableLista = new MutableLiveData<>();
        }
        return mutableLista;
    }
    public void cargarDatos(){
        lista= new ArrayList<>();
        lista.add(new Inmueble(R.drawable.imgcasa1, "Potrero de los Funes", R.drawable.imgcasa1));
        lista.add(new Inmueble(R.drawable.imgcasa2, "Juana Koslay", R.drawable.imgcasa2));
        lista.add(new Inmueble(R.drawable.imgcasa3, "San Francisco", R.drawable.imgcasa3));
        mutableLista.setValue(lista);

    }
}
