package com.example.thesisapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thesisapplication.Homepage.CarabaoDetails;
import com.example.thesisapplication.Model.AnimalClass;
import com.example.thesisapplication.R;

import java.util.List;

public class MyAdapterAnimalID extends RecyclerView.Adapter<MyAdapterAnimalID.MyViewHolder> {

    private Context context;
    private List<AnimalClass> animalClassList;

    public MyAdapterAnimalID(Context context, List<AnimalClass> animalClassList) {
        this.context = context;
        this.animalClassList = animalClassList;
    }

    @NonNull
    @Override
    public MyAdapterAnimalID.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterAnimalID.MyViewHolder holder, int position) {

        holder.animalID.setText(animalClassList.get(position).getAnimalID());
        holder.recCardAnimalID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CarabaoDetails.class);
                intent.putExtra("animalID", animalClassList.get(holder.getAdapterPosition()).getAnimalID());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return animalClassList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        CardView recCardAnimalID;
        TextView animalID;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            recCardAnimalID = itemView.findViewById(R.id.recCardAnimalID);
            animalID = itemView.findViewById(R.id.cardCarabaoID);
        }
    }
}
