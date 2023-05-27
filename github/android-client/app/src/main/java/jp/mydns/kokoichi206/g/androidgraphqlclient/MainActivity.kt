package jp.mydns.kokoichi206.g.androidgraphqlclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.apollographql.apollo3.ApolloClient
import jp.mydns.kokoichi206.g.androidgraphqlclient.ui.theme.AndroidGraphQLClientTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val apolloClient = ApolloClient.Builder()
            .serverUrl("https://api.github.com/graphql")
            .addHttpHeader(
                "Authorization",
                "bearer <your_token>"
            )
            .build()
        val viewModel = MainViewModel(apolloClient)

        setContent {
            AndroidGraphQLClientTheme {
                val state by viewModel.state.collectAsState()

                MainScreen(state = state)
            }
        }
    }
}
