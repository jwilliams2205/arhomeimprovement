package com.hciclassproject.arhomeimprovement;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link account_page#newInstance} factory method to
 * create an instance of this fragment.
 */
public class account_page extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public account_page() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment account_page.
     */
    // TODO: Rename and change types and number of parameters
    public static account_page newInstance(String param1, String param2) {
        account_page fragment = new account_page();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account_page, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(account_page.this)
                        .navigate(R.id.action_account_page_to_home_page);
            }
        });

        view.findViewById(R.id.change_password_accountpage_button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                callLoginDialog();
            }
        });
    }

    public void callLoginDialog(){

        final Dialog loginDialog = new Dialog(getActivity());
        loginDialog.setContentView(R.layout.change_password_dialog);
        loginDialog.setCancelable(false);
        loginDialog.show();
        Button changePasswordButton = (Button) loginDialog.findViewById(R.id.change_password_confirm_button);
        Button cancelPasswordChangeButton = (Button) loginDialog.findViewById(R.id.change_password_cancel_button);

        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginDialog.dismiss();
            }
        });

        cancelPasswordChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginDialog.dismiss();
            }
        });

    }
}
