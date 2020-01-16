package com.study.refrigeratormanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ExpandableAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private ArrayList<RefrigeratorData> mRefrigeratorData;
    private int parentname = 0;
    private int childname = 0;
    private LayoutInflater inflater = null;

    public ExpandableAdapter(Context context, ArrayList<RefrigeratorData> refrigerator){
        mContext = context;
        mRefrigeratorData = refrigerator;
    }

    public ExpandableAdapter(Context context, int parent, int child, ArrayList<RefrigeratorData> dataList) {
        this.mRefrigeratorData = dataList;
        this.parentname = parent;
        this.childname = child;
        this.mContext = context;

        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getGroupCount() {
        return mRefrigeratorData.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mRefrigeratorData.get(groupPosition).childname.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mRefrigeratorData.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mRefrigeratorData.get(groupPosition).childname.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(this.parentname, parent, false);
        }

        TextView parentName = convertView.findViewById(R.id.parent_name);
        parentName.setText(mRefrigeratorData.get(groupPosition).parentname);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(this.childname, parent, false);
        }

        TextView childName = convertView.findViewById(R.id.child_name);
        childName.setText(mRefrigeratorData.get(groupPosition).childname.get(childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
