package com.divmtech.pocketnotesapp.ui.share;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.divmtech.pocketnotesapp.ConnectionManager;
import com.divmtech.pocketnotesapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ShareFragment extends Fragment
{
    EditText ed1,ed2;
    Button btn;
    RatingBar rt;
    private ConnectionManager cm;
    String name="",email="";
    String star="";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root= inflater.inflate(R.layout.fragment_share,container,false);
        ed1=root.findViewById(R.id.txtn);
        ed2=root.findViewById(R.id.txte);
        btn=root.findViewById(R.id.btnrating);
        rt=root.findViewById(R.id.rt1);
        cm=new ConnectionManager();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=ed1.getText().toString();
                email=ed2.getText().toString();
                float rat=rt.getRating();
                star=Float.toString(rat);

                String command="insert into review values('"+name+"','"+email+"','"+star+"')";
                if (name.length() == 0) {
                    ed1.requestFocus();
                    ed1.setError("Plz enter your name");
                } else if (email.length() == 0) {
                    ed2.requestFocus();
                    ed2.setError("Plz enter your email");
                }
                else {
                    boolean x = cm.ExecuteQuery(command);
                    if (x == true) {
                        Toast.makeText(getActivity(), "Thanks For Review", Toast.LENGTH_SHORT).show();
                        ed1.setText("");
                        ed2.setText("");
                    } else {
                        Toast.makeText(getActivity(), "Review Unsuccessful", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



        return root;
    }
}
