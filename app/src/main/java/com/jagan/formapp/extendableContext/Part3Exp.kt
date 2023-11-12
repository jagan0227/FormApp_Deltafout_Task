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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jagan.formapp.ipUtil.DropDownIP
import com.jagan.formapp.ui.theme.blackGlance1

@Composable
fun Part3Exp() {

    val permitName = arrayOf(
        "Option 1", "Option 2", "Option 3", "Option 4"
    )

    val receiver = arrayOf(
        "Option 1", "Option 2", "Option 3"
    )

    Column(
        Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "Select Permit Issuing Authority",
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = blackGlance1
        )

        DropDownIP(permitName, "Select Permit Issuer Name")
        Spacer(Modifier.height(10.dp))

        Text(
            text = "Select Receiver",
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = blackGlance1
        )

        DropDownIP(receiver, "Myself")

        Spacer(Modifier.height(20.dp))

    }
}