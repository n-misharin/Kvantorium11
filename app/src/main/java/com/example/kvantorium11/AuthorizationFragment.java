package com.example.kvantorium11;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AuthorizationFragment extends Fragment {

    public Button authButton;
    public EditText loginEditText, passwordEditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_authorization, container, false);
        authButton = view.findViewById(R.id.btn_enter);
        loginEditText = view.findViewById(R.id.auth_et_login);
        passwordEditText = view.findViewById(R.id.auth_et_password);
        return view;
    }
}
