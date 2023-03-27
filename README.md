# Retrofit-Coruotines-Room-MvvM-
Implementing Meme API with the help of retrofit and Coroutines and storing that Data in Room Database and also following MvvM architecture!! 

# Project SetUP :

     id 'kotlin-kapt'

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.0")
   
    //Room
    implementation("androidx.room:room-runtime:2.5.0")
    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:2.5.0")
    implementation("androidx.room:room-ktx:2.5.0")

    //Coruotines
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"


    //Retrofit
    implementation 'com.squareup.okhttp3:okhttp:4.10.0'
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2'
    implementation 'com.squareup.retrofit2:converter-moshi:2.9.0'

    //Glide
    implementation 'com.github.bumptech.glide:glide:4.14.2'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.14.2'

