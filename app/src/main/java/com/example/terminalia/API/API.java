package com.example.terminalia.API;

import android.graphics.Bitmap;
import android.os.Environment;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.terminalia.models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

public class API {
    private FirebaseUser userFirebase;
    private DatabaseReference reference;
    private String userID;

    public FirebaseUser getUser()
    {
        userFirebase = FirebaseAuth.getInstance().getCurrentUser();
        userID = userFirebase.getUid();
        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                User user = snapshot.getValue(User.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });
        return userFirebase;
    }


}
