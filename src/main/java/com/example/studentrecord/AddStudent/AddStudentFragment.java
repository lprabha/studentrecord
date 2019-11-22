package com.example.studentrecord.AddStudent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.studentrecord.HomeActivity;
import com.example.studentrecord.Model.Students;
import com.example.studentrecord.R;

import java.util.ArrayList;
import java.util.List;

//import Fragment;

public class AddStudentFragment extends Fragment {

    public static List<Students> stList = new ArrayList<>();
   //List<Students> stList;
    private EditText etStudentName, etStudentAge,etStudentAddress;
    private RadioGroup Gender;
    private RadioButton rbtnMale,rbtnFemale,rbtnOther;
    private Button BtnSave;
    private int Image, age;
    private String name, address, gender;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_addstudent,container,false);
        etStudentName=view.findViewById(R.id.st_name);
        etStudentAge=view.findViewById(R.id.st_age);
        etStudentAddress = view.findViewById(R.id.studentAddress);
        Gender = view.findViewById(R.id.st_radioGender);
        rbtnMale = view.findViewById(R.id.radioMale);
        rbtnFemale = view.findViewById(R.id.radioFemale);
        rbtnOther = view.findViewById(R.id.radioOther);
        BtnSave = view.findViewById(R.id.btnAddStudent);

        final int[] image = {R.drawable.boy, R.drawable.girl, R.drawable.other};
        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etStudentName.getText().toString();
                address = etStudentAddress.getText().toString();
                age = Integer.parseInt(etStudentAge.getText().toString());

                int selectGender = Gender.getCheckedRadioButtonId();
                RadioButton radioButton = view.findViewById(selectGender);
                gender = radioButton.getText().toString();
                if(gender.equals("Male")){
                    Image = image[0];
                }
                else if (gender.equals("Female")){
                    Image = image[1];
                }
                else
                {
                    Image = image[2];
                }

                Students students = new Students(name, address, gender, age, Image);
                stList = HomeActivity.stList;
                stList.add(students);
                Toast.makeText(getActivity(),"Student registration successful",Toast.LENGTH_LONG).show();
                etStudentName.getText().clear();
                etStudentAddress.getText().clear();
                etStudentAge.getText().clear();
                Gender.clearCheck();
            }
        });
        return view;
    }
}
