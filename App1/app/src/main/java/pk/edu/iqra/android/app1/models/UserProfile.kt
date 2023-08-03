package pk.edu.iqra.android.app1.models

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//data class UserProfile(val name:String, val email:String,val contact:String):java.io.Serializable

@Parcelize
data class UserProfile(val name:String, val  email:String,val  contact:String):Parcelable