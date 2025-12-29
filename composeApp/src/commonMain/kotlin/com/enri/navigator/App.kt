package com.enri.navigator

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kmpnavigator.composeapp.generated.resources.Res
import kmpnavigator.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    Navigator(screen = MainScreen())
}
class MainScreen : Screen {
    @Composable
    override fun Content() {
        var navigator = LocalNavigator.currentOrThrow
        MaterialTheme {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .safeContentPadding()
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Button(onClick = { navigator.push(SecondScreen()) }) {
                    Text("Click me!")
                }
            }
        }
    }

    class SecondScreen : Screen {
        @Composable
        override fun Content() {
            var navigator = LocalNavigator.currentOrThrow
            Column(
                modifier = Modifier
                    .fillMaxSize().background(Color.Green),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text("Welcome Second Page")
                Button(onClick = { navigator.pop() }) {
                    Text("Close")
                }
            }
        }

}
}