package com.example.kvantorium11;

import android.annotation.SuppressLint;
import android.content.Context;
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
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Objects;

public class AuthorizationActivity extends AppCompatActivity {

    public static final String TAG = "AGAGA";

    private LinearLayout backgroundLinearLayout;
    private ImageView logoImageView;

    private Bitmap backgroundBitmap, logoBitmap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).hide();
        }
        initUI();
    }

    private void initUI(){
        backgroundLinearLayout = findViewById(R.id.linear_background);
        logoImageView = findViewById(R.id.img_logo);
        Drawable drawableBack = new Drawable() {
            @Override
            public void draw(@NonNull Canvas canvas) {
                backgroundBitmap = (new ImageConverter(getResources(), R.drawable.auth1,
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
        //logoImageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.logo1));
        backgroundLinearLayout.setBackgroundDrawable(drawableBack);
    }
}
