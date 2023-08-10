package pk.edu.iqra.android.app1.utils

import android.content.Context

class PrefManager(context:Context) {
    private var sharedPreferences = context.getSharedPreferences("my_app_pref",Context.MODE_PRIVATE)

    fun containKey(key:String):Boolean{
        return sharedPreferences.contains(key)
    }

    fun getData(key:String):String{
        return sharedPreferences.getString(key,"")?:""
    }

    fun saveData(key:String, value:String){
        sharedPreferences.edit().putString(key,value).apply()
    }

    fun clearData(){
        sharedPreferences.edit().clear().apply()
    }
}