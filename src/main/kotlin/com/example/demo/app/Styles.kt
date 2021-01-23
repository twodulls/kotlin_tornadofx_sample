package com.example.demo.app

import javafx.scene.text.FontWeight
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px

class Styles : Stylesheet() {
    companion object {
        val mainCSS by cssclass()
    }

    init {
        mainCSS {
            padding = box(20.px)
        }
    }
}