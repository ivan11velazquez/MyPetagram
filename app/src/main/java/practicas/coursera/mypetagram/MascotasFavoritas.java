package practicas.coursera.mypetagram;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;

import practicas.coursera.mypetagram.adapters.MascotasAdapter;
import practicas.coursera.mypetagram.model.Mascota;

public class MascotasFavoritas extends AppCompatActivity {

    private ArrayList<Mascota> listaMascotas;
    private RecyclerView viewMascotas;
    private MascotasAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        viewMascotas = findViewById(R.id.recyclerPetsFav);
        viewMascotas.setHasFixedSize(true);
        cargarListaMascotas();
        viewMascotas = findViewById(R.id.recyclerPetsFav);
        layoutManager = new LinearLayoutManager(this);
        viewMascotas.setLayoutManager(layoutManager);
        adapter = new MascotasAdapter(listaMascotas);
        viewMascotas.setAdapter(adapter);
    }

    private void cargarListaMascotas(){
        listaMascotas = new ArrayList<>();
        listaMascotas.add(new Mascota("Fido",50,R.drawable.pet1));
        listaMascotas.add(new Mascota("Waldo",45,R.drawable.pet2));
        listaMascotas.add(new Mascota("Rono",40,R.drawable.pet3));
        listaMascotas.add(new Mascota("Kuki",25,R.drawable.pet4));
        listaMascotas.add(new Mascota("Zuzu",15,R.drawable.pet5));
    }
}