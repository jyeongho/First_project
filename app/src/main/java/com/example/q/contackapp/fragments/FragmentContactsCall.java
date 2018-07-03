package com.example.q.contackapp.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.q.contackapp.R;
import com.example.q.contackapp.adapters.ContactsCallRvAdapter;
import com.example.q.contackapp.adapters.ContactsRvAdapter;
import com.example.q.contackapp.models.ModelContacts;
import com.example.q.contackapp.models.ModelContactsCall;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FragmentContactsCall extends Fragment {
    private View v;
    private RecyclerView recyclerView;

    public FragmentContactsCall() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        String contact_name = getArguments().getString("contact_name");
        String contact_number = getArguments().getString("contact_number");
        String contact_number2 = getArguments().getString("contact_number2");
        v = inflater.inflate(R.layout.contacts_call_log, container, false);

        TextView contact_call_name = v.findViewById(R.id.contact_call_name);
        TextView contact_call_number = v.findViewById(R.id.contact_call_number);
        TextView contact_call_number2 = v.findViewById(R.id.contact_call_number2);

        contact_call_name.setText(contact_name);
        contact_call_number.setText(contact_number);
        contact_call_number2.setText(contact_number2);

        recyclerView = v.findViewById(R.id.rv_contacts_call);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager = linearLayoutManager;
        recyclerView.setLayoutManager(layoutManager);

        ContactsCallRvAdapter adapter = new ContactsCallRvAdapter(getContext(), getCallLogs(contact_call_number.getText().toString(),contact_call_number2.getText().toString() ));

        recyclerView.setAdapter(adapter);
        return v;
    }

    private List<ModelContactsCall> getCallLogs(String string1, String string2) {

        List<ModelContactsCall> list = new ArrayList<>();

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.READ_CALL_LOG}, 1);
        }

        Cursor cursor = getContext().getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, CallLog.Calls.DATE);

        int duration = cursor.getColumnIndex(CallLog.Calls.DURATION);
        int date = cursor.getColumnIndex(CallLog.Calls.DATE);
        int number = cursor.getColumnIndex(CallLog.Calls.NUMBER);

        string1 = string1.replaceAll("-","");
        string1 = string1.replaceAll("\\(","");
        string1 = string1.replaceAll("\\)","");
        string1 = string1.replaceAll(" ","");
        string1 = string1.trim();
        string2 = string2.replaceAll("-","");
        string2 = string2.replaceAll("\\(","");
        string2 = string2.replaceAll("\\)","");
        string2 = string2.replaceAll(" ","");
        string2 = string2.trim();

        while (cursor.moveToNext()) {
            if (cursor.getString(number).equals(string1) || cursor.getString(number).equals(string2)) {
                Date datel = new Date(Long.valueOf(cursor.getString(date)));
                list.add(new ModelContactsCall(cursor.getString(duration), datel.toString()));
            }
        }
        return list;
    }
}
