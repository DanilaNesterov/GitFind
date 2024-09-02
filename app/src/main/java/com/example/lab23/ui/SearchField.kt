package com.example.lab23.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab23.ui.theme.LAB23Theme

@Composable
fun SearchField(
    search: () -> Unit,
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            leadingIcon = { Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Поисковое поле"
            ) },
            value = query,
            singleLine = true,
            onValueChange = onQueryChange,
            placeholder = {
                Text(
                    text = "Введите название репозитория",
                    fontSize = 12.sp
                )
            },
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
                .weight(1f)

        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = search,

            ) {
            Text(text = "Поиск")
        }
    }


}

@Composable
@Preview(showBackground = true)
fun SearchFieldPreview() {
    LAB23Theme {
        SearchField(
            query = "",
            onQueryChange = {},
            search = {}
        )
    }
}