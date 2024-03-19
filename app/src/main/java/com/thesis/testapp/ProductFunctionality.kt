package com.thesis.testapp

import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import com.thesis.testapp.ui.theme.TestAppTheme

open class ProductFunctionality : ComponentActivity() {

    @Composable
    fun AddProduct() {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            Arrangement.Start,
            verticalAlignment = Alignment.Bottom,
        ) {

            val checkedState = remember { mutableStateOf(false) }


            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                modifier = Modifier
            )

            Text(
                text = "Check All",
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    setContentView(R.layout.edit_text_product_details)
                    findViewById<Button>(R.id.buttonSubmitProductDetails)
                        .setOnClickListener {
                            redirectHome()
                        }

                          },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(Color.Blue),
            ) {
                Text(text = "Add Product")
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AddProductScaffold() {
        Scaffold(

            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Blue,
                        titleContentColor = Color.White,
                        ),
                    title = {
                        Text("Dynamic Pricing")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                    )
            },
            bottomBar = { AddProduct() }
        ) {

        }
    }

    fun redirectHome() {
        setContent {
            TestAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    AddProductScaffold()
                }
            }
        }
    }



    @Preview(showSystemUi = true)
    @Composable
    fun Prev(){
        AddProductScaffold()
    }
}