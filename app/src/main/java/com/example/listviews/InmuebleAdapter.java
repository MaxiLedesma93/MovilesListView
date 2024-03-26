package com.example.listviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listviews.databinding.ItemBinding;
import com.example.listviews.entidades.Inmueble;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class InmuebleAdapter extends ArrayAdapter<Inmueble> {
    private List<Inmueble> lista;
    private LayoutInflater li;
    private Context context;
    private ItemBinding binding;
    public InmuebleAdapter(@NonNull Context context, int resource, @NonNull List<Inmueble> objects, LayoutInflater li) {

        super(context, resource, objects);
        this.context = context;
        this.lista = objects;
        this.li = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View itemtView, @NonNull ViewGroup parent) {
        View view = itemtView;
        //View view = binding.getRoot();
        if(itemtView==null){
            binding = ItemBinding.inflate(li, parent, false);
            view= binding.getRoot();
            view.setTag(binding);

        }
        else{
            binding = (ItemBinding) view.getTag();
        }
        Inmueble inmueble = lista.get(position);
        binding.direccion.setText(inmueble.getDireccion());
        binding.precio.setText(inmueble.getPrecio()+"");
        binding.foto.setImageResource(inmueble.getFoto());

        return view;



    }
}
