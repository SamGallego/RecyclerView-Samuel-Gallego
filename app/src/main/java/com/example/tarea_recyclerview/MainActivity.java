package com.example.tarea_recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<Contacto> contactoArrayList = new ArrayList<>(Arrays.asList(new Contacto[]{
                new Contacto(R.drawable.mertin,"Mertin","Gonzalez","tumorcito@gmail.com","611223344"),
                new Contacto(R.drawable.merlin,"Merlin","???","Merlin@gmail.com","611334455"),
                new Contacto(R.drawable.gandalf,"Gandalf","???","Gandalf@gmail.com","611445566"),
                new Contacto(R.drawable.harry_potter,"Harry","Potter","Harry@gmail.com","611556677"),
                new Contacto(R.drawable.dumbledore,"Albus","Dumbledore","Albus@gmail.com","611667788"),
                new Contacto(R.drawable.doctor_strange,"Stephen","Strange","Stephen@gmail.com","611778899"),
                new Contacto(R.drawable.saruman,"Saruman","Gonzalez","Saruman@gmail.com","611889900"),
                new Contacto(R.drawable.morganlfay,"Morgana","Le Fay","Morgana@gmail.com","611990011"),
                new Contacto(R.drawable.raist,"Raistlin","Majere","Raistlin@gmail.com","611101122"),
                new Contacto(R.drawable.willow,"Willow","Rosenberg","Willow@gmail.com","611112233"),
                new Contacto(R.drawable.elminster,"Elminster","???","Elminster@gmail.com","611142434")
        }));

        AdaptadorContacto adaptadorContacto = new AdaptadorContacto(contactoArrayList);

        RecyclerView listaContactos = findViewById(R.id.listaContactos);

        listaContactos.setLayoutManager(new LinearLayoutManager(this));

        listaContactos.setAdapter(adaptadorContacto);


    }
}