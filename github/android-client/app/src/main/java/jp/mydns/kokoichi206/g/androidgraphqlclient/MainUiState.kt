package jp.mydns.kokoichi206.g.androidgraphqlclient

import jp.mydns.kokoichi206.ViewerQuery

data class MainUiState(
    val user: MyUser? = null,
    val isLoading: Boolean = false,
)

// ========== data class を簡単のためにここに定義する ==========
data class MyUser(
    val login: String,
    val location: String,
    val bio: String,
    val organizations: Organizations,
)

data class Organizations(
    val nodes: List<OrgNode>,
)

data class OrgNode(
    val name: String,
)

fun ViewerQuery.Viewer.toMyUser(): MyUser {
    val ns = organizations.nodes?.map {
        OrgNode(
            name = it?.name ?: "Unknown",
        )
    } ?: emptyList()

    return MyUser(
        login = login,
        location = location ?: "",
        bio = bio ?: "",
        organizations = Organizations(
            nodes = ns,
        ),
    )
}
