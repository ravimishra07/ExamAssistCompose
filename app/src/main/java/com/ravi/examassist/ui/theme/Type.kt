package com.ravi.examassist.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ravi.examassist.R

// Set of Material typography styles to start with
private val nunito = FontFamily(
    Font(R.font.nunito_regular),
    Font(R.font.nunito_light, FontWeight.W500),
    Font(R.font.nunito_bold, FontWeight.Bold)


)
val NunitoTypography = Typography(
    h1 = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.W500,
        fontSize = 50.sp,
    )
    ,
    h2 = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp,
    ),
    h3 = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp,
    ),
    h4 = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp,
    ),
    h5 = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
    ),
    h6 = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
    ),
    subtitle1 = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
    ),
    subtitle2 = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
    ),
    body1 = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = nunito,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.W400,
        fontSize = 15.sp,
        color = Color.White
    ),
    caption = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    )
)

