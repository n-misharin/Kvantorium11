package com.example.kvantorium11;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Objects;
import java.util.Random;

public class AuthorizationActivity extends AppCompatActivity {

    public static final String TAG = "debug auth activity";

    private LinearLayout backgroundLinearLayout;
    private TextView registrationTextView, forgotPasswordTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).hide();
        }
        initUI();
        setListeners();
    }

    private void initUI(){
        registrationTextView = findViewById(R.id.tv_registration);
        forgotPasswordTextView = findViewById(R.id.tv_forgot_password);
        backgroundLinearLayout = findViewById(R.id.linear_background);

        Drawable drawableBack = new Drawable() {
            @Override
            public void draw(@NonNull Canvas canvas) {
                Bitmap backgroundBitmap = (new ImageConverter(getResources(), R.drawable.auth1,
                        backgroundLinearLayout.getWidth(), backgroundLinearLayout.getHeight())
                ).convert();
                Paint paint = new Paint();
                int color = getResources().getColor(R.color.colorLightGray);
                ColorFilter colorFilter = new LightingColorFilter(color, 0);
                paint.setColorFilter(colorFilter);
                canvas.drawBitmap(backgroundBitmap,
                        new Rect(0, 0, backgroundBitmap.getWidth(), backgroundBitmap.getHeight()),
                        new Rect(0, 0, getBounds().width(), getBounds().height()),
                        paint);
            }

            @Override
            public void setAlpha(int alpha) {

            }

            @Override
            public void setColorFilter(@Nullable ColorFilter colorFilter) {

            }

            @SuppressLint("WrongConstant")
            @Override
            public int getOpacity() {
                return 0;
            }
        };

        backgroundLinearLayout.setBackgroundDrawable(drawableBack);
    }

    private void setListeners(){
        registrationTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrationIntent = new Intent(AuthorizationActivity.this, RegistrationActivity.class);
                startActivity(registrationIntent);
            }
        });

        forgotPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgotPasswordIntent = new Intent(AuthorizationActivity.this, RecoverPasswordActivity.class);
                startActivity(forgotPasswordIntent);
            }
        });
    }
}
