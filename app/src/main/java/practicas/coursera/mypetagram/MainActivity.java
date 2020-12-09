package practicas.coursera.mypetagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import practicas.coursera.mypetagram.adapters.MascotasAdapter;
import practicas.coursera.mypetagram.model.Mascota;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Mascota> listaMascotas;
    private RecyclerView viewMascotas;
    private MascotasAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton fab;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cant_fav:
                Intent intent = new Intent(this, MascotasFavoritas.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewMascotas = findViewById(R.id.recyclerPets);
        viewMascotas.setHasFixedSize(true);
        fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(view -> {

        });
        cargarListaMascotas();
        viewMascotas = findViewById(R.id.recyclerPets);
        layoutManager = new LinearLayoutManager(this);
        viewMascotas.setLayoutManager(layoutManager);
        adapter = new MascotasAdapter(listaMascotas);
        viewMascotas.setAdapter(adapter);
    }

    private void cargarListaMascotas(){
        listaMascotas = new ArrayList<>();
        listaMascotas.add(new Mascota("Fido",0,R.drawable.pet1));
        listaMascotas.add(new Mascota("Waldo",0,R.drawable.pet2));
        listaMascotas.add(new Mascota("Rono",0,R.drawable.pet3));
        listaMascotas.add(new Mascota("Kuki",0,R.drawable.pet4));
        listaMascotas.add(new Mascota("Zuzu",0,R.drawable.pet5));
    }
}