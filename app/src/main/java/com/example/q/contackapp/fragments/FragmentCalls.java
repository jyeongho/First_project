package com.example.q.contackapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.q.contackapp.R;
import com.example.q.contackapp.adapters.CallsRvAdapter;
//import com.example.q.contackapp.adapters.ContactsRvAdapter;
import com.example.q.contackapp.models.ModelContacts;

import java.util.List;

public class FragmentCalls extends Fragment {

    private RecyclerView recyclerView;
    private View v;

    public FragmentCalls() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frag_contacts, container, false);
        recyclerView = v.findViewById(R.id.rv_calls);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager = linearLayoutManager;
        recyclerView.setLayoutManager(layoutManager);

        CallsRvAdapter adapter = new CallsRvAdapter(getContext(), null);

        return v;
    }

    private List<ModelContacts> getCallLogs() {

        return null;
    }
}
