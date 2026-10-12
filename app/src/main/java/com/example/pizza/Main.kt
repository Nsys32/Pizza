//package com.example.pizza

// 1.
//abstract class PizzaCity(
//    val neapolitanPizzaPrice: Double, val romanPizzaPrice: Double,
//    val sicilianPizzaPrice: Double, val tyroleanPizzaPrice: Double
//) {
//    var neapolitanPizzaCount = 0
//    var romanPizzaCount = 0
//    var sicilianPizzaCount = 0
//    var tyroleanPizzaCount = 0
//
//    abstract fun neapolitanPizzaSale()
//    abstract fun romanPizzaSale()
//    abstract fun sicilianPizzaSale()
//    abstract fun tyroleanPizzaSale()
//}
//2
//class PizzaPeter(
//    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
//    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
//) : PizzaCity(
//    neapolitanPizzaPrice, romanPizzaPrice,
//    sicilianPizzaPrice, tyroleanPizzaPrice
//){
//    override fun neapolitanPizzaSale() {
//        println("Спасибо за покупку неаполитанской пиццы в Санкт-Петербурге")
//    }
//
//    override fun romanPizzaSale() {
//        println("Спасибо за покупку римской пиццы в Санкт-Петербурге")
//    }
//
//    override fun sicilianPizzaSale() {
//        println("Спасибо за покупку сицилийской пиццы в Санкт-Петербурге")
//    }
//}

import com.example.pizza.CheckPhoto
import com.example.pizza.Drink
import com.example.pizza.PizzaCity
import com.example.pizza.PizzaMoscow
import com.example.pizza.PizzaPeter
import kotlin.system.exitProcess

fun main(){
    val pizzaPeter = PizzaPeter(
        175.0,241.5,
        167.5,215.0
    )
    val pizzaMoscow = PizzaMoscow(
        215.0,241.5,
        180.5,240.0
    )

    var currentPizzaCity :PizzaCity

    while (true){
    println("Добрый день! Выберите город")
    println("1. Москва\n2. Санкт-Петербург\n\n0. Выход из программы")

    currentPizzaCity = when (readln()){
        "1" -> pizzaMoscow
        "2" -> pizzaPeter
        "0" -> break
        else -> {
            println("ERROR")
            continue
        }
    }


    println("Выберите пиццу:")
    println("1. Неаполитанская пицца\n2. Римская пицца\n3. Сицилийская пицца\n4. Тирольская пицца\n\n0. Показать статистику")
    val pizza = readln()
    when(readln()){
        "1" -> {
            currentPizzaCity.neapolitanPizzaSale()
            selectAddService(currentPizzaCity)
        }
        "2" -> {
            currentPizzaCity.romanPizzaSale()
            selectAddService(currentPizzaCity)
        }
        "3" -> {
            currentPizzaCity.sicilianPizzaSale()
            selectAddService(currentPizzaCity)
        }
        "4" -> {
            currentPizzaCity.tyroleanPizzaSale()
            selectAddService(currentPizzaCity)
        }
        "0" -> {currentPizzaCity.showStatistics()}
        else -> {
            println("ERROR")
            exitProcess(1)
        }
    }

//    when (currentPizzaCity) {
//        is CheckPhoto -> pizzaMoscow.showCheckPhoto()
//        else -> pizzaPeter.drinkSale()
//    }

}
    }

fun selectAddService(currentPizzaCity: PizzaCity){
    when (currentPizzaCity){
        is CheckPhoto -> currentPizzaCity.showCheckPhoto()
        is Drink -> currentPizzaCity.drinkSale()
    }
}