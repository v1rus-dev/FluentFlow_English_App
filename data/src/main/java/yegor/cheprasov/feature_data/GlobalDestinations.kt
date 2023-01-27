package yegor.cheprasov.feature_data

sealed class GlobalDestinations(val id: Int) {
    object Grammar : GlobalDestinations(0)
    object Words : GlobalDestinations(1)
    object Exercise : GlobalDestinations(2)
    object None : GlobalDestinations(-1)
}