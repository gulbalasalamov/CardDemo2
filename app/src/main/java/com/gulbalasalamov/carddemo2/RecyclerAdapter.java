package com.gulbalasalamov.carddemo2;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] baslik = {"1. Keops Piramidi",
            "2. Babil'in Asma Bahçeleri",
            "3. Zeus Heykeli",
            "4. Rodos Heykeli",
            "5. İskenderiye Feneri",
            "6. Halikarnas Mozolesi",
            "7. Artemis Tapınağı"};

    private String[] bolge = {"Mısır", "Mezopotamya", "Olimpia", "Rodos", "Mısır", "Bodrum", "Efes"};

    private int[] resim = {R.drawable.keopspiramidi,
            R.drawable.babilinasmabahceleri,
            R.drawable.zeusheykeli,
            R.drawable.rodosheykeli,
            R.drawable.iskenderiyefeneri,
            R.drawable.halikarnasmozolesi,
            R.drawable.artemistapinagi,
    };

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemResim;
        TextView itemBaslik;
        TextView itemBolge;

        public ViewHolder(View itemView) {
            super(itemView);
            itemResim = (ImageView) itemView.findViewById(R.id.resim);
            itemBaslik = (TextView) itemView.findViewById(R.id.baslik);
            itemBolge = (TextView) itemView.findViewById(R.id.bolge);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition() + 1;
                    Snackbar.make(view, position + ".liste elemanına basıldı.", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                }
            });
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemBaslik.setText(baslik[i]);
        viewHolder.itemBolge.setText(bolge[i]);
        viewHolder.itemResim.setImageResource(resim[i]);
    }

    public int getItemCount() {
        return baslik.length;
    }


}
