package com.example.lab23.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab23.model.Owner
import com.example.lab23.model.Repository
import com.example.lab23.ui.theme.LAB23Theme


@Composable
fun RepositoryCard(
    repository: Repository,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    fun openUrl(url:String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }

    Card(
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(16.dp)
        ) {
            Row {
                Text(text = "Название проекта:")
                Text(
                    textDecoration = TextDecoration.Underline,
                    text = repository.name,
                    color = Color.Blue,
                    modifier = Modifier.clickable { openUrl(repository.htmlUrl) }
                )
            }
            Row {
                Text(text = "Автор проекта:")
                Text(
                    textDecoration = TextDecoration.Underline,
                    text = repository.owner.login,
                    color = Color.Blue,
                    modifier = Modifier.clickable { openUrl(repository.owner.htmlUrl)  }
                )
            }
            Text(text = "Язык программирования: ${repository.language}")
            Text(text = "Описание: ${repository.description}")

        }


    }

}




