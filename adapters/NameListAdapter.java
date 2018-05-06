package com.guinproductions.seatingplanner.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.guinproductions.seatingplanner.R;
import com.guinproductions.seatingplanner.models.Name;

import java.util.List;

import static com.guinproductions.seatingplanner.database.DbPresenter.Name.SERVER_NAME;


public class NameListAdapter extends RecyclerView.Adapter<NameListAdapter.ViewHolder> {

    Context mContext;
    Cursor mCursor;
    public static String NAME_ITEM = "name";

    private List<Name> nameList;
    private SparseBooleanArray selectedNameItem;


    public NameListAdapter(Context context, Cursor cursor) {

        mContext = context;
        mCursor = cursor;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_name, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        mCursor.moveToPosition(position);
        holder.bindCursor(mCursor);
        /**  Name nameModel = nameList.get(position); */
//         holder.itemView.setActivated(selectedNameItem.get(position, false));
        holder.bindCursor(mCursor);

    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        Cursor mCursor;
        CardView cardViewName;
        TextView tvNameItem;
        Context mContext;

        public ViewHolder(final View itemView) {
            super(itemView);

            mContext = itemView.getContext();
            tvNameItem = itemView.findViewById(R.id.itemNameTV);
            cardViewName = itemView.findViewById(R.id.nameListCard);

            itemView.setOnClickListener(this);
        }

        public void bindCursor(Cursor cursor) {
            this.mCursor = cursor;

            tvNameItem.setText(cursor.getString(
                    cursor.getColumnIndexOrThrow(SERVER_NAME)
            ));
        }

        @Override
        public void onClick(View v) {
            getAdapterPosition();

            NAME_ITEM = tvNameItem.getText().toString().trim();
            Toast.makeText(mContext, "You Selected " + NAME_ITEM, Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    }
}
