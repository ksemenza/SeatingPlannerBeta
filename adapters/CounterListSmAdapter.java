package com.guinproductions.seatingplanner.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.guinproductions.seatingplanner.R;
import com.guinproductions.seatingplanner.models.ServerChild;
import com.guinproductions.seatingplanner.models.ServerParent;

import java.util.ArrayList;

public class CounterListSmAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private ArrayList<ServerParent> parentListSm;


    public CounterListSmAdapter(Context context, ArrayList<ServerParent> parentListSm) {
        this.mContext = context;
        this.parentListSm = parentListSm;

    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<ServerChild> childListSm = parentListSm.get(groupPosition).getChildList();
        return childListSm.get(childPosition);
    }


    @Override
    public int getGroupCount() {
        return parentListSm.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<ServerChild> childListSm =
                parentListSm.get(groupPosition).getChildList();
        return childListSm.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parentListSm.get(groupPosition);

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
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        ServerParent serverParentSm = (ServerParent) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_server_details_parent, parent, false);
        }
        /** Getting View to implement TextView from Data */
        TextView parentSmSecTV = convertView.findViewById(R.id.itemSecLetterTV);
        TextView parentSmNameTV = convertView.findViewById(R.id.itemNameParentTV);
        TextView parentSmTallyTV = convertView.findViewById(R.id.itemTallyParentTV);
/** implementing Data */
        parentSmSecTV.setText(serverParentSm.getSection().trim());
        parentSmNameTV.setText(serverParentSm.getName().trim());
        parentSmTallyTV.setText(serverParentSm.getTally());

        /**TAKEN OUT OF FOR A MATERIAL DESIGN ELEMENT
         parentTimeTV.setText(serverParent.getTime().trim());
         */
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ServerChild serverChildSm = (ServerChild) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_server_details_child, parent, false);
        }

        TextView childSmTableTV = convertView.findViewById(R.id.itemTableChildTV);
        childSmTableTV.setText(serverChildSm.getTable().trim());
        TextView childSmTimeTV = convertView.findViewById(R.id.itemTimeChildTV);
        childSmTimeTV.setText(serverChildSm.getTime().trim());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
