package com.thesis.testapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thesis.testapp.ui.theme.TestAppTheme

@Composable
fun SimpleFilledTextFieldSample() {
    var productName by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }
    var productReference by remember { mutableStateOf("") }

    Column {
        TextField(
            value = productName,
            onValueChange = { productName = it },
            label = { Text("Product Name") },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize()
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = productName,
            onValueChange = { productPrice = it },
            label = { Text("Price") },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize()
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = productReference,
            onValueChange = { productReference = it },
            label = { Text("Keyword") },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize()
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun Preview() {
    TestAppTheme {
        SimpleFilledTextFieldSample()
    }
}