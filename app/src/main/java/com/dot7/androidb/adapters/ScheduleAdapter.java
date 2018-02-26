package com.dot7.androidb.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dot7.androidb.R;
import com.dot7.androidb.models.ScheduleData;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Cristofer Marín on 27/01/2016
 */
public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleHolder> {

    private List<ScheduleData> mData = new ArrayList<>();
    private TreeSet<Integer> sectionHeader = new TreeSet<>();
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;

    public void addSectionHeaderItem(final String item) {
        mData.add(new ScheduleData(item));
        sectionHeader.add(mData.size() - 1);
        notifyDataSetChanged();
    }


    public void addListItem(final List<ScheduleData> listItems) {
        mData.addAll(listItems);
        notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) {
        return sectionHeader.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public ScheduleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case TYPE_ITEM:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_item, parent, false);
                break;
            case TYPE_SEPARATOR:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_item, parent, false);
                break;
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_item, parent, false);
                break;
        }
        return new ScheduleHolder(view);
    }

    @Override
    public void onBindViewHolder(ScheduleHolder holder, final int position) {
        View view = holder.getView();
        final ScheduleData scheduleData = mData.get(position);
        int rowType = getItemViewType(position);
        switch (rowType) {
            case TYPE_ITEM:
                ((TextView) view.findViewById(R.id.txtTopic)).setText(scheduleData.getTopic());
                ((TextView) view.findViewById(R.id.txtClassRoom)).setText(scheduleData.getClassroom());
                ((TextView) view.findViewById(R.id.txtHour)).setText(getHour(scheduleData.getStarthour(),scheduleData.getEndhour()));
                ((TextView) view.findViewById(R.id.txtTeacher)).setText(scheduleData.getTeacher());
                ((TextView) view.findViewById(R.id.txtSemester)).setText(scheduleData.getSemestre());
                break;
            case TYPE_SEPARATOR:
                ((TextView) view.findViewById(R.id.txtHeader)).setText(scheduleData.getDay());
                break;
        }

    }

    private String getHour(String start, String end){
        return start + end;
    }

    class ScheduleHolder extends RecyclerView.ViewHolder {
        private View mView;

        private ScheduleHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public View getView() {
            return mView;
        }
    }
}