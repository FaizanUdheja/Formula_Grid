package mrkinfotech.formulagrid.utils

import android.content.Context
import android.widget.Toast

object CustomDialog {
    fun showToast(context: Context, message: String){
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
    }
}