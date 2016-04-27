package com.example.dmitry.hws_android_school.ui.hw7;

import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.model.Contact;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;

/**
 * Created by Dmitry on 27.04.2016.
 */
public class ContactAdapter extends RealmBaseAdapter<Contact> {

    public ContactAdapter(Context context, RealmResults<Contact> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ContactsViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_contact, parent, false);

            viewHolder = new ContactsViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else
            viewHolder = (ContactsViewHolder) convertView.getTag();

        final Contact item = getItem(position);

        viewHolder.lastName.setText(item.getLastName());
        viewHolder.name.setText(item.getName());
        viewHolder.phone.setText(item.getPhone());

        return convertView;
    }

    static class ContactsViewHolder {
        @Bind(R.id.name)
        TextView name;
        @Bind(R.id.last_name)
        TextView lastName;
        @Bind(R.id.phone)
        TextView phone;

        ContactsViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
