package mq.lombard.bottomsup.bean

/** @author Pascal Lombard
 */
data class Glass @JvmOverloads constructor(var beerName: String,
                                           var beerStyle: BeerStyle,
                                           var toRefill: Boolean = true)