package practicas.coursera.mypetagram.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import practicas.coursera.mypetagram.R;
import practicas.coursera.mypetagram.model.Mascota;

public class MascotasAdapter extends RecyclerView.Adapter<MascotasAdapter.MascotasViewHolder>{

    private ArrayList<Mascota> datosMascota;

    public MascotasAdapter(ArrayList<Mascota> listaMascotas){
        this.datosMascota = listaMascotas;
    }

    @NonNull
    @Override
    public MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new MascotasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotasViewHolder holder, int position) {
        Mascota mascotaSelected = datosMascota.get(position);
        holder.nombreMascota.setText(mascotaSelected.getNombre());
        holder.rating.setText(String.valueOf(mascotaSelected.getRating()));
        holder.imgMascota.setImageResource(mascotaSelected.getFoto());
        holder.btnRating.setOnClickListener(view -> {
            int i = mascotaSelected.getRating();
            mascotaSelected.setRating(i+=1);
        });
    }

    @Override
    public int getItemCount() {
        return datosMascota.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder{
        private TextView nombreMascota;
        private TextView rating;
        private ImageView imgMascota;
        private ImageButton btnRating;


        public MascotasViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreMascota = itemView.findViewById(R.id.txtNombreMascota);
            rating = itemView.findViewById(R.id.txtRating);
            imgMascota = itemView.findViewById(R.id.fotoMascota);
            btnRating = itemView.findViewById(R.id.btnRating);
        }
    }
}
