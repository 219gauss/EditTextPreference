package com.sasin.mypreference_pzpapplication;

import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static class SettingsFragment extends PreferenceFragment{

        private static EditTextPreference mEditTextPreference;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settingsfragment);
            mEditTextPreference = (EditTextPreference) findPreference(getResources().getString(R.string.dialog));

            mEditTextPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    Log.d("pzp","EditText is ="+newValue.toString());
                    preference.setSummary(newValue.toString());
                    return true;
                }
            });

            mEditTextPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    mEditTextPreference.getEditText().setText("");  //每次重新打开编辑框，清空框里的数据
                    return false;
                }
            });
        }
    }
}
