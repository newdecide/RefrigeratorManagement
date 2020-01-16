package com.study.refrigeratormanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView refrigeratorList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<RefrigeratorData> RefrigeratorList = new ArrayList<>();
        refrigeratorList = (ExpandableListView) findViewById(R.id.refrigrator_mainlist);
        RefrigeratorData refrigeratorData = new RefrigeratorData("냉장고");
        refrigeratorData.childname.add("사과");
        refrigeratorData.childname.add("삼결살");
        refrigeratorData.childname.add("김치");
        RefrigeratorList.add(refrigeratorData);

        refrigeratorData = new RefrigeratorData("냉동고");
        refrigeratorData.childname.add("닭가슴살");
        refrigeratorData.childname.add("치즈");
        refrigeratorData.childname.add("밥");
        RefrigeratorList.add(refrigeratorData);

        refrigeratorData = new RefrigeratorData("상온");
        refrigeratorData.childname.add("물");
        refrigeratorData.childname.add("고추참치");
        refrigeratorData.childname.add("참기름");
        refrigeratorData.childname.add("식용유");
        RefrigeratorList.add(refrigeratorData);

        ExpandableAdapter adapter = new ExpandableAdapter(getApplicationContext(), R.layout.parent_row, R.layout.child_row, RefrigeratorList);
        refrigeratorList.setAdapter(adapter);

    }

}
