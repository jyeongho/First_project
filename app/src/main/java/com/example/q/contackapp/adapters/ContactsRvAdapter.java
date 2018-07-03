package com.example.q.contackapp.adapters;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.q.contackapp.MainActivity;
import com.example.q.contackapp.R;
import com.example.q.contackapp.fragments.FragmentContacts;
import com.example.q.contackapp.fragments.FragmentContactsCall;
import com.example.q.contackapp.models.ModelContacts;

import java.util.List;

public class ContactsRvAdapter extends RecyclerView.Adapter<ContactsRvAdapter.ViewHolder>{

    private Context mContext;
    private LayoutInflater inflater;
    private List<ModelContacts> mListContacts;
    public ContactsRvAdapter(Context context, List<ModelContacts> listContacts) {
        mContext = context;
        mListContacts = listContacts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(mContext);

        View view = inflater.inflate(R.layout.items_contacts, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView contact_name, contact_number, contact_number2;
        contact_name = holder.contact_name;
        contact_number = holder.contact_number;
        contact_number2 = holder.contact_number2;

        contact_name.setText(mListContacts.get(position).getName());
        contact_number.setText(mListContacts.get(position).getNumber());
        contact_number2.setText(mListContacts.get(position).getNumber2());

    }

    @Override
    public int getItemCount() {
        return mListContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView contact_name, contact_number, contact_number2;
        public ViewHolder(View itemView) {
            super(itemView);
            contact_name = itemView.findViewById(R.id.contact_name);
            contact_number = itemView.findViewById(R.id.contact_number);
            contact_number2 = itemView.findViewById(R.id.contact_number2);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Fragment fragment = new FragmentContactsCall();
            FragmentManager fragmentManager = ((MainActivity)mContext).getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.linear_rv, fragment).commit();

        }
    }
}
