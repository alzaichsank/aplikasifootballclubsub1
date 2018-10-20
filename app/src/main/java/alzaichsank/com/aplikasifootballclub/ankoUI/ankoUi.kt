package alzaichsank.com.aplikasifootballclub.ankoUI

import alzaichsank.com.aplikasifootballclub.extension.dp
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class ankoUi :  AnkoComponent<ViewGroup>{

    companion object {
        val anko_image = 1
        val anko_name = 2
        val anko_layout = 3
    }
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            lparams(matchParent, wrapContent)
            id = anko_layout
            orientation = LinearLayout.HORIZONTAL
            padding = dip(15)

            imageView {
                id = anko_image
            }.lparams(width = 50.dp, height = 50.dp)

            textView {
                id = anko_name
            }.lparams(wrapContent, wrapContent) {
                gravity = Gravity.CENTER_VERTICAL
                margin = dip(10)
            }
        }
    }

}