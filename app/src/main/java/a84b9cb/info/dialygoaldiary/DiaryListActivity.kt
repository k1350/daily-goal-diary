package a84b9cb.info.dialygoaldiary

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment

class DiaryListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary_list)

        val fragment = DiaryListFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, fragment as Fragment)
        transaction.commit()
    }
}
