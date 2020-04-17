package com.hciclassproject.arhomeimprovement;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    private String username;
    private String password;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.sign_in).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FrontPage_to_SignIn);
            }
        });

        view.findViewById(R.id.create_account).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callLoginDialog();
            }
        });
    }

    public void callLoginDialog(){

        final Dialog loginDialog = new Dialog(getActivity());
        loginDialog.setContentView(R.layout.login_dialog);
        loginDialog.setCancelable(false);
        loginDialog.show();
        Button createAccountButton = (Button) loginDialog.findViewById(R.id.create_account_acc_creation_button);
        Button cancelButton = (Button) loginDialog.findViewById(R.id.cancel_acc_creation_button);

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FrontPage_to_SignIn);
                loginDialog.dismiss();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginDialog.dismiss();
            }
        });

    }
}
