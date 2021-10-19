package com.divmtech.pocketnotesapp.ui.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.divmtech.pocketnotesapp.ConnectionManager;
import com.divmtech.pocketnotesapp.R;

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;
EditText ed1,ed2,ed3,ed4;
Button btn;
private ConnectionManager cm;
String name="",email="",mob="",msg="";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
       ed1=root.findViewById(R.id.txtname);
       ed2=root.findViewById(R.id.txtemail);
       ed3=root.findViewById(R.id.txtmob);
       ed4=root.findViewById(R.id.txtquery);
       btn=root.findViewById(R.id.btnenq);
       cm=new ConnectionManager();


       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               name = ed1.getText().toString();
               email = ed2.getText().toString();
               mob = ed3.getText().toString();
               msg = ed4.getText().toString();
               String command = "insert into enquiry values('" + name + "','" + email + "','" + mob + "','" + msg + "')";
               if (name.length() == 0) {
                   ed1.requestFocus();
                   ed1.setError("Plz enter your name");
               } else if (email.length() == 0) {
                   ed2.requestFocus();
                   ed2.setError("Plz enter your email");
               } else if (mob.length() == 0) {
                   ed3.requestFocus();
                   ed3.setError("Plz enter your mobile no.");
               } else if (msg.length() == 0) {
                   ed4.requestFocus();
                   ed4.setError("Plz enter your Query");
               } else {
                   boolean x = cm.ExecuteQuery(command);
                   if (x == true) {
                       Toast.makeText(getActivity(), "Your enquiry is completed,Thanks", Toast.LENGTH_SHORT).show();
                   } else {
                       Toast.makeText(getActivity(), "Enquiry not completed ,check your network connection", Toast.LENGTH_SHORT).show();

                   }
               }
           }
       });

        return root;
    }
}