package a84b9cb.info.dialygoaldiary


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DiaryListFragment : Fragment() {

    private var mTextView: TextView? = null

    override fun onCreateView(inflater: LayoutInflater?, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_diary_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mTextView = view?.findViewById<View>(R.id.textView) as TextView
        view?.findViewById<View>(R.id.button).setOnClickListener { view ->
            mTextView?.text = mTextView?.text as String + "!"
        }

        view?.findViewById<View>(R.id.date_button).setOnClickListener { view ->
            val datePicker = DatePickerDialogFragment()
            datePicker.setTargetFragment(this@DiaryListFragment, 100)
            datePicker.show(fragmentManager, "datePicker")
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            100 -> {
                if (resultCode != Activity.RESULT_OK) {
                    return
                }
                val str = data?.getStringExtra(Intent.EXTRA_TEXT)
                mTextView?.text = str
                return
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }

}// Required empty public constructor
