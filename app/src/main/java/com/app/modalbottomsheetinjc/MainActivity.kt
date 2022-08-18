@file:OptIn(ExperimentalMaterialApi::class)

package com.app.modalbottomsheetinjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.app.modalbottomsheetinjc.ui.theme.BlackShade
import com.app.modalbottomsheetinjc.ui.theme.ModalBottomSheetInJcTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModalBottomSheetInJcTheme {

                val modalBottomSheetState = rememberModalBottomSheetState(
                    initialValue = ModalBottomSheetValue.Hidden
                )

                val coroutineScope = rememberCoroutineScope()

                ModalBottomSheetLayout(
                    sheetState = modalBottomSheetState,
                    sheetBackgroundColor = BlackShade,
                    sheetContent = {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(500.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Hello, I am a modal bottom sheet 😍", color = Color.White)
                        }
                    },
                    sheetShape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
                    sheetElevation = 8.dp,
                ) {
                    //The content of rest of the screen
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(text = "Hello, Android devs 😀")

                        Button(
                            onClick = {
                                coroutineScope.launch {
                                    modalBottomSheetState.show()
                                }
                            }
                        ) {
                            Text(text = "Show bottom sheet")
                        }
                    }
                }
            }


        }
    }


}
