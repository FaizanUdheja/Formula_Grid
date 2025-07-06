package mrkinfotech.formulagrid.utils

import android.content.Context
import mrkinfotech.formulagrid.R
import mrkinfotech.formulagrid.ui.data.ModelClass

object MasterDataUtils {
    fun contestList(context: Context): ArrayList<ModelClass> {
        val dataset = ArrayList<ModelClass>()
        dataset.add(
            ModelClass(
                AppHelper.getDrawableUri(context, R.drawable.abu_dhabi),
                round = "Round1",
                country_name = "Abu Dhabi",
                description = "Fireworks",
                AppHelper.getDrawableUri(context, R.drawable.abudhabi)
            )
        )
        dataset.add(
            ModelClass(
                AppHelper.getDrawableUri(context, R.drawable.brazil_flag),
                round = "Round2",
                country_name = "Brazil",
                description = "Hot tracks",
                AppHelper.getDrawableUri(context, R.drawable.brazil)
            )
        )
        dataset.add(
            ModelClass(
                AppHelper.getDrawableUri(context, R.drawable.belguim_flag),
                round = "Round3",
                country_name = "Belgium",
                description = "New Livery",
                AppHelper.getDrawableUri(context, R.drawable.belguim)
            )
        )
        dataset.add(
            ModelClass(
                AppHelper.getDrawableUri(context, R.drawable.las_vegas_flag),
                round = "Round4",
                country_name = "LAS VEGAS",
                description = "Lightening",
                AppHelper.getDrawableUri(context, R.drawable.lasvegas)
            )
        )
        dataset.add(
            ModelClass(
                AppHelper.getDrawableUri(context, R.drawable.united_states_flag),
                round = "Round5",
                country_name = "United States",
                description = "Huge fans",
                AppHelper.getDrawableUri(context, R.drawable.unitedstates)
            )
        )
        return dataset
    }

    fun viewSlider(context: Context): ArrayList<String> {
        val dataset = ArrayList<String>()

        dataset.add(
            AppHelper.getDrawableUri(context, R.drawable.ic_app_logo)
        )
        dataset.add(
            AppHelper.getDrawableUri(context, R.drawable.brazil_flag)
        )
        return dataset
    }
}