package com.jagan.formapp.extendableContext

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jagan.formapp.R
import com.jagan.formapp.ipUtil.DropDownIP
import com.jagan.formapp.ui.theme.blackGlance1
import com.jagan.formapp.ui.theme.blackGlance2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Part2Exp() {
    val points = arrayOf(
        "Option 1", "Option 2", "Option 3", "Option 4"
    )

    val officer = arrayOf(
        "Option 1", "Option 2", "Option 3", "Option 4"
    )

    Column(
        Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        DropDownIP(points, "Select Isolation Point(s)")
        Spacer(Modifier.height(10.dp))

        Text(
            text = "Add Isolation Issuer(s)",
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = blackGlance1
        )

        var expanded by rememberSaveable { mutableStateOf(false) }
        var selectedText by rememberSaveable { mutableStateOf("") }
        var dropDownWidth by rememberSaveable { mutableStateOf(0) }

        Column {
            OutlinedTextField(
                value = selectedText,
                onValueChange = { selectedText = it },
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .onSizeChanged {
                        dropDownWidth = it.width
                    },

                readOnly = true,
                leadingIcon = {
                    Image(painterResource(id = R.drawable.smallpersonicon), null)
                },
                placeholder = { Text("Isolation Officer", fontSize = 13.sp) },
                trailingIcon = {
                    Image(if (expanded) painterResource(id = R.drawable.arrowdown) else painterResource(
                        id = R.drawable.arrowup
                    ), null, Modifier.clickable { expanded = !expanded })
                },
                textStyle = TextStyle.Default.copy(fontSize = 13.sp),
                shape = MaterialTheme.shapes.small.copy(all = CornerSize(0.dp)),
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = blackGlance2, containerColor = Color.Transparent
                )
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .background(Color.White)
                    .width(with(LocalDensity.current) { dropDownWidth.toDp() })
            ) {
                officer.forEachIndexed { index, item ->
                    DropdownMenuItem(text = {
                        Column {
                            Text(item, fontSize = 12.sp, color = blackGlance1)
                        }
                    }, onClick = {
                        selectedText = item
                        expanded = false
                    }, modifier = Modifier.height(35.dp)
                    )
                    if (index != officer.size - 1) {
                        Divider(Modifier.background(blackGlance2))
                    }
                }

            }
        }

        Spacer(Modifier.height(20.dp))

    }

}
