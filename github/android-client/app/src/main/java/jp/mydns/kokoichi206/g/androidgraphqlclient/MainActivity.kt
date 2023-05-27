package jp.mydns.kokoichi206.g.androidgraphqlclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import jp.mydns.kokoichi206.g.androidgraphqlclient.ui.theme.AndroidGraphQLClientTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidGraphQLClientTheme {

            }
        }
    }
}
