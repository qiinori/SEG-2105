package com.example.walkinclinicservices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Accounts extends AppCompatActivity {
    private ListView actList;
    private static final String TAG = "Accounts";
    public ArrayList<employee> accountList;
    public ArrayList<String> ids;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);

        Log.d(TAG, "onCreate: Started.");
        actList =  (ListView) findViewById(R.id.actList);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        accountList = new ArrayList<>();
        ids = new ArrayList<>();

        AccountListAdapter adapter = new AccountListAdapter(Accounts.this, R.layout.adapter_view_layout,accountList);
        actList.setAdapter(adapter);

        actList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //employee act = accountList.get(position);

                String idneeded = ids.get(position);

                deleteAccount(idneeded);
                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        mDatabase.child("Employee").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                accountList.clear();

                for(DataSnapshot serviceSnapshot : dataSnapshot.getChildren()){
                    employee employee1 = serviceSnapshot.getValue(employee.class);
                    accountList.add(employee1);
                    ids.add(serviceSnapshot.getKey());
                }

                AccountListAdapter adapter = new AccountListAdapter(Accounts.this,R.layout.adapter_view_layout,accountList);
                actList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void deleteAccount(String serviceId){
        DatabaseReference drAccount = FirebaseDatabase.getInstance().getReference("Employee").child(serviceId);

        drAccount.removeValue();

        Toast.makeText(this,"Account has been deleted",Toast.LENGTH_LONG).show();
    }
}
