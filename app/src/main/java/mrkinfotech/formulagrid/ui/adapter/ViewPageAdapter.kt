package mrkinfotech.formulagrid.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import mrkinfotech.formulagrid.R
import mrkinfotech.formulagrid.utils.AppHelper
import com.bumptech.glide.Glide

class ViewPageAdapter(
    private val context: Context,
    private var imageList: ArrayList<String>,
) : PagerAdapter() {

    override fun getCount(): Int = imageList.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view === `object`

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutId = R.layout.image_slider

        val view = LayoutInflater.from(context).inflate(layoutId, container, false)
        val ivImage = view.findViewById<ImageView>(R.id.imageViewPager)

        AppHelper.getDrawableUri(
            context,
            R.drawable.warning_icon,
        )
        Glide.with(context)
            .load(imageList[position])
            .placeholder(R.color.color_black)
            .error(R.drawable.warning_icon)
            .into(ivImage)

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}