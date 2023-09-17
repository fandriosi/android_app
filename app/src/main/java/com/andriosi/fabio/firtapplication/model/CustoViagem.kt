package com.andriosi.fabio.firtapplication.model

class CustoViagem() {
    var distance: Int = 0
       set(value) {
            if(value != null){
                field = value
        }else {
            CustoViagemException("The distance have more no null")
        }
    }
    var price: Float = 0.0f
            set(value){
                if (value != null) {
                    field = value
                }else {
                    CustoViagemException("The price have no null")
                }
            }
    var autonomy: Float = 0.0f
        set (value ){
            if (value != null && value > 0.0f) {
                field = value
            }else {
                CustoViagemException("The autonomy have more then zero")
            }
        }

    fun calcula():Float{
        return (distance * price)/autonomy
    }
}