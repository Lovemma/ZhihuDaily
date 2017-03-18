package xyz.lovemma.zhihudaily.ui.fragment;


import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.widget.Toast;

import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.utils.DataCleanUtil;

public class SettingFragment extends PreferenceFragment implements Preference.OnPreferenceClickListener {


    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting);

        Preference clearCache = getPreferenceScreen().findPreference("clear_cache");
        clearCache.setOnPreferenceClickListener(this);
    }


    @Override
    public boolean onPreferenceClick(Preference preference) {
        switch (preference.getKey()) {
            case "clear_cache":
                DataCleanUtil.cleanInternalCache();
                Toast.makeText(getActivity(), "清理成功", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}
