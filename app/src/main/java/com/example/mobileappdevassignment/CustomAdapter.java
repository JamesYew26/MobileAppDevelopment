package com.example.mobileappdevassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {


    private Context context;
    private ArrayList ID, Donor_Name, Donor_Age, Donor_BloodType, Donor_Date, Donating_Location;

    CustomAdapter(Context context,
                  ArrayList ID,
                  ArrayList Donor_Name,
                  ArrayList Donor_Age,
                  ArrayList Donor_BloodType,
                  ArrayList Donor_Date,
                  ArrayList Donating_Location ){
        this.context = context;
        this.ID = ID;
        this.Donor_Name = Donor_Name;
        this.Donor_Age = Donor_Age;
        this.Donor_BloodType = Donor_BloodType;
        this.Donor_Date = Donor_Date;
        this.Donating_Location = Donating_Location;

    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.ID.setText(String.valueOf(ID.get(position)));
        holder.Donor_Name.setText(String.valueOf(Donor_Name.get(position)));
        holder.Donor_Age.setText(String.valueOf(Donor_Age.get(position)));
        holder.Donor_BloodType.setText(String.valueOf(Donor_BloodType.get(position)));
        holder.Donor_Date.setText(String.valueOf(Donor_Date.get(position)));
        holder.Donating_Location.setText(String.valueOf(Donating_Location.get(position)));
    }

    @Override
    public int getItemCount() {
        return ID.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ID, Donor_Name, Donor_Age, Donor_BloodType, Donor_Date, Donating_Location;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ID = itemView.findViewById(R.id.appointment_id_text);
            Donor_Name = itemView.findViewById(R.id.apppointment_name_text);
            Donor_Age = itemView.findViewById(R.id.apppointment_age_text);
            Donor_BloodType = itemView.findViewById(R.id.apppointment_bloodtype_text);
            Donor_Date = itemView.findViewById(R.id.apppointment_date_text);
            Donating_Location = itemView.findViewById(R.id.apppointment_location_text);
        }
    }
}
