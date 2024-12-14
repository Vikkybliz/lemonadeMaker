package com.example.lemonademaker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonademaker.ui.theme.LemonadeMakerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeMakerTheme {
                LemonadeMakerPreview()

            }
        }
    }
}

@Composable
fun LemonadeMaker(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableStateOf(1) }
    var taps by remember {
        mutableStateOf(1)
    }
    var howManyTaps by remember {
        mutableStateOf(0)
    }
    when(currentStep){
        1 -> Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.lemon_tree), contentDescription = stringResource(
                id = R.string.lemon_tree,
            ), modifier = Modifier
                .wrapContentSize()
                .clickable {
                    currentStep = 2
                    taps = (1..6).random()
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = stringResource(id = R.string.tap))
        }
        2 -> Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.lemon_squeeze), contentDescription = stringResource(
                id = R.string.lemon,
            ), modifier = Modifier
                .wrapContentSize()
                .clickable {
                    howManyTaps++
                    if(howManyTaps == taps){
                    currentStep = 3
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = stringResource(id = R.string.keep_tapping))
        }
        3 -> Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.lemon_drink), contentDescription = stringResource(
                id = R.string.glass,
            ), modifier = Modifier
                .wrapContentSize()
                .clickable {
                    currentStep = 4
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = stringResource(id = R.string.drink))
        }
        4 -> Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.lemon_restart), contentDescription = stringResource(
                id = R.string.empty,
            ), modifier = Modifier
                .wrapContentSize()
                .clickable {
                    currentStep = 1
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = stringResource(id = R.string.start_again))
        }

    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

    }

}

@Preview(showBackground = true)
@Composable
fun LemonadeMakerPreview() {
    LemonadeMaker(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}