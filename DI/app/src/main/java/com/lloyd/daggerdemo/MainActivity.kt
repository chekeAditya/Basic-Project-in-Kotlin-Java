package com.lloyd.daggerdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    /*
    When using field injection make sure the field is public or else Dagger will throw an error
    as it cannot find the object to instantiate
     */
    @Inject
    lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        DaggerCarComponent.create().inject(this)
        car.driveCar()
    }
}
 /*
fun functionA(case: Int) {
    when (case) {
        1 -> {
            taskA1()
            functionB(1)
        }
        2 -> {
            taskA2()
            functionB(2)
        }
        3 -> {
            taskA3()
            functionB(3)
        }
        4 -> {
            taskA4()
            functionB(4)
        }
    }
}

fun functionB(case: Int) {
    when (case) {
        1 -> {
            taskB1()
            functionA(2)
        }
        2 -> {
            taskB2()
            functionA(3)
        }
        3 -> {
            taskB3()
            functionA(4)
        }
        4 -> {
            taskB4()
        }
    }
}

 */