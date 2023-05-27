package jp.mydns.kokoichi206.g.androidgraphqlclient

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo3.ApolloClient
import jp.mydns.kokoichi206.ViewerQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val apolloClient: ApolloClient,
) : ViewModel() {

    private val _state = MutableStateFlow(MainUiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update {
                it.copy(isLoading = true)
            }

            val user = apolloClient
                .query(ViewerQuery())
                .execute()
                .data
                ?.viewer
                ?.toMyUser()
            Log.d("user", user.toString())

            _state.update {
                it.copy(
                    user = user,
                    isLoading = false,
                )
            }
        }
    }
}
