package com.ticlavilca.abigail.laboratorio;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.ticlavilca.abigail.laboratorio.databinding.ActivityGalleryBinding;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;

public class GalleryActivity extends AppCompatActivity {
    private ActivityGalleryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicializamos ViewBinding
        binding = ActivityGalleryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtenemos el directorio de medios externos
        File directory = new File(getExternalMediaDirs()[0].getAbsolutePath());
        File[] files = directory.listFiles();

        // Verificamos si los archivos no son nulos y los revertimos
        if (files != null) {
            Collections.reverse(Arrays.asList(files));
        } else {
            files = new File[0]; // Evitamos null pointer
        }

        // Creamos el adaptador y lo asignamos al ViewPager
        GalleryAdapter adapter = new GalleryAdapter(files);
        binding.viewPager.setAdapter(adapter);
    }
}

