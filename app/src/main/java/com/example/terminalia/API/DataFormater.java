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

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Date;

public class DataFormater {
    private FirebaseUser userFirebase;
    private DatabaseReference reference;
    private String userID;

    public FirebaseUser getUser()
    {
        userFirebase = FirebaseAuth.getInstance().getCurrentUser();
        userID = userFirebase.getUid();
        return userFirebase;
    }

    public JSONObject FormatMessage(FirebaseUser user, String filePath) throws FileNotFoundException
    {
        String userEmail = user.getEmail().toString();
        FileReader fileReader = new FileReader(filePath);
        JSONObject messageObject = new JSONObject();
        messageObject.put("email",userEmail);
        messageObject.put("image",filePath);
        return messageObject;
    }

}
