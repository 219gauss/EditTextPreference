package com.sasin.mypreference_pzpapplication;

import android.preference.Preference;
import android.preference.PreferenceFragment;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 287){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    public static class SettingsFragment extends PreferenceFragment{

        private MyEditTextPreference mMyEditTextPreference;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settingsfragment);
            mMyEditTextPreference = (MyEditTextPreference)findPreference(getResources().getString(R.string.dialog));
            mMyEditTextPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    preference.setSummary(newValue.toString());
                    return false;
                }
            });
        }
    }
}
