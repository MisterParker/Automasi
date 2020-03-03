package com.example.automasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class SettingActivity extends AppCompatActivity {


    TextInputEditText pass;
    MaterialButton but;
    String cup= "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        pass=findViewById(R.id.et_phone_number);
        but=findViewById(R.id.btn_login);

        SharedPreferences sh
                = getSharedPreferences("GauriPass",
                MODE_PRIVATE);
        SharedPreferences.Editor myEdit
                = sh.edit();

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ep= String.valueOf(pass.getText());

                if(ep.length()==10){
                    myEdit.putString(
                            "gname",
                            ep);
                    Toast.makeText(getBaseContext(),"New Password Set",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getBaseContext(),"Not 10 digits",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
