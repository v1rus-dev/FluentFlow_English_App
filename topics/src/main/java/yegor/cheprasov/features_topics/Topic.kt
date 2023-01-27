package yegor.cheprasov.features_topics

import androidx.annotation.DrawableRes
import yegor.cheprasov.feature_data.GlobalDestinations

data class Topic(
    val title: String,
    val desc: String,
    val percentages: Int,
    val id: Int,
    val destination: GlobalDestinations = GlobalDestinations.None,
    @DrawableRes val background: Int,
    @DrawableRes val image: Int
)