package com.example.terminalia.API;
import android.provider.ContactsContract;

import com.example.terminalia.models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONObject;

public class Message
{
    private  FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("Airports");
    FirebaseUser user = mAuth.getCurrentUser();
    DataFormater formater = new DataFormater();
    JSONObject Jobject = new JSONObject();

    String FormatMessage(JSONObject object, DataFormater formater)
    {
        formater.FormatMessage(user,"");
        return formater.toString();
    }

    public void send()
    {

    }

}
