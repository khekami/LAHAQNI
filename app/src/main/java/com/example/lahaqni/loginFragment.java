package com.example.lahaqni;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link loginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class loginFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public loginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment loginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static loginFragment newInstance(String param1, String param2) {
        loginFragment fragment = new loginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    TextView inscription;
   // Intent intent = getActivity().getIntent();
    //String users = intent.getStringExtra("users");
    Button bouttonLogin;
    EditText mail, password;
    FirebaseAuth auth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        inscription = view.findViewById(R.id.inscrit);
        bouttonLogin = view.findViewById(R.id.envoyer);
        mail = view.findViewById(R.id.email);
        password = view.findViewById(R.id.mds);

        String userType = getActivity().getIntent().getStringExtra("users");


        auth = FirebaseAuth.getInstance();

        bouttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mail.getText().toString().trim();
                String motdepasse = password.getText().toString().trim();


                auth.signInWithEmailAndPassword(email, motdepasse).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = auth.getCurrentUser();
                            if (user.equals("chauffeur")) {
                                Intent intent = new Intent(getActivity(), Homechauffeur.class);
                                intent.putExtra("users", userType);
                                startActivity(intent);
                            }else{
                                Toast.makeText(getActivity(), "echec", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }//end oncomplete

                });//end signin
            }
        });
        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((login) getActivity()).afficherFragmentInscription();
            }
        });

        return view;
    }
}