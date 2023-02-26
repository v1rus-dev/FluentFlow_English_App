package yegor.cheprasov.feature_design

sealed class GlobalDestinations(val id: Int) {
    object Grammar : GlobalDestinations(0)
    object Words : GlobalDestinations(1)
    object Game : GlobalDestinations(2)
    object None : GlobalDestinations(-1)
}