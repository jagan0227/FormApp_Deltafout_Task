package com.jagan.formapp.extendableContext

import android.app.TimePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jagan.formapp.R
import com.jagan.formapp.ipUtil.DropDownIP
import com.jagan.formapp.ui.theme.blackGlance1
import com.jagan.formapp.ui.theme.blackGlance2
import com.jagan.formapp.ui.theme.blackGlance3
import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkSummaryExp() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var description by rememberSaveable { mutableStateOf("") }
        var endTime by rememberSaveable { mutableStateOf("") }
        val mContext = LocalContext.current
        val mCalendar = Calendar.getInstance()
        val mHour = mCalendar[Calendar.HOUR_OF_DAY]
        val mMinute = mCalendar[Calendar.MINUTE]
        var startTime by rememberSaveable { mutableStateOf("") }
        val worktypes = arrayOf(
            "Cold Work",
            "Breaking of pipeline",
            "Confined space entry",
            "Heavy equipment lifting/shifting"
        )


        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(),
            leadingIcon = {
                Icon(painterResource(id = R.drawable.editpen), null)
            },
            placeholder = {
                Text("Description of work", fontSize = 13.sp)
            },
            singleLine = true,
            textStyle = TextStyle.Default.copy(fontSize = 13.sp),
            shape = MaterialTheme.shapes.small.copy(all = CornerSize(0.dp)),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = blackGlance2, containerColor = Color.Transparent
            )
        )

        Spacer(Modifier.height(30.dp))

        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 13.sp, fontWeight = FontWeight.Bold, color = blackGlance1
                    )
                ) {
                    append("Type of work")
                }

                withStyle(
                    style = SpanStyle(
                        fontSize = 12.sp, color = blackGlance2
                    )
                ) {
                    append(" (Add more than one if needed)")
                }
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
        ) {

            Row(
                modifier = Modifier
                    .background(blackGlance3)
                    .height(32.dp)
                    .width(90.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text("Hot Work", fontSize = 11.sp, color = blackGlance1)
                Icon(Icons.Default.Clear, null, tint = Color.Gray, modifier = Modifier.size(13.dp))
            }

            Row(
                modifier = Modifier
                    .background(blackGlance3)
                    .height(32.dp)
                    .width(115.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text("Work at Height", fontSize = 11.sp, color = blackGlance1)
                Icon(Icons.Default.Clear, null, tint = Color.Gray, modifier = Modifier.size(13.dp))
            }

            Row(
                modifier = Modifier
                    .background(blackGlance3)
                    .height(32.dp)
                    .width(90.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text("Cold Work", fontSize = 11.sp, color = blackGlance1)
                Icon(Icons.Default.Clear, null, tint = Color.Gray, modifier = Modifier.size(13.dp))
            }
        }

        Spacer(Modifier.height(20.dp))

        DropDownIP(worktypes, "Select type of work")

        Text(
            text = "Start Time",
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = blackGlance1
        )


        val mTimePickerDialog = TimePickerDialog(
            mContext,
            {_, mHour : Int, mMinute: Int ->
                startTime = "$mHour:$mMinute"
            }, mHour, mMinute, false
        )

        OutlinedTextField(
            value = startTime,
            onValueChange = { },
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .onFocusChanged {
                    if (it.isFocused) {
                        mTimePickerDialog.show()
                    }
                }
            ,
            readOnly = true,
            trailingIcon = {
                Icon(painterResource(id = R.drawable.calendarclock), null, Modifier.clickable {
                    mTimePickerDialog.show()
                })
            },
            placeholder = {
                Text("Select", fontSize = 13.sp)
            },
            singleLine = true,
            textStyle = TextStyle.Default.copy(fontSize = 13.sp),
            shape = MaterialTheme.shapes.small.copy(all = CornerSize(0.dp)),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = blackGlance2, containerColor = Color.Transparent
            )

        )

        Text(
            text = "End Time",
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = blackGlance1
        )


        val mTimePickerDialog1 = TimePickerDialog(
            mContext,
            {_, mHour : Int, mMinute: Int ->
                endTime = "$mHour:$mMinute"
            }, mHour, mMinute, false
        )

        OutlinedTextField(
            value = endTime,
            onValueChange = { },
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .onFocusChanged {
                    if (it.isFocused) {
                        mTimePickerDialog1.show()
                    }
                }
            ,
            readOnly = true,
            trailingIcon = {
                Icon(painterResource(id = R.drawable.calendarclock), null, Modifier.clickable {
                    mTimePickerDialog1.show()
                })
            },
            placeholder = {
                Text("Select", fontSize = 13.sp)
            },
            singleLine = true,
            textStyle = TextStyle.Default.copy(fontSize = 13.sp),
            shape = MaterialTheme.shapes.small.copy(all = CornerSize(0.dp)),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = blackGlance2, containerColor = Color.Transparent
            )
        )

        Spacer(Modifier.height(20.dp))

    }

}