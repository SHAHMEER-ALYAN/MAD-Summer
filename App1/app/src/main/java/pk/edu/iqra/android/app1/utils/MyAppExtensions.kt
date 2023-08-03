package pk.edu.iqra.android.app1.utils

/*fun isEmail(email:String):Boolean{
    return email.contains("@")
}*/


fun String.isEmail():Boolean{
    return this.contains("@")
}

