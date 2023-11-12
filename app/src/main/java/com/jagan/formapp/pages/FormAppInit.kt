package com.jagan.formapp.pages

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jagan.formapp.R
import com.jagan.formapp.extendableContext.GeneralExp
import com.jagan.formapp.extendableContext.ManPowerExp
import com.jagan.formapp.extendableContext.Part2Exp
import com.jagan.formapp.extendableContext.Part3Exp
import com.jagan.formapp.extendableContext.PpeExp
import com.jagan.formapp.extendableContext.WorkSummaryExp
import com.jagan.formapp.ipUtil.ExpandableBar
import com.jagan.formapp.ipUtil.TopAppBar
import com.jagan.formapp.ui.theme.blueColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormAppInit() {
    var workexp by rememberSaveable { mutableStateOf(false) }
    var generalexp by rememberSaveable { mutableStateOf(false) }
    var ppeexp by rememberSaveable { mutableStateOf(false) }
    var part2exp by rememberSaveable { mutableStateOf(false) }
    var part3exp by rememberSaveable { mutableStateOf(false) }
    var manpowerexp by rememberSaveable { mutableStateOf(false) }
    var checkedState by rememberSaveable { mutableStateOf(false) }

    Scaffold(topBar = { TopAppBar() }) { innerPadding ->
        Column(
            modifier = Modifier
                .animateContentSize()
                .padding(innerPadding)
                .verticalScroll(
                    rememberScrollState()
                ),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            // collapse button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp, top = 10.dp),
                horizontalArrangement = Arrangement.End
            ) {
                OutlinedButton(
                    onClick = {
                        workexp = false
                        generalexp = false
                        ppeexp = false
                        part2exp = false
                        part3exp = false
                        manpowerexp = false
                    },
                    shape = MaterialTheme.shapes.small.copy(all = CornerSize(0.dp)),
                    border = BorderStroke(2.dp, blueColor),
                    modifier = Modifier
                        .height(38.dp)
                        .width(160.dp)
                ) {
                    Icon(
                        painterResource(id = R.drawable.minuscircle),
                        null,
                        tint = blueColor,
                        modifier = Modifier.size(25.dp)
                    )
                    Text(" Collapse All", color = blueColor, fontSize = 15.sp)
                }
            }

            Column(
                modifier = Modifier
                    .animateContentSize()
                    .padding(start = 5.dp, end = 5.dp)

            ) {

                ExpandableBar(name = "Work Summary", "") { workexp = !workexp }
                if (workexp) WorkSummaryExp()
                ExpandableBar(name = "General Guidelines", "") { generalexp = !generalexp }
                if (generalexp) GeneralExp()
                ExpandableBar(name = "PPEs Selection", "(Tick all applicable fields)") {
                    ppeexp = !ppeexp
                }
                if (ppeexp) PpeExp()
                ExpandableBar(
                    name = "PART 2: Isolation Details", "(Tick all applicable fields)"
                ) { part2exp = !part2exp }
                if (part2exp) Part2Exp()
                ExpandableBar(name = "PART 3: User Declaration", "") { part3exp = !part3exp }
                if (part3exp) Part3Exp()
                ExpandableBar(name = "Manpower Details", "") { manpowerexp = !manpowerexp }
                if (manpowerexp) ManPowerExp()

            }
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 10.dp)
                        .height(30.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Image(
                            painterResource(id = R.drawable.arrowcircletop),
                            null,
                            Modifier.size(26.dp)
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .height(24.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Checkbox(
                        checked = checkedState,
                        onCheckedChange = { checkedState = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = blueColor,
                        ),
                        modifier = Modifier
                            .width(25.dp)
                            .padding(start = 22.dp)
                    )
                    Text(
                        text = "Save it to auto-fill",
                        fontSize = 15.sp,
                        modifier = Modifier.padding(start = 15.dp),
                        textAlign = TextAlign.Start
                    )
                }
            }


            Button(
                modifier = Modifier
                    .padding(13.dp, 0.dp)
                    .fillMaxWidth()
                    .height(52.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White, containerColor = blueColor
                ),
                shape = MaterialTheme.shapes.small.copy(all = CornerSize(2.dp)),
            ) {
                Text("Create Permit", color = Color.White)
            }

            Spacer(Modifier.height(30.dp))

        }
    }
}
