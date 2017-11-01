package a84b9cb.info.dialygoaldiary

import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.support.v4.app.DialogFragment
import android.os.Bundle
import android.widget.DatePicker
import java.util.*
import android.support.v4.app.Fragment
import android.view.View

class DatePickerDialogFragment: DialogFragment(), DatePickerDialog.OnDateSetListener {

    companion object {
        fun newInstance(target: Fragment, requestCode: Int): DatePickerDialogFragment {
            val fragment = DatePickerDialogFragment()
            fragment.setTargetFragment(target, requestCode)

            val args = Bundle()
            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calender = Calendar.getInstance()
        val year = calender.get(Calendar.YEAR)
        val month = calender.get(Calendar.MONTH)
        val dayOfMonth = calender.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(activity, this@DatePickerDialogFragment, year, month, dayOfMonth)
        // val datePickerDialog = DatePickerDialog(activity, R.style.MySpinnerDatePickerStyle, this@DatePickerDialogFragment, year, month, dayOfMonth)
        // val datePickerDialog = DatePickerDialog(activity, android.R.style.Theme_Holo_Light, this@DatePickerDialogFragment, year, month, dayOfMonth)
        datePickerDialog.datePicker.maxDate = calender.timeInMillis
        return datePickerDialog
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, day: Int) {
        val target = targetFragment
        val data = Intent()
        val str = year.toString() + "/" + (month + 1).toString() + "/" + day.toString()
        data.putExtra(Intent.EXTRA_TEXT, str)
        target.onActivityResult(targetRequestCode, Activity.RESULT_OK, data)
    }
}