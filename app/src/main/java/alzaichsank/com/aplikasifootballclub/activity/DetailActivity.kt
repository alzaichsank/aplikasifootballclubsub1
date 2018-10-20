package alzaichsank.com.aplikasifootballclub.activity

import alzaichsank.com.aplikasifootballclub.item.ItemData
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val item = intent.getParcelableExtra<ItemData>(MainActivity.PARCELABLE_ITEM_DATA)
        DetailActivityUI(item).setContentView(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        showNameClub(item)
    }
    inner class DetailActivityUI(val item: ItemData) : AnkoComponent<DetailActivity> {
        val id_image = 1
        val id_name = 2
        val id_desc = 3

        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            relativeLayout {
                lparams(wrapContent, matchParent)
                imageView {
                    id = id_image
                    Glide.with(this)
                            .load(item.image)
                            .into(this)
                }.lparams(dip(100), dip(100)) {
                    centerHorizontally()
                    topMargin = dip(100)
                }
                textView {
                    id = id_name
                    text = item.name
                    textSize = 24f
                    setTypeface(null, Typeface.BOLD)
                }.lparams {
                    below(id_image)
                    centerHorizontally()
                }
                textView {
                    id = id_desc
                    padding = dip(16)
                    text = item.desc
                }.lparams {
                    below(id_name)
                }
                textView {
                    padding = dip(12)
                    text = "Created By Alza Ichsan Kurniawan 2018"
                }.lparams {
                    centerHorizontally()
                    alignParentBottom()
                }
            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onBackPressed() {
        finish()
    }
    //anko common
    private fun showNameClub(item: ItemData) {
        toast((item.name).toString())
    }
}
