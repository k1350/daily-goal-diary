package a84b9cb.info.dialygoaldiary

import android.app.Dialog
import android.support.v4.app.DialogFragment
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog

class YearMonthPickerDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage("さんぷる")
                .setPositiveButton("はい", DialogInterface.OnClickListener { dialogInterface, i ->
                    // 処理
                })
                .setNegativeButton("キャンセル", DialogInterface.OnClickListener { dialogInterface, i ->
                    // 処理
                })
        return builder.create()
    }

}