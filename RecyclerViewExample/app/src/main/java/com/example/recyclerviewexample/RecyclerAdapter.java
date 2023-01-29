package com.example.recyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CountryViewHolder>{
    private ArrayList<String> countryNamelist ;
    private ArrayList<String> detailList ;
    private ArrayList<Integer> imageList ;
    private Context context;

    public RecyclerAdapter(ArrayList<String> countryNamelist, ArrayList<String> detailList, ArrayList<Integer> imageList, Context context) {
        this.countryNamelist = countryNamelist;
        this.detailList = detailList;
        this.imageList = imageList;
        this.context = context;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design,parent,false);

        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.textViewCountryName.setText(countryNamelist.get(position));
        holder.textViewDetails.setText(detailList.get(position));
        holder.imageView.setImageResource(imageList.get(position));
    }

    @Override
    public int getItemCount() {
        return countryNamelist.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewCountryName , textViewDetails ;
        private ImageView imageView;
        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewCountryName = itemView.findViewById(R.id.textViewcountryname);
            textViewDetails = itemView.findViewById(R.id.textviewdata);
            imageView = itemView.findViewById(R.id.imageview);

        }
    }
}
