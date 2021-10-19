package com.divmtech.pocketnotesapp.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.divmtech.pocketnotesapp.ConnectionManager;
import com.divmtech.pocketnotesapp.R;
import com.divmtech.pocketnotesapp.ui.send.SendFragment;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
EditText ed1,ed2,ed3,ed4;
RadioGroup rg;
RadioButton rbtn;
Button btn,b1;
private ConnectionManager cm;
FrameLayout fl1,fl2;
String name="",email="",mobile="",pass="",gender="";
public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        ed1=root.findViewById(R.id.name);
        ed2=root.findViewById(R.id.email);
        ed3=root.findViewById(R.id.mobile);
        ed4=root.findViewById(R.id.passwd);
        rg=root.findViewById(R.id.rdbgroup);
        btn=root.findViewById(R.id.btnreg);
        b1=root.findViewById(R.id.btnsign);
        fl1=root.findViewById(R.id.frmReg);
        fl2=root.findViewById(R.id.frmChange);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                SendFragment sf=new SendFragment();
                ft.replace(R.id.frmChange,sf);
                ft.commit();
                fl1.setVisibility(View.GONE);
            }
        });
        cm=new ConnectionManager();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int gid = rg.getCheckedRadioButtonId();
                    rbtn = root.findViewById(gid);
                    gender = rbtn.getText().toString();
                    name = ed1.getText().toString();
                    email = ed2.getText().toString();
                    mobile = ed3.getText().toString();
                    pass = ed4.getText().toString();
                    String command = "insert into register values('" + name + "','" + gender + "','" + mobile + "','" + email + "','" + pass + "')";
                   String cmd="insert into login values('"+email+"','"+pass+"')";
                   if(name.length()==0)
                   {
                       ed1.requestFocus();
                       ed1.setError("Plz enter your name");
                   }
                   else if(email.length()==0)
                   {
                       ed2.requestFocus();
                       ed2.setError("Plz enter your email");
                   }
                   else if(mobile.length()==0)
                   {
                       ed3.requestFocus();
                       ed3.setError("Plz enter your mobile no.");
                   }
                   else if(pass.length()==0)
                   {
                       ed4.requestFocus();
                       ed4.setError("Plz enter your password");
                   }
                   else
                   {
                       boolean x=cm.ExecuteQuery(command);
                       if (x==true)
                       {
                           boolean y=cm.ExecuteQuery(cmd);
                           if(y==true)
                           {
                               Toast.makeText(getActivity(), "Your Registration is completed", Toast.LENGTH_SHORT).show();

                           }
                           else
                           {
                               Toast.makeText(getActivity(), " Registration Failed", Toast.LENGTH_SHORT).show();
                           ed1.setText("");
                           ed2.setText("");
                           ed3.setText("");
                           ed4.setText("");
                           }

                       }
                       else
                       {
                           Toast.makeText(getActivity(), "Your Registration Failed", Toast.LENGTH_SHORT).show();
                       }

                   }
                }
                catch(Exception ex)
                {
                    Toast.makeText(getActivity(), "Registration not completed, Plz fill up all values", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }
}