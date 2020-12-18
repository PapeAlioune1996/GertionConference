package com.example.gestionconference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gestionconference.dto.Helper;
import com.example.gestionconference.dto.UserDetails;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

  private Button singin,con;
final AppCompatActivity activity=MainActivity.this;
    private InputValidation inputValidation;
    Helper databaseHelper;
    private UserDetails user;
    SQLiteDatabase db;
    private EditText lname,fnam,mail,address,pswd;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
 //TextInputLayout textInputLayoutName,textInputLayoutpname,textInputLayoutEmail,textInputLayoutAddres,textInputLayoutPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // databaseHelper=new Helper(getBaseContext());
          init();
          //initObjects();
        singin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                register();

            }
        });

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });
    }


        //initialisation
    public void init()
    {
        lname=findViewById(R.id.nom);
        fnam=findViewById(R.id.prenom);
        mail=findViewById(R.id.email);
        address=findViewById(R.id.adress);

        pswd=findViewById(R.id.passwrds);
        singin=findViewById(R.id.sng);
        con=findViewById(R.id.lgin);
       // databaseHelper=new Helper(this);

    }

    private void register() {

        if(lname.getText().toString().isEmpty() || fnam.getText().toString().isEmpty()  || mail.getText().toString().isEmpty()  || address.getText().toString().isEmpty() || pswd.getText().toString().isEmpty())
        {
            Toast.makeText(MainActivity.this, "Veillez remplir tous les champs  svp", Toast.LENGTH_LONG).show();
        }
       else{

            if(mail.getText().toString().trim().matches(emailPattern))
            {
                if(pswd.getText().toString().length()<6)
                {
                    Toast.makeText(MainActivity.this, "Password to short", Toast.LENGTH_LONG).show();

                }
                else{
                    user=new UserDetails();
                    //user.setID();
                    user.setNom(lname.getText().toString().trim());
                    user.setPrenom(fnam.getText().toString().trim());
                    user.setEmail(mail.getText().toString().trim());
                    user.setAdress(address.getText().toString().trim());
                    user.setPassword(pswd.getText().toString().trim());

                      long cool=addUser(user);
                    if(cool>0){
                        Toast.makeText(MainActivity.this, "Errorr", Toast.LENGTH_LONG).show();

                    }else{
                       Toast.makeText(MainActivity.this, "succeeded registry", Toast.LENGTH_LONG).show();

                        emptyInputEditText();
                        Intent intent=new Intent(MainActivity.this,Login.class);
                        startActivity(intent);
                    }

                }
            }else{
                Toast.makeText(MainActivity.this, "Veillez saisir un bon email  svp", Toast.LENGTH_LONG).show();

            }

            }/* else {
                // Snack Bar to show error message that record already exists
                // Snackbar.make(nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, R.string.error_email_exists, Toast.LENGTH_LONG).show();
            }*/
      //  }
    }

    private void emptyInputEditText() {
        lname.setText(null);
        fnam.setText(null);
        mail.setText(null);
        address.setText(null);
        pswd.setText(null);

    }







    //adduser
    public long addUser(UserDetails users)
    {
        // Gets the data repository in write mode
        //db=databaseHelper.getWritableDatabase(this);
   databaseHelper=new Helper(this);
   db=databaseHelper.getWritableDatabase();
// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
       // values.put(Helper.COLUMN_ID,user.getID());
        values.put(Helper.COLUMN_NAME,users.getNom());
        values.put(Helper.COLUMN_PRENOM,users.getPrenom());
        values.put(Helper.COLUMN_Mail,users.getEmail());
        values.put(Helper.COLUMN_Adress,users.getAdress());
        values.put(Helper.COLUMN_password,users.getPassword());

// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(Helper.TABLE_NAME, null, values);
        db.close();
        return  newRowId;
    }


}