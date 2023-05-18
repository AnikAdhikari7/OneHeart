package com.example.oneheart.screens

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.oneheart.MainActivity
import com.example.oneheart.R
import com.example.oneheart.daos.PostDao
import com.example.oneheart.databinding.ActivityMainBinding
import com.example.oneheart.databinding.ActivityPostBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class PostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostBinding

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var storageRef: StorageReference
    private lateinit var firebaseFirestore: FirebaseFirestore
    private var imageUri: Uri? = null

    private lateinit var postDao: PostDao


//    companion object {
//        private const val STORAGE_PERMISSION_CODE = 100
//        private const val IMAGE_PERMISSION_CODE = 101
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPostBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()


        postDao = PostDao()

        binding.btnPost.setOnClickListener {
            val input = binding.postInput.text.toString().trim()
            if(input.isNotEmpty()) {
                postDao.addPost(input)
                finish()
            }
        }

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {

    }
}
//        initVars()
//        registerClickEvents()
//
//        checkPermission(
//            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.READ_MEDIA_IMAGES, STORAGE_PERMISSION_CODE, IMAGE_PERMISSION_CODE
//
//        )


//    private fun registerClickEvents() {
//        binding.btnPost.setOnClickListener {
////            uploadImage()
//
//        }

//        binding.ivAddImage.setOnClickListener {
//            resultLauncher.launch("image/*")
//        }
//    }

//    private val resultLauncher = registerForActivityResult(
//        ActivityResultContracts.GetContent()
//    ) {
//
//        imageUri = it
//        binding.ivAddImage.setImageURI(it)
//    }
//
//
//    private fun initVars() {
//
//        storageRef = FirebaseStorage.getInstance().reference.child("PostImages")
//        firebaseFirestore = FirebaseFirestore.getInstance()
//    }
//
//    private fun uploadImage() {
//        binding.progressBar.visibility = View.VISIBLE
//        binding.etText.visibility = View.GONE
//        binding.ivAddImage.visibility = View.GONE
//        binding.btnPost.visibility = View.GONE
//
//        storageRef = storageRef.child(System.currentTimeMillis().toString())
//        imageUri?.let {
//            storageRef.putFile(it).addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//
//                    storageRef.downloadUrl.addOnSuccessListener { uri ->
//
//                        val map = HashMap<String, Any>()
//                        map["pic"] = uri.toString()
//
//                        firebaseFirestore.collection("images").add(map).addOnCompleteListener { firestoreTask ->
//
//                            if (firestoreTask.isSuccessful){
//                                Toast.makeText(this, "Uploaded Successfully", Toast.LENGTH_SHORT).show()
//                                startActivity(Intent(this@PostActivity, MainActivity::class.java))
//                                finish()
//
//                            }else{
//                                Toast.makeText(this, firestoreTask.exception?.message, Toast.LENGTH_SHORT).show()
//
//                            }
//                            binding.etText.visibility = View.VISIBLE
//                            binding.ivAddImage.visibility = View.VISIBLE
//                            binding.btnPost.visibility = View.VISIBLE
//                            binding.progressBar.visibility = View.GONE
//
//                            binding.ivAddImage.setImageResource(R.drawable.image)
//
//                        }
//                    }
//                } else {
//                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
//                    binding.etText.visibility = View.VISIBLE
//                    binding.ivAddImage.visibility = View.VISIBLE
//                    binding.btnPost.visibility = View.VISIBLE
//                    binding.progressBar.visibility = View.GONE
//                    binding.ivAddImage.setImageResource(R.drawable.image)
//                }
//            }
//        }
//    }


    /*
    // Function to check and request permission
    private fun checkPermission(permission: String, permission: String, requestCodeStorage: Int, requestCodeImage: Int) {
        if (ContextCompat.checkSelfPermission(
                this@PostActivity,
                permission
            ) == PackageManager.PERMISSION_DENIED
        ) {
            ActivityCompat.requestPermissions(this@PostActivity, arrayOf(permission), requestCode)
        }
    }


    // This function is called when the user accepts or decline the permission.
    // Request Code is used to check which permission called this function.
    // This request code is provided when the user is prompt for permission.
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@PostActivity, "Storage Permission Granted", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this@PostActivity, "Storage Permission Denied", Toast.LENGTH_LONG)
                    .show()
            }
        }
    } */


//}