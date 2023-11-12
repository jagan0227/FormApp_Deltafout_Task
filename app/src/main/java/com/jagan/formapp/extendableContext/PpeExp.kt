package com.jagan.formapp.extendableContext

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jagan.formapp.ipUtil.DropDownIP
import com.jagan.formapp.ui.theme.blackGlance1
import com.jagan.formapp.ui.theme.blueColor

@Composable
fun PpeExp() {
    var safetyglasses by rememberSaveable { mutableStateOf(false) }
    var barricades by rememberSaveable { mutableStateOf(false) }
    var isolation by rememberSaveable { mutableStateOf(false) }
    val equipment = arrayOf(
        "Option 1", "Option 2", "Option 3", "Option 4"
    )

    Column(
        Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 2.dp, end = 10.dp, top = 5.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .height(24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Checkbox(
                    checked = safetyglasses,
                    onCheckedChange = { safetyglasses = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = blueColor,
                    ),
                    modifier = Modifier
                        .width(25.dp)
                )
                Text(
                    text = "Safety glasses",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 10.dp),
                    textAlign = TextAlign.Start
                )
            }

            Row(
                modifier = Modifier
                    .height(24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Checkbox(
                    checked = barricades,
                    onCheckedChange = { barricades = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = blueColor,
                    ),

                    modifier = Modifier
                        .width(25.dp)
                        .clip(shape = RoundedCornerShape(0))
                )
                Text(
                    text = "Barricades",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 15.dp),
                    textAlign = TextAlign.Start
                )
            }

        }

        Row(
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth()
                .padding(start = 2.dp, end = 10.dp, top = 5.dp, bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Checkbox(
                checked = isolation,
                onCheckedChange = { isolation = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = blueColor,
                ),
                modifier = Modifier
                    .width(25.dp)
            )
            Text(
                text = "Isolation Required?",
                color = Color.Red,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 10.dp),
                textAlign = TextAlign.Start
            )
        }


        Text(
            text = "Location of Isolation",
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = blackGlance1
        )

        DropDownIP(equipment, "Equipment")
        Spacer(Modifier.height(20.dp))


    }
}
