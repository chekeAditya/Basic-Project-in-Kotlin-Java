package com.application.hichat.activity

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.application.hichat.R
import com.application.hichat.models.User
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.OnProgressListener
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.android.synthetic.main.activity_user.imgBack
import kotlinx.android.synthetic.main.item_user.*
import kotlinx.android.synthetic.main.item_user.userImage
import java.io.IOException
import java.util.*

class ProfileActivity : AppCompatActivity() {

    private lateinit var firebaseUser: FirebaseUser
    private lateinit var databaseReference: DatabaseReference

    private var filePath: Uri? = null
    private val PICK_IMAGE_REQUEST: Int = 2020

    private lateinit var storage: FirebaseStorage
    private lateinit var storageRef: StorageReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        firebaseUser = FirebaseAuth.getInstance().currentUser!!

        databaseReference =
            FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.uid)

        storage = FirebaseStorage.getInstance()
        storageRef = storage.reference

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, error.message, Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(User::class.java)
                etUserName.setText(user!!.userName)

                if (user.profileImage == "") {
                    userImage.setImageResource(R.drawable.aditya_pic)
                } else {
                    Glide.with(this@ProfileActivity).load(user.profileImage).into(userImage)
                }
            }
        })

        imgBack.setOnClickListener {
            onBackPressed()
        }

        userImage.setOnClickListener {
            chooseImage()
        }

        btnSave.setOnClickListener {
            uploadImage()
            progressBar.visibility = View.VISIBLE
        }

    }

    private fun chooseImage() {
        val intent: Intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode != null) {
            filePath = data!!.data
            try {
                var bitmap: Bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                userImage.setImageBitmap(bitmap)
                btnSave.visibility = View.VISIBLE
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun uploadImage() {
        if (filePath != null) {

            var ref: StorageReference = storageRef.child("image/" + UUID.randomUUID().toString())
            ref.putFile(filePath!!)
                .addOnSuccessListener {

                    val hashMap:HashMap<String,String> = HashMap()
                    hashMap.put("userName",etUserName.text.toString())
                    hashMap.put("profileImage",filePath.toString())
                    databaseReference.updateChildren(hashMap as Map<String, Any>)


                    progressBar.visibility = View.GONE
                    Toast.makeText(applicationContext, "Uploaded", Toast.LENGTH_SHORT).show()
                    btnSave.visibility = View.GONE
                }
                .addOnFailureListener {
                    progressBar.visibility = View.GONE
                    Toast.makeText(applicationContext, "Failed" + it.message, Toast.LENGTH_SHORT)
                        .show()

                }
        }
    }
}

/**

private lateinit var firebaseUsers: FirebaseUser
private lateinit var databaseReference: DatabaseReference
private var filePath: Uri? = null
private final val PICK_IMAGE_REQUEST: Int = 1

private lateinit var storage: FirebaseStorage
private lateinit var storageReference: StorageReference

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_profile)

    firebaseUsers = FirebaseAuth.getInstance().currentUser!!
    databaseReference =
        FirebaseDatabase.getInstance().getReference("Users").child(firebaseUsers.uid)

    storage = FirebaseStorage.getInstance()
    storageReference = storage.reference

    databaseReference.addValueEventListener(object : ValueEventListener {

        override fun onDataChange(snapshot: DataSnapshot) {
            val user = snapshot.getValue(User::class.java)
            etUserName.text = user!!.userName
            if (user.profileImage == "") {
                imgProfile.setImageResource(R.drawable.aditya_pic)
            } else {
                Glide.with(this@ProfileActivity).load(user.profileImage).into(imgProfile)
            }
        }

        override fun onCancelled(error: DatabaseError) {
            Toast.makeText(this@ProfileActivity, error.message, Toast.LENGTH_SHORT).show()
        }

    })


    imgBack.setOnClickListener {
        onBackPressed()
    }

    userImage.setOnClickListener {
        chooseImage()
    }

    btnSave.setOnClickListener {
        uploadImage()
        progressBar.visibility = View.VISIBLE
    }
//        imgProfile.setOnClickListener {
//            val intent = Intent(this, UserActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
}

private fun chooseImage() {
    val intent: Intent = Intent()
    intent.type = "image/"
    intent.action = Intent.ACTION_GET_CONTENT
    startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST)
}

override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == PICK_IMAGE_REQUEST && requestCode != null) {
        filePath = data!!.data
        try {
            var bitmap: Bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
            userImage.setImageBitmap(bitmap)
            btnSave.visibility = View.VISIBLE
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}

private fun uploadImage() {
    if (filePath != null) {

        var ref: StorageReference =
            storageReference.child("image/" + UUID.randomUUID().toString())

        ref.putFile(filePath!!)
            .addOnSuccessListener {
//                    OnSuccessListener<UploadTask.TaskSnapshot> {
//                        progressDialog.dismiss()
                progressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "Uploaded", Toast.LENGTH_SHORT).show()
                btnSave.visibility = View.GONE
//                    }
            }
            .addOnFailureListener {
//                    OnFailureListener {
//                        progressDialog.dismiss()
                progressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
//                    }
            }
        /*
    .addOnProgressListener {
        OnProgressListener<UploadTask.TaskSnapshot> {
            var progress: Double = (100.0 * it.bytesTransferred / it.totalByteCount)
            progressDialog.setMessage("Uploaded " + progress.toInt() + "%")
        }
    }
         */
    }
}

}

 */
/**
val progressDialog: ProgressDialog = ProgressDialog(this)
            progressDialog.setTitle("Uploading...")
            progressDialog.show()
 */