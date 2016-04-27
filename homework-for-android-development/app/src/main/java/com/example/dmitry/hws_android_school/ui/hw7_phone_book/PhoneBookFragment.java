package com.example.dmitry.hws_android_school.ui.hw7_phone_book;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.dmitry.hws_android_school.R;
import com.example.dmitry.hws_android_school.model.Contact;
import com.example.dmitry.hws_android_school.ui.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhoneBookFragment extends BaseFragment {


    @Bind(R.id.contacts)
    ListView contacts;
    private Realm realm;


    public PhoneBookFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create the Realm configuration
        final RealmConfiguration realmConfig = new RealmConfiguration.Builder(getContext()).build();
        // Open the Realm for the UI thread.
        realm = Realm.getInstance(realmConfig);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_phone_book, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final RealmResults<Contact> noteRealmResults = realm
                .where(Contact.class)
                .findAllSorted("lastName", Sort.ASCENDING);
        final ContactAdapter contactAdapter = new ContactAdapter(getActivity(), noteRealmResults, true);
        contacts.setAdapter(contactAdapter);
    }

    @OnClick(R.id.add_contact_button)
    public void onAddContactButtonClick() {
        final EditText inputLastName = new EditText(getContext());
        final EditText inputName = new EditText(getContext());
        final EditText inputPhone = new EditText(getContext());
        View view = createAddContactView(inputLastName, inputName, inputPhone);

        new AlertDialog
                .Builder(getContext())
                .setTitle(getString(R.string.enter_contact))
                .setView(view)
                .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        realm.beginTransaction();
                        Contact contact = realm.createObject(Contact.class);
                        contact.setName(inputName.getText().toString());
                        contact.setLastName(inputLastName.getText().toString());
                        contact.setPhone(inputPhone.getText().toString());
                        realm.commitTransaction();
                    }
                })
                .setNegativeButton(getString(R.string.cancel), null)
                .show();
    }


    private View createAddContactView(EditText inputLastName, EditText inputName, EditText inputPhone) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        inputLastName.setHint(R.string.last_name);
        inputLastName.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES | InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        linearLayout.addView(inputLastName);

        inputName.setHint(R.string.name);
        inputName.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES | InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        linearLayout.addView(inputName);

        inputPhone.setHint(R.string.phone);
        inputPhone.setInputType(InputType.TYPE_CLASS_PHONE);
        linearLayout.addView(inputPhone);

        return linearLayout;
    }
}
