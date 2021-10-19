package com.divmtech.pocketnotesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import de.hdodenhof.circleimageview.CircleImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {

CircleImageView ch1,log1,java,php,python,dbms,android,net;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    ch1=(CircleImageView)findViewById(R.id.changepass);
    java=(CircleImageView)findViewById(R.id.java);
    log1=(CircleImageView)findViewById(R.id.logout);
    php=(CircleImageView)findViewById(R.id.php);
    android=(CircleImageView)findViewById(R.id.android);
    python=(CircleImageView)findViewById(R.id.python);
    dbms=(CircleImageView)findViewById(R.id.dbms1);
    net=(CircleImageView)findViewById(R.id.net);

    log1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager f=getSupportFragmentManager();
            FragmentTransaction ft=f.beginTransaction();
            Logout l=new Logout();
            ft.replace(R.id.FrmLogout,l);
            ft.commit();
        }
    });
    ch1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Dashboard.this,changepassword.class);
            startActivity(intent);
        }
    });
    java.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Dashboard.this,java.class);
            startActivity(intent);
        }
    });
    php.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Dashboard.this,PHP.class);
            startActivity(intent);
        }
    });
    python.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Dashboard.this,python.class);
            startActivity(intent);
        }
    });
    android.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Dashboard.this,android.class);
            startActivity(intent);
        }
    });
    net.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Dashboard.this,dotnet.class);
            startActivity(intent);
        }
    });
    dbms.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Dashboard.this,dbms.class);
            startActivity(intent);
        }
    });
    }

}
