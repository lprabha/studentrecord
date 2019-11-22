package com.example.studentrecord.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentrecord.Model.Students;
import com.example.studentrecord.R;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    Context mContext;
    List<Students> stList;

    public StudentAdapter(Context mContext,List<Students> stList){
        this.mContext = mContext;
        this.stList = stList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.students_view,parent,false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentViewHolder holder, final int i) {
        final Students students = stList.get(i);
        holder.name.setText(students.getName());
        holder.age.setText(String.format("%d", students.getAge()));
        holder.gender.setText(students.getGender());
        holder.address.setText(students.getAddress());
        holder.image.setImageResource(students.getImageId());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stList.remove(i);
                notifyDataSetChanged();
            }
        });

        holder.image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Toast.makeText( mContext.getApplicationContext(), "This is"+' ' + students.getName(),Toast.LENGTH_LONG ).show();
                }
        } );
    }

    @Override
    public int getItemCount() {
        return stList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView name, age, address,gender;
        ImageView image;
        Button btnDelete;

        public StudentViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
            address = itemView.findViewById(R.id.address);
            gender = itemView.findViewById(R.id.gender);
            image = itemView.findViewById(R.id.imgProfile);
            btnDelete = itemView.findViewById(R.id.delete);

        }
    }
}
