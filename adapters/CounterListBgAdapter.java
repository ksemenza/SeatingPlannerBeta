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

/**
 * Created by guinp on 4/8/2018.
 */

public class CounterListBgAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private ArrayList<ServerParent> parentListBg;


    public CounterListBgAdapter(Context context, ArrayList<ServerParent> parentListBg) {
        this.mContext = context;
        this.parentListBg = parentListBg;

    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<ServerChild> childListBg = parentListBg.get(groupPosition).getChildList();
        return childListBg.get(childPosition);
    }


    @Override
    public int getGroupCount() {
        return parentListBg.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<ServerChild> childListBg =
                parentListBg.get(groupPosition).getChildList();
        return childListBg.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parentListBg.get(groupPosition);

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

        ServerParent serverParentBg = (ServerParent) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_server_details_parent, parent, false);
        }
        /** Getting View to implement TextView from Data */
        TextView parentBgSecTV = convertView.findViewById(R.id.itemSecLetterTV);
        TextView parentBgNameTV = convertView.findViewById(R.id.itemNameParentTV);
        TextView parentBgTallyTV = convertView.findViewById(R.id.itemTallyParentTV);
/** implementing Data */
        parentBgSecTV.setText(serverParentBg.getSection().trim());
        parentBgNameTV.setText(serverParentBg.getName().trim());
        parentBgTallyTV.setText(serverParentBg.getTally());

        /**TAKEN OUT OF FOR A MATERIAL DESIGN ELEMENT
         parentTimeTV.setText(serverParent.getTime().trim());
         */
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ServerChild serverChildBg = (ServerChild) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_server_details_child, parent, false);
        }

        TextView childBgTableTV = convertView.findViewById(R.id.itemTableChildTV);
        childBgTableTV.setText(serverChildBg.getTable().trim());
        TextView childBgTimeTV = convertView.findViewById(R.id.itemTimeChildTV);
        childBgTimeTV.setText(serverChildBg.getTime().trim());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
