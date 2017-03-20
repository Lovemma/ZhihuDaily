package xyz.lovemma.zhihudaily.ui.fragment;


import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.widget.Toast;

import xyz.lovemma.zhihudaily.App;
import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.utils.DataCleanUtil;
import xyz.lovemma.zhihudaily.utils.SharedPreferencesUtils;

public class SettingFragment extends PreferenceFragment implements Preference.OnPreferenceClickListener {

    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting);

        Preference clearCache = getPreferenceScreen().findPreference("clear_cache");
        CheckBoxPreference noImgMode = (CheckBoxPreference) findPreference("NO_IMAGE_MODE");
        if ((boolean) SharedPreferencesUtils.get(App.getContext(), "NO_IMAGE_MODE", false)) {
            noImgMode.setDefaultValue(true);
        } else {
            noImgMode.setDefaultValue(false);
        }
        clearCache.setOnPreferenceClickListener(this);
        noImgMode.setOnPreferenceClickListener(this);
    }


    @Override
    public boolean onPreferenceClick(Preference preference) {
        switch (preference.getKey()) {
            case "clear_cache":
                DataCleanUtil.cleanInternalCache();
                Toast.makeText(getActivity(), "清理成功", Toast.LENGTH_SHORT).show();
                break;
            case "NO_IMAGE_MODE":
                if ((boolean) SharedPreferencesUtils.get(App.getContext(), "NO_IMAGE_MODE", false)) {
                    SharedPreferencesUtils.put(App.getContext(), "NO_IMAGE_MODE", true);
                } else {
                    SharedPreferencesUtils.put(App.getContext(), "NO_IMAGE_MODE", false);
                }
                break;
        }
        return false;
    }
}
