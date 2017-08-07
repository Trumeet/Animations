package top.trumeet.snippet.aospanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Trumeet on 2017/8/7.
 * @see FingerprintIsloatedActivity
 * @see AppearAnimationActivity
 */

public class LauncherActivity extends AppCompatActivity {
    private static final Class[] DATA = new Class[] {
            FingerprintIsloatedActivity.class,
            AppearAnimationActivity.class
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Map<String, Object>> list = new ArrayList<>(DATA.length);
        for (Class clz : DATA) {
            Map<String, Object> map = new HashMap<>(1);
            map.put("Title", clz.getSimpleName());
            map.put("Class", clz);
            list.add(map);
        }

        ListView listView = new ListView(this);
        listView.setAdapter(new SimpleAdapter(this, list,
                android.R.layout.simple_list_item_1, new String[]{"Title"}, new int[]{android.R.id.text1}));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Map<String, Object> data = (Map<String, Object>)adapterView.getItemAtPosition(i);
                startActivity(new Intent(LauncherActivity.this,
                        (Class)data.get("Class")));
            }
        });
        setContentView(listView);
    }
}
