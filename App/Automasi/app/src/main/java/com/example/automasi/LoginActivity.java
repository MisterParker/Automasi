package com.example.automasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;


public class LoginActivity extends AppCompatActivity {



    TextInputEditText pass;
    MaterialButton but;
    String cup= "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pass=findViewById(R.id.et_phone_number);
        but=findViewById(R.id.btn_login);

        SharedPreferences sh
                = getSharedPreferences("GauriPass",
                MODE_PRIVATE);

//


        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cup=String.valueOf(pass.getText());

                String s1 = sh.getString("gname", "");
                Log.v("s1value",s1);
                if(s1.equals("")){
                    Log.v("NULLWORKED","YESSSS");
                    if(cup.equalsIgnoreCase("1234567890"))
                        launchHome();
                    else
                        Toast.makeText(getBaseContext(),"Wrong Password",Toast.LENGTH_SHORT).show();

                }
                if(s1.equals(cup))
                    launchHome();
                else
                    Toast.makeText(getBaseContext(),"Wrong Password",Toast.LENGTH_SHORT).show();


            }
        });

    }




    void launchHome(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finishAfterTransition();
    }
}
