package yegor.cheprasov.feature_data.firestore

import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class AppFirebaseStorage {

    val storage = Firebase.storage

    val grammarReference = storage.getReference("grammars")
}