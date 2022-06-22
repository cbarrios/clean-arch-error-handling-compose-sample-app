package com.lalosapps.cleanarcherrorhandling.ui.main

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lalosapps.cleanarcherrorhandling.R
import com.lalosapps.cleanarcherrorhandling.ui.theme.CleanArchErrorHandlingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchErrorHandlingTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            val viewModel = viewModel<MainViewModel>()
            TextField(
                value = viewModel.email,
                onValueChange = viewModel::onEmailChanged,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = viewModel::submitEmail,
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = stringResource(R.string.submit_btn))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = viewModel.error ?: "")
        }
    }
}

@Preview("Light mode")
@Preview("Dark mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun MyAppPreview() {
    CleanArchErrorHandlingTheme {
        MyApp()
    }
}