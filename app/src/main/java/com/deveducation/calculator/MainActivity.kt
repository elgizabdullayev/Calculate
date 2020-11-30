package com.deveducation.calculator

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var displayOperations : TextView
    private lateinit var but7 : Button
    private lateinit var but8 : Button
    private lateinit var but9 : Button
    private lateinit var but4 : Button
    private lateinit var but5 : Button
    private lateinit var but6 : Button
    private lateinit var but1 : Button
    private lateinit var but2 : Button
    private lateinit var but3 : Button
    private lateinit var but0 : Button
    private lateinit var but00 : Button
    private lateinit var butClear : Button
    private lateinit var butDot : Button
    private lateinit var butDivide : Button
    private lateinit var butMultiply : Button
    private lateinit var butPlus : Button
    private lateinit var butMinus : Button
    private lateinit var butEqual : Button
    private lateinit var displayResult : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
    displayOperations = findViewById(R.id.displayOperations)
        but7 = findViewById(R.id.but7)
        but8 = findViewById(R.id.but8)
        but9 = findViewById(R.id.but9)
        but4 = findViewById(R.id.but4)
        but5 = findViewById(R.id.but5)
        but6 = findViewById(R.id.but6)
        but1 = findViewById(R.id.but1)
        but2 = findViewById(R.id.but2)
        but3 = findViewById(R.id.but3)
        but0 = findViewById(R.id.but0)
        but00 = findViewById(R.id.but00)
        butClear = findViewById(R.id.butClear)
        butDot = findViewById(R.id.butDot)
        butDivide = findViewById(R.id.butDivide)
        butMultiply = findViewById(R.id.butMultiply)
        butPlus = findViewById(R.id.butPlus)
        butMinus = findViewById(R.id.butMinus)
        butEqual = findViewById(R.id.butEqual)
        displayResult = findViewById(R.id.displayResult)

    }
    var firstZero : Boolean = false
    var existingDot : Boolean = false
    var haveSign : Boolean = true
    var isNewOp : Boolean = true
    val numbers : MutableList<Double> = mutableListOf()
    val signs : MutableList<String> = mutableListOf()
    lateinit var temproary : String
    var symbCount : Int = 0
    var previousResult : String = ""
    var haveDot : Boolean = true
    var lastOp : Boolean = false
    var endsWithSign : Boolean = true
    fun numbers(view: View) {
        if(isNewOp == true ){
            if(displayOperations.text != "-"){
            displayOperations.text = ""}
                existingDot = false
                firstZero = false
                isNewOp = true
                numbers.clear()
                signs.clear()
                temproary = ""
                displayResult.text = ""
                symbCount = 0

        }
        isNewOp = false
        var butclick : String = displayOperations.text.toString()
        var buttonSelect : Button = view as Button

        when(buttonSelect.id){
            but7.id -> {if(firstZero==false){
                butclick += "7"
                haveSign = false
                haveDot = false
                lastOp = false
                endsWithSign = false
            displayOperations.text = butclick}
            }
            but8.id -> {if(firstZero==false){
                butclick += "8"
                haveSign = false
                haveDot = false
                lastOp = false
                endsWithSign = false
                displayOperations.text = butclick}
            }
            but9.id -> {if(firstZero==false){
                butclick += "9"
                haveSign = false
                haveDot = false
                lastOp = false
                endsWithSign = false
                displayOperations.text = butclick}
            }
            but4.id -> {if(firstZero==false){
                butclick += "4"
                haveSign = false
                haveDot = false
                lastOp = false
                endsWithSign = false
                displayOperations.text = butclick}
            }
            but5.id -> {if(firstZero==false){
                butclick += "5"
                haveSign = false
                haveDot = false
                lastOp = false
                endsWithSign = false
                displayOperations.text = butclick}
            }
            but6.id -> {if(firstZero==false){
                butclick += "6"
                haveSign = false
                haveDot = false
                lastOp = false
                endsWithSign = false
                displayOperations.text = butclick}
            }
            but1.id -> {if(firstZero==false){
                butclick += "1"
                haveSign = false
                haveDot = false
                lastOp = false
                endsWithSign = false
                displayOperations.text = butclick}
            }
            but2.id -> {if(firstZero==false){
                butclick += "2"
                haveSign = false
                haveDot = false
                lastOp = false
                endsWithSign = false
                displayOperations.text = butclick}
            }
            but3.id -> {if(firstZero==false){
                butclick += "3"
                haveSign = false
                haveDot = false
                lastOp = false
                endsWithSign = false
                displayOperations.text = butclick}
            }
            but0.id -> {if(firstZero==false){
                butclick += "0"
                haveDot = false
                lastOp = false
                endsWithSign = false
                if(existingDot == true){
                firstZero = false
                }
                else if (existingDot == false && displayOperations.text == "" || haveSign == true) {
                    firstZero = true
                    haveSign = false
                }
                displayOperations.text = butclick}
            }
            but00.id -> {
                if ((displayOperations.text != "" && firstZero == false && haveSign == false)  || (displayOperations.text != "" && haveDot==true)) {
                butclick += "00"
                endsWithSign = false
                displayOperations.text = butclick}

            }


        }
    }

    fun butClear(view: View) {
        var clean : String = ""
        var buttonSelect : Button = view as Button
        when(buttonSelect.id){
            butClear.id -> { displayOperations.text = clean
                existingDot = false
                firstZero = false
                isNewOp = true
            numbers.clear()
            signs.clear()
                temproary = ""
                displayResult.text = clean
                symbCount = 0
            }
        }

    }


    fun mathOp(view: View) {
        var butclick: String = displayOperations.text.toString()
        var buttonSelect: Button = view as Button
        when (buttonSelect.id) {
            butDivide.id -> {
                if (displayOperations.text != "" && haveSign == false && !displayOperations.text.endsWith(".")) {
                    if(lastOp == true){
                        displayOperations.text = previousResult
                        butclick = displayOperations.text.toString()
                        symbCount = 0
                        isNewOp = false
                        numbers.clear()
                        signs.clear()
                    }

                    butclick += "/"
                    var removed : String =""
                    temproary = displayOperations.text.toString()
                    displayOperations.text = butclick

                    removed = temproary.drop(symbCount)

                    symbCount = temproary.lastIndex+2
                    signs.add("/")
                    numbers.add(removed.toDouble())
                    haveSign = true
                    existingDot = false
                    temproary=""
                    endsWithSign = true
                    firstZero = false
                }
            }
            butMultiply.id -> {
                if (displayOperations.text != "" && haveSign == false && !displayOperations.text.endsWith(".")) {
                    if(lastOp == true){
                        displayOperations.text = previousResult
                        butclick = displayOperations.text.toString()
                        isNewOp = false
                        symbCount = 0
                        numbers.clear()
                        signs.clear()
                    }
                    butclick += "*"
                    temproary = displayOperations.text.toString()
                    displayOperations.text = butclick

                    var removed : String = temproary.drop(symbCount)
                    symbCount = temproary.lastIndex+2
                    signs.add("*")
                    numbers.add(removed.toDouble())
                    haveSign = true
                    existingDot = false
                    temproary=""
                    endsWithSign = true
                    firstZero = false
                }
            }
            butPlus.id -> {
                if (displayOperations.text != "" && haveSign == false && !displayOperations.text.endsWith(".")) {
                    if(lastOp == true){
                        displayOperations.text = previousResult
                        butclick = displayOperations.text.toString()
                        isNewOp = false
                        lastOp = false
                        symbCount = 0
                        numbers.clear()
                        signs.clear()
                    }

                    butclick += "+"
                    temproary = displayOperations.text.toString()
                    displayOperations.text = butclick

                    var removed : String = temproary.drop(symbCount)
                    symbCount = temproary.lastIndex+2
                    signs.add("+")
                    numbers.add(removed.toDouble())
                    haveSign = true
                    existingDot = false
                    temproary=""
                    endsWithSign = true
                    firstZero = false
                }
            }
            butMinus.id -> {
                if (displayOperations.text != "" && haveSign == false && !displayOperations.text.endsWith(".")) {
                    if(lastOp == true){
                        displayOperations.text = previousResult
                        butclick = displayOperations.text.toString()
                        isNewOp = false
                        symbCount = 0
                        numbers.clear()
                        signs.clear()
                    }

                    butclick += "-"
                    temproary = displayOperations.text.toString()
                    displayOperations.text = butclick

                    var removed : String = temproary.drop(symbCount)

                    symbCount = temproary.lastIndex+2
                    signs.add("-")
                    numbers.add(removed.toDouble())
                    haveSign = true
                    existingDot = false
                    temproary=""
                    endsWithSign = true
                    firstZero = false
                }
                else if(displayOperations.text == ""){

                    butclick += "-"
                    displayOperations.text = butclick

                }
            }
        }
    }

    fun resultCalc(view: View) {
        var buttonSelect: Button = view as Button

            when (buttonSelect.id) {
                butEqual.id -> {
                    if(displayOperations.text != "" && endsWithSign == false) {

                        var removed: String = ""
                        if(!displayOperations.text.endsWith(".")){
                        temproary = displayOperations.text.toString()
                        removed = temproary.drop(symbCount)
                        numbers.add(removed.toDouble())}
                    }
                    if (displayOperations.text != "" && endsWithSign==false && numbers.size>0 && signs.size>0 && isNewOp == false && !displayOperations.text.endsWith(".")) {
                        var result: Double = 0.0
                        var error : String = "Error"
                        var boolError : Boolean = false
                        var x : Int = 0
                    while(x<signs.size) {
                        if (signs.contains("/") || signs.contains("*")) {

                            if (signs.contains("/") && signs.contains("*")) {
                                if (signs.indexOf("/") < signs.indexOf("*")) {
                                    var index: Int = signs.indexOf("/")
                                    if(numbers[index+1] == 0.0){
                                        Toast.makeText(applicationContext, "You can not divide by 0.", Toast.LENGTH_SHORT).show()
                                        displayOperations.text = ""
                                        boolError = true
                                        isNewOp=true
                                        break
                                    }
                                    var buf: Double = numbers[index] / numbers[index + 1]
                                    numbers.removeAt(index)
                                    numbers.removeAt(index)
                                    signs.removeAt(index)
                                    numbers.add(index, buf)
                                    result = numbers[index]
                                } else {
                                    var index: Int = signs.indexOf("*")
                                    var buf: Double = numbers[index] * numbers[index + 1]
                                    numbers.removeAt(index)
                                    numbers.removeAt(index)
                                    signs.removeAt(index)
                                    numbers.add(index, buf)
                                    result = numbers[index]
                                }
                            } else {
                                if (signs.contains("/")) {
                                    var index: Int = signs.indexOf("/")
                                    if(numbers[index+1] == 0.0){
                                        Toast.makeText(applicationContext, "You can not divide by 0.", Toast.LENGTH_SHORT).show()
                                        displayOperations.text = ""
                                        boolError = true
                                        isNewOp=true
                                        break
                                    }
                                    var buf: Double = numbers[index] / numbers[index + 1]
                                    numbers.removeAt(index)
                                    numbers.removeAt(index)
                                    signs.removeAt(index)
                                    numbers.add(index, buf)
                                    result = numbers[index]
                                } else if (signs.contains("*")) {
                                    var index: Int = signs.indexOf("*")
                                    var buf: Double = numbers[index] * numbers[index + 1]
                                    numbers.removeAt(index)
                                    numbers.removeAt(index)
                                    signs.removeAt(index)
                                    numbers.add(index, buf)
                                    result = numbers[index]
                                }
                            }
                        } else if (signs.contains("+") || signs.contains("-")) {

                            if (signs.contains("+") && signs.contains("-")) {
                                if (signs.indexOf("+") < signs.indexOf("-")) {
                                    var index: Int = signs.indexOf("+")
                                    var buf: Double = numbers[index] + numbers[index + 1]
                                    numbers.removeAt(index)
                                    numbers.removeAt(index)
                                    signs.removeAt(index)
                                    numbers.add(index, buf)
                                    result = numbers[index]
                                } else {
                                    var index: Int = signs.indexOf("-")
                                    var buf: Double = numbers[index] - numbers[index + 1]
                                    numbers.removeAt(index)
                                    numbers.removeAt(index)
                                    signs.removeAt(index)
                                    numbers.add(index, buf)
                                    result = numbers[index]
                                }
                            } else {
                                if (signs.contains("+")) {
                                    var index: Int = signs.indexOf("+")
                                    var buf: Double = numbers[index] + numbers[index + 1]
                                    numbers.removeAt(index)
                                    numbers.removeAt(index)
                                    signs.removeAt(index)
                                    numbers.add(index, buf)
                                    result = numbers[index]
                                } else if (signs.contains("-")) {
                                    var index: Int = signs.indexOf("-")
                                    var buf: Double = numbers[index] - numbers[index + 1]
                                    numbers.removeAt(index)
                                    numbers.removeAt(index)
                                    signs.removeAt(index)
                                    numbers.add(index, buf)
                                    result = numbers[index]
                                }
                            }
                        }
                    }
                    var last: Int = 0
                        if(boolError == false) {
                            if (result % 1 == 0.0) {
                                last = result.toInt()
                                displayResult.text = last.toString()
                                previousResult = last.toString()

                            } else {
                                var rounded: Double = Math.round(result * 100000.0) / 100000.0

                                displayResult.text = rounded.toString()
                                previousResult = rounded.toString()
                            }
                            lastOp = true
                        }
                        else{
                            displayResult.text = error
                        }

                    isNewOp = true


                }
            }
        }
    }

    fun dot(view: View) {
        var butclick : String = displayOperations.text.toString()
        var buttonSelect : Button = view as Button
        when(buttonSelect.id){
        butDot.id -> {if (existingDot == false && displayOperations.text != "" && haveSign == false && isNewOp == false) {butclick += "."
        existingDot = true
        firstZero = false
        haveDot = true
        displayOperations.text = butclick}
        }
    }}

}