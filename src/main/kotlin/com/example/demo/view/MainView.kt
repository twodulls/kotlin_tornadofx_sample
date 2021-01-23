package com.example.demo.view

import com.example.demo.controller.ParamController
import com.example.demo.app.Styles.Companion.mainCSS
import javafx.collections.FXCollections
import javafx.scene.control.TextField
import javafx.scene.control.ToggleGroup
import javafx.scene.text.FontWeight
import tornadofx.*
import kotlin.system.exitProcess

class MainView : View("Active On / Off") {

    val paramController: ParamController by inject()
    var evnValue: String ? = null
    var adValue : Int = 0
    var isActiveValue: String ? = null

    override val root = vbox {
        addClass(mainCSS)

        label("Active On / Off")
        {
            style(append = true){
                fontSize = 25.px
                fontWeight = FontWeight.EXTRA_BOLD
            }
        }

        //evn 선택
        label("Environment")
        {
            style(append = true){
                fontSize = 15.px
                fontWeight = FontWeight.EXTRA_BOLD
            }
            vboxConstraints{
                marginTop = 20.0
            }
        }

        val envs = FXCollections.observableArrayList("dev", "stage", "prod")
        combobox<String>
        {
            items = envs
            selectionModel.selectedItemProperty().onChange {
                evnValue = "$it"
            }
        }

        //Ad-Object
        label("Test-Object")
        {
            style(append = true){
                fontSize = 15.px
                fontWeight = FontWeight.EXTRA_BOLD
            }
            vboxConstraints{
                marginTop = 20.0
            }
        }

        val toggleGroup = ToggleGroup()
        radiobutton("Object 1", toggleGroup, value=1)
        {
            action{
                adValue=1
            }
        }
        radiobutton("Object 2", toggleGroup, value=2)
        {
            action{
                adValue=2
            }
        }
        radiobutton("Object 3", toggleGroup, value=3)
        {
            action{
                adValue=3
            }
        }

        //id 입력 - 배열로 저장
        label("id (쉼표로 구분)")
        {
            style(append = true){
                fontSize = 15.px
                fontWeight = FontWeight.EXTRA_BOLD
            }
            vboxConstraints{
                marginTop = 20.0
            }
        }

        var ids: TextField by singleAssign()
        ids = textfield()

        //Active on/off
        label("Active")
        {
            style(append = true){
                fontSize = 15.px
                fontWeight = FontWeight.EXTRA_BOLD
            }
            vboxConstraints{
                marginTop = 20.0
            }
        }

        val isActive = FXCollections.observableArrayList("On", "Off")
        combobox<String>
        {
            items = isActive
            selectionModel.selectedItemProperty().onChange {
                isActiveValue = "$it"
            }
        }

        button("Proceed")
        {
            vboxConstraints {
                marginTop = 20.0
            }

            action{
                println("evn : $evnValue")
                println("adValue : $adValue")
                val idsArray = paramController.makeArrayIds("${ids.text}")
                println("ids is $idsArray")
                println("isActiveValue : $isActiveValue")
            }
        }

        button("Exit")
        {
            action{
                information("종료")
                println("결과 화면으로 이동해야 한다")
                exitProcess(1)
            }
        }
    }
}