package com.example.dmitry.hws_android_school.ui.hw7_phone_book;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.model.Contact;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * Created by Dmitry on 27.04.2016.
 */
public class ContactRecyclerAdapter extends RecyclerView.Adapter<ContactRecyclerAdapter.ViewHolder> {

    private final RealmChangeListener listener;
    protected LayoutInflater inflater;
    protected RealmResults<Contact> realmResults;
    protected Context context;

    public ContactRecyclerAdapter(Context context, RealmResults<Contact> realmResults, boolean automaticUpdate) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        }
        this.context = context;
        this.realmResults = realmResults;
        this.inflater = LayoutInflater.from(context);
        this.listener = (!automaticUpdate) ? null : new RealmChangeListener() {
            @Override
            public void onChange() {
                notifyDataSetChanged();
            }
        };

        if (listener != null && realmResults != null) {
            realmResults.addChangeListener(listener);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_contact, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ContactRecyclerAdapter.ViewHolder holder, int position) {
        final Contact item = getItem(position);

        holder.lastName.setText(item.getLastName());
        holder.name.setText(item.getName());
        holder.phone.setText(item.getPhone());
    }

    @Override
    public int getItemCount() {
        if (realmResults == null) {
            return 0;
        }
        return realmResults.size();
    }

    public Contact getItem(int i) {
        if (realmResults == null) {
            return null;
        }
        return realmResults.get(i);
    }

    public long getItemId(int i) {
        // TODO: find better solution once we have unique IDs
        return i;
    }

    public void updateRealmResults(RealmResults<Contact> queryResults) {
        if (listener != null) {
            // Making sure that Adapter is refreshed correctly if new RealmResults come from another Realm
            if (this.realmResults != null) {
                this.realmResults.removeChangeListener(listener);
            }
            if (queryResults != null) {
                queryResults.addChangeListener(listener);
            }
        }

        this.realmResults = queryResults;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.name)
        TextView name;
        @Bind(R.id.last_name)
        TextView lastName;
        @Bind(R.id.phone)
        TextView phone;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
