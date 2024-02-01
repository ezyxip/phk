package com.ezyxip.phk.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

class Screen (
    private val _path: String,
    val arguments: List<String> = listOf(),
    val screenContent: @Composable (
        Map<String, String?>,
        NavHostController
    ) -> Unit = { _, _ -> Text(text = _path) }
){
    val path: String
        get(){
            var res = _path
            for (arg in arguments){
                res += "/{$arg}"
            }

            return res
        }

    fun pathWithArg(vararg argValue: String): String {
        var res = _path
        try {
            for(i in arguments.indices){
                res += "/${argValue[i]}"
            }
        } catch (e: Exception){
            throw Exception("Слишком мало параметров")
        }


        return res
    }
}