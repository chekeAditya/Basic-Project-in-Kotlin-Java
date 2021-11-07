package com.lloyd.daggerdemo

import dagger.Component

@Component
interface CarComponent {
    fun getCar() : Car
}

/*
    - Through this you will get the car object

 */