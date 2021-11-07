package com.example.storingdata;

import android.Manifest;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {


    private EditText metFileName;
    private TextView mTvStatus;
    private Button mBtnInsert, mBtnDelete, mBtnFetch, mBtnUpdate;
    private ImageView mIvImage;
    private mySqliteDBHandler sqliteDBHandler;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        permission();
        storingImage();

    }

    private void storingImage() {
        try {
            // conversion -> Image -> Bitmap -> Byte and then we will stroe it
            sqliteDBHandler = new mySqliteDBHandler(this, "database_name", null, 1);
            sqLiteDatabase = sqliteDBHandler.getWritableDatabase();
            sqLiteDatabase.execSQL("CREATE TABLE TABLENAME(Name Text,Image BLOB)"); //here we are storing image in the form of BLOB
        } catch (Exception e) {
            Log.d("TAG", "storingImage:" + e.getMessage());
        }
    }

    private void initViews() {
        metFileName = findViewById(R.id.etFileName);
        mTvStatus = findViewById(R.id.Status);
        mBtnDelete = findViewById(R.id.btnDelete);
        mBtnInsert = findViewById(R.id.btnInsert);
        mBtnFetch = findViewById(R.id.btnFetch);
        mBtnUpdate = findViewById(R.id.btnUpdate);
        mIvImage = findViewById(R.id.ivImage);
    }

    private void permission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
    }

    public void btnInsert(View view) {
        String stringFilePath = Environment.getExternalStorageDirectory().getPath() + "/Download/" + metFileName.getText().toString() + ".jpeg";
        Bitmap bitmap = BitmapFactory.decodeFile((stringFilePath));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream); //converting into byte
        byte[] bytesImage = byteArrayOutputStream.toByteArray();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", "MyImage"); //putting name of the image hardcoring you can also use the edittext
        contentValues.put("Image", bytesImage); //putting the image
        sqLiteDatabase.insert("TABLENAME", null, contentValues);
        mTvStatus.setText("Insert Successful");
        Toast.makeText(this, "Insert Successful", Toast.LENGTH_LONG).show();
    }

    public void btnUpdate(View view) {
        String stringFilePath = Environment.getExternalStorageDirectory().getPath() + "/Download/" + metFileName.getText().toString() + ".jpeg";
        Bitmap bitmap = BitmapFactory.decodeFile((stringFilePath));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream); //converting into byte
        byte[] bytesImage = byteArrayOutputStream.toByteArray();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", "MyImage"); //putting name of the image hardcoring you can also use the edittext
        contentValues.put("Image", bytesImage); //putting the image
        sqLiteDatabase.update("TABLENAME", contentValues, null, null);
        mTvStatus.setText("Update Successful");
        Toast.makeText(this, "Update Successful", Toast.LENGTH_LONG).show();
    }

    public void btnDelete(View view) {
        if (sqLiteDatabase.delete("TABLENAME", "Name=\"MyImage\"", null) > 0) {
            mTvStatus.setText("Deletion Successfully");
            Toast.makeText(this, "Deletion Successful", Toast.LENGTH_LONG).show();
        }
        ;


    }

    public void btnFetch(View view) {
        String stringQuery = "Select Image Where Name =\"MyImage\"";
        Cursor cursor = sqLiteDatabase.rawQuery(stringQuery, null);
        try {
            cursor.moveToFirst();
            byte[] bytesImage = cursor.getBlob(0);
            cursor.close();
            Bitmap bitmapImage = BitmapFactory.decodeByteArray(bytesImage, 0, bytesImage.length); //here we got the image
            mIvImage.setImageBitmap(bitmapImage);
            mTvStatus.setText("Fetch SUccessful");
            Toast.makeText(this, "Fetch Successfully", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            mTvStatus.setText("Error");
        }
    }

}