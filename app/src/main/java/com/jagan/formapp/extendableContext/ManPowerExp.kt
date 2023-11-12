package com.jagan.formapp.extendableContext

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jagan.formapp.ipUtil.DropDownIP
import com.jagan.formapp.ui.theme.blackGlance1
import com.jagan.formapp.ui.theme.blackGlance2


@Composable
fun ManPowerExp() {

    val technicians = arrayOf(
        "Option 1", "Option 2", "Option 3", "Option 4"
    )

    Column(
        Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 15.sp, fontWeight = FontWeight.Bold, color = blackGlance1
                    )
                ) {
                    append("Type of work")
                }

                withStyle(
                    style = SpanStyle(
                        fontSize = 13.sp, color = blackGlance2
                    )
                ) {
                    append(" (Add more than one if needed)")
                }
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp)
        )

        DropDownIP(technicians, "Select person(s) involved")

        Spacer(Modifier.height(20.dp))


    }
}
