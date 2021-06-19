package com.ravi.examassist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ravi.examassist.ui.theme.ExamAssistTheme
import com.ravi.examassist.ui.theme.NunitoTypography
import com.ravi.examassist.ui.theme.Primary

class MainActivity : ComponentActivity() {
  
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val windows = this.window
//        windows.statusBarColor= (0xFFFFFFFF)
        setContent {
            ExamAssistTheme {
                Surface(color = MaterialTheme.colors.background) {
                    OnBoardingPage1()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingPage1() {
    Surface(
        color = Color.Transparent,
        modifier = Modifier.fillMaxWidth(),
    ){
        Image(
            painterResource(id = R.drawable.onboarding_bg), contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
    }
    Column {
        MainView()
    }
}

@Composable
fun MainView() {
    Surface(
        color = Color.Transparent,
        modifier = Modifier.fillMaxWidth(),
    ) {
        // Background Image


        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End,

            ) {

            Text(text = "")
            //Next button view
            Box(
                modifier = Modifier
                    .padding(12.dp)
                    .size(110.dp, 50.dp)
            ) {


                Button(
                    onClick = { },
                    shape = RoundedCornerShape(50), // = 50% percent
                    modifier = Modifier
                        .size(110.dp, 50.dp)
                        .align(Alignment.BottomEnd),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Primary),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 6.dp,
                        pressedElevation = 8.dp,
                        disabledElevation = 0.dp
                    )
                    ) {
                    Text(
                        style = NunitoTypography.h1,
                        text = "Next", fontSize = 18.sp,
                        modifier = Modifier.offset((-8).dp, 0.dp),


                    )
                }
                Image(
                    painterResource(id = R.drawable.next_arrow), contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .offset((-16).dp, 0.dp)//.padding(12.dp)

                )

            }

        }

    }
}