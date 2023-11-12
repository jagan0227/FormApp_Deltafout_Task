package com.jagan.formapp.extendableContext

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jagan.formapp.R
import com.jagan.formapp.ui.theme.checkBlueColor
import com.jagan.formapp.ui.theme.checkRedColor

@Composable
fun GeneralExp() {

    var switchCheckedState1 by rememberSaveable { mutableStateOf(false) }
    var switchCheckedState2 by rememberSaveable { mutableStateOf(true) }

    Column(
        Modifier
            .fillMaxSize()

            .padding(start = 8.dp, end = 8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            Modifier
                .fillMaxWidth()
                .border(
                    BorderStroke(1.dp, Color(0xFFedeeef)),
                )
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Work area free from combustible / flammable / toxic materials? ",
                fontSize = 13.sp,
                modifier = Modifier
                    .weight(0.7f)
                    .fillMaxSize()
                    .padding(5.dp),
                lineHeight = 15.sp
            )
            Switch(
                checked = switchCheckedState1,
                onCheckedChange = { switchCheckedState1 = it },
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxSize()
                    .border(
                        BorderStroke(1.dp, Color(0xFFedeeef)),
                    )
                    .scale(0.8f),
                thumbContent = if (switchCheckedState1) {
                    {
                        Image(
                            painterResource(id = R.drawable.switchyes),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                        )
                    }
                } else {
                    {
                        Image(
                            painterResource(id = R.drawable.switchno),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                        )
                    }
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = checkBlueColor,
                    checkedTrackColor = checkBlueColor,
                    checkedBorderColor = checkBlueColor,
                    uncheckedBorderColor = checkRedColor,
                    uncheckedThumbColor = checkRedColor,
                    uncheckedTrackColor = checkRedColor,

                    )
            )

        }


        Row(
            Modifier
                .fillMaxWidth()
                .border(
                    BorderStroke(1.dp, Color(0xFFedeeef)),
                )
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Manholes, catch pits / basins, sewer connections are covered? ",
                fontSize = 13.sp,
                modifier = Modifier
                    .weight(0.7f)
                    .fillMaxSize()
                    .padding(5.dp),
                lineHeight = 15.sp
            )
            Switch(
                checked = switchCheckedState2,
                onCheckedChange = { switchCheckedState2 = it },
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxSize()
                    .border(
                        BorderStroke(1.dp, Color(0xFFedeeef)),
                    )
                    .scale(0.8f),
                thumbContent = if (switchCheckedState2) {
                    {
                        Image(
                            painterResource(id = R.drawable.switchyes),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                        )
                    }
                } else {
                    {
                        Image(
                            painterResource(id = R.drawable.switchno),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                        )
                    }
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = checkBlueColor,
                    checkedTrackColor = checkBlueColor,
                    checkedBorderColor = checkBlueColor,
                    uncheckedBorderColor = checkRedColor,
                    uncheckedThumbColor = checkRedColor,
                    uncheckedTrackColor = checkRedColor,

                    )
            )
        }


    }

    Spacer(Modifier.height(20.dp))

}

