package com.divmtech.pocketnotesapp.ui.send;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.divmtech.pocketnotesapp.ConnectionManager;
import com.divmtech.pocketnotesapp.Dashboard;
import com.divmtech.pocketnotesapp.R;
import com.divmtech.pocketnotesapp.ui.slideshow.SlideshowFragment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SendFragment extends Fragment {
EditText ed1,ed2;
Button btn,b1;
    FrameLayout fl1,fl2;
private ConnectionManager cm;
String userid="",passwd="";
    private SendViewModel sendViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sendViewModel =
                ViewModelProviders.of(this).get(SendViewModel.class);
        View root = inflater.inflate(R.layout.fragment_send, container, false);
        ed1=root.findViewById(R.id.luid);
        ed2=root.findViewById(R.id.lpass);
        btn=root.findViewById(R.id.btnlogin);
        cm=new ConnectionManager();
        b1=root.findViewById(R.id.signup);
        fl1=root.findViewById(R.id.frmLog);
        fl2=root.findViewById(R.id.frmCh);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                SlideshowFragment sf=new SlideshowFragment();
                ft.replace(R.id.frmCh,sf);
                ft.commit();
                fl1.setVisibility(View.GONE);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userid=ed1.getText().toString();
                passwd=ed2.getText().toString();
                if(userid.length()==0)
                {
                    ed1.requestFocus();
                    ed1.setError("Plz enter your Userid");
                }
                else if(passwd.length()==0)
                {
                    ed2.requestFocus();
                    ed2.setError("Plz enter your Password");
                }
                else
                {
                String command="select * from login where userid='"+userid+"' and passwd='"+passwd+"'";
                    ResultSet rs=cm.selectData(command);
                    try {
                        if(rs.next())
                        {
                          Intent intent=new Intent(getActivity(),Dashboard.class);
                          startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(getActivity(), "Invaild Userid and Password", Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        return root;
    }
}