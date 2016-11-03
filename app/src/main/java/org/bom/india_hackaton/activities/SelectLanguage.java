package org.bom.india_hackaton.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import org.bom.india_hackaton.R;
import org.bom.india_hackaton.activities.base.BaseActivity;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.logo;
import static android.R.attr.onClick;
import static android.R.attr.tag;

public class SelectLanguage extends BaseActivity {
    public static  final String TAG = "Select Language";
    @BindView(R.id.english_language) Button eng_btn;

    @BindView(R.id.hindi_language) Button hindi_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.hindi_language)
    void Click()
    {
        Log.e("Select Language","Hindi Button Clicked");
        SharedPreferences sharedPreferences  = getSharedPreferences("MyPrefs",this.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("lang","hi");
        editor.commit();
        Intent intent = new Intent(SelectLanguage.this,LoginActivity.class);
        Log.e(TAG, "Preferences: " +sharedPreferences.getString("lang","Default"));
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.english_language)
    void click_eng()
    {
        Log.e("Select Language","English Button Clicked");
        SharedPreferences sharedPreferences  = getSharedPreferences("MyPrefs",this.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("lang","en");
        editor.commit();
        Intent intent = new Intent(SelectLanguage.this,LoginActivity.class);
        Log.e(TAG, "Preferences: " +sharedPreferences.getString("lang","Default"));
        SelectLanguage.this.startActivity(intent);
        finish();
    }












}
