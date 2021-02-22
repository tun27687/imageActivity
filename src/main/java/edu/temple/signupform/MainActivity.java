package edu.temple.signupform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder alertDialog;
    Button SAVE;
    EditText name,email,mobile,password,confirmpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set text color for Application
        TextView textView6 = findViewById(R.id.textView6);
        textView6.setTextColor(Color.WHITE);

        //Getting all the ID field
        SAVE=(Button)findViewById(R.id.SAVE);
        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
        mobile=(EditText)findViewById(R.id.mobile);
        password=(EditText)findViewById(R.id.password);
        confirmpassword=(EditText) findViewById(R.id.confirmpassword);

        //creating alertbox for showing the username after successfull signup
        alertDialog=new AlertDialog.Builder(MainActivity.this);

        // action click
        SAVE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //check all the fields are empty or filled
                if(name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || mobile.getText().toString().isEmpty() || password.getText().toString().isEmpty() ||
                        confirmpassword.getText().toString().isEmpty()  )
                {
                    Toast.makeText(MainActivity.this, "All Fields are Filled!", Toast.LENGTH_SHORT).show();
                    //if yes then toast will apear to show the fields are mandatory


                }
                else if(!password.getText().toString().equals(confirmpassword.getText().toString()))
                {
                    //if password wrong then this toast will show up
                    Toast.makeText(MainActivity.this, "Re-enter Password!", Toast.LENGTH_SHORT).show();

                }
                else
                {

                    //successfully showing the msg in the form of alert box
                    alertDialog.setTitle("Welcome");
                    alertDialog.setMessage(""+name.getText().toString());
                    alertDialog.setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    finish();
                                    Toast.makeText(getApplicationContext(),"successful saving info",
                                            Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //  Action for 'NO' Button
                                    dialog.cancel();
                                    Toast.makeText(getApplicationContext(),"Not saving any infor",
                                            Toast.LENGTH_SHORT).show();
                                }

                            });
                    //Creating dialog box
                    AlertDialog alert = alertDialog.create();
                    //Setting the title manually
                    alert.setTitle("Welcome ");
                    alert.show();
                }





            }
        });



    }
}
