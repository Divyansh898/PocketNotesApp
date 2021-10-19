package com.divmtech.pocketnotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class changepassword extends AppCompatActivity {
    EditText ed1, ed2, ed3;
    Button btn;
String oldpass="",newpass="",confirmpass="";
ConnectionManager cm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);
        cm=new ConnectionManager();
        ed1 = (EditText) findViewById(R.id.oldpass);
        ed2 = (EditText) findViewById(R.id.newpass);
        ed3 = (EditText) findViewById(R.id.confirmpass);
        btn = (Button) findViewById(R.id.changebtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            oldpass=ed1.getText().toString();
            newpass=ed2.getText().toString();
            confirmpass=ed3.getText().toString();
            if(oldpass.length()==0)
            {
                ed1.setError("plz Enter Old Password");
                ed1.requestFocus();
            }
              else if(newpass.length()==0)
                {
                    ed2.setError("plz Enter new Password");
                    ed2.requestFocus();
                }
            else if(confirmpass.length()==0)
            {
                ed3.setError("plz Enter confirm Password");
                ed3.requestFocus();
            }
            else
            {
                if(newpass.equals(confirmpass))
                {
                 String command="update login set passwd='"+newpass+"' where passwd='"+oldpass+"'";
               boolean x=cm.ExecuteQuery(command);
               if(x==true)
               {
                   Toast.makeText(changepassword.this, "Password Change Successfully", Toast.LENGTH_SHORT).show();
                   Intent intent=new Intent(changepassword.this,MainActivity.class);
                   startActivity(intent);
               }
               else
                   {
                       Toast.makeText(changepassword.this, "Your Password is Not Change", Toast.LENGTH_SHORT).show();
                   }

                }
                else
                {
                    Toast.makeText(changepassword.this, "Plz Confirm Password ", Toast.LENGTH_SHORT).show();
                }
            }
            }
        });
    }
}
