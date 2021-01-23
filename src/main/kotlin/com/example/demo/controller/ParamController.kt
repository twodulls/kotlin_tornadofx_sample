package com.example.demo.controller

import tornadofx.*

class ParamController: Controller() {
    fun makeArrayIds(text: String) : List<String>{
        var stringArray = text.split(";")
        return stringArray
    }
}